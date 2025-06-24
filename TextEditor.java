import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import utils.Constants;

public class TextEditor extends JPanel  implements KeyListener{

    Data.TextArea data;
    UI.TextArea textArea;
    UI.Cursor cursor;
    TextEditor textEditor;

    public TextEditor(){
        setFocusable(true);
        addKeyListener(this);
        init();
    }

    public static void main(String[] args) {
        new TextEditor();
    }

    public void init(){
        data = new Data.TextArea();
        cursor = new UI.Cursor(this);
        textArea = new UI.TextArea(data,cursor);
        JFrame frame = new JFrame("Simple Text Editor");
        
        this.setOpaque(true);
        this.setBackground(Color.white);
        this.setBorder(null);
        //this.setBounds(0,0,Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
        frame.add(this);

        frame.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.requestFocusInWindow(); // Ensure the editor has focus to receive key events
    }

    
    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {
        textArea.keyPressed(e);
        repaint();
  }

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void paint(Graphics g) {        
        super.paint(g);
        cursor.paint(g);
        textArea.paint(g);
    
    }
}