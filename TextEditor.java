import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;

import utils.Constants;

import java.awt.BorderLayout;
import java.awt.FontMetrics;

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
        JScrollPane scroll = new JScrollPane(this);
        scroll.setBorder(null);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

        frame.setLayout(new BorderLayout());
        frame.add(scroll,BorderLayout.CENTER);
        frame.setSize(Constants.PANEL_WIDTH, Constants.PANEL_HEIGHT);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        this.requestFocusInWindow(); // Ensure the editor has focus to receive key events
    }

    @Override
    public Dimension getPreferredSize() {
        int width = this.getWidth();
        int height = this.getHeight();
        if(this.getWidth() < textArea.getWidth()){
            width = textArea.getWidth();
        }
        return new Dimension(width, height);
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
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        cursor.paint(g);
        textArea.paint(g);
    }
    
}