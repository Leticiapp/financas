package com.example.financas;

import java.io.Serializable;
import java.util.Date;

public class Operacoes implements Serializable {
    private Long id_operacao;
    private String tp_operacao;
    private String op_desc;
    private Long dt_operacao;
    private double valor_operacao;

    public String getOp_desc() {
        return op_desc;
    }

    public void setOp_desc(String op_desc) {
        this.op_desc = op_desc;
    }

    public Long getId_operacao() {
        return id_operacao;
    }

    public void setId_operacao(Long id_operacao) {
        this.id_operacao = id_operacao;
    }

    public String getTp_operacao() {
        return tp_operacao;
    }

    public void setTp_operacao(String tp_operacao) {
        this.tp_operacao = tp_operacao;
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
}
