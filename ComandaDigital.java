import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class ComandaDigital {
    private List<Pedido> pedidos;
    private double totalConta;

    public ComandaDigital() {
        pedidos = new ArrayList<>();
        totalConta = 0.0;
    }

    public void fazerPedido(Prato prato, int quantidade, String observacoes) {
        Pedido pedido = new Pedido(prato, quantidade, observacoes);
        pedidos.add(pedido);
        System.out.println("Pedido realizado: " + pedido.toString());
        totalConta += prato.getPreco() * quantidade;
    }

    public void exibirPedidos() {
        for (Pedido pedido : pedidos) {
            System.out.println(pedido.toString());
        }
    }

    public void atualizarStatusPedido(int numeroPedido, String novoStatus) {
        if (numeroPedido > 0 && numeroPedido <= pedidos.size()) {
            Pedido pedido = pedidos.get(numeroPedido - 1);

            System.out.println("Status do pedido " + numeroPedido + " atualizado para: " + novoStatus);
        } else {
            System.out.println("Pedido não encontrado");
        }
    }

    public double calcularTotalConta() {
        return totalConta;
    }

    public void realizarPagamento(double valorPago, String formaPagamento) {
        double troco = valorPago - totalConta;
        System.out.println("Pagamento realizado via " + formaPagamento);
        System.out.println("Valor pago: R$" + valorPago);
        System.out.println("Total da conta: R$" + totalConta);
        if (troco > 0) {
            System.out.println("Troco: R$" + troco);
        }
        System.out.println("Obrigado pela visita!");
        pedidos.clear();
        totalConta = 0.0;
    }
}

