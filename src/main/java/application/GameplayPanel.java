package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameplayPanel extends JPanel implements KeyListener, ActionListener {

    private ImageIcon imagenTitulo = new ImageIcon(".\\src\\main\\resources\\img\\snaketitle.jpg");

    // primera posicion de ambos array es la cabeza de la serpiente
    private int[] posicionX = new int[750];
    private int[] posicionY = new int[750];

    private boolean flechaArriba = false;
    private boolean flechaAbajo = false;
    private boolean flechaDerecha = false;
    private boolean flechaIzquierda = false;

    private int largoSerpiente = 3;

    private ImageIcon imagenBocaArriba = new ImageIcon(".\\src\\main\\resources\\img\\upmouth.png");
    private ImageIcon imagenBocaAbajo = new ImageIcon(".\\src\\main\\resources\\img\\downmouth.png");
    private ImageIcon imagenBocaDerecha = new ImageIcon(".\\src\\main\\resources\\img\\rightmouth.png");
    private ImageIcon imagenBocaIzquierda = new ImageIcon(".\\src\\main\\resources\\img\\leftmouth.png");

    private ImageIcon imagenCuerpoSerpiente = new ImageIcon(".\\src\\main\\resources\\img\\snakeimage.png");

    private Timer timer;
    private int delay = 100;

    private int cantidadMovimientos = 0;

    public GameplayPanel(){
        // posision por defecto de la serpiente
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {

        // dibujar el borde blanco de la imagen del titulo
        g.setColor(Color.WHITE);
        g.drawRect(24,10,851,55);

        // dibujar la imagen del titulo
        imagenTitulo.paintIcon(this,g,25,11);

        // dibujar el borde blanco del area de juego
        g.setColor(Color.WHITE);
        g.drawRect(24,74,851,577);

        // dibujar el background negro para el area de juego
        g.setColor(Color.BLACK);
        g.fillRect(25,75,850,575);

        // posicion inicial de serpiente
        imagenBocaDerecha.paintIcon(this, g, posicionX[0], posicionY[0]);

        for(int i=0; i < largoSerpiente; i++){

            // este if se ejecutara la primera vez que inicia el juego
            if( cantidadMovimientos == 0){
                posicionX[2] = 50;
                posicionX[1] = 75;
                posicionX[0] = 100;

                posicionY[2] = 100;
                posicionY[1] = 100;
                posicionY[0] = 100;
            }

            // i = 0 entonces recien solo tiene la cara sin cuerpo

            // segun los booleanos de direccion va a mostrarse la imagen de la boca segun correcponda
            if( i==0 && flechaDerecha){
                imagenBocaDerecha = new ImageIcon(".\\src\\main\\resources\\img\\rightmouth.png");
                imagenBocaDerecha.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            if( i==0 && flechaIzquierda){
                imagenBocaIzquierda = new ImageIcon(".\\src\\main\\resources\\img\\leftmouth.png");
                imagenBocaIzquierda.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            if( i==0 && flechaArriba){
                imagenBocaArriba =  new ImageIcon(".\\src\\main\\resources\\img\\upmouth.png");
                imagenBocaArriba.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            if( i==0 && flechaAbajo){
                imagenBocaAbajo = new ImageIcon(".\\src\\main\\resources\\img\\downmouth.png");
                imagenBocaAbajo.paintIcon(this, g, posicionX[i], posicionY[i]);
            }

            // si i no es cero (es decir agarro comida) entonces hay que dibujar el cuerpo

            if(i!=0){
                imagenCuerpoSerpiente = new ImageIcon(".\\src\\main\\resources\\img\\snakeimage.png");
                imagenCuerpoSerpiente.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            cantidadMovimientos++;
        }

        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {

    }
}
