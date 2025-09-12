package com.logistica.services;

import com.logistica.view.Mensagem;

public class TratamentoErros {
    Mensagem mensagem = new Mensagem();

    public int verificaInteiro(String entrada){
        int numero = 0;
        try {
           numero = Integer.parseInt(entrada);
        } catch (NumberFormatException erro ){
          mensagem.erroNumerico();
        }

        return numero;
    }
}
