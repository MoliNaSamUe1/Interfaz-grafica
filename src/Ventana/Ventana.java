package Ventana; 
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

public class Ventana extends JFrame{
    JPanel panel;
    int matriz[][];
    JTextField cajaTexto;
    JTextField cajaTexto1;
    JTextField cajaTexto2;
    JTextField cajaTexto3;
    JTextField cajaTexto4;
    JTextPane textoEstilizado; // El objeto textPane es como un objeto de tipo area de texto, lo uso para colocar los numeros de la matriz
    JButton boton1;
    JButton boton2;
    
    public Ventana() {
        setSize(800, 900); //Establece el tamaño de la ventana
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Cuando se cierre la ventana, finaliza la ejecucion del programa
        setTitle("P1_Operaciones con matriz"); //Coloca el titulo de la ventana
        setLocationRelativeTo(null); //Ubicacion de la ventana en el centro de cualquier pantalla
        // setResizable(false); Establece si la pantalla se puede redimensionar
        // setMinimumSize(new Dimension(500,500)); establece el tamañao minimo de la pantalla
        //this.getContentPane().setBackground(Color.BLUE); //Coloca color a la ventana
        IniciarComponentes(); //Ejecutamos la funcion para que se agrega un panel sobre la ventana
        
    }
    
    private void IniciarComponentes() {
        ColocarPanel();
        ColocarEtiquetas();
        ColocarJTextPane();
        ColocarCajaDeTexto();
        ColocarBoton();
    }
    
    private void ColocarPanel() {
        panel = new JPanel(); //Iniciamos un panel con el constructor de objeto JPanel
        panel.setBackground(Color.white); //Coloca color a el panel
        panel.setLayout(null); //Desactivamos el diseño del layout que trae el panel por defecto
        getContentPane().add(panel); //Con esto se agrega el panel a la ventana
    }
    
    private void ColocarEtiquetas() {
        
        // Etiqueta de texto principal
        JLabel etiqueta = new JLabel(); /*Instanciamos un objeto de clase 
        JLabel , para crear una etiqueta  */
        etiqueta.setText("Dimension de la Matriz:"); //Le colocamos un texto a a la etiqueta
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Alineamos el texto de la etiqueta con respecto a la horizontal
        etiqueta.setBounds(50, 27, 230, 30); //Establecemos la posicion y dimensiones de la etiqueta
        etiqueta.setForeground(Color.BLUE); // Agrega color a las letras de la etiqueta 
        etiqueta.setOpaque(true); // Establecemos que se puede pintar el fondo de la etiqueta con true
        etiqueta.setBackground(Color.WHITE); // Establecemos el color de fondo de la etiqueta
        etiqueta.setFont(new Font("arial",3 , 20)); // Colocamos la fuente, el tipo de letra(negritas, cursivas,...) y el tamaño de la fuente
        panel.add(etiqueta); //Agregamos eqtiqueta al panel
        
        // Etiqueta de texto de los algortimos
        JLabel etiqueta1 = new JLabel();
        etiqueta1.setText("1) Diagonal Principal Ordanada de Mayor a Menor:");
        etiqueta1.setBounds(50, 400, 400, 35);
        etiqueta1.setOpaque(true);
        etiqueta1.setBackground(Color.WHITE);
        etiqueta1.setFont(new Font("arial",3,15));
        panel.add(etiqueta1);
        
        JLabel etiqueta2 = new JLabel();
        etiqueta2.setText("2) Promedio de Suma de la Diagonal Secundaria:");
        etiqueta2.setBounds(50, 500, 400, 35);
        etiqueta2.setOpaque(true);
        etiqueta2.setBackground(Color.WHITE);
        etiqueta2.setFont(new Font("arial",3,15));
        panel.add(etiqueta2);
        
        JLabel etiqueta3 = new JLabel();
        etiqueta3.setText("3) Potencia del Menor Numero de la 1era Columna Elevado al Mayor Numero de la Ult. Columna:");
        etiqueta3.setBounds(50, 600, 700, 35);
        etiqueta3.setOpaque(true);
        etiqueta3.setBackground(Color.WHITE);
        etiqueta3.setFont(new Font("arial",3,15));
        panel.add(etiqueta3);
        
        JLabel etiqueta4 = new JLabel();
        etiqueta4.setText("4) Secuencia Fibonacci Hasta el Mayor Numero de la Matriz:");
        etiqueta4.setBounds(50, 750, 420, 35);
        etiqueta4.setOpaque(true);
        etiqueta4.setBackground(Color.WHITE);
        etiqueta4.setFont(new Font("arial",3,15));
        panel.add(etiqueta4);



        
        
        
    }
    
    private void ColocarBoton() {
        
     // Boton operar
        
        boton1 = new JButton(); // Instanciamos y creamos un obejto de la clase JButton el cual sera el boton
        boton1.setText("Operar"); // le damos un texto dentro del boton
        boton1.setBounds(400, 25, 100, 35); // Asignamos la posicion y dimension del boton dentro del panel
        panel.add(boton1); // agregamos el boton al panel
        
     // Boton limpiar
        boton2 = new JButton();
        boton2.setText("Limpiar");
        boton2.setBounds(511, 25, 100, 35);
        boton2.setEnabled(false);
        panel.add(boton2);
               
     // Agregamos un evento al boton
        FuncionDelBotonOperar();
        FuncionDelBotonLimpiar();
    }
    
