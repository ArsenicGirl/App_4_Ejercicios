package com.example.appmultitarea;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appmultitarea.calcularEdad.EdadView;
import com.example.appmultitarea.calcularIMC.DatosIMC;
import com.example.appmultitarea.compra.DatosCliente;
import com.example.appmultitarea.test.Preguntas;

public class MainActivity extends AppCompatActivity {

    private Button btnCE;
    private Button btnIMC;
    private Button btnCompra;
    private Button btnTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //CALCULO EDAD
        this.btnCE = findViewById(R.id.btnCE);

        btnCE.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCE = new Intent(getApplicationContext(), EdadView.class);
                startActivity(goCE);
            }
        });

        //COMPRA

        this.btnCompra = findViewById(R.id.btnCompra);

        btnCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goCompra = new Intent(getApplicationContext(), DatosCliente.class);
                startActivity(goCompra);
            }
        });

        //TEST

        this.btnTest = findViewById(R.id.btnTest);

        btnTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goTest = new Intent(getApplicationContext(), Preguntas.class);
                startActivity(goTest);
            }
        });

        //IMC
        this.btnIMC = findViewById(R.id.btnIMC);

        btnIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goIMC = new Intent(getApplicationContext(), DatosIMC.class);
                startActivity(goIMC);
            }
        });


    }
}