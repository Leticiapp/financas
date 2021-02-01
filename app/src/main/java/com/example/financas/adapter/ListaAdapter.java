package com.example.financas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.R;
import com.example.financas.model.Operacoes;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.MyViewHolder> {
            private List<Operacoes> list;

            public class MyViewHolder extends RecyclerView.ViewHolder {
                TextView tipo, valor;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    tipo = itemView.findViewById(R.id.textViewTipoLista);
                    valor = itemView.findViewById(R.id.textViewValorLista);
                }
            }

            public ListaAdapter(List<Operacoes> list){this.list = list; System.out.println(list.size()); }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View listaItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_lista, parent, false);
                return new MyViewHolder(listaItem);
            }

            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                Operacoes operacao = list.get(position);
                NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
                nf.setMinimumFractionDigits(2);
                nf  .setMaximumFractionDigits(2);
                String val = "R$ " + nf.format(operacao.getValor_operacao());

                holder.tipo.setText(operacao.getTp_operacao());
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
