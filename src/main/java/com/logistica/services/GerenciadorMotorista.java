package com.logistica.services;

import com.logistica.DAO.MotoristaDAO;
import com.logistica.DTO.MotoristaDTO;
import com.logistica.model.Motorista;
import com.logistica.view.Mensagem;
import com.logistica.view.Menu;

public class GerenciadorMotorista {

    MotoristaDAO motoristaDAO = new MotoristaDAO();
    Menu menu = new Menu();
    Mensagem mensagem = new Mensagem();

    public void cadastro(MotoristaDTO motoristaDTO){

        String nome = motoristaDTO.getNome();
        String cnh =  motoristaDTO.getCnh();
        String veiculo = motoristaDTO.getVeiculo();
        String cidadeBase = motoristaDTO.getCidadeBase();

        Motorista motorista = new Motorista(nome, cnh, veiculo, cidadeBase);
        motoristaDAO.novoMotorista(motorista);
    }

    public void buscarClienteID(){
        motoristaDAO.buscaMotorista(menu.buscaClienteID());
    }

    public void excluir() {
        int id = menu.buscaClienteID();
        if (motoristaDAO.buscaMotorista(id)){
            if (menu.confirmaExcluirCliente()){
                motoristaDAO.removeMotorista(id);
            }
        } else {
            mensagem.clienteNaoEncontrado();
        }

    }
}


