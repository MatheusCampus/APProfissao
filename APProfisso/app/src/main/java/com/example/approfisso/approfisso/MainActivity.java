package com.example.approfisso.approfisso;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.approfisso.R;
import com.example.approfisso.crud.ManipulaBD;
import com.example.approfisso.domain.Empregos;


import java.util.LinkedList;
import java.util.List;

import com.example.approfisso.crud.CriaBD;
import com.example.approfisso.crud.Dados;
import com.example.approfisso.crud.ManipulaBD;
import com.example.approfisso.domain.Empregos;


import java.util.List;


public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db=new ManipulaBD(getApplicationContext());

        atualiza();

    }

    private List<Empregos> dados;
    ArrayAdapter<String> adapter;
    ManipulaBD db;

    private void atualiza() {
        dados =db.getProdutos();
        adapter =
                new ArrayAdapter(this, R.layout.support_simple_spinner_dropdown_item,
                        dados );



    }

    public void novoProduto(View view) {
        Intent it = new Intent(this, Oferece_emprego.class);
        startActivityForResult(it, 201, null);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 201)
            if (resultCode == RESULT_OK) {
                atualiza();
                Toast.makeText(this, "Salvo " , Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Saiu", Toast.LENGTH_SHORT).show();
            }

    }
}