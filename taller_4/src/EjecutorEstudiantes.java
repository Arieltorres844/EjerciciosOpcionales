
import java.util.Random;
import java.util.Scanner;

class Estudiante {

    public String nombre;
    public double nota1;
    public double nota2;
    public double promedio;
    public boolean estado;
    public double suple;

    public Estudiante(String nombre, double nota1, double nota2, double suple) {
        this.nombre = nombre;
        this.nota1 = nota1;
        this.nota2 = nota2;
    }

    public void setSuple(double suple) {
        this.suple = suple;
    }

    public double getSuple() {
        return suple;
    }

    public void calcularPromedio() {
        this.promedio = (this.nota1 + this.nota2) / 2;
    }
    public void calcularEstado(double notafinal) {
        if (notafinal > 7) {
            this.estado = true;
        }else 
            this.estado = false;
    }
    
    @Override
    public String toString() {
        return "Estudiante{" + "nombre=" + nombre + ", nota1=" + String.format("%.2f", nota1)
                + ", nota2=" + String.format("%.2f", nota2) + ", promedio=" + String.format("%.2f", promedio)
                + ", estado=" + estado + ", suple=" + String.format("%.2f", suple) + '}';
    }
}

public class EjecutorEstudiantes {

    public static void main(String[] args) {
        Scanner tcl = new Scanner(System.in);
        Random ale = new Random();
        String nombre;
        double nota1, nota2, suple = 0;
        while (true) {
            System.out.println("nombre del estudiante: ");
            nombre = tcl.nextLine();
            nota1 = ale.nextDouble(10);
            nota2 = ale.nextDouble(10);
            Estudiante est = new Estudiante(nombre, nota1, nota2, suple);
            est.calcularEstado(est.promedio);
            if (!est.estado){
                  est.setSuple(ale.nextDouble(10));
                  est.calcularEstado(est.getSuple());
            }
            est.calcularPromedio();
            System.out.println(est.toString());
        }
    }
}
