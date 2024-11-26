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
    /*public void añadirBuque(Buque buque) {
        buqueact.add(buque);
    }*/
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
    /*public boolean hacerRepa(BuqueInactivo buque) {
        double coste=buque.getCosteRepa();
        if(buque.getTipo().equals("UltraLigeros")&&!BuqueEnRepa()){
            repa=true;
            buque.setEstado("Reparacion");
        }else if(dinero>=coste&& !BuqueEnRepa()){
            repa=true;
            dinero-=coste;
            buque.setEstado("Reparacion");
        }else {
            repa=false;
        }
        return repa;
    }*/
    public boolean hacerRepa(BuqueInactivo buque) {
        // Verificar que el buque esté en un estado válido para iniciar reparación
        if (!buque.getEstado().equals("Parado")) {
            return false; // Solo se puede reparar un buque que está "Parado"
        }

        double coste = buque.getCosteRepa();

        // Reparación para UltraLigeros (solo si no hay otra reparación en curso)
        if (buque.getTipo().equals("UltraLigeros") && !BuqueEnRepa()) {
            //System.out.println("Iniciando reparación para un UltraLigero...");
            buque.setEstado("Reparacion"); //Pinta que el fallo está aquí
            return true;
        }

        // Reparación estándar (requiere dinero y que no haya otra en curso)
        if (dinero >= coste && !BuqueEnRepa()) {
            dinero -= coste;
            buque.setEstado("Reparacion");
            return true;
        }

        // No se puede reparar
        return false;
    }
    public boolean cancelarRepa(BuqueInactivo buque) {
        if(buque.getEstado().equals("Reparacion")){
            buque.setEstado("Pendiente de Reparacion");
            return true;
        }else{
            return false;
        }
    }

    public boolean confirmarRepa(BuqueInactivo buque, boolean RepaSi) {
        if(RepaSi==true){
            buque.setEstado("Navegacion");
        }else{
            buque.setEstado("Parado");
        }
        return repa;
    }

    public void recompensaVuelta(Buque buque) {
        if(buque.EnEjercito()==true){
            double recompensa=buque.getRecompensa();
            dinero+=recompensa;
            buque.setEstado("Parado");
        }
    }
    public void Hundimiento(BuqueInactivo buque) { //Si el daño causado al buque es masivo este se hunde
        if(buque.getRazonParado()==razonParado.DAÑOMASIVO){
            buque.setEstado("Hundido");
        }
        buqueinact.remove(buque);
    }
}
