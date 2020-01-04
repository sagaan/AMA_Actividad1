package com.ama.act1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final int contador = getIntent().getExtras().getInt("unContador");
        Toast.makeText(Main2Activity.this, "Contador: "+contador, Toast.LENGTH_SHORT).show();

        final int contador2 = contador + 1;

        Button btnChangeActivity = findViewById(R.id.btnA2toA1);
        btnChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cambiarActivity = new Intent(Main2Activity.this, MainActivity.class);
                cambiarActivity.putExtra("otroContador",contador2);
                startActivity(cambiarActivity);
            }
        });
    }
}
