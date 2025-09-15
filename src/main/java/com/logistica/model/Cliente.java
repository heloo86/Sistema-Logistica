package com.logistica.model;

import java.time.LocalDateTime;

public class Cliente {

    private String nome;
    private String cpfCnpj;
    private String endereco;
    private String cidade;
    private String estado;
    private LocalDateTime dataCadastro;

    public Cliente() {
        this.dataCadastro = LocalDateTime.now();
    }

    public Cliente(String nome, String cpfCnpj, String endereco, String cidade, String estado) {
        this();
        this.nome = nome;
        this.cpfCnpj = cpfCnpj;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpfCnpj() {
        return cpfCnpj;
    }

    public void setCpfCnpj(String cpfCnpj) {
        this.cpfCnpj = cpfCnpj;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    @Override
    public String toString() {
        return "------------------------------------"+
                "\nnome = " + nome +
                "\ncpfCnpj = " + cpfCnpj +
                "\nendereco = " + endereco +
                "\ncidade = " + cidade +
                "\nestado = " + estado +
                "\ndataCadastro = " + dataCadastro +
                "\n------------------------------------";
    }
}
