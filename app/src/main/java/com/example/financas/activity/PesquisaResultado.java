package com.example.financas.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.R;
import com.example.financas.adapter.AdapterExtrato;

public class PesquisaResultado extends AppCompatActivity {
    private RecyclerView recyclerView;
    private AdapterExtrato pesquisaAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisa_resultado);

        pesquisaAdapter = new AdapterExtrato(Pesquisar.operacoesLista);

        recyclerView = findViewById(R.id.recyclerViewPesquisaResultado);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(pesquisaAdapter);
    }
}
