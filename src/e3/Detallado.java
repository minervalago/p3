package e3;

public class Detallado extends Cliente{
    @Override
    public String obtenerInfo(Accion accion) {
        return accion.toString();
    }
}
