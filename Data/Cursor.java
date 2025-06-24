package Data;

public class Cursor {
    private int position;

    public Cursor() {
        this.position = 0;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public void moveTo(int newPosition) {
        this.position = newPosition;
    }

    public void moveBy(int offset) {
        this.position += offset;
    }

    public void reset() {
        this.position = 0;
    }
}