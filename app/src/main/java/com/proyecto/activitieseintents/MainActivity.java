package com.proyecto.activitieseintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private EditText editText;
    private TextView textView, mensaje;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        editText = findViewById(R.id.editTextTextPersonName);
        textView = findViewById(R.id.textView3);
        mensaje = findViewById(R.id.textView4);

        textView.setVisibility(View.INVISIBLE);
        mensaje.setVisibility(View.INVISIBLE);


        String message;
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                message = null;
            } else {


                message = extras.getString("mensajeReplica");
                textView.setVisibility(View.VISIBLE);
                mensaje.setVisibility(View.VISIBLE);
                mensaje.setText(message);
            }
        } else {
            message = (String) savedInstanceState.getSerializable("mensaje");
        }


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals(" ")) {
                    Toast.makeText(MainActivity.this, "Introduce un texto para enviar a la segunda actividad", Toast.LENGTH_SHORT).show();
                } else {
                    Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                    intent.putExtra("mensaje", editText.getText().toString());
                    startActivity(intent);
                }
            }
        });
    }
}