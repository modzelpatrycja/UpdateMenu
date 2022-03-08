package com.example.updatemenu;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

public class VMenu extends AppCompatActivity implements IListaDan {
    Button przyciskZmiany;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListaDan.clear();
        ListaDan.add(new MPozycjaMenu("Kurczak z ryżem"));
        ListaDan.add(new MPozycjaMenu("Kotlety sojowe"));
        ListaDan.add(new MPozycjaMenu("Pizza"));
        ListaDan.add(new MPozycjaMenu("Makaron"));
        ListaDan.add(new MPozycjaMenu("Sałatka Cezar"));
        ListaDan.add(new MPozycjaMenu("Kanapka"));
        przyciskZmiany = findViewById(R.id.zmianaPrzycisk);
        przyciskZmiany.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                wyświetlOknoDokonywaniaZmian(v);
            }
        });

    }

    private void wyświetlOknoDokonywaniaZmian(View v) {
        Intent intent = new Intent(getApplicationContext(), VOknoDokonywaniaZmian.class);
        startActivity(intent);
    }

}