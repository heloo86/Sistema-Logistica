package com.logistica.view;

public class Mensagem {

    public void cadastroConcluido(){
        System.out.println(" Cadastro concluido com sucesso");
    }

    public void excluido(){
        System.out.println(" Item removdo");
    }

    public void erroNumerico() {
        System.out.println(" Ops, houve um erro :/\n Por favor insira um numero válido");
    }
}
