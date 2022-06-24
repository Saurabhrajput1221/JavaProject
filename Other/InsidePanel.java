package Other;
import java.awt.Graphics;

import javax.swing.Action;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InsidePanel extends JPanel implements ActionListener {
    private boolean right = false;
    private boolean left = true;
    private boolean up = false;
    private boolean down = false;

    private int[] SXlength = new int[100];
    private int[] SYlength = new int[100];

    private int moves = 0;
    private int LengthOfS = 2;
    private ImageIcon rightmove = new ImageIcon(getClass().getResource("New.png"));

    public InsidePanel() {

    }

    @Override

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(10, 10, 660, 40);
        g.drawString("Score :", 550, 25);
        g.drawString("Snake Game ", 30, 30);
        g.drawString("Length :", 550, 45);

        g.drawRect(10, 60, 660, 390);

        if (moves == 0) {
            SXlength[0] = 100;
            SXlength[1] = 75;
            // SXlength[2] = 50;

            SYlength[0] = 100;
            SYlength[1] = 100;
            // SYlength[2] = 100;
            moves++;

        }
        if (left) {
            rightmove.paintIcon(this, g, SXlength[0], SYlength[0]);
        }
        for (int i = 1; i < LengthOfS; i++) {
            rightmove.paintIcon(this, g, SXlength[i], SYlength[i]);
        }
        g.dispose();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // snake will move from (up to down) and (right to left)
        for (int i = LengthOfS - 1; i > 0; i--) {
            SXlength[i] = SXlength[i - 1];
            SYlength[i] = SYlength[i - 1];
        }
        if (left) {
            SXlength[0] = SXlength[0] - 10;
        }
        if (SXlength[0] > 650)
            SXlength[0] = 10;
        if (SXlength[0] < 10)
            SXlength[0] = 650;

        if (SYlength[0] > 430)
            SXlength[0] = 75;
        if (SXlength[0] < 75)
            SXlength[0] = 430;
        repaint();
    }

}
