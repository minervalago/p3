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
        flota = new Flota(5000); //Dinero que tiene al principio
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

        assertFalse(flota.getBuqueinact().contains(buqueInactivo));
    }

    @Test
    public void BuqueEnRepaTest(){
        assertFalse(flota.BuqueEnRepa());
        buqueInactivo.setEstado("Reparacion");
        flota.añadirBuque(buqueInactivo);
        assertTrue(flota.BuqueEnRepa());
    }

    @Test
    public void HacerRepaTest() {
        buqueInactivo.setEstado("Navegacion");
        boolean reparacionExi = flota.hacerRepa(buqueInactivo);
        assertFalse(reparacionExi);
        assertEquals("Navegacion",buqueInactivo.getEstado());

        buqueInactivo2 = new BuqueInactivo("Destructores", "UltraLigeros", "Parado", 1.0, 100.0, 200.0, razonParado.DAÑOMASIVO);
        flota.añadirBuque(buqueInactivo2);
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);
        assertTrue(reparacionExitosa);
        assertEquals("Reparacion", buqueInactivo2.getEstado());

        BuqueInactivo buqueInactivo4 = new BuqueInactivo("Portaaviones","Pesado","Parado",1.0,100.0,200.0, razonParado.DAÑOMASIVO);
        flota.añadirBuque(buqueInactivo4);
        System.out.println("Estado actual del buque antes de hacerRepa: " + buqueInactivo.getEstado());
        boolean reparacionExit = flota.hacerRepa(buqueInactivo4);
        assertTrue(reparacionExit);
        assertEquals("Reparacion", buqueInactivo4.getEstado());
        assertEquals(4900.0,flota.getDinero(),0.01); //Verifica el dinero que queda después de la reparación
    }
    @Test
    public void cancelarRepaTest() {
        buqueInactivo2 = new BuqueInactivo("DestructoresDeEscolta", "UltraLigeros", "Parado", 1.0, 100.0, 200.0, razonParado.DAÑOMASIVO);
        flota = new Flota(500.0);
        flota.añadirBuque(buqueInactivo2);
        boolean reparacionExitosa = flota.hacerRepa(buqueInactivo2);
        assertTrue(reparacionExitosa);
        assertEquals("Reparacion", buqueInactivo2.getEstado());

        boolean cancelacionExitosa = flota.cancelarRepa(buqueInactivo2);
        assertTrue(cancelacionExitosa);
        assertEquals("Pendiente de Reparacion", buqueInactivo2.getEstado());

        BuqueInactivo buqueNoReparacion=new BuqueInactivo("Portahidros","Ligeros ","Navegacion",1.0,100.0,200.0,razonParado.DAÑOMASIVO);
        flota.añadirBuque(buqueNoReparacion);
        boolean cancelacionNo=flota.cancelarRepa(buqueNoReparacion);
        assertFalse(cancelacionNo);
        assertEquals("Navegacion", buqueNoReparacion.getEstado());
    }

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

        flota.recompensaVuelta(BuqueActivo);
        flota.recompensaVuelta(BuqueActivo1);
        flota.recompensaVuelta(BuqueActivo2);
        flota.recompensaVuelta(BuqueActivo3);
    }

    @Test
    public void HumdimientoTest(){
        assertNotEquals(buqueInactivo.getRazonParado(),razonParado.DAÑOMASIVO);
        assertEquals(buqueInactivo2.getRazonParado(),razonParado.DAÑOMASIVO);

        flota.Hundimiento(buqueInactivo2);
        assertEquals(buqueInactivo2.getEstado(), "Hundido");
    }
}
