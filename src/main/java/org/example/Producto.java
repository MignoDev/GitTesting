package org.example;

public class Producto {
    private String nombre;

    private double precio;

    private int stock;
    private double descuento;

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.descuento = 0.02;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getDescuento() {
        return descuento;
    }

    public void setDescuento(double descuento) {
        this.descuento = descuento;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                '}';
    }

    //region Métodos
    
    //region VentaProductos
    public boolean vender(int cantidad)
    {
        if (cantidad > 0)
        {
            if (cantidad <= this.stock)
            {
                this.stock -= cantidad;
                System.out.println("Se ha vendido " + cantidad + ", Stock actual: " + this.stock);
                return true;
            }
            System.out.println("Stock insuficiente, stock actual: " + stock);
            return false;
        }
        System.out.println("Valor inválido");
        return false;
    }
    //endregion

    //region Reponer stock
    public void reponerStock (int cantidad)
    {
        if (cantidad > 0)
        {
            System.out.println("Cantidad anterior");
            stock += cantidad;
        }
        System.out.println("Se ingresó un valor inválido");
    }
    //endregion

    //region descuento
    public double aplicarDescuento ()
    {
        this.precio -= this.precio * this.descuento;
        return this.precio;
    }
    //endregion

    //region aumentarPrecio
    public void aumnetarPrecio (double porcentaje)
    {
        double porcentajeFinal = porcentaje/100;
        this.precio += this.precio * porcentajeFinal;
    }
    //endregion

    //region valorInventario
    public double valorInventario ()
    {
        return this.stock*this.precio;
    }
    //endregion

    public void productoMayorQue( Producto producto)
    {
        if(this.precio < producto.getPrecio())
        {
            System.out.println("El producto " + producto.getNombre() + " es "+ (producto.getPrecio() - this.precio) + " más costoso");
            return;
        }

        if (this.precio > producto.getPrecio())
        {
            System.out.println("El producto " + this.nombre + " es " + (this.precio-producto.getPrecio()) +" más costoso");
            return;
        }

        System.out.println("Ambos productos tienen el mismo valor");

    }
    //endregion
}
