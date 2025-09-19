package com.logistica.DAO;

import com.logistica.view.Mensagem;

public interface DAO<T>{

    Mensagem mensagem = new Mensagem();

    public void cadastro(T entidade);
    public T  buscar();
    public void remover(T entidade);
    public void listar();
}
