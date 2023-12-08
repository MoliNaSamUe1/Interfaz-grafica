
package ventana;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel; //Importo el paquete de las etiquetas
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.util.Scanner;
import java.math.BigInteger;

public class ventana extends JFrame {
    //Componentes
    private JPanel panel;
    private JLabel etiqueta;
    private JLabel etiqueta2;
    private JLabel etiqueta3;
    private JLabel etiqueta4;
    private JLabel etiqueta5;
    private JTextField cajaTexto;
    private JTextField cajaTexto2;
    private JTextField cajaTexto3;
    private JTextField cajaTexto4;
    private JTextField cajaTexto5;
    private JTextArea areaTexto;
    private JButton boton1;
    private JButton boton2;
    int dimension;
    int matriz[][];
    
    public ventana(){  //Constructor de ventana
        setSize(750,650); //Establecemos el tamano de la ventana
        
        setTitle("Parcial 1"); //titulo de la ventana
        setLocationRelativeTo(null);  //Pongo la ventana en el centro
        
        iniciarComponentes();
        setDefaultCloseOperation(EXIT_ON_CLOSE); //termina la ejecucion del programa
        
    }
    private void iniciarComponentes(){
        colocarPaneles();
        colocarEtiquetas();
        colocarBotones();
        colocarCajasDeTexto();
        colocarAreasDeTexto();
    }
    
    private void colocarPaneles(){
        //panel
        panel=new JPanel(); //Creacion de un panel
        panel.setLayout(null);  //Modificamos el diseno por defecto
        panel.setBackground(Color.WHITE); //Establecemos el color del panel
        this.getContentPane().add(panel); //Agregamos el panel a la ventana
    }
    
    private void colocarEtiquetas(){   
        //Etiquetas
        etiqueta=new JLabel(); //Se crea una etiqueta
        etiqueta.setText("Introduzca la dimension de la matriz:");  //Le agrego texto a la etiqueta
        etiqueta.setBounds(40,1,230,30);
        //etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos el texto en el centro de la etiqueta
        panel.add(etiqueta); //Agregamos la etiqueta al panel
        
        etiqueta2=new JLabel(); //Se crea una etiqueta
        etiqueta2.setText("1- Ordenar la diagonal principal de mayor a menor");  //Le agrego texto a la etiqueta
        etiqueta2.setBounds(50,290,500,30);
        //etiqueta2.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos el texto en el centro de la etiqueta
        panel.add(etiqueta2);
        
        etiqueta3=new JLabel(); //Se crea una etiqueta
        etiqueta3.setText("2- Promedio de la suma de la diagonal secundaria");  //Le agrego texto a la etiqueta
        etiqueta3.setBounds(50,360,500,30);
        panel.add(etiqueta3);
        
        etiqueta4=new JLabel(); //Se crea una etiqueta
        etiqueta4.setText("3- Potencia menor numero de la 1era columna elevado al mayor numero de la ultima");  //Le agrego texto a la etiqueta
        etiqueta4.setBounds(50,430,500,30);
        panel.add(etiqueta4);
        
        etiqueta5=new JLabel(); //Se crea una etiqueta
        etiqueta5.setText("2- Secuencia Fibonacci hasta el numero mayor de la matriz");  //Le agrego texto a la etiqueta
        etiqueta5.setBounds(50,500,500,30);
        panel.add(etiqueta5);
    }
        
