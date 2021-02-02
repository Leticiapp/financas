package com.example.financas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.adapter.AdapterExtrato;
import com.example.financas.model.Operacoes;
import com.example.financas.helper.OperacoesDAO;
import com.example.financas.R;

import java.util.ArrayList;
import java.util.List;


public class Extrato extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterExtrato adapterExtrato;
    private List<Operacoes> operacoesLista = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_extrato);

        recyclerView = findViewById(R.id.recyclerViewExtrato);

        OperacoesDAO operacoesDAO = new OperacoesDAO(getApplicationContext());
        operacoesLista = operacoesDAO.getAllOperacoes();

        adapterExtrato = new AdapterExtrato(operacoesLista);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(false);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(adapterExtrato);



        Double saldo =  operacoesDAO.getSaldo();

        TextView saldo2 = findViewById(R.id.textViewOperacoes);
        saldo2.setText("Saldo atual: R$" + String.format("%.2f", saldo));


    }


    public void voltar(View view){

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();

    }
}
