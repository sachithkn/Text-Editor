package UI;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import utils.Constants;

public class TextArea{
    public Data.TextArea textArea;
    int x;
    int y;
    FontMetrics fm;
    Cursor cursor;

    public TextArea(Data.TextArea textArea,Cursor cursor){
        this.textArea = textArea;
        this.cursor = cursor;
    }

    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void keyPressed(KeyEvent e) {
        String text = e.getKeyChar()+"";
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            textArea.deleteText(1,y);  // Delete 1 character from end
        }else if(e.getKeyCode() == KeyEvent.VK_ENTER){
            textArea.addLine();  // Delete 1 character from end
            y++;
        }else if(e.getKeyChar() >= 32 && e.getKeyChar() <= 126){
            textArea.addText(text,y);
        }
        text = textArea.getText(y);

        cursor.setCursorHeight(getHeight());
        cursor.setCursorPosition(getWidth()+Constants.CELL_WIDTH+2, (getHeight()*y)+5);
    }

    
    public Integer getWidth(){
        String lineText = textArea.getText(y);
        if(fm == null)
            return 0;
        return fm.stringWidth(lineText.substring(0, textArea.getText(y).length()));
    }

    
    public Integer getHeight(){
        if(fm == null)
            return 0;
        return fm.getHeight();
    }

    public void paint(Graphics g) {
        //g.setFont(new Font("Arial", Font.PLAIN, 22)); 
        for(int i=0;i<textArea.getLines().size();i++){
            g.setFont(new Font("Monospaced", Font.PLAIN, 16));
            g.drawString(textArea.getText(i).toString(),Constants.CELL_WIDTH,(i+1)*getHeight());
        }
        if(fm == null){
            Font font = g.getFont();
            fm = g.getFontMetrics(font);
        }
    }

}
