package com.example.updatemenu;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VOknoDokonywaniaZmian extends AppCompatActivity implements IListaDan {

    private RecyclerView recView;
    private ListaAdapter ListaAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_okno_dokonywania_zmian);
        listaView();
    }

    private void listaView() {
        recView = findViewById(R.id.rec);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recView.setLayoutManager(layoutManager);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recView.getContext(), layoutManager.getOrientation());
        recView.addItemDecoration(dividerItemDecoration);

        ListaAdapter = new ListaAdapter(ListaDan);
        recView.setAdapter(ListaAdapter);

    }
}