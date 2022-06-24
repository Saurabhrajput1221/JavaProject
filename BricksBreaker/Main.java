package BricksBreaker;

import javax.swing.JFrame;

import SecondProject.GamePanel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bricks and Breaker");
        JFrame frame = new JFrame();
        frame.setTitle("Bricks and Breaker");
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);

        Gameplay panel = new Gameplay();
        frame.add(panel);

    }

}
