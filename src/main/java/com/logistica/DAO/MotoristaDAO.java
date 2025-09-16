package com.logistica.DAO;

import com.logistica.model.Cliente;
import com.logistica.model.Motorista;
import com.logistica.services.Conexao;
import com.logistica.view.Mensagem;

import java.sql.*;

public class MotoristaDAO {

    Mensagem mensagem = new Mensagem();

    public void novoMotorista(Motorista motorista){
        String query = "INSERT INTO motorista (nome, cnh, veiculo, cidade_base, data_cadastro) VALUES (?, ?, ?, ?, ?)";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setString(1, motorista.getNome());
            statement.setString(2, motorista.getCnh());
            statement.setString(3, motorista.getVeiculo());
            statement.setString(4, motorista.getCidadeBase());
            statement.setString(6, String.valueOf(motorista.getDataCadastro()));

            statement.executeUpdate();

            mensagem.cadastroConcluido();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void removeMotorista (int id){
        String query = "DELETE FROM motorista WHERE id = ?";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1,id);

            statement.executeUpdate();

            mensagem.excluido();

        } catch (SQLException e) {
            System.err.println("Erro ao acessar banco de dados\nImpossivel excluir o motorista");
        }
    }

    public boolean buscaMotorista (int id){

        boolean encontrado = false;
        String query = "SELECT id, nome, cnh, veiculo, cidade_base , data_cadastro FROM motorista WHERE id = ?";

        try (Connection connection = Conexao.conectar();
        PreparedStatement statement = connection.prepareStatement(query)){

            statement.setInt(1, id);

            try (ResultSet resultSet = statement.executeQuery()){
                if (resultSet.next()){
                    System.out.println("ID: " + resultSet.getInt("id"));
                    System.out.println("Nome: " + resultSet.getString("nome"));
                    System.out.println("CNH: " + resultSet.getString("cpf_cnpj"));
                    System.out.println("Veiculo: " + resultSet.getString("endereco"));
                    System.out.println("Cidade Base: " + resultSet.getString("cidade"));

                    Date dataCadastro = resultSet.getDate("data_cadastro");
                    System.out.println("Data de cadastro: " + dataCadastro);

                    encontrado = true;

                } else {
                    System.out.println("Motorista com id " + id + " não encontrado");
                    throw new RuntimeException("Erro de banco de dados ao tentar buscar motorista.");
                }

            }


        } catch (SQLException e) {
            System.err.println("Erro ao buscar e exibir motorista: " + e.getMessage());
            throw new RuntimeException("Erro ao procurar cliente");
        }

        return encontrado;
    }
}
