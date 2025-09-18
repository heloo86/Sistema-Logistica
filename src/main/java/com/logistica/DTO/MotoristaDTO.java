package com.logistica.DTO;

import java.time.LocalDateTime;

public class MotoristaDTO {
    private String nome;
    private String cnh;
    private String veiculo;
    private String cidadeBase;
    private LocalDateTime dataCadastro;

    public MotoristaDTO(String nome, String cnh, String veiculo, String cidadeBase) {
        this();
        this.nome = nome;
        this.cnh = cnh;
        this.veiculo = veiculo;
        this.cidadeBase = cidadeBase;
    }

    public MotoristaDTO() {
        this.dataCadastro = LocalDateTime.now();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getVeiculo() {
        return veiculo;
    }

    public void setVeiculo(String veiculo) {
        this.veiculo = veiculo;
    }

    public String getCidadeBase() {
        return cidadeBase;
    }

    public void setCidadeBase(String cidadeBase) {
        this.cidadeBase = cidadeBase;
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
                "\nNome = " + nome +
                "\nCNH = " + cnh +
                "\nCidade base = " + cidadeBase +
                "\nVeiculo = " + veiculo +
                "\nData de Cadastro = " + dataCadastro +
                "\n------------------------------------";
    }
}
