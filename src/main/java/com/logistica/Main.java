package com.logistica;


import com.logistica.services.Conexao;
import com.logistica.services.GerenciadorCliente;
import com.logistica.services.GerenciadorMenuPrincipal;
import com.logistica.view.Menu;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Conexao conexao = new Conexao();

        conexao.testeConexao();

        GerenciadorMenuPrincipal gerenciadorMenuPrincipal = new GerenciadorMenuPrincipal();
        Menu menu = new Menu();

        int escolha;

        do {
            escolha = menu.menuPrincipal();
            gerenciadorMenuPrincipal.gerenciaMenu(escolha);
        } while (escolha != 0);


    }
}