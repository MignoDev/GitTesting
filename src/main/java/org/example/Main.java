package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Producto> listProductos = new ArrayList<>();
        Scanner tcl = new Scanner(System.in);
        int opcion = 1;

        while (opcion != 0)
        {
            System.out.println("Opción 1: crear producto\nOpción 2: vender producto\nOpción 3: Reponer stock\nOpción 4: Aplicar descuento\nOpción 5: información del producto\nOpción 6: subir precio");
            System.out.println("Opción 7: valor inventario\nOpción 8: Comparar precios\nOpcion 9: ver lista de productos");
            opcion = tcl.nextInt();
            switch (opcion){
                case 1 -> {
                    System.out.println("Ingrese el nombre del producto");
                    String nombre = tcl.next();
                    System.out.println("Ingrese valor del producto");
                    double precio = tcl.nextDouble();
                    System.out.println("Ingrese el stock del producto");
                    int stock = tcl.nextInt();
                    listProductos.add(new Producto(nombre, precio, stock));
                }
                case 2 -> {
                    System.out.println("Ingrese el nombre del producto que desea vender");
                    String nombreProducto = tcl.next();

                    for(Producto producto : listProductos)
                    {
                        if(producto.getNombre().equals(nombreProducto))
                        {
                            do{
                                System.out.println("ingrese la cantidad que se desea vender");
                            } while(!producto.vender(tcl.nextInt()));
                            break;
                        }
                    }
                }
                case 3 -> {
                    System.out.println("Ingrese el nombre del producto que desea reponer");
                    String nombreProducto = tcl.next();
                    for(Producto producto : listProductos)
                    {
                        if(producto.getNombre().equals(nombreProducto))
                        {
                            System.out.println("ingrese la cantidad que se desea reponer");
                            producto.reponerStock(tcl.nextInt());
                            System.out.println("Cantidad actual en stock de " + producto.getNombre() + ": " + producto.getStock());
                            break;
                        }
                    }
                }
                case 4 -> {
                    System.out.println("Ingrese el nombre del producto al que desea apliacarle descuento del 2%");
                    String nombreProducto = tcl.next();
                    for(Producto producto : listProductos)
                    {
                        if(producto.getNombre().equals(nombreProducto))
                        {
                            System.out.println("Precio actual: " + producto.getPrecio());
                            producto.aplicarDescuento();
                            System.out.println("Precio tras descuento: " + producto.getPrecio());
                            break;
                        }
                    }
                }
                case 5 -> {
                    System.out.println("Ingrese el nombre del producto para ver su información");
                    String nombreProducto = tcl.next();
                    for(Producto producto : listProductos)
                    {
                        if(producto.getNombre().equals(nombreProducto))
                        {
                            System.out.println("información del producto: ");
                            System.out.println(producto.toString());
                            break;
                        }
                    }
                }
                case 6 -> {
                    System.out.println("Ingrese el nombre del producto al que desea subir el precio");
                    String nombreProducto = tcl.next();
                    for(Producto producto : listProductos)
                    {
                        if(producto.getNombre().equals(nombreProducto))
                        {
                            System.out.println("porcentaje que desea subir el precio");
                            double porcentaje = tcl.nextDouble();
                            System.out.println("precio anterior: " + producto.getPrecio());
                            producto.aumnetarPrecio(porcentaje);
                            System.out.println("Precio actual tras aumento del " + porcentaje + "%: " + producto.getPrecio());
                            break;
                        }
                    }
                }
                case 7 -> {
                    System.out.println("Ingrese el nombre del producto para ver el valor del inventario");
                    String nombreProducto = tcl.next();
                    for(Producto producto : listProductos)
                    {
                        if(producto.getNombre().equals(nombreProducto))
                        {
                            System.out.println("Valor del niventario de" + producto.getNombre() + ": " + producto.valorInventario());
                            break;
                        }
                    }
                }
                case 8 -> {
                    System.out.println("ingrese el primer producto para comparar");
                    String producto1 = tcl.next();
                    System.out.println("ingrese el segundo producto para comparar");
                    String producto2 = tcl.next();

                    for (Producto productoPrimero : listProductos)
                    {
                        if (productoPrimero.getNombre().equals(producto1))
                        {
                            for (Producto productoSegundo : listProductos)
                            {
                                if (productoSegundo.getNombre().equals(producto2))
                                {
                                    productoPrimero.productoMayorQue(productoSegundo);
                                }
                            }
                        }
                    }
                }
                case 9 -> {
                    for (Producto producto : listProductos)
                    {
                        System.out.println(producto.toString());
                    }
                }
            }
        }

    }
}

