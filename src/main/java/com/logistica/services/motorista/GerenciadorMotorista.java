package com.logistica.services.motorista;

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

    public void buscarMotoristaID(){
        motoristaDAO.buscaMotorista(menu.buscaID());
    }

    public void excluir() {
        int id = menu.buscaID();
        if (motoristaDAO.buscaMotorista(id)){
            if (menu.confirmaExcluirMotorista()){
                motoristaDAO.removeMotorista(id);
            }
        } else {
            mensagem.motoristaNaoEncontrado();
        }

    }

    public void listar(){
        motoristaDAO.listarMotoristas();
    }
}


