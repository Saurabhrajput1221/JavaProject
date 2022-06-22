package SecondProject;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Action;
import javax.swing.ImageIcon;
// import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener {

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
        timer = new Timer(delay , this);
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
            Moves++;

        }
        if (left) {
            leftmouth.paintIcon(this, g, snakeYlength[0], snakeXlength[0]);
        }
        if (right) {
            downmouth.paintIcon(this, g, snakeYlength[0], snakeXlength[0]);
        }
        if (down) {
            rightmouth.paintIcon(this, g, snakeYlength[0], snakeXlength[0]);
        }
        if (up) {
            upmouth.paintIcon(this, g, snakeYlength[0], snakeXlength[0]);
        }
        for (int i = 1; i < SnakeLength; i++) {

            snakeimage.paintIcon(this, g, snakeYlength[i], snakeXlength[i]);

        }
        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(left){
           snakeXlength[0] = snakeXlength[0] - 15;
        }
        if(right){
            snakeXlength[0] = snakeXlength[0] + 15;
         }
         if(up){
            snakeYlength[0] = snakeYlength[0] - 15;
         }
         if(down){
             snakeYlength[0] = snakeYlength[0] + 15;
          }
          
   repaint();
    }

}