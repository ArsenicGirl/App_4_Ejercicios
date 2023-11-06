package com.example.appmultitarea.compra;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.appmultitarea.R;
import com.example.appmultitarea.compra.Datos;

public class DatosCliente extends AppCompatActivity {

    private EditText etNombreCliente;
    private EditText etApellidoCliente;
    private EditText etDireccionCliente;
    private Button btnDatosCliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);
        begin();

        btnDatosCliente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = etNombreCliente.getText().toString();
                String apellido = etApellidoCliente.getText().toString();
                String direccion = etDireccionCliente.getText().toString();

                Datos datosCliente = new Datos(nombre, apellido, direccion);
                Intent intent = new Intent(DatosCliente.this, Productos.class);
                intent.putExtra("DATOS_CLIENTE", datosCliente);
                startActivity(intent);
            }
        });
    }
    private void begin(){
        this.etNombreCliente = findViewById(R.id.etNombreCliente);
        this.etApellidoCliente = findViewById(R.id.etApellidoCliente);
        this.etDireccionCliente = findViewById(R.id.etDireccion);
        this.btnDatosCliente = findViewById(R.id.btnDatosCliente);
    }


}