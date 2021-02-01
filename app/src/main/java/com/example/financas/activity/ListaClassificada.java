package com.example.financas.activity;

import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.R;
import com.example.financas.adapter.ListaAdapter;
import com.example.financas.helper.OperacoesDAO;
import com.example.financas.model.Operacoes;

import java.util.ArrayList;
import java.util.List;

public class ListaClassificada extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListaAdapter listaAdapter;
    private List<Operacoes> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recyclerViewLista);

        OperacoesDAO listaDAO = new OperacoesDAO(getApplicationContext());
        itemList = listaDAO.getAllOperacoes();

        listaAdapter = new ListaAdapter(itemList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(listaAdapter);
    }
}
