package main;

import inputs.KeyboardInputs;
import inputs.MouseInputs;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;


public class GamePanel extends JPanel {
    private MouseInputs mouseInputs;
    private float xDelta = 100, yDelta = 100;
    private BufferedImage img;

    private int frameRate = 0;
    private long lastCheck  = 0;

    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);
        importImg();

    }

    private void importImg() {
        InputStream is = getClass().getResourceAsStream("/MC.jpeg");



    }

    private void setPanelSize(){
        Dimension size = new Dimension(1280, 800);
        setMinimumSize(size);
        setPreferredSize(size);
        setMaximumSize(size);
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

//    g.drawImage(null, x, y, null);

    }

}
