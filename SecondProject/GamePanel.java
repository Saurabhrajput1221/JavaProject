package SecondProject;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.ImageIcon;
// import javax.swing.JFrame;
import javax.swing.JPanel;

public class GamePanel extends JPanel {

    // private ImageIcon hello = new ImageIcon(getClass().getResource("snaketitle.jpg"));

    GamePanel() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.white);
        g.drawRect(15, 20, 850, 50);
        g.drawRect(15, 80, 850, 550);

        // hello.paintIcon(this, g, 2, 2);

    }

}