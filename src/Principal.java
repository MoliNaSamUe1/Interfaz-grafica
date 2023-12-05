import java.util.*;
public class Principal {
    public static void main(String[] args) {
        
        // Creamos una matriz de 3x3 para probar las funciones
        int matriz[][] = new int[3][3];
        for(int i = 0; i<matriz.length ; ++i) {
            for(int j = 0 ; j<matriz.length ; ++j) {
                matriz[i][j] = (int) (Math.random()*1000);
            }
        }
        for(int i = 0; i<matriz.length ; ++i) {
            for(int j = 0 ; j<matriz.length ; ++j) {
                System.out.printf("%-3d" + "  ",matriz[i][j]);
            }
            System.out.println("");
        }
        
        // Se prueuba la funcion
        System.out.println("\nRESULTADO DE LA FUNCION");
        System.out.println(Secundario.Algoritmo3(matriz));
    }
    
}
