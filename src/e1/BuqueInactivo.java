package e1;

public class BuqueInactivo extends Buque{
    private razonParado razonParado;

    public BuqueInactivo(String nome,String tipo,String estado, double peso, double costeRepa, double recompensa, razonParado razonParado) {
        super(nome,tipo,estado,peso,costeRepa,recompensa);
        this.razonParado = razonParado;
    }
    public BuqueInactivo(Buque buque, razonParado razonParado) {
        super(buque.getNome(), buque.getTipo(), buque.getEstado(), buque.getPeso(), buque.getCosteRepa(), buque.getRecompensa());
        if (razonParado == null) {  // Si no se pasa razón, se asume que no está parado
            this.razonParado = null;  // O cualquier valor que indique que no está parado
        } else {
            this.razonParado = razonParado;
        }
    }
    public razonParado getRazonParado() {
        return razonParado;
    }
    public void setCosteRepa(double costeRepa) {
        this.costeRepa = costeRepa;
    }
    public double getCosteRepa() {
        return costeRepa*peso;
    }
}
