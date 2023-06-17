import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Pedido {
    private Prato prato;
    private int quantidade;
    private String observacoes;

    public Pedido(Prato prato, int quantidade, String observacoes) {
        this.prato = prato;
        this.quantidade = quantidade;
        this.observacoes = observacoes;
    }



    @Override
    public String toString() {
        return prato.toString() + " - Quantidade: " + quantidade + " - Observações: " + observacoes;
    }
}

