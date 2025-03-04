package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RuletaRusa ruletaRusa;
        Scanner scanner = new Scanner(System.in);
        List<String>jugadores = new ArrayList<>();

        Random random = new Random();

        int jugadorTurno;
        int numeroJugadores;
        int opcion;

        //region Inicio del juego
        System.out.println("Ruleta rusa, presione 1 para jugar cualquier otra numero para cerrar el juego");
        opcion = scanner.nextInt();
        //endregion
        while(opcion == 1) {

            //region seleccion de jugadores
            do {
                System.out.println("ingrese cantidad de jugadores");
                numeroJugadores = scanner.nextInt();
                if (numeroJugadores <= 0) {
                    System.out.println("numero de jugadores invalido");
                } else {
                    for (int i = 0; i < numeroJugadores; i++) {
                        System.out.println("ingrese nombre del jugador " + (i+1));
                        jugadores.add(scanner.next());
                    }
                }
            } while (numeroJugadores <= 0);
            int nCamaras;
            if (numeroJugadores < 4)
            {
                nCamaras = 4;
            } else if( numeroJugadores > 6)
            {
                nCamaras = 6;
            } else {
                nCamaras = numeroJugadores;
            }
            ruletaRusa = new RuletaRusa(nCamaras);
            //endregion

            //region Desarrollo del juego

            jugadorTurno = random.nextInt(0, jugadores.size() - 1);

            do {
                System.out.println("turno del jugador " + jugadores.get(jugadorTurno));
                System.out.println("presione 1 para disparar");
                opcion = scanner.nextInt();
                if (opcion == 1)
                {
                    if (ruletaRusa.disparar()) {
                        System.out.println("Jugador " + jugadores.get(jugadorTurno) + " eliminado");
                        jugadores.remove(jugadorTurno);
                        if (jugadorTurno >= jugadores.size()-1) {
                            jugadorTurno = 0;
                        } else {
                            jugadorTurno++;
                        }
                    } else {
                        if (jugadorTurno >= jugadores.size()-1) {
                            jugadorTurno = 0;
                        } else {
                            jugadorTurno++;
                        }
                    }
                }
            } while (jugadores.size() >= 2);


            //endregion

            //region fin del juego
            System.out.println("Ganador jugador " + jugadores.getFirst());
            System.out.println("Si desea reinciar presione 1, si desea reiniciar,si desea salir presione otro numero");
            opcion = scanner.nextInt();
            //endregion
        }


    }
}

