package SecondProject;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

// import javax.swing.Action;
import javax.swing.ImageIcon;
// import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.plaf.FontUIResource;

public class GamePanel extends JPanel implements ActionListener, KeyListener {

    private int[] snakeXlength = new int[100];
    private int[] snakeYlength = new int[100];
    private int LengthOfSnake = 5;
    private int Moves = 0;

    private int[] xPos = { 25, 50, 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475,
            500, 525, 550, 575, 600, 625, 650, 675, 700, 725, 750, 775, 800, 825, 850 };
    private int[] yPos = { 75, 100, 125, 150, 175, 200, 225, 250, 275, 300, 325, 350, 375, 400, 425, 450, 475, 500, 525,
            550, 575, 600, 625 };

    private Random random = new Random();
    private int EnyX, EnyY;

    private boolean gameOver = false;
    private int score = 0;

    private boolean left = false;
    private boolean right = true;
    private boolean up = false;
    private boolean down = false;

    private ImageIcon snakeTitle = new ImageIcon(getClass().getResource("snaketitle.jpg"));
    private ImageIcon downmouth = new ImageIcon(getClass().getResource("downmouth.png"));
    private ImageIcon leftmouth = new ImageIcon(getClass().getResource("leftmouth.png"));
    private ImageIcon rightmouth = new ImageIcon(getClass().getResource("rightmouth.png"));
    private ImageIcon snakeimage = new ImageIcon(getClass().getResource("snakeimage.png"));
    private ImageIcon upmouth = new ImageIcon(getClass().getResource("upmouth.png"));
    private ImageIcon enemy = new ImageIcon(getClass().getResource("enemy.jpg"));

    private Timer timer;
    private int delay = 100;

    public GamePanel() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new Timer(delay, this);
        timer.start();

        newEnemy();

    }

    private void newEnemy() {
        EnyX = xPos[random.nextInt(34)];
        EnyY = yPos[random.nextInt(23)];

        for (int i = LengthOfSnake - 1; i >= 0; i--) {
            if (snakeXlength[i] == EnyX && snakeYlength[i] == EnyY) {
                newEnemy();
            }

        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.setColor(Color.white);
        g.drawRect(24, 10, 851, 55);
        g.drawRect(24, 74, 851, 576);

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial" ,Font.PLAIN,15));
        g.drawString("Score :" + score, 750, 30);
        g.drawString("Length :" + LengthOfSnake, 750, 50);
        

        snakeTitle.paintIcon(this, g, 25, 11);

        g.setColor(Color.BLACK);
        g.fillRect(25, 75, 850, 575);

        if (Moves == 0) {
            snakeXlength[0] = 100;
            snakeXlength[1] = 75;
            snakeXlength[2] = 50;
            // snakeXlength[3] = 25;

            snakeYlength[0] = 100;
            snakeYlength[1] = 100;
            snakeYlength[2] = 100;
            // snakeYlength[3] = 100;
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
        for (int i = 1; i < LengthOfSnake; i++) {

            snakeimage.paintIcon(this, g, snakeXlength[i], snakeYlength[i]);
        }
        if (gameOver) {
            g.setColor(Color.red);
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.drawString("Game Over", 300, 300);

            g.setFont(new Font("Arial", Font.PLAIN, 20));
            g.drawString("Press SPACE to Restart", 320, 350);

            
        }
       
      enemy.paintIcon(this, g, EnyX, EnyY);

        g.dispose();

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = LengthOfSnake - 1; i > 0; i--) {
            snakeXlength[i] = snakeXlength[i - 1];
            snakeYlength[i] = snakeYlength[i - 1];
            // System.out.println(snakeYlength[i-1]);
        }
        if (left) {
            snakeXlength[0] = snakeXlength[0] - 25;
        }
        if (right) {
            snakeXlength[0] = snakeXlength[0] + 25;
        }
        if (up) {
            snakeYlength[0] = snakeYlength[0] - 25;
        }
        if (down) {
            snakeYlength[0] = snakeYlength[0] + 25;
        }
        // i didnot understand
        if (snakeXlength[0] > 850)
            snakeXlength[0] = 25;
        if (snakeXlength[0] < 25)
            snakeXlength[0] = 850;

        if (snakeYlength[0] > 625)
            snakeYlength[0] = 75;
        if (snakeYlength[0] < 75)
            snakeYlength[0] = 625;

        collidsWithEnemy();
        collidsWithBody();

        repaint();
    }

    private void collidsWithBody() {
        for (int i = LengthOfSnake - 1; i > 0; i--) {
            if (snakeXlength[i] == snakeXlength[0] && snakeYlength[i] == snakeYlength[0]) {
                timer.stop();
                gameOver = true;
            }
        }
    }

    private void collidsWithEnemy() {
        if (snakeXlength[0] == EnyX && snakeYlength[0] == EnyY) {
            newEnemy();
            LengthOfSnake++;
            score++;

        }
    }

    // @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            Restart();
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT && (!right)) {
            left = true;
            right = false;
            up = false;
            down = false;
            Moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_RIGHT && (!left)) {
            left = false;
            right = true;
            up = false;
            down = false;
            Moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_UP && (!down)) {
            left = false;
            right = false;
            up = true;
            down = false;
            Moves++;
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN && (!up)) {
            left = false;
            right = false;
            up = false;
            down = true;
            Moves++;
        }
    }

    private void Restart() {
        gameOver = false;
        Moves = 0;
        score = 0;
        LengthOfSnake = 3;
        left= false;
        right = true;
        up = false;
        down= false;
        timer.start();
        repaint();
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