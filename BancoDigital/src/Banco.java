import java.util.ArrayList;
import java.util.List;

public class Banco {
    List<Cliente> listaClientes;
    List<Conta> listaContas;

    public Banco() {
        listaClientes = new ArrayList<>();
        listaContas = new ArrayList<>();
    }

    public void criarContaCorrente(String cpf) {
        if (verificarCadastroCliente(cpf, listaClientes)) {
            Cliente cliente = buscarCliente(cpf, listaClientes);
            ContaCorrente contaCorrente = new ContaCorrente(cliente);
            listaContas.add(contaCorrente);
            contaCorrente.exibirInformacoesConta();
            System.out.println("Conta corrente criada com sucesso.\n");
            
        } else {
            System.out.println("Não foi possível criar a conta. Cliente não cadastrado.\n");
        }
    }

    public void criarContaPoupanca(String cpf) {
        if (verificarCadastroCliente(cpf, listaClientes)) {
            Cliente cliente = buscarCliente(cpf, listaClientes);
            ContaPoupanca contaPoupanca = new ContaPoupanca(cliente);
            listaContas.add(contaPoupanca);
            contaPoupanca.exibirInformacoesConta();
            System.out.println("Conta poupança criada com sucesso.\n");
        } else {
            System.out.println("Não foi possível criar a conta. Cliente não cadastrado.\n");
        }
    }

    public void cadastrarCliente(String nome, String cpf) {
        if (verificarCadastroCliente(cpf, listaClientes)) {
            System.out.println("Não foi possível cadastrar o cliente. CPF já cadastrado.\n");
        } else {
            listaClientes.add(new Cliente(nome, cpf));
            System.out.println("Cliente cadastrado com sucesso.\n");
        }
    }

    public boolean verificarCadastroCliente(String cpf, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return true;
            }
        }
        
        return false;
    }

    public Cliente buscarCliente(String cpf, List<Cliente> listaClientes) {
        for (Cliente cliente : listaClientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }

        return null;
    }

    public Conta buscarConta(int numeroConta, List<Conta> listaContas) {
        for (Conta conta : listaContas) {
            if (conta.getNumeroConta() == numeroConta) {
                return conta;
            }
        }

        return null;
    }
}
