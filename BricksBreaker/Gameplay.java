package BricksBreaker;

import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

public class Gameplay extends JPanel implements ActionListener, KeyListener {
    private boolean play = false;
    private int totalBrick = 21;
    private Timer timer;
    private int delay = 80;
    private int ballpoX = 120;
    private int ballpoY = 350;
    private int ballXdir = 1;
    private int ballYdir = 2;
    private int playerX = 350;

    public Gameplay() {
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new Timer(delay, this);
        timer.start();
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

    private void moveleft() {
        play = true;
        playerX -= 20;
    }

    private void moveRight() {
        play =true;
        playerX += 20;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(playerX <=0){
                playerX = 0;
            }else{
                moveleft();
            }
            // System.out.println(e.getKeyCode() + "hello ");
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            moveRight();
            if(playerX>=600){
                playerX = 600;
            }else{
                repaint();
            }
        }
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){


            ballpoX += ballpoX;
            ballpoY +=ballpoY;
        }
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
