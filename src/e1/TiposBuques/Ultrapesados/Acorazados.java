package e1.TiposBuques.Ultrapesados;

import e1.Buque;
import e1.TiposBuques.BuquesUltrapesados;

public class Acorazados extends BuquesUltrapesados {
    //private static final double COSTE_REPARACION = 1000; // Valor fijo
    //private static final double RECOMPENSA = 500;
    public Acorazados(String nome, String estado) {
        super("Acorazado", estado,20000, 1000, 500);
    }
}
