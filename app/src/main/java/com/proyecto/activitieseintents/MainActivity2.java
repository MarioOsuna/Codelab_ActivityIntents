package com.proyecto.activitieseintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView, mensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        button = findViewById(R.id.button2);
        editText = findViewById(R.id.editTextTextPersonName2);
        textView = findViewById(R.id.textView);
        mensaje = findViewById(R.id.textView2);

        Bundle extras = getIntent().getExtras();

        Intent intent = getIntent();
        String message = extras.getString("mensaje");


        mensaje.setText(message);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(" ")) {
                    Toast.makeText(MainActivity2.this, "Introduce un texto para enviar a la segunda actividad", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                    intent.putExtra("mensajeReplica", editText.getText().toString());
                    setResult(RESULT_OK,intent);
                    finish();
                    startActivity(intent);
                }
            }
        });

    }
}