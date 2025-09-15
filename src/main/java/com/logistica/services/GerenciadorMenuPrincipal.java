package com.logistica.services;

import com.logistica.DAO.ClienteDAO;
import com.logistica.Main;
import com.logistica.view.Mensagem;
import com.logistica.view.Menu;

public class GerenciadorMenuPrincipal {

    Menu menu = new Menu();
    GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    Mensagem mensagem = new Mensagem();
    TratamentoErros erro = new TratamentoErros();


    public void gerenciaMenu( int entrada) throws InterruptedException {

        switch (entrada){
            case 0 -> {
                mensagem.despedida();
            } case 1 ->{
                gerenciadorCliente.cadastro(menu.menuCadastroCliente());
            } case 2-> {
                gerenciadorCliente.buscarClienteID();
            } case 3 -> {
                gerenciadorCliente.excluir();
            } default -> {
                return;
            }
        }

    }


}
