package com.example.appmultitarea.calcularEdad;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.appmultitarea.R;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EdadView extends AppCompatActivity {

    private EditText etNacimiento;
    private TextView tvEdadCalculada;
    private Button btnEnviarEdad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edad_view);

        begin();

        btnEnviarEdad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    calcularEdad();
                }
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    private void calcularEdad() {
        LocalDate today = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate birthday;
        boolean birthdayPassed;
        String birthdateStr = etNacimiento.getText().toString();
        String patternStr = "^(\\d{2})/(\\d{2})/(\\d{4})$";
        Pattern pattern = Pattern.compile(patternStr);
        Matcher validator = pattern.matcher(birthdateStr);

        if (!validator.find()) {
            Toast.makeText(this, "Formato de fecha incorrecto", Toast.LENGTH_SHORT).show();
            tvEdadCalculada.setText("");
        } else {
            birthday = LocalDate.parse(birthdateStr, formatter);
            birthdayPassed = (today.getMonthValue() > birthday.getMonthValue()) || (today.getMonthValue() == birthday.getMonthValue() && today.getDayOfMonth() >= birthday.getDayOfMonth());
            int age = today.getYear() - birthday.getYear() - (birthdayPassed ? 0 : 1);
            tvEdadCalculada.setText("Su edad es: " + age);
        }
    }

    private void begin() {
        etNacimiento = findViewById(R.id.etNacimiento);
        tvEdadCalculada = findViewById(R.id.tvEdadCalculada);
        btnEnviarEdad = findViewById(R.id.btnEnviarEdad);
    }
}
