package com.example.financas.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.R;
import com.example.financas.model.ListaSaldo;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;


public class ListaAdapter extends RecyclerView.Adapter<ListaAdapter.MyViewHolder> {
            private List<ListaSaldo> list;

            public class MyViewHolder extends RecyclerView.ViewHolder {
                TextView tipo, valor;
                ImageView img;

                public MyViewHolder(@NonNull View itemView) {
                    super(itemView);
                    tipo = itemView.findViewById(R.id.textViewOperacoes);
                    valor = itemView.findViewById(R.id.TextViewSald);
                    img = itemView.findViewById(R.id.imageViewIMG);
                }
            }

            public ListaAdapter(List<ListaSaldo> list){this.list = list; System.out.println(list.size()); }

            @NonNull
            @Override
            public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View listaItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_cell, parent, false);
                return new MyViewHolder(listaItem);
            }



            @Override
            public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
                ListaSaldo listasald = list.get(position);
                NumberFormat nf = NumberFormat.getInstance(new Locale("pt", "BR"));
                nf.setMinimumFractionDigits(2);
                nf  .setMaximumFractionDigits(2);
                String val = "R$ " + nf.format(listasald.getSaldo());
                holder.valor.setText(val);

                String tp = listasald.getTp_operacao() + " - " + listasald.getOp_desc();
                holder.tipo.setText(tp);

                holder.img.setImageResource(listasald.getImg()); ;

            }

            @Override
            public int getItemCount() {
                return this.list.size();
            }
    }
