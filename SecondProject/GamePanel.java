package SecondProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// import javax.swing.Action;
import javax.swing.ImageIcon;
// import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private int[] snakeXlength = new int[750];
    private int[] snakeYlength = new int[750];
    private int SnakeLength = 3;
    private int Moves = 0;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon snakeTitle = new ImageIcon(getClass().getResource("snaketitle.jpg"));
    private ImageIcon downmouth = new ImageIcon(getClass().getResource("downmouth.png"));
    private ImageIcon enemy = new ImageIcon(getClass().getResource("enemy.png"));
    private ImageIcon leftmouth = new ImageIcon(getClass().getResource("leftmouth.png"));
    private ImageIcon rightmouth = new ImageIcon(getClass().getResource("rightmouth.png"));
    private ImageIcon snakeimage = new ImageIcon(getClass().getResource("snakeimage.png"));
    private ImageIcon upmouth = new ImageIcon(getClass().getResource("upmouth.png"));

    private Timer timer;
    private int delay = 100;

    GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new Timer(delay, this);
        timer.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.white);
        g.drawRect(15, 20, 851, 50);
        g.drawRect(15, 80, 851, 550);

        snakeTitle.paintIcon(this, g, 16, 20);

        g.setColor(Color.BLACK);
        g.fillRect(16, 81, 850, 549);

        if (Moves == 0) {
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;
            // Moves++;

        }
        if (left) {
            leftmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        }
        if (right) {
            rightmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        }
        if (down) {
            downmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        }
        if (up) {
            upmouth.paintIcon(this, g, snakeXlength[0], snakeYlength[0]);
        }
        for (int i = 1; i < SnakeLength; i++) {

            snakeimage.paintIcon(this, g, snakeYlength[i], snakeXlength[i]);

        }
        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = SnakeLength - 1; i > 0; i--) {
            snakeXlength[i] = snakeXlength[i - 1];
            snakeYlength[i] = snakeYlength[i - 1];
        }
        if (left) {
            snakeXlength[0] = snakeXlength[0] - 15;
        }
        if (right) {
            snakeXlength[0] = snakeXlength[0] + 15;
        }
        if (up) {
            snakeYlength[0] = snakeYlength[0] - 15;
        }
        if (down) {
            snakeYlength[0] = snakeYlength[0] + 15;
        }
        if (snakeXlength[0] > 900)
            snakeXlength[0] = 25;
        if (snakeXlength[0] < 16)
            snakeXlength[0] = 900;

        if (snakeXlength[0] > 650)
            snakeXlength[0] = 25;
        if (snakeXlength[0] < 16)
            snakeXlength[0] = 950;

        repaint();
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            left = true;
            right = false;
            up = false;
            down = false;
            Moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            left = false;
            right = true;
            up = false;
            down = false;
            Moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            left = false;
            right = false;
            up = true;
            down = false;
            Moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            left = false;
            right = false;
            up = false;
            down = true;
            Moves++;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

   

}