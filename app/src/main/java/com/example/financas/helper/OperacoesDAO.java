package com.example.financas.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.Toast;

import com.example.financas.R;
import com.example.financas.model.ListaSaldo;
import com.example.financas.model.Operacoes;

import java.util.ArrayList;
import java.util.List;


public class OperacoesDAO {

    private SQLiteDatabase write;
    private SQLiteDatabase read;

    public OperacoesDAO(Context context) {
        DBHelper db = new DBHelper(context);
        write = db.getWritableDatabase();
        read = db.getReadableDatabase();
    }

    public boolean insertOperacoes(Operacoes Operacoes) {
        ContentValues values = new ContentValues();
        values.put("tp_operacao", Operacoes.getTp_operacao());
        values.put("op_desc", Operacoes.getOp_desc());
        values.put("dt_operacao", Operacoes.getDt_operacao());
        values.put("valor_operacao", Operacoes.getValor_operacao());
        try {
            write.insert(DBHelper.TABLE_NAME, null, values);
            Log.i("INFO", "Operacao salva com sucesso. ");
        } catch (Exception e) {
            Log.e("INFO", "Erro ao salvar a operacao. " + e.getMessage());
            return false;
        }
        return true;
    }

    public List<Operacoes> getAllOperacoes() {
        List<Operacoes> OperacoesList = new ArrayList<>();
        Cursor cursor = read.query(DBHelper.TABLE_NAME, new String[]{"id_operacao", "tp_operacao", "op_desc", "dt_operacao", "valor_operacao"},
                null, null, null, null, "dt_operacao desc", String.valueOf(15));
        while (cursor.moveToNext()) {
            Operacoes Operacoes = new Operacoes();

            Long id_operacao = cursor.getLong(cursor.getColumnIndex("id_operacao"));
            String tp_operacao = cursor.getString(cursor.getColumnIndex("tp_operacao"));
            String op_desc = cursor.getString(cursor.getColumnIndex("op_desc"));
            Long dt_operacao = cursor.getLong(cursor.getColumnIndex("dt_operacao"));
            Double valor_operacao = cursor.getDouble(cursor.getColumnIndex("valor_operacao"));


            Operacoes.setId_operacao(id_operacao);
            Operacoes.setTp_operacao(tp_operacao);
            Operacoes.setOp_desc(op_desc);
            Operacoes.setDt_operacao(dt_operacao);
            Operacoes.setValor_operacao(valor_operacao);

            OperacoesList.add(Operacoes);

        }
        return OperacoesList;
    }

    Double saldo;

    public Double getSaldo(){

        Cursor cursor = read.query(DBHelper.TABLE_NAME, new String[]{"sum(valor_operacao) as saldo"},
                null, null, null, null, null);

        while (cursor.moveToNext())
            saldo = cursor.getDouble(cursor.getColumnIndex("saldo"));

        return saldo;

    }

    public List<Operacoes> search(long dtI, long dtF, String tipo) {
        List<Operacoes> operacoesLista = new ArrayList<>();
        if (tipo.equals("Todos"))
            tipo=" ";
        else if(tipo.equals("Débito"))
            tipo=" tp_operacao LIKE 'Débito' AND";
        else
            tipo=" tp_operacao LIKE 'Crédito' AND";

        Cursor cursor = read.query(DBHelper.TABLE_NAME, new String[]{"id_operacao", "tp_operacao", "op_desc", "dt_operacao", "valor_operacao"},
                tipo + " dt_operacao BETWEEN "+dtI + " AND "+ dtF , null, null, null, " dt_operacao ");

        try {
            while (cursor.moveToNext()) {
                Operacoes Operacoes = new Operacoes();

                Long id_operacao = cursor.getLong(cursor.getColumnIndex("id_operacao"));
                String tp_operacao = cursor.getString(cursor.getColumnIndex("tp_operacao"));
                String op_desc = cursor.getString(cursor.getColumnIndex("op_desc"));
                Long dt_operacao = cursor.getLong(cursor.getColumnIndex("dt_operacao"));
                Double valor_operacao = cursor.getDouble(cursor.getColumnIndex("valor_operacao"));


                Operacoes.setId_operacao(id_operacao);
                Operacoes.setTp_operacao(tp_operacao);
                Operacoes.setOp_desc(op_desc);
                Operacoes.setDt_operacao(dt_operacao);
                Operacoes.setValor_operacao(valor_operacao);

                operacoesLista.add(Operacoes);
            }
            return operacoesLista;
        } catch (Exception e) {
            return null;
        }

    }



    public List<ListaSaldo> ListaPorCategoria() {
        List<ListaSaldo> ListaPorCatg = new ArrayList<>();
        Cursor cursor = read.query(DBHelper.TABLE_NAME, new String[]{"tp_operacao", "op_desc", "dt_operacao", "valor_operacao", "sum(valor_operacao) as saldo"},
                null, null, "op_desc", null, "saldo desc" );
        while (cursor.moveToNext()) {
            ListaSaldo ListaSaldo = new ListaSaldo();

            String tp_operacao = cursor.getString(cursor.getColumnIndex("tp_operacao"));
            String op_desc = cursor.getString(cursor.getColumnIndex("op_desc"));
            Long dt_operacao = cursor.getLong(cursor.getColumnIndex("dt_operacao"));
            Double valor_operacao = cursor.getDouble(cursor.getColumnIndex("valor_operacao"));
            Double saldo = cursor.getDouble(cursor.getColumnIndex("saldo"));


            ListaSaldo.setTp_operacao(tp_operacao);
            ListaSaldo.setOp_desc(op_desc);
            ListaSaldo.setDt_operacao(dt_operacao);
            ListaSaldo.setValor_operacao(valor_operacao);
            ListaSaldo.setSaldo(saldo);

            if (op_desc.equals("Educação"))
                ListaSaldo.setImg(R.drawable.educacao);

            if (op_desc.equals("Saúde"))
                ListaSaldo.setImg(R.drawable.saude);

            if (op_desc.equals("Lazer"))
                ListaSaldo.setImg(R.drawable.lazer);

            if (op_desc.equals("Moradia"))
            ListaSaldo.setImg(R.drawable.moradia);

            if (op_desc.equals("Salário"))
            ListaSaldo.setImg(R.drawable.salario);

            if (op_desc.equals("Tranferências"))
            ListaSaldo.setImg(R.drawable.transferencias);

            if (op_desc.equals("Outros"))
                ListaSaldo.setImg(R.drawable.outros);

            ListaPorCatg.add(ListaSaldo);

        }
        return ListaPorCatg;
    }


}
