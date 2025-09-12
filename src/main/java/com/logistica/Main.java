package com.logistica;


import com.logistica.services.Conexao;
import com.logistica.services.GerenciadorCliente;
import com.logistica.view.Menu;

public class Main {

    public static void main(String[] args) {

        Conexao conexao = new Conexao();

        conexao.testeConexao();

        GerenciadorCliente gerenciadorCliente = new  GerenciadorCliente();
        Menu menu = new Menu();

        gerenciadorCliente.cadastro(menu.menuCadastro());

    }
}