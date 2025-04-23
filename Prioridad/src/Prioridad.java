import java.util.*;

class Proceso {
    int id;
    int tiempoEjecucion;
    int prioridad;

    Proceso(int id, int tiempoEjecucion, int prioridad) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
        this.prioridad = prioridad;
    }

    public String toString() {
        return "P" + id + " [Ejec: " + tiempoEjecucion + ", Prioridad: " + prioridad + "]";
    }
}

public class Prioridad {
    public static void main(String[] args) {

        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(1, 5, 2));
        procesos.add(new Proceso(2, 3, 1));
        procesos.add(new Proceso(3, 8, 3));
        procesos.add(new Proceso(4, 6, 4));


        procesos.sort(Comparator.comparingInt(p -> p.prioridad));

        System.out.println("Algoritmo Prioridad:");
        int tiempoTotal = 0;
        for (Proceso p : procesos) {
            System.out.println("Proceso " + p.id + " ejecutado desde " + tiempoTotal + " hasta " + (tiempoTotal + p.tiempoEjecucion));
            tiempoTotal += p.tiempoEjecucion;
        }
    }
}
