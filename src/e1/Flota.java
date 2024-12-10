package e1;
import java.util.ArrayList;
import java.util.List;

public class Flota {
    private List<Buque> buqueact;
    private List<BuqueInactivo> buqueinact;
    private double dinero;
    private boolean repa;

    public Flota(double dineroIni) {
        this.dinero = dineroIni;
        this.buqueinact = new ArrayList<BuqueInactivo>();
        this.buqueact=new ArrayList<Buque>();
        this.repa=false;
    }

    public List<BuqueInactivo> getBuqueinact() {
        return buqueinact;
    }
    public List<Buque> getBuqueact() {
        return buqueact;
    }
    public double getDinero() {
        return dinero;
    }

    public void añadirBuque(Buque buque) {
        if (buque instanceof BuqueInactivo && buque.getEstado().equals("Reparacion")) {
            buqueinact.add((BuqueInactivo) buque);
        } else {
            buqueact.add(buque);
        }
    }
    public void retirarBuque(Buque buque) {
        if(buqueact.contains(buque)) {
            buqueact.remove(buque);
        }
        if(buqueinact.contains(buque)) {
            buqueinact.remove(buque);
        }
    }
    public boolean BuqueEnRepa() {
        for(Buque buque: buqueinact) {
            if(buque.getEstado().equals("Reparacion")){
                return true;
            }
        }
        return false;
    }

    public boolean hacerRepa(BuqueInactivo buque) {
        if (!buque.getEstado().equals("Parado")) {
            System.out.println("El estado del buque no es 'Parado'. Estado actual: " + buque.getEstado());
            return false;
        }

        double coste = buque.getCosteRepa();
        System.out.println("Coste de reparación: " + coste + ", Dinero disponible: " + dinero);

        if (buque.getTipo().equals("UltraLigeros") && !BuqueEnRepa()) {
            //System.out.println("Reparación iniciada para un UltraLigero.");
            buque.setEstado("Reparacion");
            System.out.println("Reparación completada para un "+buque.getNome() + " " +buque.getTipo()+ "Barco listo para ser reparado");
            return true;
        } else {
            System.out.println("No se cumple condición para UltraLigeros o ya hay otra reparación en curso.");
        }

        if (dinero >= coste && !BuqueEnRepa()) {
            dinero -= coste;
            buque.setEstado("Reparacion");
            System.out.println("Reparación estándar iniciada para un "+buque.getNome()+" "+buque.getTipo()+ "Con un coste de: "+coste);
            return true;
        } else {
            System.out.println("No se puede iniciar reparación estándar: dinero insuficiente o hay otra reparación.");
        }

        return false;
    }

    public boolean cancelarRepa(BuqueInactivo buque) {
        if(buque.getEstado().equals("Reparacion")){
            buque.setEstado("Pendiente de Reparacion");
            return true;
        }
        return false;
    }

    public boolean confirmarRepa(BuqueInactivo buque, boolean RepaSi) {
        if(RepaSi){
            buque.setEstado("Navegacion");
        }else{
            buque.setEstado("Parado");
        }
        return true;
    }

    public void recompensaVuelta(Buque buque) {
        if(buque.EnEjercito()){
            double recompensa=buque.getRecompensa();
            dinero+=recompensa;
            buque.setEstado("Parado");
            System.out.println("El "+buque.getNome()+" "+buque.getTipo()+" obtiene una recompensa al volver de la travesía: "+recompensa);
        }
    }
    public void Hundimiento(BuqueInactivo buque) { //Si el daño causado al buque es masivo este se hunde
        if(buque.getRazonParado()==razonParado.DAÑOMASIVO){
            buque.setEstado("Hundido");
            System.out.println("El "+buque.getNome()+" "+buque.getTipo()+" se hundió");
        }
        buqueinact.remove(buque);
    }
}

