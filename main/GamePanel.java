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
    private BufferedImage img,subImg;

    private int frameRate = 0;
    private long lastCheck  = 0;
    private BufferedImage[] idleAni;
    public GamePanel() {
        mouseInputs = new MouseInputs(this);
        addKeyListener(new KeyboardInputs(this));
        addMouseListener(mouseInputs);
        addMouseMotionListener(mouseInputs);

        importImg();

    }
//    private void loadAnimations(){
//        idleAni = new BufferedImage[4];
//
//        for(int i=0; i<idleAni.length; i++)
//            idleAni[i] = img.getSubimage(1*20, 80,264 ,80);
//
//    }

    private void importImg() {
        InputStream inputStream = getClass().getResourceAsStream("/Idle-Sheet.png");

        try {
            img = ImageIO.read(inputStream);
        } catch (IOException e) {
              throw new RuntimeException(e);
        }finally {
            try {
                inputStream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

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


    public void paintComponent(Graphics g) {
        super.paintComponent(g);
//        g.drawImage(img.getSubimage(0,0, 256, 80), 0,0, null);
      subImg = img.getSubimage(3*20, 0*80, 60, 80 );
      g.drawImage(subImg, (int)xDelta,(int) yDelta,120, 160, null);

//        g.drawImage(idleAni[2],(int)xDelta,(int) yDelta,120, 160, null);


    }

}
