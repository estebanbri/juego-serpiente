package application;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameplayPanel extends JPanel implements KeyListener, ActionListener {

    // primera posicion de ambos array es la cabeza de la serpiente
    private int[] posicionX = new int[750];
    private int[] posicionY = new int[750];

    private boolean movimientoArriba = false;
    private boolean movimientoAbajo = false;
    private boolean movimientoDerecha = false;
    private boolean movimientoIzquierda = false;

    private ImageIcon imagenTitulo = new ImageIcon(".\\src\\main\\resources\\img\\snaketitle.jpg");

    private ImageIcon imagenBocaArriba = new ImageIcon(".\\src\\main\\resources\\img\\upmouth.png");
    private ImageIcon imagenBocaAbajo = new ImageIcon(".\\src\\main\\resources\\img\\downmouth.png");
    private ImageIcon imagenBocaDerecha = new ImageIcon(".\\src\\main\\resources\\img\\rightmouth.png");
    private ImageIcon imagenBocaIzquierda = new ImageIcon(".\\src\\main\\resources\\img\\leftmouth.png");

    private ImageIcon imagenCuerpoSerpiente = new ImageIcon(".\\src\\main\\resources\\img\\snakeimage.png");

    private int largoSerpiente = 3; // largo inicial de la serpiente

    private Timer timer;
    private int delay = 100; // milisegundos

    private int cantidadMovimientos = 0;


    public GameplayPanel(){
        this.addKeyListener(this);
        this.setFocusable(true);
        this.setFocusTraversalKeysEnabled(false);
        timer = new Timer(delay, this);
        timer.start();
    }

    @Override
    public void paint(Graphics g) {

        // este if se ejecutara la primera vez que inicia el juego y representa la posicion inicial de la serpiente dentro del area de juego
        if( cantidadMovimientos == 0){
            posicionX[2] = 50;
            posicionX[1] = 75;
            posicionX[0] = 100;

            posicionY[2] = 100;
            posicionY[1] = 100;
            posicionY[0] = 100;
        }

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

        // dibujo la serpiente
        for(int i=0; i < largoSerpiente; i++){

            // i = 0 es decir posicionX[0], posicionY[0] representa la cabeza de la serpiente

            // segun los booleanos de direccion va a mostrarse la imagen de la boca segun correcponda
            if( i==0 && movimientoDerecha){
                imagenBocaDerecha = new ImageIcon(".\\src\\main\\resources\\img\\rightmouth.png");
                imagenBocaDerecha.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            if( i==0 && movimientoIzquierda){
                imagenBocaIzquierda = new ImageIcon(".\\src\\main\\resources\\img\\leftmouth.png");
                imagenBocaIzquierda.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            if( i==0 && movimientoArriba){
                imagenBocaArriba =  new ImageIcon(".\\src\\main\\resources\\img\\upmouth.png");
                imagenBocaArriba.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
            if( i==0 && movimientoAbajo){
                imagenBocaAbajo = new ImageIcon(".\\src\\main\\resources\\img\\downmouth.png");
                imagenBocaAbajo.paintIcon(this, g, posicionX[i], posicionY[i]);
            }

            // i != 0 representa el cuerpo

            if(i!=0){
                imagenCuerpoSerpiente = new ImageIcon(".\\src\\main\\resources\\img\\snakeimage.png");
                imagenCuerpoSerpiente.paintIcon(this, g, posicionX[i], posicionY[i]);
            }
        }

        g.dispose();
    }

    public void actionPerformed(ActionEvent e) {
        timer.start();
        if(movimientoArriba){
            for(int i = largoSerpiente - 1; i>=0; i--){
                posicionX[i+1] = posicionX[i];
            }
            for(int i = largoSerpiente; i>=0; i--){
                if(i == 0){
                    posicionY[i] = posicionY[i] - 25;
                }else{
                    posicionY[i] = posicionY[i-1];
                }

                if(posicionY[i] < 75){
                    posicionY[i] = 625;
                }
            }
            repaint(); // hace un call al metodo paint() y ejecuta toda la implemetacion que hiciste
        }
        if(movimientoAbajo){
            for(int i = largoSerpiente - 1; i>=0; i--){
                posicionX[i+1] = posicionX[i];
            }
            for(int i = largoSerpiente; i>=0; i--){
                if(i == 0){
                    posicionY[i] = posicionY[i] + 25;
                }else{
                    posicionY[i] = posicionY[i-1];
                }

                if(posicionY[i] > 625){
                    posicionY[i] = 75;
                }
            }
            repaint(); // hace un call al metodo paint() y ejecuta toda la implemetacion que hiciste
        }
        if(movimientoDerecha){
            for(int i = largoSerpiente - 1; i>=0; i--){
                posicionY[i+1] = posicionY[i];
            }
            for(int i = largoSerpiente; i>=0; i--){
                if(i == 0){
                   posicionX[i] = posicionX[i] + 25;
                }else{
                    posicionX[i] = posicionX[i-1];
                }

                if(posicionX[i] > 850){
                    posicionX[i] = 25;
                }
            }
            repaint(); // hace un call al metodo paint() y ejecuta toda la implemetacion que hiciste
        }
        if(movimientoIzquierda){
            for(int i = largoSerpiente - 1; i>=0; i--){
                posicionY[i+1] = posicionY[i];
            }
            for(int i = largoSerpiente; i>=0; i--){
                if(i == 0){
                    posicionX[i] = posicionX[i] - 25;
                }else{
                    posicionX[i] = posicionX[i-1];
                }

                if(posicionX[i] < 25){
                    posicionX[i] = 850;
                }
            }
            repaint(); // hace un call al metodo paint() y ejecuta toda la implemetacion que hiciste
        }
    }

    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_UP){
            cantidadMovimientos++;
            if(movimientoAbajo){ // if para prevenir colision de la cabeza cuando la serpiente ya se encuentra en movimiento hacia abajo
                movimientoArriba = false;
            }else{
                movimientoArriba = true;
            }
            movimientoDerecha = false;
            movimientoIzquierda= false;
        }
        if(e.getKeyCode() == KeyEvent.VK_DOWN){
            cantidadMovimientos++;
            if(movimientoArriba){ // if para prevenir colision de la cabeza cuando la serpiente ya se encuentra en movimiento hacia arriba
                movimientoAbajo = false;
            }else{
                movimientoAbajo = true;
            }
            movimientoDerecha = false;
            movimientoIzquierda= false;
        }
        if(e.getKeyCode() == KeyEvent.VK_RIGHT){
            cantidadMovimientos++;
            if(movimientoIzquierda){ // if para prevenir colision de la cabeza cuando la serpiente ya se encuentra en movimiento hacia izquierda
                movimientoDerecha = false;
            }else{
                movimientoDerecha = true;
            }
            movimientoArriba = false;
            movimientoAbajo = false;
        }
        if(e.getKeyCode() == KeyEvent.VK_LEFT){
            cantidadMovimientos++;
            if(movimientoDerecha){ // if para prevenir colision de la cabeza cuando la serpiente ya se encuentra en movimiento hacia derecha
                movimientoIzquierda = false;
            }else{
                movimientoIzquierda = true;
            }
            movimientoArriba = false;
            movimientoAbajo = false;
        }
    }

    public void keyReleased(KeyEvent e) {

    }
    public void keyTyped(KeyEvent e) {

    }
}