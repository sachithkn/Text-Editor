package UI;

import java.awt.Graphics;
import java.util.Timer;
import java.util.TimerTask;
import javax.swing.JPanel;

public class Cursor {
    private int cursorX = 5;
    private int cursorY = 5;
    private int cursorHeight = 10;
    private boolean isVisible;
    private Timer timer;
    private long blinkRate = 500; 

    public Cursor(JPanel jPanel) {
        this.isVisible = true; // Cursor is visible by default
        timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                isVisible = !isVisible;
                jPanel.repaint();
            }            
        }, blinkRate,blinkRate);
    }

    public void setCursorHeight(int cursorHeight){
        this.cursorHeight = cursorHeight - 5;
    }

    public void setCursorPosition(int x, int y) {
        this.cursorX = x;
        this.cursorY = y;
    }
    
    public void paint(Graphics g) {
        if(isVisible){
            g.drawLine(cursorX, cursorY, cursorX, cursorY+cursorHeight);
        }
    }

}