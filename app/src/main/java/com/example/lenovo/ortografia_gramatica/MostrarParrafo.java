package com.example.lenovo.ortografia_gramatica;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Random;

/**
 * Created by LenoVo on 3/18/2018.
 */

public class MostrarParrafo extends AppCompatActivity{

    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mostrar_parrafo);
        Bundle bundle = getIntent().getBundleExtra(MainActivity.EXTRA_MESSAGE);
        String palabras[] = bundle.getStringArray("EXTRA_PALABRAS");
        int total = bundle.getInt("EXTRA_TOTAL");
        int numero_palabras = bundle.getInt("EXTRA_NPALABRAS");
        if (palabras.length < numero_palabras){
            numero_palabras = palabras.length;
        }
        TextView vertotal = new TextView(this);
        String ntotal = getString(R.string.total_words) + total;
        vertotal.setText(ntotal);
        vertotal.setTextSize(30);
        vertotal.setTextColor(Color.parseColor("#000000"));
        TextView verparrafo = new TextView(this);
        String parrafo = "";
        Random rn = new Random();
        for (int i = 0 ; i < numero_palabras; i++){
            parrafo += palabras[rn.nextInt(numero_palabras)] + " ";
        }
        verparrafo.setText(parrafo);
        verparrafo.setTextSize(30);
        verparrafo.setTextColor(Color.parseColor("#000000"));
        ViewGroup layout = (ViewGroup)findViewById(R.id.mostrar_parrafo);
        vertotal.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        verparrafo.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        layout.setPadding(30, 30,30,0);
        layout.addView(vertotal);
        layout.addView(verparrafo);
    }
}