    private void ColocarCajaDeTexto() {
      //caja de texto inicial  
        cajaTexto = new JTextField(); // creamos el objeto de caja de texto
        cajaTexto.setBounds(290, 25, 100, 35); // establecemos la posicion y dimension de la caja de texto
        panel.add(cajaTexto);
        
        
     // Caja de texto de los algortimos   
        cajaTexto1 = new JTextField();
        cajaTexto1.setBounds(480, 400, 250, 35);
        panel.add(cajaTexto1);
        
        cajaTexto2 = new JTextField();
        cajaTexto2.setBounds(480, 500, 250, 35);
        panel.add(cajaTexto2);
        
        cajaTexto3 = new JTextField();
        cajaTexto3.setBounds(50, 650, 680, 35);
        panel.add(cajaTexto3);
     
        cajaTexto4 = new JTextField();
        cajaTexto4.setBounds(480, 750, 250, 35);
        panel.add(cajaTexto4);
    }
    
    private void ColocarJTextPane() { // Funcion que crea el textpane donde se coloca la matriz
        textoEstilizado = new JTextPane();
        textoEstilizado.setBounds(150, 100, 450, 230);
      //textoEstilizado.setBackground(Color.LIGHT_GRAY);
        textoEstilizado.setFont(new Font("Courier New", Font.PLAIN, 18));

        textoEstilizado.setEditable(false);

        // Las siguientes 4 lineas de codigo tal cual como estan hacen que el texto del textpane se centre horizontalmente
        StyledDocument doc = textoEstilizado.getStyledDocument();
        SimpleAttributeSet centerAlign = new SimpleAttributeSet();
        StyleConstants.setAlignment(centerAlign, StyleConstants.ALIGN_CENTER);
        doc.setParagraphAttributes(0, doc.getLength(), centerAlign, false);
        
        panel.add(textoEstilizado);
    }
    
    private void FuncionDelBotonOperar() {
        ActionListener oyenteDeAccion = new ActionListener() {  // creamos el objeto evento (ActionListener) que es el evento asociado al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                int tamaño = Integer.parseInt(cajaTexto.getText());
                String mostrar = "";
                // Creamos la matriz 
                matriz = new int[tamaño][tamaño];
                for(int i = 0; i<matriz.length ; ++i) {
                    for(int j = 0 ; j<matriz.length ; ++j) {
                        matriz[i][j] = (int) (Math.random()*1000);
                        mostrar += String.format("%4d", matriz[i][j]);
                    }
                    mostrar += "\n";
                }
                textoEstilizado.setText(mostrar); // Pasamos los datos de la matriz al textpane
                cajaTexto.setEditable(false); // deshabilitamos la caja de texto que pide la dimension de la matriz
                boton1.setEnabled(false); // deshabilitamos el boton operar 
                boton2.setEnabled(true); // deshabilitamos el boton limpiar
                
                // Invocamos los algoritmos que realizan las 4 funciones con los datos de la matriz
                cajaTexto1.setText(Funciones.Algoritmo1(matriz)); 
                cajaTexto1.setCaretPosition(0);                   // esto hace que el puntero de la caja de texto se quede en el inicio
                cajaTexto2.setText(Funciones.Algoritmo2(matriz));
                cajaTexto2.setCaretPosition(0);
                cajaTexto3.setText(Funciones.Algoritmo3(matriz));
                cajaTexto3.setCaretPosition(0);
                cajaTexto4.setText(Funciones.Algoritmo4(matriz));
                cajaTexto4.setCaretPosition(0);
            }
        };
        
        
        boton1.addActionListener(oyenteDeAccion); // le pasamos el evento al boton
    }
    
    private void FuncionDelBotonLimpiar() {
        
        ActionListener oyenteDeAccion = new ActionListener() {  // creamos el objeto evento (ActionListener) que es el evento asociado al boton
            @Override
            public void actionPerformed(ActionEvent e) {
                boton1.setEnabled(true); // hablitamos el boton operar
                cajaTexto.setText(""); // borramos el texto de la caja donde introducimos la dimension de la matriz
                cajaTexto.setEditable(true); // habilitamos la edicion de la caja donde introducimos la dimension de la matriz
                textoEstilizado.setText(""); // borramos el texto de la matriz
                boton2.setEnabled(false);  // deshabilitamos el boton de limpiar
                
                // borramos los textos de las cajas donde se muestran los resultados de los algoritmos
                cajaTexto1.setText("");
                cajaTexto2.setText("");
                cajaTexto3.setText("");
                cajaTexto4.setText("");
                
            }
        };
        
        
        boton2.addActionListener(oyenteDeAccion);
    }
}

/* Para jugar con las dimensiones y posicion de un elemento, hay que desactivar el layout donde se esta colocando
   este elemento ---> Ejemplo juego con etiquetas desactivo layout del padre que es el panel
*/