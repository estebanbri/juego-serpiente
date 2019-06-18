package application;

import javax.swing.*;
import java.awt.*;

public class Application {
    public static void main(String[] args) {

        JFrame marco = new JFrame();
        GameplayPanel gameplayPanel = new GameplayPanel();

        marco.setBounds(10,10,905,700);
        marco.setBackground(Color.DARK_GRAY);
        marco.setResizable(false);
        marco.setVisible(true);
        marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        marco.add(gameplayPanel);
    }
}
