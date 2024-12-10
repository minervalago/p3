package e1.TiposBuques.Ultrapesados;

import e1.Buque;
import e1.TiposBuques.BuquesUltrapesados;

public class Acorazados extends BuquesUltrapesados {
    public Acorazados(String nome, String estado) {
        super("Acorazado", estado,20000, 1000, 500);
    }
}
