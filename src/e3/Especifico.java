package e3;

public class Especifico extends Cliente{
    private String simboloInteres;

    public Especifico (String simboloInteres){
        this.simboloInteres = simboloInteres;
    }

    @Override
    public String obtenerInfo(Accion accion) {
        if (accion.getSimbolo().equals(simboloInteres)){
            return accion.toString();
        }else {
            return "No se encontraron datos para la accion " + simboloInteres;
        }
    }
}
