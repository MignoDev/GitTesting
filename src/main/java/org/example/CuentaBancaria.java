package org.example;
/*

 */
public class CuentaBancaria {

    private String titular;
    private double saldo;
    private String numeroCuenta;

    //constructor
    public CuentaBancaria() {

    }
    //constructor con parametros
    public CuentaBancaria(String titular, double saldo, String numeroCuenta) {
        this.titular = titular;
        this.saldo = saldo;
        this.numeroCuenta = numeroCuenta;
    }

    //setter y getter


    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "titular='" + titular + '\'' +
                ", saldo=$" + saldo +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                '}';
    }

    //Métodos
    public void depositar(double monto){
        if (monto > 0)
        {
            saldo += monto;
            System.out.println("Se ha ingresado el monto de $" + monto + " correctamente");
        } else
        {
            System.out.println("Monto ingresado inválido");
        }
    }

    public boolean retirar(double monto) {
        if (monto <= saldo)
        {
            saldo -= monto;
            System.out.println("Se ha retirado: " + monto);
            return true;
        } else
        {
            System.out.println("Saldo insuficiente, saldo actual: " + this.saldo);
            return this.saldo == 0.0;
        }
    }

    public String mostrarInfo()
    {
        return "Titular: " + titular + "\nNúmero de cuenta: " + numeroCuenta + "\nSaldo: $" + saldo;
    }
}
