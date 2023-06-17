import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Prato {
    private String nome;
    private String descricao;
    private double preco;
    private boolean disponivel;

    public Prato(String nome, String descricao, double preco, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = disponivel;
    }


    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Setters
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    @Override
    public String toString() {
        return nome + " - R$" + preco;
    }
}
