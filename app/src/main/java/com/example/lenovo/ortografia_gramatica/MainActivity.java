package com.example.lenovo.ortografia_gramatica;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.NumberPicker;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_MESSAGE="com.example.lenovo.ortografia_gramatica";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText et = (EditText)findViewById(R.id.new_paragraph);
        NumberPicker np = (NumberPicker)findViewById(R.id.NumberPicker01);
        np.setMinValue(0);
        np.setMaxValue(100);
        np.setWrapSelectorWheel(false);
    }
    public void enviarParrafo(View view){
        Intent intent = new Intent(this,MostrarParrafo.class);
        Bundle bundle = new Bundle();
        String parrafo = ((EditText)findViewById(R.id.new_paragraph)).getText().toString();
        String palabras[] = parrafo.split(" ");
        int total = palabras.length;
        int numeropalabras = ((NumberPicker)findViewById(R.id.NumberPicker01)).getValue();
        bundle.putStringArray("EXTRA_PALABRAS",palabras);
        bundle.putInt("EXTRA_TOTAL",total);
        bundle.putInt("EXTRA_NPALABRAS",numeropalabras);
        intent.putExtra(EXTRA_MESSAGE,bundle);
        startActivity(intent);
    }
}
