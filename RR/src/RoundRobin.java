import java.util.*;

class Proceso {
    int id;
    int tiempoEjecucion;
    int tiempoRestante;

    Proceso(int id, int tiempoEjecucion) {
        this.id = id;
        this.tiempoEjecucion = tiempoEjecucion;
        this.tiempoRestante = tiempoEjecucion;
    }

    public String toString() {
        return "P" + id + " [Ejec: " + tiempoEjecucion + ", Rest: " + tiempoRestante + "]";
    }
}

public class RoundRobin {
    public static void main(String[] args) {

        List<Proceso> procesos = new ArrayList<>();
        procesos.add(new Proceso(1, 5));
        procesos.add(new Proceso(2, 3));
        procesos.add(new Proceso(3, 8));
        procesos.add(new Proceso(4, 6));


        int quantum = 2;
        Queue<Proceso> cola = new LinkedList<>(procesos);

        System.out.println("Algoritmo Round Robin:");
        int tiempoTotal = 0;
        while (!cola.isEmpty()) {
            Proceso p = cola.poll();
            if (p.tiempoRestante > quantum) {
                System.out.println("Proceso " + p.id + " ejecutado desde " + tiempoTotal + " hasta " + (tiempoTotal + quantum));
                p.tiempoRestante -= quantum;
                tiempoTotal += quantum;
                cola.add(p);
            } else {
                System.out.println("Proceso " + p.id + " ejecutado desde " + tiempoTotal + " hasta " + (tiempoTotal + p.tiempoRestante));
                tiempoTotal += p.tiempoRestante;
                p.tiempoRestante = 0;
            }
        }
    }
}
