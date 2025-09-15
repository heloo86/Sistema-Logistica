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

    public void despedida() throws InterruptedException {
        System.out.println("++++++++++++++++++++++++++++++++++++");
        System.out.println("   Saindo  ");
        Thread.sleep(1000);
        System.out.print("   * ");
        Thread.sleep(1000);
        System.out.print(" * ");
        Thread.sleep(1000);
        System.out.print(" * ");
        Thread.sleep(1000);
        System.out.println("\n Alterações salvas, volte sempre!!");
    }

    public void clienteNaoEncontrado() {
        System.out.println(" Cliente não encontrado");
    }
}
