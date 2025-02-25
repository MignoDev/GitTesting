package org.example;

import java.util.Scanner;

import java.util.Random;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Random rnd = new Random();

        int influenciaInternet = 7000000;
        int influenciaRadio = 200000;
        int influenciaTelevision = 600000;

        int candidato1 = 0;
        int costoCampana1 = 0;
        double porcentaje1 = 0f;
        int candidato1Internet = 0;
        int candidato1Radio = 0;
        int candidato1Television = 0;

        int candidato2 = 0;
        int costoCampana2 = 0;
        double porcentaje2 = 0f;
        int candidato2Internet = 0;
        int candidato2Radio = 0;
        int candidato2Television = 0;

        int candidato3 = 0;
        int costoCampana3 = 0;
        double porcentaje3 = 0f;
        int candidato3Internet = 0;
        int candidato3Radio = 0;
        int candidato3Television = 0;

        int numeroVotos = 1+rnd.nextInt(100);

        int metodoVoto = 1+rnd.nextInt(3);

        int voto = 1+rnd.nextInt(3);

        double costoPromedio = 0;


        for (int i = 0; i < numeroVotos; i++)
        {
            //System.out.println(voto);
            switch (metodoVoto){
                case 1 -> {
                    switch (voto)
                    {
                        case 1 -> {
                            candidato1++;
                            candidato1Internet++;
                        }
                        case 2 -> {
                            candidato2++;
                            candidato2Internet++;
                        }
                        case 3 -> {
                            candidato3++;
                            candidato3Internet++;
                        }
                    }
                }
                case 2 -> {
                    switch (voto)
                    {
                        case 1 -> {
                            candidato1++;
                            candidato1Radio++;
                        }
                        case 2 -> {
                            candidato2++;
                            candidato2Radio++;
                        }
                        case 3 -> {
                            candidato3++;
                            candidato3Radio++;
                        }
                    }
                }
                case 3 -> {
                    switch (voto)
                    {
                        case 1 -> {
                            candidato1++;
                            candidato1Television++;
                        }
                        case 2 -> {
                            candidato2++;
                            candidato2Television++;
                        }
                        case 3 -> {
                            candidato3++;
                            candidato3Television++;
                        }
                    }
                }
            }

            metodoVoto = 1+rnd.nextInt(3);

            voto = 1+rnd.nextInt(3);
        }

        costoCampana1 = (influenciaInternet * candidato1Internet) + (influenciaRadio * candidato1Radio) + (influenciaTelevision * candidato1Television);
        costoCampana2 = (influenciaInternet * candidato2Internet) + (influenciaRadio * candidato2Radio) + (influenciaTelevision * candidato2Television);
        costoCampana3 = (influenciaInternet * candidato3Internet) + (influenciaRadio * candidato3Radio) + (influenciaTelevision * candidato3Television);

        porcentaje1 = (candidato1/((double)numeroVotos))*100;
        porcentaje2 = (candidato2/((double)numeroVotos))*100;
        porcentaje3 = (candidato3/((double)numeroVotos))*100;



        System.out.println("Costo camapaña candidato 1: " + costoCampana1);
        System.out.println("Influencia internet: " + (influenciaInternet * candidato1Internet));
        System.out.println("Influencia radio: " + (influenciaRadio * candidato1Radio));
        System.out.println("Influencia telvisión: " + (influenciaTelevision * candidato1Television));
        System.out.println("--------------------------------------------");
        System.out.println("Costo camapaña candidato 2: " + costoCampana2);
        System.out.println("Influencia internet: " + (influenciaInternet * candidato2Internet));
        System.out.println("Influencia radio: " + (influenciaRadio * candidato2Radio));
        System.out.println("Influencia telvisión: " + (influenciaTelevision * candidato2Television));
        System.out.println("--------------------------------------------");
        System.out.println("Costo camapaña candidato 3: " + costoCampana3);
        System.out.println("Influencia internet: " + (influenciaInternet * candidato3Internet));
        System.out.println("Influencia radio: " + (influenciaRadio * candidato3Radio));
        System.out.println("Influencia telvisión: " + (influenciaTelevision * candidato3Television));
        System.out.println("--------------------------------------------");

        System.out.println("Número total de votos " + numeroVotos);

        System.out.println("Porcentaje de votos por candidato");
        System.out.println("Candidato 1: " + porcentaje1 + "%");
        System.out.println("Candidato 2: " + porcentaje2 + "%");
        System.out.println("Candidato 3: " + porcentaje3 + "%");
        System.out.println("--------------------------------------------");
        System.out.println("Costo promedio de camapaña en las elecciones:");
        System.out.println("$" + (costoCampana1 + costoCampana2 + costoCampana3)/3);

        candidato1 = 0;
        candidato2 = 0;
        candidato3 = 0;
        numeroVotos = 0;
    }
}