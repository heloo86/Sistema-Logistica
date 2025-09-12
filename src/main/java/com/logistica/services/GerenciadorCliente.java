package com.logistica.services;

import com.logistica.DAO.ClienteDAO;
import com.logistica.DTO.ClienteDTO;
import com.logistica.model.Cliente;

public class GerenciadorCliente {

    ClienteDAO clienteDAO = new ClienteDAO();

    public void cadastro(ClienteDTO clienteDTO){

        String nome = clienteDTO.getNome();
        String cpfCnpj = clienteDTO.getCpfCnpj();
        String endereco = clienteDTO.getEndereco();
        String cidade = clienteDTO.getCidade();
        String estado = clienteDTO.getEstado();

        Cliente cliente = new Cliente(nome, cpfCnpj, endereco, cidade, estado);
        clienteDAO.novoCliente(cliente);
    }


}


