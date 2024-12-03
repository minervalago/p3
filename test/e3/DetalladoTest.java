package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DetalladoTest {
    Accion a = new Accion("Amazon",205,258,120,1920);
    Cliente d = new Detallado();
    @Test
    void test() {
        String esperado = "Accion: Amazon\n"+"Cierre: 205.0\n"+"Maximo:258.0\n"+"Minimo: 120.0\n"+"Volumen: 1920";
        assertEquals(esperado,d.obtenerInfo(a));
    }
    @Test
    void ClienteModificadoTest() {
        a.setCierre(220);
        a.setVolumen(12000);
        a.setMinimo(119);
        a.setMaximo(300);
        String esperado="Accion: Amazon\n"+"Cierre: 220.0\n"+"Maximo:300.0\n"+"Minimo: 119.0\n"+"Volumen: 12000";
        assertEquals(esperado,d.obtenerInfo(a));
    }
}
