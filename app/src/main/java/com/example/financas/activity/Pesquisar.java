package com.example.financas.activity;

import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Long4;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.financas.R;
import com.example.financas.adapter.AdapterExtrato;
import com.example.financas.helper.OperacoesDAO;
import com.example.financas.model.Operacoes;

import java.util.List;

public class Pesquisar extends AppCompatActivity {
    RadioGroup rg;
    EditText dtInicial, dtFinal;
    Button btn;
    Long dtI, dtF;

    private OperacoesDAO operacoesDAO;
    private Operacoes operacoes;
    public static List<Operacoes> operacoesLista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pesquisar);

        rg = findViewById(R.id.radioGroup);
        btn = findViewById(R.id.buttonP);

        OperacoesDAO operacoesDAO = new OperacoesDAO(getApplicationContext());
    }

    public void pesquisar(View view) {
        dtInicial = findViewById(R.id.editTextDateInicial);
        dtFinal = findViewById(R.id.editTextDateFinal);
        rg = (RadioGroup) findViewById(R.id.radioGroup2);
        int rb = rg.getCheckedRadioButtonId();
        RadioButton rbb = findViewById(rb);

        dtI = Long.valueOf(dtInicial.getText().toString().replaceAll("[^\\d.]|\\.", ""));
        dtF = Long.valueOf(dtFinal.getText().toString().replaceAll("[^\\d.]|\\.", ""));

        try {
            OperacoesDAO operacoesDAO = new OperacoesDAO(getApplicationContext());
            operacoesLista = operacoesDAO.search(dtI, dtF, (String) rbb.getText());
            Intent i = new Intent(Pesquisar.this, PesquisaResultado.class);
            startActivity(i);
        } catch (Exception e){
            Toast.makeText(this,"Não foi encontrado", Toast.LENGTH_SHORT).show();
        }

    }
}
