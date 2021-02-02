package com.example.financas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.model.Operacoes;
import com.example.financas.R;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

        Date dt = new Date (operacao.getDt_operacao());
        System.out.println("data2:" + dt);


        DateFormat originalFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss 'GMT'Z yyyy", Locale.ENGLISH);
        DateFormat targetFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try {
            date = originalFormat.parse(String.valueOf(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        System.out.println("data2:" + date);
        String formattedDate = targetFormat.format(date);
        System.out.println("data211:" + formattedDate);


        holder.data.setText(String.valueOf(formattedDate));
        holder.valor.setText(val);

    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }
}