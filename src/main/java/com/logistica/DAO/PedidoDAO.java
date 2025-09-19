package com.logistica.DAO;

import com.logistica.model.Cliente;
import com.logistica.model.Pedido;
import com.logistica.services.Conexao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PedidoDAO implements DAO<Pedido>{


    @Override
    public void cadastro(Pedido pedido){
      String query = "INSERT INTO pedido (cliente_id, volume_m3, peso_kg, status, data_criacao, data_atualizacao VALUES (?, ? ,? ,? ,? ,?)";

      try (Connection connection = Conexao.conectar();
           PreparedStatement statement = connection.prepareStatement(query)){

          statement.setInt(1, pedido.getCliente().getId() );
          statement.setDouble(2, pedido.getVolumeM3());
          statement.setDouble(3, pedido.getPesoKg());
          statement.setString(4, pedido.getStatusPedido().name());
          statement.setDate(5, pedido.getDataPedidio());
          statement.setString(6, String.valueOf(pedido.getDataAtualizacao()));

          statement.executeUpdate();

          mensagem.cadastroConcluido();

      } catch (SQLException e){

      }
    }

    @Override
    public Pedido buscar() {
    return null;
    }

    @Override
    public void remover(Pedido pedido) {

    }

    @Override
    public void listar() {

    }

}
