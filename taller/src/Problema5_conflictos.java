
import java.time.LocalDate;
import java.util.ArrayList;

class Pais {

    String nombre;
    boolean primerMundo;
    int poblacion;

    public Pais(String nombre, boolean primerMundo, int poblacion) {
        this.nombre = nombre;
        this.primerMundo = primerMundo;
        this.poblacion = poblacion;
    }

    public String getNombre() {
        return nombre;
    }

    public boolean isPrimerMundo() {
        return primerMundo;
    }
}

class Evento {

    String nombre;
    LocalDate fecha;
    String ubicacion;
    String descripcion;

    public Evento(String nombre, LocalDate fecha, String ubicacion, String descripcion) {

        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void consultarDetalles() {

        System.out.println("Evento: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Descripcion: " + descripcion);
    }
}

class Batalla {

    String nombre;
    LocalDate fecha;
    String ubicacion;
    String descripcion;

    double porcentajePaisesAfectados;
    boolean armasNucleares;
    double porcentajeBajas;

    public Batalla(String nombre, LocalDate fecha, String ubicacion, String descripcion, double porcentajePaisesAfectados,
            boolean armasNucleares, double porcentajeBajas) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;

        this.porcentajePaisesAfectados
                = porcentajePaisesAfectados;

        this.armasNucleares = armasNucleares;

        this.porcentajeBajas = porcentajeBajas;
    }

    public String getNombre() {
        return nombre;
    }

    public void consultarDetalles() {

        System.out.println("Batalla: " + nombre);
        System.out.println("Fecha: " + fecha);
        System.out.println("Ubicacion: " + ubicacion);
        System.out.println("Descripcion: " + descripcion);
    }

    public boolean verificarGuerraMundial(
            boolean primerMundo) {

        if (porcentajePaisesAfectados > 50) {
            return true;
        }

        if (primerMundo && armasNucleares) {
            return true;
        }

        return false;
    }

    public boolean verificarUrgenciaONU() {

        if (porcentajePaisesAfectados >= 30
                && porcentajePaisesAfectados <= 50) {

            return true;
        }

        if (porcentajeBajas >= 50) {
            return true;
        }

        return false;
    }
}

class ConflictoInternacional {

    String nombre;

    ArrayList<Pais> paises;
    ArrayList<Evento> eventos;
    ArrayList<Batalla> batallas;

    public ConflictoInternacional(String nombre) {

        this.nombre = nombre;

        paises = new ArrayList<>();
        eventos = new ArrayList<>();
        batallas = new ArrayList<>();
    }

    public void agregarPais(Pais p) {

        paises.add(p);
    }

    public void agregarEvento(Evento e) {

        eventos.add(e);
    }

    public void agregarBatalla(Batalla b) {

        batallas.add(b);

        System.out.println(
                "Batalla agregada: " + b.getNombre());

        for (Pais p : paises) {

            if (b.verificarGuerraMundial(
                    p.isPrimerMundo())) {

                System.out.println(
                        "SE DECLARA GUERRA MUNDIAL");
            }

            if (b.verificarUrgenciaONU()) {

                convocarONU();
            }
        }
    }

    public void convocarONU() {

        System.out.println(
                "La ONU fue convocada urgentemente.");
    }

    public void mostrarEventos() {

        System.out.println("\nEVENTOS");

        for (Evento e : eventos) {

            e.consultarDetalles();
        }

        System.out.println("\nBATALLAS");

        for (Batalla b : batallas) {

            b.consultarDetalles();
        }
    }
}

public class Problema5_conflictos {

    public static void main(String[] args) {

        Pais usa = new Pais("Estados Unidos", true, 331000000);

        Pais ecuador = new Pais("Ecuador", false, 18000000);

        ConflictoInternacional conflicto = new ConflictoInternacional("Conflicto Global");
        conflicto.agregarPais(usa);
        conflicto.agregarPais(ecuador);
        Evento reunion = new Evento("Reunion Diplomatica", LocalDate.of(2026, 5, 10), "Nueva York", "Reunion de emergencia");
        conflicto.agregarEvento(reunion);
        Batalla batalla1 = new Batalla("Batalla Central", LocalDate.of(2026, 6, 1), "Europa", "Batalla internacional", 60, true, 55);
        conflicto.agregarBatalla(batalla1);
        conflicto.mostrarEventos();
    }
}
