
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

public class ventana extends JFrame {
    //Componentes
    private JPanel panel;
    private JTextField cajaTexto;
    private JTextArea areaTexto;
    private JButton boton1;
    private JButton boton2;
    int dimension;
    
    public ventana(){  //Constructor de ventana
        setSize(500,500); //Establecemos el tamano de la ventana
        
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
        JLabel etiqueta=new JLabel(); //Se crea una etiqueta
        etiqueta.setText("Tamano");  //Le agrego texto a la etiqueta
        etiqueta.setBounds(100,1,50,30);
        etiqueta.setHorizontalAlignment(SwingConstants.CENTER); //Establecemos el texto en el centro de la etiqueta
        panel.add(etiqueta); //Agregamos la etiqueta al panel
    }
        
    private void colocarBotones(){    
        //Botones
        //Boton 1
        boton1 = new JButton("Operar");
        boton1.setBounds(240,40,100,30);  //tamano y ubicacion del boton
        boton1.setEnabled(true); //hago que se puedaclickear o no
        panel.add(boton1);  //Agrego boton al panel
        //Boton 2
        boton2 = new JButton("Limpiar");
        boton2.setBounds(350,40,100,30);  //tamano y ubicacion del boton
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
                    dimension=Integer.parseInt(cajaTexto.getText());
                    String numCadena,a; 
                    int digitos,numero;
                    if ((dimension>=3)&&(dimension<=10)){
                        int matriz[][]=new int[dimension][dimension];
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
                        boton2.setEnabled(true); //boton de reiniciar activado
                        boton1.setEnabled(false); //boton operar desactivado
                        cajaTexto.setEnabled(false); //desactivo caja de texto
                        areaTexto.setEnabled(true);
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
                areaTexto.setText(null);
                boton1.setEnabled(true);
                boton2.setEnabled(false);
                cajaTexto.setEnabled(true);
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
        areaTexto.setBounds(100,100,300,300);
        //areaTexto.setText("Aqui estoy");
        panel.add(areaTexto);
    }
}
