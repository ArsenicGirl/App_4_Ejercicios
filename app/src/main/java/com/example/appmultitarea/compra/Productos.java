package com.example.appmultitarea.compra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import com.example.appmultitarea.R;

public class Productos extends AppCompatActivity {

    private CheckBox cbChocolates;
    private CheckBox cbDesayuno;
    private CheckBox cbPeluches;
    private CheckBox cbDulces;
    private CheckBox cbAccesorios;
    private CheckBox cbArreglos;
    private Button btnRegistrarProductos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        begin();

        btnRegistrarProductos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Calcular sumatoria de productos seleccionados
                int sumatoria = calcularSumatoria();
                Datos datosCliente = (Datos) getIntent().getSerializableExtra("DATOS_CLIENTE");
                Intent intent = new Intent(Productos.this, Factura.class);
                intent.putExtra("DATOS_CLIENTE", datosCliente);
                intent.putExtra("SUMATORIA_PRODUCTOS", sumatoria);
                startActivity(intent);
            }
        });
    }

    private int calcularSumatoria() {
        int sumatoria = 0;
        if (cbChocolates.isChecked()) {
            sumatoria += 3000;
        }
        if (cbDesayuno.isChecked()) {
            sumatoria += 10000;
        }
        if (cbPeluches.isChecked()) {
            sumatoria += 5000;
        }
        if (cbDulces.isChecked()) {
            sumatoria += 5000;
        }
        if (cbAccesorios.isChecked()) {
            sumatoria += 2000;
        }
        if (cbArreglos.isChecked()) {
            sumatoria += 10000;
        }
        return sumatoria;
    }

    public void begin(){
        this.cbChocolates = findViewById(R.id.cbChocolates);
        this.cbDesayuno = findViewById(R.id.cbDesayuno);
        this.cbPeluches = findViewById(R.id.cbPeluche);
        this.cbDulces = findViewById(R.id.cbDulces);
        this.cbAccesorios = findViewById(R.id.cbAccesorios);
        this.cbArreglos = findViewById(R.id.cbArreglos);
        this.btnRegistrarProductos = findViewById(R.id.btnRegistrarProductos);
    }
}