package inputs;

import main.GamePanel;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardInputs implements KeyListener {
    private GamePanel gamePanel;
    public KeyboardInputs(GamePanel gamePanel){
        this.gamePanel = gamePanel;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_W:
                System.out.println("W is pressed");
                gamePanel.changeYDelta(-5);

            break;
            case KeyEvent.VK_A:
                System.out.println("A is pressed");
                gamePanel.changeXDelta(-5);
            break;
            case KeyEvent.VK_S:
                System.out.println("S is pressed");
                gamePanel.changeYDelta(5);
            break;
            case KeyEvent.VK_D:
                System.out.println("D is pressed");
                gamePanel.changeXDelta(5);
            break;
        }
    }
}
