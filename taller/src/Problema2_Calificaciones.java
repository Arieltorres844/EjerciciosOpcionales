
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Materia {

    String nombre;
    double acd;
    double ape;
    double aa;

    public Materia(String nombre, double acd, double ape, double aa) {
        this.nombre = nombre;
        this.acd = acd;
        this.ape = ape;
        this.aa = aa;
    }

    public double notaFinal() {
        return acd + ape + aa;
    }

    public boolean aprobado() {
        return notaFinal() >= 7.0;
    }

    public double recuperacion() {
        return 7.0 - notaFinal();
    }

    public String estado() {

        if (aprobado()) {
            return "APROBADO";
        } else {
            return "REPROBADO - Recuperacion: "
                    + recuperacion()
                    + " puntos";
        }
    }

    @Override
    public String toString() {

        return "Materia: " + nombre
                + "\nACD: " + acd
                + "\nAPE: " + ape
                + "\nAA: " + aa
                + "\nNota Final: " + notaFinal()
                + "\nEstado: " + estado();
    }
}

class estudiante {

    String nombre;
    int edad;

    private ArrayList<Materia> materias;

    public estudiante(String nombre, int edad, ArrayList<Materia> materias) {

        this.nombre = nombre;
        this.edad = edad;
        this.materias = materias;
    }

    @Override
    public String toString() {

        String texto = "\n====================="
                + "\nNombre: " + nombre
                + "\nEdad: " + edad
                + "\nMaterias\n";
        for (Materia m : materias) {
            texto += m.toString() + "\n";
        }
        return texto;
    }
}

public class Problema2_Calificaciones {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<estudiante> estudiantes = new ArrayList<>(Arrays.asList(new estudiante(
                "Carlos", 20, new ArrayList<>(Arrays.asList(
                        new Materia("Programacion", 2.5, 2.0, 2.0),
                        new Materia("Base de Datos", 3.0, 2.5, 1.5)))),
                new estudiante("Ana", 22, new ArrayList<>(Arrays.asList(
                        new Materia("Matematica", 3.5, 3.0, 2.5),
                        new Materia("Fisica", 2.0, 2.0, 1.0))))));
        for (estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
