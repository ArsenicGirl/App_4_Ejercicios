package com.example.appmultitarea.test;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.appmultitarea.MainActivity;
import com.example.appmultitarea.R;

public class TestRespuestaCrowley extends AppCompatActivity {

    private Button btnVolverTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_respuesta_crowley);
        this.btnVolverTest = findViewById(R.id.btnVolverTest);
        btnVolverTest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent back = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(back);
            }
        });
    }
}