package br.inatel.pcmania.modelo;

public class Computador {
    private String marca;
    private float preco;
    private HardwareBasico[] hb;
    private SistemaOperacional so;
    private MemoriaUSB musb;

    // Construtor completo: injetamos o SO e os Hardwares para evitar Setters desnecessários!
    public Computador(String marca, float preco, SistemaOperacional so, HardwareBasico[] hb) {
        this.marca = marca;
        this.preco = preco;
        this.so = so;
        this.hb = hb;
    }

    public void mostraPCConfigs() {
        System.out.println("Marca: " + marca);
        System.out.println("Preço: R$ " + preco);
        System.out.println("Hardware:");
        for (int i = 0; i < hb.length; i++) {
            if (hb[i] != null) {
                if (hb[i].getNome().equals("Memória RAM") || hb[i].getNome().equals("HD")) {
                    System.out.println(" - " + hb[i].getNome() + ": " + hb[i].getCapacidade() + " Gb");
                } else {
                    System.out.println(" - " + hb[i].getNome() + ": " + hb[i].getCapacidade() + " Mhz");
                }
            }
        }
        if (so != null) {
            System.out.println("Sistema Operacional: " + so.getNome() + " (" + so.getTipo() + " bits)");
        }
        if (musb != null) {
            System.out.println("Acompanha: " + musb.getNome() + " de " + musb.getCapacidade() + " Gb");
        }
    }

    public void addMemoriaUSB(MemoriaUSB musb) {
        this.musb = musb;
    }

    public float getPreco() {
        return preco;
    }
}