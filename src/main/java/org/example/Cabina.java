package org.example;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Cabina {

    //region Atributos

    //posibles atributos:
    // costo de llamada loca, larga distancia, celular
    //numero de llamadas
    //duracion de las llamadas

    private String idCabina;

    private int numeroLlamadas;

    private List<Double> duracionLlamadasLocal = new ArrayList<Double>();
    private List<Double> duracionLlamadasDistancia = new ArrayList<Double>();
    private List<Double> duracionLlamadasCelular = new ArrayList<Double>();

    private double costoLocal;
    private double costoDistancia;
    private double costoCelular;

    DecimalFormat formato = new DecimalFormat("#.00");

    //endregion

    //region Constructores

    public Cabina(String idCabina, double costoLocal, double costoDistancia, double costoCelular) {
        this.idCabina = idCabina;
        this.costoLocal = costoLocal;
        this.costoDistancia = costoDistancia;
        this.costoCelular = costoCelular;
    }

    //endregion

    //region Setters y Getters


    public String getIdCabina() {
        return idCabina;
    }

    public void setIdCabina(String idCabina) {
        this.idCabina = idCabina;
    }

    public int getNumeroLlamadas() {
        return numeroLlamadas;
    }

    public void setNumeroLlamadas(int numeroLlamadas) {
        this.numeroLlamadas = numeroLlamadas;
    }

    public List<Double> getDuracionLlamadasLocal() {
        return duracionLlamadasLocal;
    }

    public void setDuracionLlamadasLocal(List<Double> duracionLlamadasLocal) {
        this.duracionLlamadasLocal = duracionLlamadasLocal;
    }

    public List<Double> getDuracionLlamadasDistancia() {
        return duracionLlamadasDistancia;
    }

    public void setDuracionLlamadasDistancia(List<Double> duracionLlamadasDistancia) {
        this.duracionLlamadasDistancia = duracionLlamadasDistancia;
    }

    public List<Double> getDuracionLlamadasCelular() {
        return duracionLlamadasCelular;
    }

    public void setDuracionLlamadasCelular(List<Double> duracionLlamadasCelular) {
        this.duracionLlamadasCelular = duracionLlamadasCelular;
    }

    public double getCostoLocal() {
        return costoLocal;
    }

    public void setCostoLocal(double costoLocal) {
        this.costoLocal = costoLocal;
    }

    public double getCostoDistancia() {
        return costoDistancia;
    }

    public void setCostoDistancia(double costoDistancia) {
        this.costoDistancia = costoDistancia;
    }

    public double getCostoCelular() {
        return costoCelular;
    }

    public void setCostoCelular(double costoCelular) {
        this.costoCelular = costoCelular;
    }

    @Override
    public String toString() {
        return "Cabina{" +
                "idCabina='" + idCabina + '\'' +
                ", numeroLlamadas=" + numeroLlamadas +
                ", duracionLlamadasLocal=" + duracionLlamadasLocal +
                ", duracionLlamadasDistancia=" + duracionLlamadasDistancia +
                ", duracionLlamadasCelular=" + duracionLlamadasCelular +
                ", costoLocal=" + costoLocal +
                ", costoDistancia=" + costoDistancia +
                ", costoCelular=" + costoCelular +
                '}';
    }

    //endregion

    //region Métodos

    /*

    Posibles metodos:
     - Registrar una llamada. Recibe: tipo de llamada
     - Reiniciar cabina
     - costo total de llamadas
     - duración total de las llamadas
     */

    public boolean registrarLlamada (int tipoLlamada)
    {
        Random random = new Random();
        switch (tipoLlamada)
        {
            case 1 ->
            {
                duracionLlamadasLocal.add(random.nextDouble()*10);
                numeroLlamadas ++;
                return true;
            }
            case 2 ->
            {
                duracionLlamadasDistancia.add(random.nextDouble()*10);
                numeroLlamadas ++;
                return true;
            }
            case 3 ->
            {
                duracionLlamadasCelular.add(random.nextDouble()*10);
                numeroLlamadas ++;
                return true;
            }
            default -> {
                System.out.println("tipo de llamada inválido");
                return false;
            }
        }

    }

    public void reiniciar ( double costoLocal, double costoDistancia, double costoCelular)
    {
        duracionLlamadasLocal.clear();
        duracionLlamadasDistancia.clear();
        duracionLlamadasCelular.clear();
        numeroLlamadas = 0;

        this.costoLocal = costoLocal;
        this.costoDistancia = costoDistancia;
        this.costoCelular = costoCelular;

        System.out.println("se ha reiniciado la cabina " + idCabina + " correctamente");
    }

    public String costoTotal ()
    {
        double totalLocal = 0;
        double totalDistancia = 0;
        double totalCelular = 0;

        for (int i = 0; i < duracionLlamadasLocal.size(); i++) {
            totalLocal += duracionLlamadasLocal.get(i) * costoLocal;
        }
        for (int i = 0; i < duracionLlamadasDistancia.size(); i++) {
            totalDistancia += duracionLlamadasDistancia.get(i) * costoDistancia;
        }
        for (int i = 0; i < duracionLlamadasCelular.size(); i++) {
            totalCelular += duracionLlamadasCelular.get(i) * costoCelular;
        }

        return "Ganancias llamadas locales: $" + formato.format(totalLocal) +
                "\nGanancias llamadas a distancia: $" + formato.format(totalDistancia) +
                "\nGanancias llamadas a celular: $" + formato.format(totalCelular) +
                "\nTotal de ganado en llamadas" + formato.format(totalLocal+totalDistancia+totalCelular);
    }

    public String duracionTotal()
    {
        double totalLocal = 0;
        double totalDistancia = 0;
        double totalCelular = 0;

        for (int i = 0; i < duracionLlamadasLocal.size(); i++) {
            totalLocal += duracionLlamadasLocal.get(i);
        }
        for (int i = 0; i < duracionLlamadasDistancia.size(); i++) {
            totalDistancia += duracionLlamadasDistancia.get(i);
        }
        for (int i = 0; i < duracionLlamadasCelular.size(); i++) {
            totalCelular += duracionLlamadasCelular.get(i);
        }

        return  "Tiempo llamadas locales: " + formato.format(totalLocal) + " minutos" +
                "\nTiempo llamadas a distancia: " + formato.format(totalDistancia) + " minutos" +
                "\nTiempo llamadas a celular: " + formato.format(totalCelular) + " minutos" +
                "\nTiempo total en llamadas" + formato.format(totalLocal + totalDistancia + totalCelular);
    }

    public String detalleCabina ()
    {
        String costoTotal = costoTotal();
        String duracionTotal = duracionTotal();

        return "Cabina: " + idCabina + "\n{ Número de llamadas locales: " + duracionLlamadasLocal.size() +
                "\nNúmero de llamadas a distancia: " + duracionLlamadasDistancia.size() +
                "\nNúmero de llamadas a celular: " + duracionLlamadasCelular.size() +
                "\nNúmero total de llamadas: " + numeroLlamadas +
                "\n" + costoTotal + "\n" + duracionTotal + "}\n";
    }
    //endregion

}
