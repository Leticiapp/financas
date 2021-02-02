//package com.example.financas.adapter;
//
//
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.financas.R;
//
//import java.util.List;
//
//
//public class ToDoAdapter extends RecyclerView.Adapter<ToDoAdapter.MyViewHolder> {
//    private List<Operacoes> list;
//
//    public class MyViewHolder extends RecyclerView.ViewHolder {
//
//        TextView Operacoes;
//
//        public MyViewHolder(@NonNull View itemView) {
//            super(itemView);
//            Operacoes = itemView.findViewById(R.id.textViewOp);
//        }
//    }
//
//    public ToDoAdapter(List<Operacoes> list) {
//        this.list = list;
//    }
//
//    @NonNull
//    @Override
//    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View toDoItem =
//                LayoutInflater.from(parent.getContext()).inflate(R.layout.todo_cell,
//                        parent, false);
//        return new MyViewHolder(toDoItem);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
//        Operacoes Operacoes = list.get(position);
//        holder.Operacoes.setText(Operacoes.getTp_operacao());
//        holder.Operacoes.setText(Operacoes.getOp_desc());
//        holder.Operacoes.setText((int) Operacoes.getValor_operacao());
//        holder.Operacoes.setText(Operacoes.getDt_operacao());
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return this.list.size();
//    }
//}
