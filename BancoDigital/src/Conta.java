public abstract class Conta {
    private static final String AGENCIA_PADRAO = "0001";
    private static int NUMERO_CONTA = 1;

    private String agencia;
    private int numeroConta;
    private Cliente cliente;
    private double saldo;

    public Conta(Cliente cliente) {
        agencia = AGENCIA_PADRAO;
        numeroConta = NUMERO_CONTA++;
        setCliente(cliente);
        setSaldo(0);
    }

    public Conta() {

    }

    public String getAgencia() {
        return agencia;
    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setSaldo(double saldo) {
        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valorDeposito) {
        if (valorDeposito > 0) {
            saldo += valorDeposito;
            System.out.println("Depósito efetuado com sucesso.\n");
        } else {
            System.out.println("Não foi possível realizar o depósito. Valor inválido.\n");
        }
    }

    public void sacar(double valorSaque) {
        if (valorSaque < 0) {
            System.out.println("Não foi possível realizar o saque. Valor inválido.\n");
        } else if (valorSaque > saldo) {
            System.out.println("Não foi possível realizar o saque. Saldo insuficiente.\n");
        } else {
            saldo -= valorSaque;
            System.out.println("Saque efetuado com sucesso.\n");
        }
    }

    public void transferir(Conta contaDestino, double valorTransferencia) {
        if (valorTransferencia <= 0) {
            System.out.println("Não foi possível realizar a transferência. Valor inválido.\n");
        } else if (valorTransferencia > saldo) {
            System.out.println("Não foi possível realizar a transferência. Saldo insuficiente.\n");
        } else {
            saldo -= valorTransferencia;
            contaDestino.depositar(valorTransferencia);
            System.out.println("Transferência realizada com sucesso.\n");
        }
    }

    public abstract void exibirInformacoesConta();

    public abstract void exibirExtrato();
}