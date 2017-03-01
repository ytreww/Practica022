package com.example.soportecea.practica02;

import android.app.Application;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickIniciar(View view){
        intent= new Intent(this,Juego.class);
        startActivity(intent);


    }

    public void clickInfo(View view){
        intent = new Intent(this, Informacion.class);
        startActivity(intent);
    }

    public void clickSalir(View view){
        System.exit(0);
    }
}
