package com.example.appmultitarea.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import com.example.appmultitarea.R;
import com.example.appmultitarea.compra.Factura;
import com.example.appmultitarea.compra.Productos;

public class Preguntas extends AppCompatActivity {

    private RadioButton rbAPregunta1;
    private RadioButton rbBPregunta1;
    private RadioButton rbAPregunta2;
    private RadioButton rbBPregunta2;
    private RadioButton rbAPregunta3;
    private RadioButton rbBPregunta3;
    private RadioButton rbAPregunta4;
    private RadioButton rbBPregunta4;
    private RadioButton rbAPregunta5;
    private RadioButton rbBPregunta5;
    private RadioButton rbAPregunta6;
    private RadioButton rbBPregunta6;
    private Button btnResponder;

    private int puntuacionTotal = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preguntas);
        begin();

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularPuntuacion();
            }
        });

    }

    private void calcularPuntuacion() {
        int pregunta1 = Integer.parseInt((rbAPregunta1.isChecked() == true) ? "1" : "2");
        int pregunta2 = Integer.parseInt((rbAPregunta2.isChecked() == true) ? "1" : "2");
        int pregunta3 = Integer.parseInt((rbAPregunta3.isChecked() == true) ? "1" : "2");
        int pregunta4 = Integer.parseInt((rbAPregunta4.isChecked() == true) ? "1" : "2");
        int pregunta5 = Integer.parseInt((rbAPregunta5.isChecked() == true) ? "1" : "2");
        int pregunta6 = Integer.parseInt((rbAPregunta6.isChecked() == true) ? "1" : "2");

        puntuacionTotal = pregunta1 + pregunta2 + pregunta3 + pregunta4 + pregunta5 + pregunta6;

        if (puntuacionTotal <= 8){
                Intent aziraphale = new Intent(getApplicationContext(), TestRespuestaAziraphale.class);
                startActivity(aziraphale);
        } else if (puntuacionTotal >= 9){
                Intent crowley = new Intent(getApplicationContext(), TestRespuestaCrowley.class);
                startActivity(crowley);
        }
    }

    public void begin(){
        this.rbAPregunta1 = findViewById(R.id.rbAPregunta1);
        this.rbBPregunta1 = findViewById(R.id.rbBPregunta1);
        this.rbAPregunta2 = findViewById(R.id.rbAPregunta2);
        this.rbBPregunta2 = findViewById(R.id.rbBPregunta2);
        this.rbAPregunta3 = findViewById(R.id.rbAPregunta3);
        this.rbBPregunta3 = findViewById(R.id.rbBPregunta3);
        this.rbAPregunta4 = findViewById(R.id.rbAPregunta4);
        this.rbBPregunta4 = findViewById(R.id.rbBPregunta4);
        this.rbAPregunta5 = findViewById(R.id.rbAPregunta5);
        this.rbBPregunta5 = findViewById(R.id.rbBPregunta5);
        this.rbAPregunta6 = findViewById(R.id.rbAPregunta6);
        this.rbBPregunta6 = findViewById(R.id.rbBPregunta6);
        this.btnResponder = findViewById(R.id.btnResponder);
    }
}