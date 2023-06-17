import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Cardapio {
    private List<Prato> pratos;

    public Cardapio() {
        pratos = new ArrayList<>();
    }

    public void adicionarPrato(Prato prato) {
        pratos.add(prato);
    }

    public void exibirCardapio() {
        for (Prato prato : pratos) {
            System.out.println(prato.toString());
        }

        }

    public Prato buscarPrato(String nome) {
        for (Prato prato : pratos) {
            if (prato.getNome().equalsIgnoreCase(nome)) {
                return prato;
            }
        }

        return null;
    }
}