package effective_java.Item10.symmetry;

import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof ColorPoint)) return false;
        return super.equals(o) && this.color == ((ColorPoint)o).color;
    }
}
