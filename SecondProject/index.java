package SecondProject;
import java.awt.Color;

import javax.swing.JFrame;

import SecondProject.GamePanel;

public class index {
    public static void main(String[] args) {
        System.out.println("Snake game");
        JFrame frame = new JFrame("Snake Game ");
        frame.setBounds(10, 10, 900, 700);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

       GamePanel panel = new GamePanel();
       panel.setBackground(Color.gray);
       frame.add(panel);


        frame.setVisible(true);

    }

}
