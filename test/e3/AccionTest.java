package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AccionTest {
    Accion a1 = new Accion("Microsoft",100,105,80,1890);
    Accion a2 = new Accion("Amazon",205,258,120,1920);

    @Test
    void DatosTest(){
        assertEquals("Microsoft",a1.getSimbolo());
        assertEquals(100,a1.getCierre());
        assertEquals(105,a1.getMaximo());
        assertEquals(80,a1.getMinimo());
        assertEquals(1890,a1.getVolumen());
    }

    @Test
    void ToStringTest(){
        String esperado="Accion: Microsoft\n"+"Cierre: 100.0\n"+"Maximo:105.0\n"+"Minimo: 80.0\n"+"Volumen: 1890";
        assertEquals(esperado,a1.toString());
    }
}
