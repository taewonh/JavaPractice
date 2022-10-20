package effective_java.Item10.liskov;

import java.awt.*;

public class ColorPoint extends Point {
    private final Color color;

    public ColorPoint(int x, int y, Color color) {
        super(x, y);
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) return false;

        //o가 Point이면 색상을 제외하고 x,y 정보만 비교한다.
        if(!(o instanceof ColorPoint)) return o.equals(this);

        //o가 ColorPoint이므로 색상, x, y 모두를 비교한다.
        return super.equals(o) && this.color == ((ColorPoint)o).color;
    }
}