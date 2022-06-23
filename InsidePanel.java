import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class InsidePanel extends JPanel {
    private boolean right = true;
    private boolean left = false;
    private boolean up = false;
    private boolean down = false;

    private int moves = 0;

    private ImageIcon rightmove = new ImageIcon(getClass().getResource("New.png"));
    
    public InsidePanel(){

    }
    
    @Override

    public void paint(Graphics g) {
        super.paint(g);
        g.drawRect(10, 10, 660, 40);
        g.drawString("Score :",550, 25);
        g.drawString("Snake Game ", 30, 30);
        g.drawString("Length :", 550, 45);

        g.drawRect(10, 60, 660, 390);

        if(moves == 0){
            

        }
    }



}
