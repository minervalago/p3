package e3;

import java.util.ArrayList;
import java.util.List;

public class Accion {
    private List<Cliente> c= new ArrayList<>();
    private String simbolo;
    private double cierre;
    private double maximo;
    private double minimo;
    private int volumen;

    public Accion (String simbolo, double cierre, double maximo, double minimo, int volumen){
        this.simbolo = simbolo;
        this.cierre = cierre;
        this.maximo = maximo;
        this.minimo = minimo;
        this.volumen = volumen;
    }

    public void notifyClientes(){
        for(int i=0;i<c.size();i++){
            Cliente cliente=c.get(i);
            cliente.obtenerInfo(this);
        }
    }
    public String getSimbolo(){
        return simbolo;
    }

    public double getCierre(){
        return cierre;
    }
    public void setCierre(double cierre){
        this.cierre = cierre;
        notifyClientes();
    }
    public double getMaximo(){
        return maximo;
    }
    public void setMaximo(double maximo){
        this.maximo = maximo;
        notifyClientes();
    }
    public double getMinimo(){
        return minimo;
    }
    public void setMinimo(double minimo){
        this.minimo = minimo;
        notifyClientes();
    }
    public int getVolumen(){
        return volumen;
    }
    public void setVolumen(int volumen){
        this.volumen = volumen;
        notifyClientes();
    }

    @Override
    public String toString(){
        return "Accion: " + simbolo + "\n" +
                "Cierre: " + cierre + "\n" +
                "Maximo:" + maximo + "\n" +
                "Minimo: " + minimo + "\n" +
                "Volumen: " + volumen;
    }

}
