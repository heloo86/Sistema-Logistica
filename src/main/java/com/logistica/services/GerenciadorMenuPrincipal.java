package com.logistica.services;

import com.logistica.DAO.ClienteDAO;
import com.logistica.Main;
import com.logistica.view.Mensagem;
import com.logistica.view.Menu;

public class GerenciadorMenuPrincipal {

    Menu menu = new Menu();
    GerenciadorCliente gerenciadorCliente = new GerenciadorCliente();
    GerenciadorMotorista gerenciadorMotorista = new GerenciadorMotorista();
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
            } case 4 ->{
                gerenciadorMotorista.cadastro(menu.menuCadastroMotorista());
            } case 5-> {
                gerenciadorMotorista.buscarMotoristaID();
            } case 6 -> {
                gerenciadorMotorista.excluir();
            } case 7 ->{
                gerenciadorMotorista.listar();
            } case 8 -> {
                gerenciadorCliente.listar();
            }default -> {
                return;
            }
        }

    }


}
