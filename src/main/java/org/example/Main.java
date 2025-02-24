package org.example;

import java.util.Scanner;

public class Main {
    static Scanner teclado = new Scanner(System.in);
    static int monedasIngresadas = 0;
    static int monedas20 = 0;
    static int monedas50 = 0;
    static int monedas100 = 0;
    static int monedas500 = 0;
    static int alcancia = 0;
    public static void main(String[] args) {
        String menu = "Presione 1 para agregar monedas\nPresione 2 para ver cuantas monedas tiene de una denominación\nprecione 3 para ver cuantas monedas tiene en la alcancia\nPresione 4 para romper la alcancia\nPresione 0 para salir";
        System.out.println(menu);
        int eleccion = teclado.nextInt();
        //en una alcancia es 20 50 100 500 cuanto tiene en la alcancia sin romperla  cuantas monedas de cada denominación agregar monedas cuantas monedas tiene dinero ahorrado, romper alcancia
        while(eleccion != 0)
        {
            switch (eleccion)
            {
                case 1:
                    System.out.println("Ingrese la denominación de la moneda");
                    System.out.println("se ingreso una mondea de " + agregarMoneda(teclado.nextInt()));
                    break;
                case 2:
                    System.out.println("Ingrese la denominación de la moneda");
                    System.out.println(cantidadMonedas(teclado.nextInt()));
                    break;
                case 3:
                    System.out.println("Usted tiene un total de: " + alcancia + "$\n" + cantidadMonedas(20) + "\n" + cantidadMonedas(50) + "\n" + cantidadMonedas(100) + "\n" + cantidadMonedas(500));
                    break;
                case 4:
                    System.out.println("Se ha roto la alcancia, ha extraido un total de " + romperAlcancia());
                    System.out.println("Cantidad actual en la alcancia: " + alcancia);
                case 0:
                    break;
            }
            System.out.println(menu);
            eleccion = teclado.nextInt();
        }

    }

    public static int agregarMoneda(int valor){
        switch (valor)
        {
            case 20:

                monedas20++;
                alcancia += 20;
                break;
            case 50:
                monedas50++;
                alcancia += 50;
                break;
            case 100:
                monedas100++;
                alcancia += 100;
                break;
            case 500:
                monedas500++;
                alcancia += 500;
                break;
        }
        return valor;
    }

    public static String cantidadMonedas(int denominacion)
    {
        String mensaje = "Cantidad de monedas de ";
        switch (denominacion)
        {
            case 20:
                mensaje = mensaje.concat(Integer.toString(denominacion) + ": " + monedas20);
                break;
            case 50:
                mensaje = mensaje.concat(Integer.toString(denominacion)).concat(": ").concat(Integer.toString(monedas50));
                break;
            case 100:
                mensaje = mensaje.concat(Integer.toString(denominacion) + ": " + monedas100);
                break;
            case 500:
                mensaje = mensaje.concat(Integer.toString(denominacion) + ": " + monedas500);
                break;
        }
        return mensaje;
    }

    public static int romperAlcancia ()
    {
        int cantidadMonedasAlcancia = alcancia;

        monedas50 = 0;
        monedas20 = 0;
        monedas100 = 0;
        monedas500 = 0;
        alcancia = 0;
        monedasIngresadas = 0;

        return cantidadMonedasAlcancia;
    }

}