package com.example.soportecea.practica02;

import android.content.Intent;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by SoporteCEA on 21/02/2017.
 */

public class Logica {

    private final static int ROCK = 0;
    private final static int PAPER = 1;
    private final static int SCISSORS = 2;
    private final static int LIZARD = 3;
    private final static int SPOCK = 4;

    private Map<Integer,String> armas= new HashMap<Integer, String>();
    private Random random;
    private int cpuRandom;

    public Logica(){
        random = new Random();
        armas.put(ROCK, "Piedra");
        armas.put(PAPER, "Papel");
        armas.put(SCISSORS, "Tijeras");
        armas.put(LIZARD, "Lagarto");
        armas.put(SPOCK, "Spock");

    }

    public boolean compararEleccion(int playerChoice){
        cpuRandom=random.nextInt(5);
        if(playerChoice == ROCK && (cpuRandom== LIZARD || cpuRandom== SCISSORS)){
            return true;
        }
        if(playerChoice == PAPER && (cpuRandom== ROCK || cpuRandom== SPOCK)){
            return true;
        }
        if(playerChoice == SCISSORS && (cpuRandom== PAPER || cpuRandom== LIZARD)){
            return true;
        }
        if(playerChoice == LIZARD && (cpuRandom== SPOCK || cpuRandom== PAPER)){
            return true;
        }
        if(playerChoice == SPOCK && (cpuRandom== SCISSORS || cpuRandom== PAPER)){
            return true;
        }
       return false;
    }

    public Map<Integer, String> getArmas() {
        return armas;
    }

    public int getCpuRandom() {
        return cpuRandom;
    }
}
