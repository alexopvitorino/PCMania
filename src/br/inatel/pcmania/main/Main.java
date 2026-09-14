package br.inatel.pcmania.main;

import br.inatel.pcmania.modelo.Cliente;

public class Main {
    public static void main(String[] args) {

        float matricula = 589;
        Cliente cliente = new Cliente("Alex Vitorino", "102.157.056-70");

        SistemaCompras sistema = new SistemaCompras();

        sistema.iniciarMenu(cliente, matricula);

    }
}
