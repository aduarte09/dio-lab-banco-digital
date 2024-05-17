import java.util.Scanner;

public class SistemaBancoDigital {
    public static void main(String[] args) {
        Banco banco = new Banco();
        Conta conta = null;

        Scanner scan = new Scanner(System.in);

        int opcao;
        String cpf, nome;
        int numeroConta;

        while(true) {
            System.out.println("MENU");
            System.out.println("(1) Cadastrar cliente");
            System.out.println("(2) Criar conta corrente");
            System.out.println("(3) Criar conta poupança");
            System.out.println("(4) Sacar");
            System.out.println("(5) Depositar");
            System.out.println("(6) Transferir");
            System.out.println("(7) Exibir extrato");
            System.out.println("(0) Sair\n");

            do {
                System.out.println("Opção desejada: ");
                opcao = scan.nextInt();
                scan.nextLine();

                if ((opcao < 1) && (opcao > 7)) {
                    System.out.println("Opção inválida. Tente novamente.\n");
                }
            } while ((opcao < 1) && (opcao > 7));
            
            if (opcao == 0) {
                scan.close();
                System.out.println("Programa encerrado.\n");
                break;
            }

            switch (opcao) {
                case 1: // cadastrar cliente
                    System.out.println("Digite seu nome: ");
                    nome = scan.nextLine();
                    System.out.println("Digite seu CPF: ");
                    cpf = scan.nextLine();

                    banco.cadastrarCliente(nome, cpf);
                    break;
            
                case 2: // criar conta corrente
                    System.out.println("Digite seu CPF: ");
                    cpf = scan.nextLine();
                        
                    banco.criarContaCorrente(cpf);
                    break;

                case 3: // criar conta poupança
                    System.out.println("Digite seu CPF: ");
                    cpf = scan.nextLine();
                        
                    banco.criarContaPoupanca(cpf);
                    break;
                
                case 4: // sacar
                    System.out.println("Digite o número da sua conta: ");
                    numeroConta = scan.nextInt();
                    conta = banco.buscarConta(numeroConta, banco.listaContas);
                    
                    if (conta != null) {
                        System.out.println("Digite o valor do saque: ");
                        double valorSaque = scan.nextDouble();
                        scan.nextLine();
                        conta.sacar(valorSaque);
                    } else {
                        System.out.println("Sua conta não foi encontrada.\n");
                    }
                    
                    break;
                case 5: // depositar
                    System.out.println("Digite o número da sua conta: ");
                    numeroConta = scan.nextInt();
                    conta = banco.buscarConta(numeroConta, banco.listaContas);
                    
                    if (conta != null) {
                        System.out.println("Digite o valor do depósito: ");
                        double valorDeposito = scan.nextDouble();
                        scan.nextLine();
                        conta.depositar(valorDeposito);
                    } else {
                        System.out.println("Sua conta não foi encontrada.\n");
                    }
                    
                    break;

                case 6: // transferir
                    System.out.println("Digite o número da sua conta: ");
                    numeroConta = scan.nextInt();
                    conta = banco.buscarConta(numeroConta, banco.listaContas);
                    System.out.println("Digite o número da conta destino: ");
                    numeroConta = scan.nextInt();
                    Conta contaDestino = banco.buscarConta(numeroConta, banco.listaContas); 
                
                    if (conta != null) {
                        if (contaDestino != null) {
                            System.out.println("Digite o valor a ser transferido: ");
                            double valorTransferencia = scan.nextDouble();
                            scan.nextLine();
                            conta.transferir(contaDestino, valorTransferencia);
                        } else {
                            System.out.println("Conta destino não encontrada.\n");
                        }
                    } else {
                        System.out.println("Sua conta não foi encontrada.\n");
                    }

                    break;
                
                case 7: // imprimir extrato
                    System.out.println("Digite o número da sua conta: ");
                    numeroConta = scan.nextInt();
                    conta = banco.buscarConta(numeroConta, banco.listaContas);

                    if (conta != null) {
                        conta.exibirExtrato();
                    } else {
                        System.out.println("Sua conta não foi encontrada.\n");
                    }

                    break;
            }
        }
    }
}