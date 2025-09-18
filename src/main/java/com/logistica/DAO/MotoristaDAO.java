package com.logistica.DAO;

import com.google.protobuf.StringValue;
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
            statement.setString(5, String.valueOf(motorista.getDataCadastro()));

            statement.executeUpdate();

            mensagem.cadastroConcluido();

        } catch (SQLException e) {
            throw new RuntimeException("Não foi possivel realizar o cadastro");
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
                    System.out.println("CNH: " + resultSet.getString("cnh"));
                    System.out.println("Veiculo: " + resultSet.getString("veiculo"));
                    System.out.println("Cidade Base: " + resultSet.getString("cidade_base"));

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

    public void listarMotoristas(){
        String query = "SELECT id, nome, cnh, veiculo, cidade_base , data_cadastro FROM motorista";

        try (Connection connection = Conexao.conectar();
             PreparedStatement statement = connection.prepareStatement(query);
             ResultSet resultSet = statement.executeQuery()){
         while (resultSet.next()){

             int id = resultSet.getInt("id");
             String nome = resultSet.getString("nome");
             String cnh = resultSet.getString("cnh");
             String veiculo = resultSet.getString("veiculo");
             String cidadeBase = resultSet.getString("cidade_base");
             Date dataCadastro = resultSet.getDate("data_cadastro");

             System.out.println("ID: "+ id + " | Nome: " +nome+ " | CNH = "+ cnh + " | Veiculo: " +veiculo+ " | Cidade base: "+cidadeBase+" | Data cadastro: " +dataCadastro);
         }


        } catch (SQLException e){
            System.err.println("Erro ao acessar banco de dados");
        }
    }
}
