
import java.io.File;
import java.util.Formatter;
import java.util.Random;
import java.util.Scanner;

public class Eventos_Carnaval {

    public static void main(String[] args) {
        String datIN[][] = leerArchivo("registro.csv", 4, 3);
        String datOut[][] = procesarArchivo(datIN, 3);
        persistirRegistro("registroFinal.csv", datIN, datOut);
    }
    public static void persistirRegistro(String nombreArchivoOut,String datIN[][], String datOut[][]){
        try {
            Formatter fout = new Formatter(new File(nombreArchivoOut));
            fout.format("%s;\n", "Evento;Capacidad;precio;personas;total;>%50");
            for (int i = 0; i < datIN.length; i++) {
                for (int j = 0; j < datIN[0].length; j++) 
                    fout.format("%s;", datIN[i][j]);
                for (int j = 0; j < datOut[0].length; j++) 
                    fout.format("%s;", datOut[i][j]);
                 fout.format("%s", "\n");                 
            }
            fout.format("\n"); 
            fout.format("ESTADISTICAS\n");
            fout.format("Mas per:;%s\n", obtenerEventoMasPersonas(datIN, datOut));
            fout.format("Mayor total:;%s\n", obtenerEventoMayorRecaudacion(datIN, datOut));
            fout.close();
        } catch (Exception e) {
        }
    }

    public static String[][] leerArchivo(String nombreArchivo, int m, int n) {
        String[][] datos = new String[m][n];
        try {
            Scanner fin = new Scanner(new File(nombreArchivo));
            fin.nextLine();
            int i = 0;
            while (fin.hasNext()) {
                String data [] = fin.nextLine().split(";");
                datos [i][0] = data[0];
                datos [i][1] = data[1];
                datos [i][2] = data[2];
                i++;
            }
    } catch (Exception e) {
            System.out.println("Error");
        }
        return datos;
}
    public static String[][] procesarArchivo(String datos[][], int n) {
        String datosOut[][] = new String[datos.length][n];
        Random ale = new Random();
        for (int i = 0; i < datos.length; i++) {
            int capacidad = Integer.parseInt(datos[i][1]);
            int precio = Integer.parseInt(datos[i][2]);
            int personas = ale.nextInt(capacidad + 1);
            int total = personas * precio;
            String mayor50 = personas > capacidad / 2 ? "SI" : "NO";
            datosOut[i][0] = String.valueOf(personas);
            datosOut[i][1] = String.valueOf(total);
            datosOut[i][2] = mayor50;       
        }
        return datosOut;
    }

    public static String obtenerEventoMayorRecaudacion(String datIN[][], String datOut[][]) {
        int maxTotal = -1;
        String nombreEvento = "";

        for (int i = 0; i < datOut.length; i++) {
            if (datOut[i][1] != null) {
                int totalActual = Integer.parseInt(datOut[i][1]);
                if (totalActual > maxTotal) {
                    maxTotal = totalActual;
                    nombreEvento = datIN[i][0];
                }
            }
        }
        return nombreEvento + " (Total: $" + maxTotal + ")";
    }
    public static String obtenerEventoMasPersonas(String datIN[][], String datOut[][]) {
        int maxPersonas = -1;
        String nombreEvento = "";

        for (int i = 0; i < datOut.length; i++) {
            if (datOut[i][0] != null) {
                int personasActual = Integer.parseInt(datOut[i][0]);
                if (personasActual > maxPersonas) {
                    maxPersonas = personasActual;
                    nombreEvento = datIN[i][0];
                }
            }
        }
        return nombreEvento + " (" + maxPersonas + " personas)";
    }
}
