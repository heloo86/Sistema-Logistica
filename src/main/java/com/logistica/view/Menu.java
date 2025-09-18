package com.logistica.view;

import com.logistica.DTO.ClienteDTO;
import com.logistica.DTO.MotoristaDTO;
import com.logistica.services.TratamentoErros;

import java.util.Scanner;

public class Menu {

    Scanner scan = new Scanner(System.in);
    TratamentoErros erro = new TratamentoErros();

    public int menuPrincipal(){
        System.out.println("\n=============LOGISTICA==============");
        System.out.println(" 1 Cadastrar Cliente");
        System.out.println(" 2 Buscar Cliente");
        System.out.println(" 3 Excluir Cliente");
        System.out.println("\n 4 Cadastrar Motorista");
        System.out.println(" 5 Buscar Motorista");
        System.out.println(" 6 Excluir Motorista");
        System.out.println("\n 7 Listar Motoristas");
        System.out.println(" 8 Listar Clientes");
        System.out.println("\n 0 Sair");

        String entrada = scan.nextLine();
        int saida = erro.verificaInteiro(entrada);
        return saida;
    }

    public int buscaID() {
        System.out.println("Digite o ID: ");
        String entrada = scan.nextLine();
        int saida = erro.verificaInteiro(entrada);

        return saida;
    }

    // CLIENTE --------------------------------------------------------------------------------------------------

    public ClienteDTO menuCadastroCliente(){
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

    public boolean confirmaExcluirCliente (){
        System.out.println("\n Deseja mesmo excluir o cliente acima?\n 1 Sim, excluir registro\n 2 Não, manter registro");
        String entrada = scan.nextLine();
        int saida = erro.verificaInteiro(entrada);

        boolean excluir = false;

        if (saida == 1){
            excluir = true;
        }

        return excluir;
    }

    // MOTORISTA --------------------------------------------------------------------------------------------------

    public MotoristaDTO menuCadastroMotorista(){
        System.out.print("Nome: ");
        String nome = scan.nextLine();
        System.out.print("CNH: ");
        String cnh = scan.nextLine();
        System.out.print("Veiculo: ");
        String veiculo = scan.nextLine();
        System.out.print("Cidade Base: ");
        String cidadeBase = scan.nextLine();

        MotoristaDTO motoristaDTO = new MotoristaDTO(nome, cnh, veiculo, cidadeBase);
        System.out.println(motoristaDTO);

        return motoristaDTO;
    }

    public boolean confirmaExcluirMotorista(){
        System.out.println("\n Deseja mesmo excluir o motorista acima?\n 1 Sim, excluir registro\n 2 Não, manter registro");
        String entrada = scan.nextLine();
        int saida = erro.verificaInteiro(entrada);

        boolean excluir = false;

        if (saida == 1){
            excluir = true;
        }

        return excluir;
    }
}
