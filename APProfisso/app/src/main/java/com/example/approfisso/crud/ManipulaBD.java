package com.example.approfisso.crud;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.approfisso.domain.Empregos;

import java.util.LinkedList;
import java.util.List;

public class ManipulaBD {
    private final Context context;

    public ManipulaBD(Context context) {
        this.context = context;
    }

    public Long insere(Empregos empregos) {
        CriaBD criaBD = new CriaBD(context);
        SQLiteDatabase database = criaBD.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nome", empregos.getNome());
        contentValues.put("quantidade", empregos.getQuantidade());

        return empregos.getId()!=null&&empregos.getId()>0?
     database.update("produto",contentValues, "id=?", new String[]{empregos.getId()+""})
                :
         database.insertOrThrow("produto", null, contentValues);
    }

    public List<Empregos> getProdutos() {
        List<Empregos> retorno = new LinkedList<>();
        CriaBD criaBD = new CriaBD(context);
        SQLiteDatabase database = criaBD.getReadableDatabase();
        Cursor cursor = database.query("produto", new String[]{"id","nome", "quantidade"},
                null, null,
                null, null, null, null);
        if (cursor.moveToFirst()) {
            do {
                Empregos p = new Empregos();
                p.setId(cursor.getInt(0));
                p.setNome(cursor.getString(1));
                p.setQuantidade(cursor.getInt(2));
                retorno.add(p);
            } while (cursor.moveToNext());
        }

    return retorno;
    }

    public Integer remover(Empregos empregos) {
        CriaBD criaBD = new CriaBD(context);
        SQLiteDatabase database = criaBD.getWritableDatabase();
        String[] argumentos = {empregos.getId() + ""};
        return database.delete("produto","id=?",
                argumentos );
    }
}
