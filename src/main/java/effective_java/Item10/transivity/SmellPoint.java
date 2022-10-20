package effective_java.Item10.transivity;

public class SmellPoint extends Point {

    private final Smell smell;

    public SmellPoint(int x, int y, Smell smell) {
        super(x, y);
        this.smell = smell;
    }

    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Point)) return false;

        //o가 일반 Point이면 색상을 무시햐고 x,y정보만 비교한다.
        if(!(o instanceof SmellPoint)) return o.equals(this);

        //o가 ColorPoint이면 색상까지 비교한다.
        return super.equals(o) && this.smell == ((SmellPoint) o).smell;
    }
}
