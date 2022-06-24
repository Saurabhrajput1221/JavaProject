package BricksBreaker;

import java.util.Timer;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;

public class Gameplay extends JPanel {
    private boolean play = false;
    private int totalBrick = 21;
    private Timer timer;
    private int delay = 8;
    private int ballpoX = 120;
    private int ballpoY = 350;
    private int ballXdir = 1;
    private int ballYdir = 2;
    private int playerX = 350;

    public Gameplay() {

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.BLACK);
        g.fillRect(1, 1, 692, 592);
        // Border line top , left and right respectively
        g.setColor(Color.YELLOW);
        g.fillRect(0, 0, 692, 3);
        g.fillRect(0, 3, 3, 592);
        g.fillRect(692, 3, 3, 592);
        // pedal
        g.setColor(Color.ORANGE);
        g.fillRect(playerX, 550, 100, 8);
        // ball
        g.setColor(Color.RED);
        g.fillOval(ballpoX, ballpoY, 20, 20);

    }
}
