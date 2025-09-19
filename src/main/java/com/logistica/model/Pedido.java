package com.logistica.model;

import com.logistica.services.pedido.StatusPedido;

import java.sql.Date;
import java.time.LocalDateTime;

public class Pedido {
    private Date dataPedidio;
    private Cliente cliente;
    private double volumeM3;
    private double pesoKg;
    private StatusPedido statusPedido;
    private LocalDateTime dataCadastro;
    private LocalDateTime dataAtualizacao;

    public Pedido() {
        this.dataAtualizacao = LocalDateTime.now();
        this.dataCadastro = LocalDateTime.now();
    }

    public Pedido(Date dataPedidio, Cliente cliente, double volumeM3, double pesoKg, StatusPedido statusPedido) {
        this();
        this.dataPedidio = dataPedidio;
        this.cliente = cliente;
        this.volumeM3 = volumeM3;
        this.pesoKg = pesoKg;
        this.statusPedido = statusPedido;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getDataPedidio() {
        return dataPedidio;
    }

    public void setDataPedidio(Date dataPedidio) {
        this.dataPedidio = dataPedidio;
    }

    public double getVolumeM3() {
        return volumeM3;
    }

    public void setVolumeM3(double volumeM3) {
        this.volumeM3 = volumeM3;
    }

    public double getPesoKg() {
        return pesoKg;
    }

    public void setPesoKg(double pesoKg) {
        this.pesoKg = pesoKg;
    }

    public StatusPedido getStatusPedido() {
        return statusPedido;
    }

    public void setStatusPedido(StatusPedido statusPedido) {
        this.statusPedido = statusPedido;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public LocalDateTime getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(LocalDateTime dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    @Override
    public String toString(){
        return "------------------------------------"+
                "\nData do pedido = " + dataPedidio +
                "\nVolume em M³ = " + volumeM3 +
                "\nPeso em Kg = " + pesoKg +
                "\nStatus = " + statusPedido +
                "\nData de Cadastro = " + dataCadastro +
                "\nUltima atualização = " + dataAtualizacao+
                "\n------------------------------------";
    }
}
