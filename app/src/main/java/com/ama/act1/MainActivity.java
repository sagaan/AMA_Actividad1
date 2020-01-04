package com.ama.act1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.err.println("onCreated(): Created Successfully");
        setContentView(R.layout.activity_main);

        int contador2;
        try {
            contador2 = getIntent().getExtras().getInt("otroContador");
        }catch(NullPointerException npe){
            contador2 = 0;
        }
        contador = contador2;

        Toast.makeText(MainActivity.this, "Contador: "+contador, Toast.LENGTH_SHORT).show();

        final TextView txtHello = findViewById(R.id.txtHello);
        Button btnHello = findViewById(R.id.btnHello);
        btnHello.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                if(contador % 2 == 0 )
                    txtHello.setText(contador + " es divisible entre 2");
                else
                    txtHello.setText(contador + " es indivisible entre 2");
            }
        });


        final EditText txtSaludo = findViewById(R.id.txtSaludo);
        final TextView txtInsert = findViewById(R.id.txtInsert);
        Button btnTransferir = findViewById(R.id.btnTransferir);
        btnTransferir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, txtSaludo.getText(), Toast.LENGTH_SHORT).show();
                //txtInsert.setText(txtSaludo.getText());
            }
        });

        Button btnChangeActivity = findViewById(R.id.btnA1toA2);
        btnChangeActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                contador++;
                Intent cambiarActivity = new Intent(MainActivity.this,Main2Activity.class);
                cambiarActivity.putExtra("unContador",contador);
                startActivity(cambiarActivity);
            }
        });
    }

    @Override
    protected void onStart(){
        super.onStart();
        System.err.println("onStart(): Started Successfully");
    }
    @Override
    protected void onResume(){
        super.onResume();
        System.err.println("onResume(): Resumed Successfully");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        System.err.println("onRestart(): Restarted Successfully");
    }

    @Override
    protected void onPause(){
        super.onPause();
        System.err.println("onPause(): Paused Successfully");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        System.err.println("onDestroy: Destroyed Successfully");
    }
}