package com.example.financas.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.financas.model.Operacoes;
import com.example.financas.helper.OperacoesDAO;
import com.example.financas.R;

public class Cadastro extends AppCompatActivity {
    RadioGroup rg;
    private OperacoesDAO operacoesDAO;
    private Operacoes operacoes;
    private static final String[] filtroD = {"Educação", "Lazer", "Moradia", "Saúde", "Outros"};
    private static final String[] filtroC = {"Salário", "Tranferências"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        operacoesDAO = new OperacoesDAO(getApplicationContext());
        rg = findViewById(R.id.radioGroup);
        Spinner dropdown = findViewById(R.id.spinner1);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.radioButtonDebito:
                        ArrayAdapter<String>adapter = new ArrayAdapter<String>(Cadastro.this,
                                android.R.layout.simple_spinner_item,filtroD);
                        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        dropdown.setAdapter(adapter);
                        break;
                    case R.id.radioButtonCredito:
                        ArrayAdapter<String>adapter2 = new ArrayAdapter<String>(Cadastro.this,
                                android.R.layout.simple_spinner_item,filtroC);
                        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        dropdown.setAdapter(adapter2);
                        break;
                    default:
                        break;
                }
            }
        });
    }

    public void cadastrar(View view){
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        int rb = rg.getCheckedRadioButtonId();
        RadioButton rbb = findViewById(rb);
        Spinner spn = findViewById(R.id.spinner1);
        EditText valor = findViewById(R.id.editTextValor);
        EditText data = findViewById(R.id.editTextDate);

        Operacoes op = new Operacoes();
        op.setTp_operacao((String) rbb.getText());
        op.setOp_desc((String) spn.getSelectedItem());
        op.setValor_operacao(Double.parseDouble(valor.getText().toString()));
        op.setDt_operacao(Long.valueOf(data.getText().toString().replaceAll("[^\\d.]|\\.", "")));
        operacoesDAO.insertOperacoes(op);

        Toast.makeText(this,"Cadastro realizado",Toast.LENGTH_SHORT).show();
    }

}
