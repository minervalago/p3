package e3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SencilloTest {
    Accion a=new Accion("Google",200,230,155,20002);
    Cliente s=new Sencillo();

    @Test
    public void test() {
        String esperado="Simbolo: Google, Precio de cierre: 200.0";
        assertEquals(esperado,s.obtenerInfo(a));
    }

    @Test
    public void ClienteNotificadoTest() {
        a.setCierre(210);
        String esperado="Simbolo: Google, Precio de cierre: 210.0";
        assertEquals(esperado,s.obtenerInfo(a));
    }
}
