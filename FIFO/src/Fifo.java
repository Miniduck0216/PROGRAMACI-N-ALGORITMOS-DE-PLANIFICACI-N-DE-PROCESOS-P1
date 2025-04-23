import java.util.*;

class Proceso {
    int id;
    int tiempoEjecucion;

    Proceso(int id, int tiempoEjecucion) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
    }

    public String toString() {
        return "P" + id + " [Ejec: " + tiempoEjecucion + "]";
    }
}

public class Fifo {
    public static void main(String[] args) {

        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(1, 5));
        procesos.add(new Proceso(2, 3));
        procesos.add(new Proceso(3, 8));
        procesos.add(new Proceso(4, 6));

        System.out.println("Algoritmo FIFO:");
        int tiempoTotal = 0;
        for (Proceso p : procesos) {
            System.out.println("Proceso " + p.id + " ejecutado desde " + tiempoTotal + " hasta " + (tiempoTotal + p.tiempoEjecucion));
            tiempoTotal += p.tiempoEjecucion;
        }
    }
}
