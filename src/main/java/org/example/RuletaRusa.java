package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RuletaRusa {

    /*
        Atributos
     */
    List<Integer> tambor = new ArrayList<>();

    int bala;
    int posicionActual;

    Random random;

    /*
        Constructor
     */
    public RuletaRusa(int camaras) {
        random = new Random();
        for (int i = 0; i < camaras; i++) {
            tambor.add(i);
        }

        bala = random.nextInt(0,camaras-1);

        this.posicionActual = random.nextInt(0,tambor.getLast());


    }

    /*
        Metodos
     */

    public boolean disparar()
    {
        if (posicionActual == bala)
        {
            System.out.println("Perder");
            bala = random.nextInt(0, tambor.getLast());
            posicionActual = random.nextInt(0, tambor.getLast());
            return true;
        }

        if (posicionActual == tambor.getLast())
        {
            posicionActual = tambor.getFirst();
        }
        else {
            posicionActual ++;
        }
        System.out.println("Sobrevive");
        return false;

    }

    public void reiniciarJuego (int camaras)
    {
        for (int i = 0; i < camaras; i++) {
            tambor.add(i);
        }

        bala = random.nextInt(0,camaras-1);

        this.posicionActual = random.nextInt(0,tambor.getLast());
    }
}
