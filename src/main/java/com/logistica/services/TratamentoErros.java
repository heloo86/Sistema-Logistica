package com.logistica.services;

import com.logistica.view.Mensagem;

public class TratamentoErros {
    Mensagem mensagem = new Mensagem();

    public int verificaInteiro(String entrada){
        int numero = 0;
        try {
           numero = Integer.parseInt(entrada);
           return numero;
        } catch (NumberFormatException erro ){
          mensagem.erroNumerico();
          return -1;
        }
    }
}
