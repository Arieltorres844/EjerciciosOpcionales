
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.Scanner;


public class FileTest1 {
    public static void main(String[] args) throws FileNotFoundException {
        //flujo de salida-escritura desde .java hacia files
        Formatter fout = new Formatter(new File("notas.csv"));
        fout.format("%s;%s;%s\n", "nombreEst", "Nota1", "Nota2");
        fout.format("%s;%d;%d\n", "andre",7,8);
        fout.format("%s;%d;%d\n", "daniel",6,5);
        fout.close();
        //fujo de entrada-lectura desde file hacia .java
        Scanner fin = new Scanner(new File("notas.csv"));
        String contenido = fin.nextLine();
        System.out.println(contenido);
        contenido = fin.nextLine();
        String tokes [] = contenido.split(";");
        int promedio = (Integer.parseInt(tokes[1]) + Integer.parseInt(tokes[2]))/2;
        System.out.println("promedio" + promedio);
        fin.close();
        //flujo de salida-escritura desde java hacia file
        Formatter fout2 = new Formatter(new File("notasOut.csv"));
        fout2.format("%s;%s;%s;%s\n", "nombreEst", "Nota1" , "Nota2","Promedio");
        fout2.format("%s;%s;%s;%d\n", tokes[0], tokes[1], tokes[2], promedio);
        fout2.close();
    }
}
