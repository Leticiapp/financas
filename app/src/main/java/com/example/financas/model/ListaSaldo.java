package com.example.financas.model;

import java.io.Serializable;

public class ListaSaldo implements Serializable {
    private int img;
    private String tp_operacao;
    private String op_desc;
    private Long dt_operacao;
    private double valor_operacao;
    private double saldo;

    public ListaSaldo(int img, String tp_operacao, String op_desc, Long dt_operacao, double valor_operacao, double saldo) {
        this.img = img;
        this.tp_operacao = tp_operacao;
        this.op_desc = op_desc;
        this.dt_operacao = dt_operacao;
        this.valor_operacao = valor_operacao;
        this.saldo = saldo;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }


    public ListaSaldo() {
    }

    public String getTp_operacao() {
        return tp_operacao;
    }

    public void setTp_operacao(String tp_operacao) {
        this.tp_operacao = tp_operacao;
    }

    public String getOp_desc() {
        return op_desc;
    }

    public void setOp_desc(String op_desc) {
        this.op_desc = op_desc;
    }

    public Long getDt_operacao() {
        return dt_operacao;
    }

    public void setDt_operacao(Long dt_operacao) {
        this.dt_operacao = dt_operacao;
    }

    public double getValor_operacao() {
        return valor_operacao;
    }

    public void setValor_operacao(double valor_operacao) {
        this.valor_operacao = valor_operacao;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
