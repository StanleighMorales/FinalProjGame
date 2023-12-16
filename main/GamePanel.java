package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.swing.JPanel;
import java.awt.*;
import java.awt.color.*;
import java.util.Random;

public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDir = 0.1f, yDir = 0.1f;
    private float xDelta = 100, yDelta = 100;

    private int frameRate = 0;
    private long lastCheck  = 0;
    private Color color = new Color(20,30,40);
    private Random random;
    public GamePanel() {
        random = new Random();
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

    }

    public void changeXDelta (int value){
        this.xDelta += value;
        repaint();
    }
    public void changeYDelta (int value){
        this.yDelta += value;
        repaint();
    }

    public void setRecPos(int x, int y){
        this.xDelta = x;
        this.yDelta = y;
        repaint();
    }


    public void paintComponent(Graphics g){
     super.paintComponent(g);

     updateRec();
     g.setColor(color);
     g.fillRect((int)xDelta, (int)yDelta, 200, 50);



    }

    private void updateRec() {
        xDelta += xDir;
        if(xDelta > 400 || xDelta < 0) {
            xDir *= -1;
            color = getRndColor();
        }

        yDelta += yDir;
        if(yDelta > 400 || yDelta <0) {
            yDir *= -1;
            color = getRndColor();
        }
    }

    private Color getRndColor() {
        int r = random.nextInt(255);
        int b = random.nextInt(255);;
        int g = random.nextInt(255);;
        return new Color(r,b,g);
    }

}
