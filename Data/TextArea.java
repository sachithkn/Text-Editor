package Data;

import java.util.ArrayList;

public class TextArea {

    private ArrayList<StringBuilder> lines;

    public TextArea(){
        lines = new ArrayList<>();
        addLine();
    }
    
    public void addText(String newText,int line) {
        lines.get(line).append(newText);
    }
    
    public void addLine() {
        lines.add(new StringBuilder());
    }
    
    public void deleteText(int length,int line) {
        StringBuilder text  = lines.get(line);
        if (length > 0 && length <= text.length()) {
            text.delete(text.length() - length, text.length());
        }
    }

    public String getText(int line) {
        return lines.get(line).toString();
    }
    
    public ArrayList<StringBuilder> getLines() {
        return lines;
    }

    public void clear(int line) {
        lines.get(line).setLength(0);
    }
}