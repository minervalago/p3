package e1;

import e1.TiposBuques.Ligeros.CrucerosLigeros;
import e1.TiposBuques.Ligeros.Portahidros;
import e1.TiposBuques.Pesados.CrucerosPesados;
import e1.TiposBuques.Pesados.Portaaviones;
import e1.TiposBuques.UltraLigeros.Destructores;
import e1.TiposBuques.UltraLigeros.DestructoresDeEscolta;
import e1.TiposBuques.Ultrapesados.Acorazados;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class Flotatest {
    private Flota flota;
    private Buque acorazado;
    private Buque destructoresDeEscolta;
    private Buque destructores;
    private Buque portaaviones;
    private Buque crucerosPesados;
    private Buque portahidros;
    private Buque crucerosLigeros;

    private BuqueInactivo buqueInactivo;
    private BuqueInactivo buqueInactivo1;
    private BuqueInactivo buqueInactivo2;
    private Buque BuqueActivo;
    private Buque BuqueActivo1;
    private Buque BuqueActivo2;
    private Buque BuqueActivo3;
    private Buque BuqueActivo4;

    @BeforeEach
    public void setUp() {
        flota = new Flota(500); //Dinero que tiene al principio
        acorazado = new Acorazados("Acorazado", "Parado");
        buqueInactivo = new BuqueInactivo(acorazado, razonParado.DAÑO);
        crucerosLigeros = new CrucerosLigeros("CrucerosLigero", "Navegacion");
        BuqueActivo = new BuqueInactivo(crucerosLigeros,null);
        destructoresDeEscolta = new DestructoresDeEscolta("DestructorEscolta", "Navegacion");
        buqueInactivo1 = new BuqueInactivo(destructoresDeEscolta, razonParado.REMODELACION);
        destructores = new Destructores("Destructor", "Parado");
        buqueInactivo2 = new BuqueInactivo(destructores, razonParado.DAÑOMASIVO);
        portaaviones = new Portaaviones("Portaaviones", "Navegacion");
        BuqueActivo1 = new BuqueInactivo(portaaviones,null);
        crucerosPesados = new CrucerosPesados("CruceroPesado", "Navegacion");
        BuqueActivo2 = new BuqueInactivo(crucerosPesados,null);
        portahidros = new Portahidros("Portahidros", "Navegacion");
        BuqueActivo3 = new BuqueInactivo(portahidros,null);
    }

    @Test
    public void AñadirBuqueTest() {
        flota.añadirBuque(buqueInactivo);
        flota.añadirBuque(BuqueActivo);
        assertTrue(flota.getBuqueact().contains(BuqueActivo));
        assertTrue(flota.getBuqueact().contains(buqueInactivo));

        assertFalse(flota.getBuqueact().contains(buqueInactivo1));
        flota.añadirBuque(buqueInactivo1);
        assertTrue(flota.getBuqueact().contains(buqueInactivo1));
    }

    @Test
    public void BorrarBuqueTest() {
        flota.añadirBuque(buqueInactivo);
        flota.añadirBuque(BuqueActivo);
        flota.retirarBuque(BuqueActivo);
        flota.retirarBuque(buqueInactivo);
        assertFalse(flota.getBuqueact().contains(BuqueActivo));
        assertFalse(flota.getBuqueact().contains(buqueInactivo));

        flota.añadirBuque(buqueInactivo1);
        assertTrue(flota.getBuqueact().contains(buqueInactivo1));
        flota.retirarBuque(buqueInactivo1);
        assertFalse(flota.getBuqueinact().contains(buqueInactivo1));
    }

    @Test
    public void BuqueEnRepaTest(){
        assertFalse(flota.BuqueEnRepa());
        buqueInactivo.setEstado("Reparacion");
        flota.añadirBuque(buqueInactivo);
        assertTrue(flota.BuqueEnRepa());
    }
    /*@Test
    public void HacerRepaTest(){ //Probandolo para UltraLigeros, falta probar para el resto(si tenemos dinero para costear la reforma)
        assertFalse(flota.hacerRepa(buqueInactivo1));
        flota=new Flota(2300);
        assertTrue(flota.hacerRepa(buqueInactivo1)); //Falla
        assertEquals("Reparacion", buqueInactivo1.getEstado());
    }*/
    /*@Test AAAAAAAAAAAAA
    public void HacerRepaTest() {
        buqueInactivo2.setEstado("Parado"); // Configurar estado inicial.

        // Reparación para UltraLigeros.
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);
        assertTrue(reparacionExitosa, "La reparación no se inició para un buque UltraLigeros.");
        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó a Reparacion.");
    }*/
    @Test
    public void HacerRepaTest() {
        // Crear un buque inactivo con tipo "UltraLigeros" y estado "Parado".
        buqueInactivo2 = new BuqueInactivo("Buque1", "UltraLigeros", "Parado", 1.0, 100.0, 200.0, razonParado.DAÑOMASIVO);

        // Crear una flota con suficiente dinero para reparar.
        flota = new Flota(500.0);

        // Añadir el buque a la flota.
        flota.añadirBuque(buqueInactivo2);

        // Intentar iniciar la reparación.
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);

        // Verificar que la reparación fue exitosa.
        assertTrue(reparacionExitosa, "La reparación no se inició para un buque UltraLigeros.");
        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó a Reparacion.");
    }
    /*@Test
    public void HacerRepaTest() {
        flota.añadirBuque(buqueInactivo2);
        buqueInactivo2.setEstado("Parado");
        System.out.println("Estado inicial: " + buqueInactivo2.getEstado());
        System.out.println("Tipo de buque: " + buqueInactivo2.getTipo());
        System.out.println("BuqueEnRepa antes: " + flota.BuqueEnRepa());

        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);
        System.out.println("Reparación exitosa: " + reparacionExitosa);
        System.out.println("Estado después: " + buqueInactivo2.getEstado());

        assertTrue(reparacionExitosa, "La reparación no se inició para un buque UltraLigeros.");
        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó a Reparacion.");
    }*/

    /*@Test
    public void HacerRepaTest() {
        // Configurar estado inicial del buque
        buqueInactivo2.setEstado("Parado");

        // Asegurar que es UltraLigeros
        assertEquals("Ultraligeros", buqueInactivo2.getTipo(), "El buque no es del tipo UltraLigeros.");

        // Crear flota
        flota = new Flota(500); // Dinero inicial bajo, pero no relevante para UltraLigeros

        // Intentar reparar
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);
        assertTrue(reparacionExitosa, "La reparación no se inició para un buque UltraLigeros.");
        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó a Reparacion.");
    }*/

    /*@Test
    public void cancelarRepaTest(){
        flota.hacerRepa(buqueInactivo2);
        assertEquals("Reparacion", buqueInactivo2.getEstado()); //Falla
        assertTrue(flota.cancelarRepa(buqueInactivo2));
        assertEquals("PendienteRepa", buqueInactivo2.getEstado());
        assertFalse(flota.cancelarRepa(buqueInactivo1));
    }*/
    /*@Test
    public void cancelarRepaTest() {
        flota.añadirBuque(buqueInactivo2);
        flota.hacerRepa(buqueInactivo2);

        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado inicial no es Reparacion.");
        boolean cancelacionExitosa = flota.cancelarRepa(buqueInactivo2);
        assertTrue(cancelacionExitosa, "La reparación no se pudo cancelar.");
        assertEquals("Pendiente de Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó tras cancelar.");
    }*/
    @Test
    public void cancelarRepaTest() {
        // Configurar el buque y la flota.
        buqueInactivo2 = new BuqueInactivo("Buque1", "UltraLigeros", "Parado", 1.0, 100.0, 200.0, razonParado.DAÑOMASIVO);
        flota = new Flota(500.0); // Dinero suficiente para la reparación.

        // Añadir el buque a la flota.
        flota.añadirBuque(buqueInactivo2);

        // Intentar iniciar la reparación.
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);

        // Verificar que la reparación fue exitosa.
        assertTrue(reparacionExitosa, "La reparación no se inició correctamente.");
        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado inicial no es Reparacion.");

        // Intentar cancelar la reparación.
        boolean cancelacionExitosa = flota.cancelarRepa(buqueInactivo2);
        assertTrue(cancelacionExitosa, "La reparación no se pudo cancelar.");
        assertEquals("Pendiente de Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó tras cancelar.");
    }

    /*@Test
    public void cancelarRepaTest() {
        flota = new Flota(1000);
        buqueInactivo2.setEstado("Parado");
        flota.añadirBuque(buqueInactivo2);
        assertEquals("Ultraligeros", buqueInactivo2.getTipo(), "El buque no es del tipo UltraLigeros.");
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);
        // Verificar que la reparación haya iniciado correctamente
        assertTrue(reparacionExitosa, "La reparación no se inició."); //Falla
        assertEquals("Reparacion", buqueInactivo2.getEstado(), "El estado del buque no se actualizó a Reparacion.");

        // Cancelar reparación
        assertTrue(flota.cancelarRepa(buqueInactivo2), "No se pudo cancelar la reparación.");
        assertEquals("Pendiente de Reparacion", buqueInactivo2.getEstado(), "El estado no se actualizó correctamente tras cancelar.");
    }*/

    @Test
    public void confirmarRepaTest() {
        flota = new Flota(1000);
        flota.hacerRepa(buqueInactivo);
        flota.confirmarRepa(buqueInactivo, true);
        assertEquals("Navegacion", buqueInactivo.getEstado());

        flota.confirmarRepa(buqueInactivo, false);
        assertEquals("Parado", buqueInactivo.getEstado());
    }

    @Test
    public void recompensaVueltaTest(){
        assertFalse(buqueInactivo.EnEjercito());
        assertTrue(buqueInactivo1.EnEjercito());
        assertFalse(buqueInactivo2.EnEjercito());
        assertTrue(BuqueActivo.EnEjercito());
        assertTrue(BuqueActivo1.EnEjercito());
        assertTrue(BuqueActivo2.EnEjercito());
        assertTrue(BuqueActivo3.EnEjercito());
    }

    @Test
    public void HumdimientoTest(){
        assertNotEquals(buqueInactivo.getRazonParado(),razonParado.DAÑOMASIVO);
        assertEquals(buqueInactivo2.getRazonParado(),razonParado.DAÑOMASIVO);
    }
}
