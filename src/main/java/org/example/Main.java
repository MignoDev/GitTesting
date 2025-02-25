package org.example;

import java.util.Scanner;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int dado1Sum =  0;
        int dado2Sum = 0;
        int dado1 = 0;
        int dado2 = 0;


        System.out.println("dados");
        int lanzamientos = (int)(Math.random()*100);

        for (int i=0; i<lanzamientos; i++)
        {
            dado1 = (int)(Math.random()*10);
            dado2 = (int)(Math.random()*10);
            while(dado1 > 6)
            {
                dado1 = (int)(Math.random()*10);
            }
            while(dado2 > 6)
            {
                dado2 = (int)(Math.random()*10);
            }
            dado1Sum += dado1;
            dado2Sum += dado2;
        }
        if (dado1Sum > dado2Sum)
        {
            System.out.println("Dado 1 ganador con:" + dado1Sum + " - " + dado2Sum);
        }else if (dado2Sum > dado1Sum) {
            System.out.println("Dado 2 ganador con:" + dado2Sum + " - " + dado1Sum);
        } else {
            System.out.println("Se ha generado un empate con: " + dado1Sum + " - " + dado2Sum);
        }

        System.out.println("Piedra, papel o tijera");

        //1: Piedra 2: Papel 3: Tijera

        Random random = new Random();

        int jugador1 = 0;
        int jugador2 = 0;

        int lanzamientoJugador1 = 0;
        int lanzamientoJugador2 = 0;

        int ronda = 0;

        while (jugador1<2 && jugador2<2)
        {
            ronda ++;
            lanzamientoJugador1 = 1+random.nextInt(3);
            lanzamientoJugador2 = 1+random.nextInt(3);

            switch (lanzamientoJugador1)
            {
                case 1 -> {
                    switch (lanzamientoJugador2) {
                        case 3 -> {
                            jugador1++;
                            System.out.println("ronda " + ronda + " gana jugador 1 con piedra contra tijera");
                        }
                        case 2 -> {
                            jugador2++;
                            System.out.println("ronda " + ronda + " gana jugador 2 con papel contra piedra");
                        }
                        default -> System.out.println("ronda " + ronda + " empate");

                    }
                }
                case 2 -> {
                    switch (lanzamientoJugador2){
                        case 1 -> {
                            jugador1++;
                            System.out.println("ronda " + ronda + " gana jugador 1 con papel contra piedra");
                        }
                        case 3 -> {
                            jugador2++;
                            System.out.println("ronda " + ronda + " gana jugador 2 con tijera contra papel");
                        }
                        default -> System.out.println("ronda " + ronda + " empate");
                    }
                }
                case 3 -> {
                    switch (lanzamientoJugador2) {
                        case 1 -> {
                            jugador2++;
                            System.out.println("ronda " + ronda + " gana jugador 2 con piedra contra tijera");
                        }
                        case 2 -> {
                            jugador1++;
                            System.out.println("ronda " + ronda + " gana jugador 1 con tijera contra papel");
                        }
                        default -> System.out.println("ronda " + ronda + " empate");
                    }
                }
            }

        }

        if (jugador1 > jugador2)
        {
            System.out.println("Ganador jugador 1 con: " + jugador1 + " - " + jugador2);
        } else {
            System.out.println("Ganador jugador 2 con: " + jugador2 + " - " + jugador1);
        }
    }
}