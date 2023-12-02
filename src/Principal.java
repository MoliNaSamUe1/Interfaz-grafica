import java.util.Scanner;
public class Principal {
    public static void main(String[] args) {
        System.out.println("Sucesion de fibonacci");
        System.out.print("Coloque el numero de terminos de fibonacci: ");
        Scanner teclado = new Scanner(System.in);
        int i = teclado.nextInt();
        int temp ,sig =1, ant = 0;
        for (int x = 0 ; x<i ; ++x) {
            System.out.print(ant +", ");
            temp = sig;
            sig = sig +ant;
            ant = temp;
        }
        System.out.println();
    }
    
}
