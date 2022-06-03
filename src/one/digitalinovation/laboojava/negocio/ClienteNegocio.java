package one.digitalinovation.laboojava.negocio;

import one.digitalinovation.laboojava.basedados.Banco;
import one.digitalinovation.laboojava.entidade.Cliente;
import one.digitalinovation.laboojava.entidade.Produto;

import java.util.Optional;

/**
 * Classe para manipular a entidade {@link Cliente}.
 * @author thiago leite
 */
public class ClienteNegocio {

    /**
     * {@inheritDoc}.
     */
    private Banco bancoDados;

    /**
     * Construtor.
     * @param banco Banco de dados para ter acesso aos clientes cadastrados
     */
    public ClienteNegocio(Banco banco) {
        this.bancoDados = banco;
    }

    /**
     * Consulta o cliente pelo seu CPF.
     * @param cpf CPF de um cliente
     * @return O cliente que possuir o CPF passado.
     */
    public Optional<Cliente> consultar(String cpf) {

        for (Cliente cliente: bancoDados.getCliente()){

            if (cliente.getCpf().equalsIgnoreCase(cpf)) {
                return  Optional.of(cliente);
            }
        }

        return Optional.empty();

    }
    public void listarTodos() {

        if (bancoDados.getCliente().length == 0) {
            System.out.println("Não existem clientes cadastrados");
        } else {

            for (Cliente cliente: bancoDados.getCliente()) {
                System.out.println(cliente.toString());
            }
        }
    }

    //TODO Fazer a exclusão de cliente

    public void excluir(String cpf) {

        int clienteExclusao = -1;
        for (int i = 0; i < bancoDados.getCliente().length; i++) {

            Cliente cliente = bancoDados.getCliente()[i];
            if (cliente.getCpf().equals(cpf)) {
                clienteExclusao = i;
                break;
            }
        }

        if (clienteExclusao != -1) {
            bancoDados.removerCliente(clienteExclusao);
            System.out.println("Cliente excluído com sucesso.");
        } else {
            System.out.println("Cliente inexistente.");
        }
    }
    //TODO Fazer a inclusão de cliente


    public void salvar(Cliente novoCliente) {

        boolean clienteRepetido = false;
        for (Cliente cliente: bancoDados.getCliente()) {
            if (cliente.getCpf() == novoCliente.getCpf()) {
                clienteRepetido = true;
                System.out.println("Cliente já cadastrado.");
                break;
            }
        }

        if (!clienteRepetido) {
            this.bancoDados.adicionarCliente(novoCliente);
            System.out.println("Cliente cadastrado com sucesso.");
        }
    }
}
