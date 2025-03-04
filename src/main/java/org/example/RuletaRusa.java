package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class RuletaRusa {

    /*
        Atributos
     */
    private List<Integer> tambor = new ArrayList<>();

    private int bala;
    private int posicionActual;

    private Random random;

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
        setter y getters
     */

    public List<Integer> getTambor() {
        return tambor;
    }

    public void setTambor(List<Integer> tambor) {
        this.tambor = tambor;
    }

    public int getBala() {
        return bala;
    }

    public void setBala(int bala) {
        this.bala = bala;
    }

    public int getPosicionActual() {
        return posicionActual;
    }

    public void setPosicionActual(int posicionActual) {
        this.posicionActual = posicionActual;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "RuletaRusa{" +
                "tambor=" + tambor +
                ", bala=" + bala +
                ", posicionActual=" + posicionActual +
                ", random=" + random +
                '}';
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
