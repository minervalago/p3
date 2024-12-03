package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class EspecificoTest {
    Accion a = new Accion("Microsoft",100,105,80,1890);
    Cliente e= new Especifico("Microsoft");
    Cliente en = new Especifico("Amazon");
    @Test
    void ExisteAccionTest(){
        String esperado="Accion: Microsoft\n"+"Cierre: 100.0\n"+"Maximo:105.0\n"+"Minimo: 80.0\n"+"Volumen: 1890";
        assertEquals(esperado,e.obtenerInfo(a));
    }

    @Test
    void NoExisteAccionTest(){
        String esperado= "No se encontraron datos para la accion Amazon";
        assertEquals(esperado,en.obtenerInfo(a));
    }

    @Test
    void ClienteModificadoTest(){
        a.setMaximo(120);
        String esperado="Accion: Microsoft\n"+"Cierre: 100.0\n"+"Maximo:120.0\n"+"Minimo: 80.0\n"+"Volumen: 1890";
    }
}
