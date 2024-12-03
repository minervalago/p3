package e3;

public class Sencillo extends Cliente{
    @Override
    public String obtenerInfo (Accion accion){
        return "Simbolo: " + accion.getSimbolo() + ", Precio de cierre: " + accion.getCierre();
    }
}
