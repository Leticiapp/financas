package com.example.financas.activity;

import android.content.Intent;
import android.os.Bundle;

import com.example.financas.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void showCadastro (View view){
       Intent it = new Intent(this, Cadastro.class);
            startActivity(it);
    }
    public void showPesquisar (View view){
        Intent it = new Intent(this, Pesquisar.class);
            startActivity(it);
    }
    public void showExtrato (View view){
        Intent it = new Intent(this, Extrato.class);
        startActivity(it);
    }
    public void showLista (View view){
        Intent it = new Intent(this, ListaClassificada.class);
        startActivity(it);
    }

    public void exit (View view){
        this.finishAffinity();
    }

}