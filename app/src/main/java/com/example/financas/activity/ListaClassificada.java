package com.example.financas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.financas.R;
import com.example.financas.adapter.ListaAdapter;
import com.example.financas.helper.OperacoesDAO;
import com.example.financas.model.ListaSaldo;
import com.example.financas.model.Operacoes;

import java.util.ArrayList;
import java.util.List;

public class ListaClassificada extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ListaAdapter listaAdapter;
    private List<ListaSaldo> Lista = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista);

        recyclerView = findViewById(R.id.recyclerViewLista);

        OperacoesDAO listaDAO = new OperacoesDAO(getApplicationContext());
        Lista = listaDAO.ListaPorCategoria();


        listaAdapter = new ListaAdapter(Lista);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getApplicationContext(), LinearLayout.VERTICAL));
        recyclerView.setAdapter(listaAdapter);


    }

    public void voltar(View view){

        Intent it = new Intent(this, MainActivity.class);
        startActivity(it);
        finish();

    }
}
