package com.logistica.DAO;

import com.google.protobuf.StringValue;
import com.logistica.model.Cliente;
import com.logistica.services.Conexao;
import com.logistica.view.Mensagem;

import java.sql.*;

public class ClienteDAO {

    Mensagem mensagem = new Mensagem();

    public void novoCliente(Cliente cliente){
        String query = "INSERT INTO cliente (nome, cpf_cnpj, endereco, cidade, estado, data_cadastro) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, cliente.getNome());
            statement.setString(2, cliente.getCpfCnpj());
            statement.setString(3, cliente.getEndereco());
            statement.setString(4, cliente.getCidade());
            statement.setString(5, cliente.getEstado());
            statement.setString(6, String.valueOf(cliente.getDataCadastro()));

            statement.executeUpdate();

            mensagem.cadastroConcluido();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeCliente (int id){
        String query = "DELETE FROM cliente WHERE id = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1,id);

            statement.executeUpdate();

            mensagem.excluido();

        } catch (SQLException e) {
            System.err.println("Erro ao acessar banco de dados\nImpossivel excluir o cliente");
        }
    }

    public Cliente buscaCliente (int id){

        boolean encontrado = false;
        String query = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado, data_cadastro FROM cliente WHERE id = ?";

        try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    int clienteId = resultSet.getInt("id");
                    String nome = resultSet.getString("nome");
                    String cpfCnpj = resultSet.getString("cpf_cnpj");
                    String endereco = resultSet.getString("endereco");
                    String cidade = resultSet.getString("cidade");
                    String estado = resultSet.getString("estado");
                    Date dataCadastro = resultSet.getDate("data_cadastro");

                    Cliente cliente = new Cliente();
                    return cliente;

                } else {
                    System.out.println("Cliente com id " + id + " não encontrado");
                    throw new RuntimeException("Erro de banco de dados ao tentar buscar cliente.");
                }

            }


        } catch (SQLException e) {
            System.err.println("Erro ao buscar e exibir cliente: " + e.getMessage());
            return null;
        }
    }

    public void listarClientes(){
        String query = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado, data_cadastro FROM cliente";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()){
            while (resultSet.next()){

                int id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String cpfCnpj = resultSet.getString("cpf_cnpj");
                String endereco = resultSet.getString("endereco");
                String cidade = resultSet.getString("cidade");
                String estado = resultSet.getString("estado");
                Date dataCadastro = resultSet.getDate("data_cadastro");

                System.out.println("ID: "+ id + " | Nome: " +nome+ " | CPF/CNPJ = "+ cpfCnpj + " | Endereço: " +endereco+ " | Cidade: "+cidade+" | Estado: "+estado+" | Data cadastro: " +dataCadastro);
            }


        } catch (SQLException e){
            System.err.println("Erro ao acessar banco de dados");
        }
    }
}
