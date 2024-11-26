package e1.TiposBuques;

import e1.Buque;

public class BuquesPesados extends Buque {
    public BuquesPesados(String nome, String estado, double peso, double costeRepa,double recompensa) {
        super(nome,"Pesados",estado,peso, costeRepa, recompensa);
    }
}
