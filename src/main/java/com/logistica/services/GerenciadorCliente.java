package com.logistica.services;

import com.logistica.DAO.ClienteDAO;
import com.logistica.DTO.ClienteDTO;
import com.logistica.model.Cliente;
import com.logistica.view.Mensagem;
import com.logistica.view.Menu;

public class GerenciadorCliente {

    ClienteDAO clienteDAO = new ClienteDAO();
    Menu menu = new Menu();
    Mensagem mensagem = new Mensagem();

    public void cadastro(ClienteDTO clienteDTO){

        String nome = clienteDTO.getNome();
        String cpfCnpj = clienteDTO.getCpfCnpj();
        String endereco = clienteDTO.getEndereco();
        String cidade = clienteDTO.getCidade();
        String estado = clienteDTO.getEstado();

        Cliente cliente = new Cliente(nome, cpfCnpj, endereco, cidade, estado);
        clienteDAO.novoCliente(cliente);
    }

    public void buscarClienteID(){
        clienteDAO.buscaCliente(menu.buscaID());
    }

    public void excluir() {
        int id = menu.buscaID();
        if (clienteDAO.buscaCliente(id)){
            if (menu.confirmaExcluirCliente()){
                clienteDAO.removeCliente(id);
            }
        } else {
            mensagem.clienteNaoEncontrado();
        }

    }

    public void listar() {
        clienteDAO.listarClientes();
    }
}


