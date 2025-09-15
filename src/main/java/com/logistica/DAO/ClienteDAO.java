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

    public boolean buscaCliente (int id){

        boolean encontrado = false;
        String query = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado, data_cadastro FROM cliente WHERE id = ?";

        try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nome: " + resultSet.getString("nome"));
                    System.out.println("CPF/CNPJ: " + resultSet.getString("cpf_cnpj"));
                    System.out.println("Endereço: " + resultSet.getString("endereco"));
                    System.out.println("Cidade: " + resultSet.getString("cidade"));
                    System.out.println("Estado: " + resultSet.getString("estado"));

                    Date dataCadastro = resultSet.getDate("data_cadastro");
                    System.out.println("Data de cadastro: " + dataCadastro);

                    encontrado = true;

                } else {
                    System.out.println("Cliente com id " + id + " não encontrado");
                    throw new RuntimeException("Erro de banco de dados ao tentar buscar cliente.");
                }

            }


        } catch (SQLException e) {
            System.err.println("Erro ao buscar e exibir cliente: " + e.getMessage());
            throw new RuntimeException("Erro ao procurar cliente");
        }

        return encontrado;
    }
}
