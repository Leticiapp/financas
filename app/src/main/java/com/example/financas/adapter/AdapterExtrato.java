package com.example.financas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.model.Operacoes;
import com.example.financas.R;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class AdapterExtrato extends RecyclerView.Adapter<AdapterExtrato.MyViewHolder> {
    private List<Operacoes> list;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tipo, data, valor;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tipo = itemView.findViewById(R.id.textViewTipoExtrato);
            data = itemView.findViewById(R.id.textViewDataExtrato);
            valor = itemView.findViewById(R.id.textViewValorExtrato);
        }
    }

    public AdapterExtrato(List<Operacoes> list){this.list = list; }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View operacaoItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.extrato_cell, parent, false);
        return new MyViewHolder(operacaoItem);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        Operacoes operacao = list.get(position);
        NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
        nf.setMinimumFractionDigits(2);
        nf  .setMaximumFractionDigits(2);
        String val = "R$ " + nf.format(operacao.getValor_operacao());

        holder.tipo.setText(operacao.getTp_operacao());
        holder.data.setText(operacao.getDt_operacao().toString());
        holder.valor.setText(val);
        if(operacao.getTp_operacao().toString().equals("Débito")){
            holder.valor.setText("- " + val);
        }else{
            holder.valor.setText("+ " + val);
        }
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}