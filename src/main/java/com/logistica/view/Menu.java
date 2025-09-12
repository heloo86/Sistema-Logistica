package com.logistica.view;

import com.logistica.DTO.ClienteDTO;
import com.logistica.model.Cliente;
import com.logistica.services.TratamentoErros;

import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    TratamentoErros erro = new TratamentoErros();

    public int menuPrincipal(){
        System.out.println("=============LOGISTICA=============");
        System.out.println(" 1 Cadastrar Cliente");

        String entrada = scan.nextLine();
        int saida = erro.verificaInteiro(entrada);

        return saida;
    }

    public ClienteDTO menuCadastro(){
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("CPF/CPJ: ");
        String cpfCnpj = scan.nextLine();
        System.out.print("Endereço: ");
        String endereco = scan.nextLine();
        System.out.print("Cidade: ");
        String cidade = scan.nextLine();
        System.out.print("Estado: ");
        String estado = scan.nextLine();

        ClienteDTO clienteDTO = new ClienteDTO(nome, cpfCnpj, endereco, cidade, estado);
        System.out.println(clienteDTO);

        return clienteDTO;
    }

    public int  buscaID() {
        System.out.println("Digite o ID: ");
        String entrada = scan.nextLine();
        int saida = erro.verificaInteiro(entrada);

        return saida;
    }
}
