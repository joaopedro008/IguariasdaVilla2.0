import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        Cardapio cardapio = new Cardapio();
        Prato prato1 = new Prato("Hambúrguer", "Pão, carne, queijo, alface, tomate", 15.99, true);
        Prato prato2 = new Prato("Pizza", "Massa, molho, queijo, presunto, tomate", 25.99, true);
        Prato prato3 = new Prato("Parmegiana", "Frango, queijo, molho, arroz, batata frita", 45.00, true);
        cardapio.adicionarPrato(prato1);
        cardapio.adicionarPrato(prato2);
        cardapio.adicionarPrato(prato3);

        System.out.println("Cardápio:");
        cardapio.exibirCardapio();

        ComandaDigital comandaDigital = new ComandaDigital();

        boolean sair = false;
        while (!sair) {
            System.out.println("Escolha uma opção:");
            System.out.println("1. Fazer pedido");
            System.out.println("2. Exibir pedidos");
            System.out.println("3. Atualizar status do pedido");
            System.out.println("4. Fechar conta");
            System.out.println("5. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o nome do prato desejado: ");
                    String nomePrato = scanner.nextLine();
                    Prato prato = cardapio.buscarPrato(nomePrato);
                    if (prato != null) {
                        System.out.print("Digite a quantidade: ");
                        int quantidade = scanner.nextInt();
                        scanner.nextLine();

                        System.out.print("Digite observações adicionais: ");
                        String observacoes = scanner.nextLine();

                        comandaDigital.fazerPedido(prato, quantidade, observacoes);
                    } else {
                        System.out.println("Prato não encontrado no cardápio");
                    }
                    break;
                case 2:
                    System.out.println("Pedidos realizados:");
                    comandaDigital.exibirPedidos();
                    break;
                case 3:
                    System.out.print("Digite o número do pedido: ");
                    int numeroPedido = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o novo status do pedido: ");
                    String novoStatus = scanner.nextLine();

                    comandaDigital.atualizarStatusPedido(numeroPedido, novoStatus);
                    break;
                case 4:
                    System.out.println("Total da conta: R$" + comandaDigital.calcularTotalConta());
                    System.out.print("Digite o valor pago: ");
                    double valorPago = 0.0;
                    boolean valorValido = false;
                    while (!valorValido) {
                        try {
                            String valorPagoStr = scanner.nextLine();
                            valorPago = Double.parseDouble(valorPagoStr);
                            valorValido = true;
                        } catch (NumberFormatException e) {
                            System.out.println("Valor inválido. Digite um número válido: ");
                        }
                    }

                    System.out.println("Formas de pagamento disponíveis:");
                    System.out.println("1. Dinheiro");
                    System.out.println("2. Cartão de crédito");
                    System.out.println("3. Cartão de débito");
                    System.out.print("Escolha a forma de pagamento: ");
                    int opcaoPagamento = scanner.nextInt();
                    scanner.nextLine();

                    String formaPagamento;
                    switch (opcaoPagamento) {
                        case 1:
                            formaPagamento = "Dinheiro";
                            break;
                        case 2:
                            formaPagamento = "Cartão de crédito";
                            break;
                        case 3:
                            formaPagamento = "Cartão de débito";
                            break;
                        default:
                            formaPagamento = "Forma de pagamento inválida";
                            break;
                    }

                    comandaDigital.realizarPagamento(valorPago, formaPagamento);
                    break;
                case 5:
                    sair = true;
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }

        scanner.close();
    }
}