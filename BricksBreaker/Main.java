package BricksBreaker;

import javax.swing.JFrame;

import SecondProject.GamePanel;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bricks and Breaker");
        JFrame frame = new JFrame("Bricks and Breaker");
        frame.setSize(700, 600);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);

        Gameplay panel = new Gameplay();
        frame.add(panel);

    }

}