    private void colocarBotones(){    
        //Botones
        //Boton 1
        boton1 = new JButton("Operar");
        boton1.setBounds(340,40,100,30);  //tamano y ubicacion del boton
        boton1.setEnabled(true); //hago que se puedaclickear o no
        panel.add(boton1);  //Agrego boton al panel
        //Boton 2
        boton2 = new JButton("Limpiar");
        boton2.setBounds(450,40,100,30);  //tamano y ubicacion del boton
        boton2.setEnabled(false); //hago que se puedaclickear o no
        panel.add(boton2);  //Agrego boton a el panel
        eventoBotonOperar();
        eventoBotonReiniciar();
    }    
    private void eventoBotonOperar(){    
        //Agrego el evento de tipo ActionListener
        ActionListener oyenteDeAccion = new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!cajaTexto.getText().isEmpty()){
                    int multi;
                    dimension=Integer.parseInt(cajaTexto.getText());
                    String numCadena,texto_alg1,texto_alg2,texto_alg3,texto_alg4;  
                    int digitos,numero;
                    if ((dimension>=3)&&(dimension<=10)){
                        matriz=new int[dimension][dimension];
                        for (int i = 0; i < matriz.length; i++) {
                            for (int j = 0; j < matriz[0].length; j++) {
                                matriz[i][j]=(int)(Math.random()*999);
                                numero=matriz[i][j];
                                numCadena= Integer. toString(numero);
                                digitos=numCadena.length();
                                if(digitos==1){ 
                                    areaTexto.append(String.valueOf("       "+matriz[i][j]));
                                }
                                else if(digitos==2){ 
                                    areaTexto.append(String.valueOf("    "+matriz[i][j]));
                                }
                                else{  
                                    areaTexto.append(String.valueOf("  "+matriz[i][j]));
                                }
                        

                            }
                            areaTexto.append(String.valueOf("\n"));
                        }
                        texto_alg1=Algoritmo1(matriz);
                        texto_alg2=Algoritmo2(matriz);
                        texto_alg3=Algoritmo3(matriz);
                        texto_alg4=Algoritmo4(matriz);
                        cajaTexto2.setText(texto_alg1);//Agrego algoritmo 1 a la caja de texto
                        cajaTexto3.setText(texto_alg2);
                        cajaTexto4.setText(texto_alg3);
                        cajaTexto5.setText(texto_alg4);
                        boton2.setEnabled(true); //boton de reiniciar activado
                        boton1.setEnabled(false); //boton operar desactivado
                        cajaTexto.setEnabled(false); //desactivo caja de texto
                        areaTexto.setEnabled(true);
                        cajaTexto2.setEnabled(true);
                        cajaTexto3.setEnabled(true);
                        cajaTexto4.setEnabled(true);
                        cajaTexto5.setEnabled(true);
                    }
                }
            }
        };
        boton1.addActionListener(oyenteDeAccion);
    }
    
    private void eventoBotonReiniciar(){
        //Agrego el avento de tipo ActionListener
        ActionListener oyenteDeAccion2=new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cajaTexto.setText(null);
                cajaTexto2.setText(null);
                cajaTexto3.setText(null);
                cajaTexto4.setText(null);
                cajaTexto5.setText(null);
                areaTexto.setText(null);
                boton1.setEnabled(true);
                boton2.setEnabled(false);
                cajaTexto.setEnabled(true);
                cajaTexto2.setEnabled(false);
                cajaTexto3.setEnabled(false);
                cajaTexto4.setEnabled(false);
                cajaTexto5.setEnabled(false);
                areaTexto.setEnabled(false);
            }
        };
        boton2.addActionListener(oyenteDeAccion2);
    }
    
    private void colocarCajasDeTexto(){
        //Cajas de texto
        cajaTexto = new JTextField(); //instancio la caja de texto
        cajaTexto.setBounds(80,40,100,30); //tamano y ubicacion de la caja
        panel.add(cajaTexto);  //La agrego al panel
        eventoCajaTexto();
        
        cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(550,290,170,30);
        panel.add(cajaTexto2);
        
        cajaTexto3 = new JTextField();
        cajaTexto3.setBounds(550,360,170,30);
        panel.add(cajaTexto3);
        
        cajaTexto4 = new JTextField();
        cajaTexto4.setBounds(550,430,170,30);
        panel.add(cajaTexto4);
        
        cajaTexto5 = new JTextField();
        cajaTexto5.setBounds(550,500,170,30);
        panel.add(cajaTexto5);
    }
    
    private void eventoCajaTexto(){
        KeyListener eventoTeclado=new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char car=e.getKeyChar();
                if (car<'0'||car>'9'){
                    e.consume();
                }

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        };
        
        cajaTexto.addKeyListener(eventoTeclado);
        
    }
    
    private void colocarAreasDeTexto(){
        areaTexto=new JTextArea();
        areaTexto.setBounds(200,100,300,200);
        //areaTexto.setText("Aqui estoy");
        panel.add(areaTexto);
    }
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
        
        // Se retorna el promedio como String
        
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
