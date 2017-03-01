package com.example.soportecea.practica02;

import android.app.Application;
import android.content.DialogInterface;
import android.content.Intent;
import android.preference.DialogPreference;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Map;

public class Juego extends AppCompatActivity {
    private Logica logica;
    private boolean resultado = false;
    private int cpuChoice;
    Intent intent;
    TextView txtCpuChoice;
    TextView txtPlayerChoice;
    TextView txtRonda;
    TextView txtScreen;
    TextView txtPlayerName;
    TextView txtCpuName;
    Map armas;
    int ronda = 0;
    int playerPoints=0;
    int cpuPoints=0;
    String[] resultados= new String[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle("Rock, Paper, Scissors, Lizard , Spock");
        setContentView(R.layout.activity_juego);
        logica = new Logica();
        txtCpuChoice = (TextView) findViewById(R.id.cpuChoice);
        txtPlayerChoice = (TextView)findViewById(R.id.playerChoice);
        txtRonda = (TextView)findViewById(R.id.txtRonda);
        txtScreen=(TextView)findViewById(R.id.screenMssg);
        txtPlayerName = (TextView)findViewById(R.id.playerName);
        txtCpuName = (TextView)findViewById(R.id.cpuName);
        armas=logica.getArmas();
        update();

    }

    public void onClick(View view) {
        if (view.getId() == R.id.btnRock) {
            Log.i("Boton", "Rock");
            resultado=logica.compararEleccion(0);
            txtPlayerChoice.setText(armas.get(0).toString());
            cpuChoice=logica.getCpuRandom();
            txtCpuChoice.setText(armas.get(cpuChoice).toString());
            if(cpuChoice!=0) {
                if (resultado) {
                    playerPoints++;
                    txtScreen.setText("Jugador gana");
                    resultados[ronda]= "Ronda "+ronda+": Jugador";

                } else {
                    cpuPoints++;
                    txtScreen.setText("Cpu gana");
                    resultados[ronda]= "Ronda "+ronda+": CPU";

                }
            }else{
                txtScreen.setText("Empate");
                ronda--;
            }
            ronda++;
            update();
            if(ronda==5){
                finish();
            }

        }
        if (view.getId() == R.id.btnPaper) {
            Log.i("Boton", "Paper");
            resultado=logica.compararEleccion(1);
            txtPlayerChoice.setText(armas.get(1).toString());
            cpuChoice=logica.getCpuRandom();
            txtCpuChoice.setText(armas.get(cpuChoice).toString());
            if(cpuChoice!=1) {
                if (resultado) {
                    playerPoints++;
                    txtScreen.setText("Jugador gana");
                    resultados[ronda]= "Ronda "+ronda+": Jugador";

                } else {
                    cpuPoints++;
                    txtScreen.setText("Cpu gana");
                    resultados[ronda]= "Ronda "+ronda+": CPU";

                }
            }else{
                txtScreen.setText("Empate");
                ronda--;
            }
            ronda++;
            update();
            if(ronda==5){
                finish();
            }

        }
        if (view.getId() == R.id.btnScissors) {
            Log.i("Boton", "Scissors");
            resultado=logica.compararEleccion(2);
            txtPlayerChoice.setText(armas.get(2).toString());
            cpuChoice=logica.getCpuRandom();
            txtCpuChoice.setText(armas.get(cpuChoice).toString());
            if(cpuChoice!=2) {
                if (resultado) {
                    playerPoints++;
                    txtScreen.setText("Jugador gana");
                    resultados[ronda]= "Ronda "+ronda+": Jugador";
                } else {
                    cpuPoints++;
                    txtScreen.setText("Cpu gana");
                    resultados[ronda]= "Ronda "+ronda+": CPU";
                }
            }else{
                txtScreen.setText("Empate");
                ronda--;
            }
            ronda++;
            update();
            if(ronda==5){
                finish();
            }

        }
        if (view.getId() == R.id.btnLizard) {
            Log.i("Boton", "Lizard");
            resultado=logica.compararEleccion(3);
            txtPlayerChoice.setText(armas.get(3).toString());
            cpuChoice=logica.getCpuRandom();
            txtCpuChoice.setText(armas.get(cpuChoice).toString());
            if(cpuChoice!=3) {
                if (resultado) {
                    playerPoints++;
                    txtScreen.setText("Jugador gana");
                    resultados[ronda]= "Ronda "+ronda+": Jugador";
                } else {
                    cpuPoints++;
                    txtScreen.setText("Cpu gana");
                    resultados[ronda]= "Ronda "+ronda+": CPU";
                }
            }else{
                txtScreen.setText("Empate");
                ronda--;
            }
            ronda++;
            update();
            if(ronda==5){
                finish();
            }

        }
        if (view.getId() == R.id.btnSpock) {
            Log.i("Boton", "Spock");
            resultado=logica.compararEleccion(4);
            txtPlayerChoice.setText(armas.get(4).toString());
            cpuChoice=logica.getCpuRandom();
            txtCpuChoice.setText(armas.get(cpuChoice).toString());
            if(cpuChoice!=4) {
                if (resultado) {
                    playerPoints++;
                    txtScreen.setText("Jugador gana");
                    resultados[ronda]= "Ronda "+ronda+": Jugador";
                } else {
                    cpuPoints++;
                    txtScreen.setText("Cpu gana");
                    resultados[ronda]= "Ronda "+ronda+": CPU";
                }
            }else{
                txtScreen.setText("Empate");
                ronda--;
            }
            ronda++;
            update();
            if(ronda==5){
                finish();
            }

        }

    }

    public void update() {
        if(ronda<=5) {
            txtRonda.setText("Ronda: " + ronda);
            txtCpuName.setText("CPU: " + cpuPoints);
            txtPlayerName.setText("Player: " + playerPoints);
        }
    }

    public void finish(){
        Log.i("puntos",""+cpuPoints+"s"+playerPoints);
        if(playerPoints>cpuPoints) {
            Toast.makeText(this, "Jugador gana la partida", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "CPU gana la partida", Toast.LENGTH_SHORT).show();
        }
        AlertDialog alertDialog = new AlertDialog.Builder(Juego.this).create();
        alertDialog.setTitle("Resultado");
        alertDialog.setMessage(resultados[0]+"\n"+resultados[1]+"\n"+resultados[2]+"\n"+resultados[3]+"\n"+resultados[4]+"\n");
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK", new DialogInterface.OnClickListener(){
            public void onClick(DialogInterface dialog, int wich){
                dialog.dismiss();
            }
        });
        alertDialog.show();
        this.recreate();
    }


}
