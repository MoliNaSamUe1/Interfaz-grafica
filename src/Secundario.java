
import java.util.Scanner;



public class Secundario {
    
    public static void OrdenarVector(int vect[]) {
        // Definimos una funcion que ordene un vector
        int temp;
        int tamaño = vect.length;
        for (int i = 0 ; i<(tamaño -1) ; ++i) {
            for (int j = 0 ; j<(tamaño-1); ++j) {
                if (vect[j] < vect[j+1]) {
                    temp = vect[j];
                    vect[j] =  vect[j+1];
                    vect[j+1] = temp;
                }
            } 
        }
    }
    
    public static String Algoritmo1(int matriz[][]) {
        
        // Creamos la Diagonal Principal
            int tamaño = matriz.length;
            int DiagPrincipal[] = new int[tamaño];
            for (int i = 0 ; i<tamaño ; ++i) {
                for (int j = 0 ; j<tamaño ; ++j) {
                    if (i == j) {
                        DiagPrincipal[i] = matriz[i][j];
                    }
                }
            }
        // Ordenamos la Diagonal Principal de mayor a menor
        OrdenarVector(DiagPrincipal);
            
        // Mostramos por pantalla la Diagonal Principal ordenada de mayor a menor
        
        String texto = "";
        for (int i = 0 ; i<(tamaño) ; ++i) {
            if (i != tamaño-1) {
                texto += DiagPrincipal[i] + ", ";
            }
            else {
                texto += DiagPrincipal[i];
            }
        }
        return texto;
    }
    
    public static String Algoritmo2(int matriz[][]) {
        
        // Creamos la Diagonal Secundaria y la guardamos en una variable
        int tamaño = matriz.length;
        int DiagSecundaria[] = new int[tamaño];
        for (int i = 0 ; i<tamaño ; ++i) {
            for (int j = 0 ; j<tamaño ; ++j) {
                if (i +j== tamaño - 1) {
                     DiagSecundaria[i] = matriz[i][j];
                }
            }
        }
        
        // Se saca el promedio de la Diagonal secundaria
        double prom, suma = 0;
        for (int i = 0; i<tamaño ;++i) {
            suma += DiagSecundaria[i];    
        }
        prom = suma/tamaño;
        
        // Se retorna el promedio como Strign
        
        return (prom + "");
    }
    
    public static String Algoritmo3(int matriz[][]){
        
        // Definimos la Primera y ultima Columna en variables que guarden los arreglos
        int tamaño = matriz.length;
        int PrimerColumna[] = new int[tamaño];
        int UltimaColumna[] = new int[tamaño];
        for (int i = 0; i<tamaño ; ++i) {
            PrimerColumna[i] = matriz[i][0];
            UltimaColumna[i] = matriz[i][tamaño-1];
        }
        
        // Ordenamos de mayor a menor cada columna
        OrdenarVector(PrimerColumna);
        OrdenarVector(UltimaColumna);
        
        // Retornamos la potencia del menor numero de la primera columna elevada al mayor numero de la ultima columna
        return ( Math.pow(PrimerColumna[tamaño-1], UltimaColumna[0]) + "");
    }
    
     public static void Algoritmo4(){
        
        System.out.println("Sucesion de fibonacci");
        System.out.print("Coloque el numero de terminos de fibonacci: ");
        Scanner teclado = new Scanner(System.in);
        int i = teclado.nextInt();
        int temp ,sig =1, ant = 0;
        for (int x = 0 ; x<i ; ++x) {
            if (x < i-1) {
                System.out.print(ant +", ");
                temp = sig;
                sig = sig +ant;
                ant = temp;
            }
            else {
                System.out.print(ant);
            }
        }
        System.out.println();
    }
}
