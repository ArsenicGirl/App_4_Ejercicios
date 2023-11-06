package com.example.appmultitarea.compra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.appmultitarea.MainActivity;
import com.example.appmultitarea.R;

import com.example.appmultitarea.compra.DatosCliente;
import com.example.appmultitarea.compra.Datos;

public class Factura extends AppCompatActivity {

    private TextView tvNombreFactura;
    private TextView tvDireccionFactura;
    private TextView tvSumatoriaFactura;
    private Button btnTerminar2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_factura);
        begin();

        Datos datosCliente = (Datos) getIntent().getSerializableExtra("DATOS_CLIENTE");
        int sumatoriaProductos = getIntent().getIntExtra("SUMATORIA_PRODUCTOS", 0);

        // Mostrar el nombre y la dirección del cliente en la factura
        String nombreCompleto = datosCliente.toString();
        tvNombreFactura.setText(nombreCompleto);
        tvDireccionFactura.setText("Dirección: " + datosCliente.direccion());

        // Mostrar la sumatoria de productos en la factura
        tvSumatoriaFactura.setText("Total: $" + sumatoriaProductos);

        this.btnTerminar2 = findViewById(R.id.btnTerminar2);
        btnTerminar2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });
    }

    public void begin(){
        this.tvNombreFactura = findViewById(R.id.tvNombreFactura);
        this.tvDireccionFactura = findViewById(R.id.tvDireccionFactura);
        this.tvSumatoriaFactura = findViewById(R.id.tvSumatoriaFactura);
    }
}