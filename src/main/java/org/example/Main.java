package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Cabina> cabinas = new ArrayList<>();
        Scanner scn = new Scanner(System.in);

        int opcion = 1;

        while (opcion != 0) {
            System.out.println("Opción 1: crear cabina\nOpción 2: registrar llamada\nOpción 3 :mostrar información de cabina\nOpción 4: mostrar información total cabinas\nOpción 5: Reiniciar cabina");
            opcion = scn.nextInt();
            switch (opcion) {
                case 1 -> {
                    System.out.println("ingrese el nombre o identificador de la cabina");
                    String nombre = scn.next();
                    System.out.println("Ingrese el costo local");
                    double costoLocal = scn.nextDouble();
                    System.out.println("Ingrese el costo a distancia");
                    double costoDistancia = scn.nextDouble();
                    System.out.println("Ingrese el costo a celular");
                    double costoCelular = scn.nextDouble();
                    cabinas.add(new Cabina(nombre, costoLocal, costoDistancia, costoCelular));
                }
                case 2 -> {
                    System.out.println("Elija la cabina");
                    for(Cabina cabina : cabinas)
                    {
                        System.out.println(cabina.getIdCabina());
                    }
                    String seleccionCabina = scn.next();
                    for(Cabina cabina : cabinas)
                    {
                        if (cabina.getIdCabina().equals(seleccionCabina))
                        {
                            do {
                                System.out.println("Seleccione el tipo de llamada. 1 para local, 2 para distancia y 3 para celular");
                            }while(!cabina.registrarLlamada(scn.nextInt()));
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Elija la cabina");
                    for(Cabina cabina : cabinas)
                    {
                        System.out.println(cabina.getIdCabina());
                    }
                    String seleccionCabina = scn.next();
                    for(Cabina cabina : cabinas)
                    {
                        if (cabina.getIdCabina().equals(seleccionCabina))
                        {
                            System.out.println(cabina.detalleCabina());
                        }
                    }
                }
                case 4 -> {
                    for(Cabina cabina : cabinas)
                    {
                        System.out.println(cabina.detalleCabina());
                    }
                }
                case 5 -> {
                    System.out.println("Elija la cabina");
                    for(Cabina cabina : cabinas)
                    {
                        System.out.println(cabina.getIdCabina());
                    }
                    String seleccionCabina = scn.next();
                    for(Cabina cabina : cabinas)
                    {
                        if (cabina.getIdCabina().equals(seleccionCabina))
                        {
                            System.out.println("Ingrese el costo local");
                            double costoLocal = scn.nextDouble();
                            System.out.println("Ingrese el costo a distancia");
                            double costoDistancia = scn.nextDouble();
                            System.out.println("Ingrese el costo a celular");
                            double costoCelular = scn.nextDouble();
                            cabina.reiniciar(costoLocal, costoDistancia, costoCelular);
                        }
                    }
                }
            }

        }
    }
}

