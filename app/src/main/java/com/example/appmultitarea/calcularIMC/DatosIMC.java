package com.example.appmultitarea.calcularIMC;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.appmultitarea.R;

public class DatosIMC extends AppCompatActivity {

    private EditText etEstatura1;
    private EditText etPeso1;
    private TextView tvResultadoIng;
    private EditText etEstatura2;
    private EditText etPeso2;
    private Button btnCalcularIMC;
    private TextView tvResultadoMet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_imc);
        begin();

        btnCalcularIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMCIngles();
                calcularIMCMetrico();
            }
        });

    }

    private void begin() {
        etEstatura1 = findViewById(R.id.etEstatura1);
        etEstatura2 = findViewById(R.id.etEstatura2);
        etPeso1 = findViewById(R.id.etPeso1);
        etPeso2 = findViewById(R.id.etPeso2);
        btnCalcularIMC = findViewById(R.id.btnCalcularIMC);
        tvResultadoIng = findViewById(R.id.tvResultadoIng);
        tvResultadoMet = findViewById(R.id.tvResultadoMet);
    }

    private void calcularIMCIngles() {
        double estaturaIngles = Double.parseDouble(etEstatura1.getText().toString());
        double pesoIngles = Double.parseDouble(etPeso1.getText().toString());
        double resultadoIMC = (pesoIngles / (estaturaIngles * estaturaIngles)) * 703.0;
        tvResultadoIng.setText("IMC en sistema inglés: " + resultadoIMC);
    }

    private void calcularIMCMetrico() {
        double estaturaMetrico = Double.parseDouble(etEstatura2.getText().toString());
        double pesoMetrico = Double.parseDouble(etPeso2.getText().toString());
        double resultadoIMC = pesoMetrico / (estaturaMetrico * estaturaMetrico);
        tvResultadoMet.setText("IMC en sistema métrico: " + resultadoIMC);
    }
}
