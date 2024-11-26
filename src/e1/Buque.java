package e1;

public class Buque {
    public String nome;
    public String tipo;
    public String estado;
    public double peso;
    private boolean Ejercito;
    public double costeRepa;
    public double recompensa;


    public Buque(String nome, String tipo, String estado, double peso, double costeRepa, double recompensa) {
        this.nome = nome;
        this.tipo = tipo;
        this.estado = estado;
        this.peso = peso;
        this.costeRepa = costeRepa;
        this.recompensa = recompensa;

    }
    public String getNome() {
        return nome;
    }
    public String getTipo() {
        return tipo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public double getPeso() {
        return peso;
    }
    public double getCosteRepa() {
        return costeRepa*peso;
    }
    public double getRecompensa() {
        return recompensa;
    }
    public boolean EnEjercito() {
        return !estado.equals("Reparacion") && !estado.equals("Hundido") && !estado.equals("Parado");
    }
}
