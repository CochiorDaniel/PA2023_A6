import java.awt.*;
import java.io.Serializable;

public class Linie implements Serializable {
    private int x1, y1, x2, y2;
    private Color c;

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    public int getX2() {
        return x2;
    }

    public void setX2(int x2) {
        this.x2 = x2;
    }

    public int getY2() {
        return y2;
    }

    public void setY2(int y2) {
        this.y2 = y2;
    }

    public Color getC() {
        return c;
    }

    public void setC(Color c) {
        this.c = c;
    }

    @Override
    public boolean equals(Object obj) {
        Linie l = (Linie) obj;
        if(l.x1==x1 && l.x2==x2 && l.y1==y1 && l.y2==y2 && l.c.equals(c))
            return true;
        else
            return false;
    }
}
