package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);

        CuentaBancaria cuenta1 = new CuentaBancaria("José Gonzales", 0, "1");
        CuentaBancaria cuenta2 = new CuentaBancaria("Mario Perez", 1000000, "2");
        CuentaBancaria cuenta3 = new CuentaBancaria();

        List<CuentaBancaria> cuentasBancarias = new ArrayList<>();
        cuenta3.setTitular("Francisco Fuentes");
        cuenta3.setSaldo(25000000);
        cuenta3.setNumeroCuenta("3");

        cuentasBancarias.add(cuenta1);
        cuentasBancarias.add(cuenta2);
        cuentasBancarias.add(cuenta3);

        int opcion = 0;
        double monto;
        String numeroCuenta;

        System.out.println("Cuentas disponibles");
        for (CuentaBancaria cuenta: cuentasBancarias)
        {
            System.out.println(cuenta.getNumeroCuenta());
        }

        do {

            System.out.println("Ingrese su número de cuenta o presione 0 para salir");
            numeroCuenta = teclado.next();

            for (CuentaBancaria cuenta: cuentasBancarias)
            {
                if (numeroCuenta.equals(cuenta.getNumeroCuenta()))
                {
                    System.out.println("Presione 1 para retirar dinero\nPresione 2 para depositar dinero\nPresione 3 para ver la información de su cuenta\n presione cualquier otro boton para salir");
                    opcion = teclado.nextInt();

                    switch (opcion){
                        case 1 -> {
                            do{
                                System.out.println("ingrese el monto a retirar");
                                monto = teclado.nextDouble();
                            } while (!cuenta.retirar(monto));
                            monto = 0;
                        }
                        case 2 -> {
                            System.out.println("Ingrese el monto del depósito");
                            monto = teclado.nextDouble();
                            cuenta.depositar(monto);
                            monto = 0;
                        }
                        case 3 -> {
                            System.out.println(cuenta.toString());
                        }
                    }
                } else {
                    opcion = 0;
                }
            }


        } while ((opcion == 1 || opcion == 2 || opcion == 3) || !numeroCuenta.equals("0"));
    }
}

