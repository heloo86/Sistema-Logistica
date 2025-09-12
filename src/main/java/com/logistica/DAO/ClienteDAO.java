package com.logistica.DAO;

import com.google.protobuf.StringValue;
import com.logistica.model.Cliente;
import com.logistica.services.Conexao;
import com.logistica.view.Mensagem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

    public void removeClienteC(Cliente cliente){
        String query = "DELETE FROM cliente WHERE cpf_cnpj = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, cliente.getCpfCnpj());

            statement.executeUpdate();

            mensagem.excluido();

        } catch (SQLException e) {
            throw new RuntimeException("Erro ao cacessar banco de dados");
        }
    }

    public void buscaCliente (int id){

        String query = "SELECT id, nome, cpf_cnpj, endereco, cidade, estado, data_cadastro FROM cliente WHERE id = ?";

        try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            statement.executeQuery();


        } catch (SQLException e) {
            throw new RuntimeException("Erro ao procurar cliente\nCliente não encontrado");
        }
    }
}
