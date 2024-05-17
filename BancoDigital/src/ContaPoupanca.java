public class ContaPoupanca extends Conta {
    private static final String TIPO_CONTA = "Conta poupança";
    
    public ContaPoupanca(Cliente cliente) {
        super(cliente);
    }

    public void exibirInformacoesConta() {
        System.out.println("\nTitular: " + getCliente().getNome());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Número da conta: " + getNumeroConta());
        System.out.println("Tipo de conta: " + TIPO_CONTA);
        System.out.println();
    }

    public void exibirExtrato() {
        System.out.println("\n--- EXTRATO CONTA POUPANÇA ---");
        System.out.println("\nTitular: " + getCliente().getNome());
        System.out.println("Agência: " + getAgencia());
        System.out.println("Número da conta: " + getNumeroConta());
        System.out.println("Saldo: R$ " + getSaldo());
        System.out.println();
    }
}
