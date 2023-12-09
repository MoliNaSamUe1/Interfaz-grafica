package Ventana;

import java.math.BigInteger;


public class Funciones {
    
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
        String mostrar;
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
        mostrar=String.format("%5.2f",prom);
        // Se retorna el promedio como Strign
        
        return mostrar;
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
        

        // Creamos un objeto de tipo BigInterger que pueda almacenar la potencia
        BigInteger base = BigInteger.valueOf(PrimerColumna[tamaño-1]);
        BigInteger resultado = base.pow(UltimaColumna[0]);
        
        // Convertimos el resultado en String y lo retornamos
        
        return resultado.toString();
        
    }
    
     public static String Algoritmo4(int matriz[][]){
         
         // Sacamos un arreglo con todos los numeros de la matriz
        int i = 0;
        int vect[] = new int[matriz.length * matriz.length];
        for (int x = 0 ; x<matriz.length ; ++x) {
            for (int y = 0 ; y<matriz.length ; ++y) {
                vect[i] = matriz[x][y];
                i += 1;
            }
        }
        
        // oredenamos el arreglo para sacar el numero mayor de la matriz
         OrdenarVector(vect);
         int mayorNum = vect[0];
         // Hacemos la sucesion de fibonacci hasta el mayor numero de la matriz
         int temp ,sig =1, ant = 0;
         String valor = "";
        while(ant <= mayorNum) {
            if (sig > mayorNum) {
                valor += ant;
            }
            else {
            valor += ant +", ";
            }
            temp = sig;
            sig = sig +ant;
            ant = temp;
        }
        return valor;
    }
        
}
