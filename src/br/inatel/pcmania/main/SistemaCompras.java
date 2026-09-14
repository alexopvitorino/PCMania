package br.inatel.pcmania.main;

import br.inatel.pcmania.modelo.*;
import java.util.Scanner;

public class SistemaCompras {

    public void iniciarMenu(Cliente cliente, float matricula) {
        Scanner entrada = new Scanner(System.in);
        int opcao;
        int pos = 0;

        System.out.println("Bem-vindo a PC Mania, " + cliente.getNome() + "!");

        do {
            System.out.println("\n--- MENU DE PROMOÇÕES ---");
            System.out.println("1 - Promoção 1 (Apple)");
            System.out.println("2 - Promoção 2 (Samsung)");
            System.out.println("3 - Promoção 3 (Dell)");
            System.out.println("0 - Finalizar Compra");
            System.out.print("Escolha uma opção de compra: ");
            opcao = entrada.nextInt();

            if (opcao == 1) {
                SistemaOperacional so1 = new SistemaOperacional("macOS Sequoia", 64);
                HardwareBasico[] hb1 = new HardwareBasico[3];
                hb1[0] = new HardwareBasico("Pentium Core i5", 2200);
                hb1[1] = new HardwareBasico("Memória RAM", 8);
                hb1[2] = new HardwareBasico("HD", 500);

                Computador pc1 = new Computador("Apple", matricula, so1, hb1);
                pc1.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));

                cliente.getComputadores()[pos] = pc1;
                pos++;
                System.out.println("=> Computador Apple adicionado ao carrinho!");

            } else if (opcao == 2) {
                SistemaOperacional so2 = new SistemaOperacional("Windows 8", 64);
                HardwareBasico[] hb2 = new HardwareBasico[3];
                hb2[0] = new HardwareBasico("Pentium Core i7", 3370);
                hb2[1] = new HardwareBasico("Memória RAM", 16);
                hb2[2] = new HardwareBasico("HD", 1000);

                Computador pc2 = new Computador("Samsung", matricula + 1, so2, hb2);
                pc2.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));

                cliente.getComputadores()[pos] = pc2;
                pos++;
                System.out.println("=> Computador Samsung adicionado ao carrinho!");

            } else if (opcao == 3) {
                SistemaOperacional so3 = new SistemaOperacional("Windows 10", 64);
                HardwareBasico[] hb3 = new HardwareBasico[3];
                hb3[0] = new HardwareBasico("Pentium Core i7", 4500);
                hb3[1] = new HardwareBasico("Memória RAM", 32);
                hb3[2] = new HardwareBasico("HD", 2000);

                Computador pc3 = new Computador("Dell", matricula + 2, so3, hb3);
                pc3.addMemoriaUSB(new MemoriaUSB("HD Externo", 1000));

                cliente.getComputadores()[pos] = pc3;
                pos++;
                System.out.println("=> Computador Dell adicionado ao carrinho!");

            } else if (opcao != 0) {
                System.out.println("=> Opção inválida!");
            }

        } while (opcao != 0);

        imprimirExtrato(cliente);

        ProcessarPedido.confirmarPedido(cliente.getComputadores());

        entrada.close();
    }

    private void imprimirExtrato(Cliente cliente) {
        System.out.println("\n==================================");
        System.out.println("        RESUMO DA COMPRA");
        System.out.println("==================================");
        System.out.println("Cliente: " + cliente.getNome());
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("----------------------------------");
        System.out.println("PCs Adquiridos:");

        for (int i = 0; i < cliente.getComputadores().length; i++) {
            if (cliente.getComputadores()[i] != null) {
                System.out.println("\n[ Máquina " + (i + 1) + " ]");
                cliente.getComputadores()[i].mostraPCConfigs();
            }
        }

        System.out.println("\n==================================");
        System.out.println("TOTAL DA COMPRA: R$ " + cliente.calculaTotalCompra());
        System.out.println("==================================");
    }
}