package Other;
import java.awt.Color;
import javax.swing.JFrame;

public class Game {

    public static void main(String[] args) {
        System.out.println("snake game");
        JFrame frame = new JFrame("snake game at my own");

        frame.setBounds(50, 50, 700, 500);
        frame.setVisible(true);
            frame.setResizable(true);
        // frame.setBackground(Color.yellow);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        InsidePanel newpanel = new InsidePanel();
        newpanel.setBackground(Color.BLACK);
        frame.add(newpanel);

        newpanel.setVisible(true);

    }
}
