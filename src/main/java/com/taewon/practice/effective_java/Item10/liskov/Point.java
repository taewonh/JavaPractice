package com.taewon.practice.effective_java.Item10.liskov;

import java.util.Set;

public class Point {

    private final int x;
    private final int y;

    private static final Set<Point> unitCircle = Set.of(
            new Point(1, 0),
            new Point(0, 1),
            new Point(-1, 1),
            new Point(0, -1)
    );

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public static boolean onUnitCircle(Point p) {
        return unitCircle.contains(p);
    }

    @Override
    public boolean equals(Object o) {
        if(o == null || o.getClass() != this.getClass()) {
            return false;
        }
        Point p = (Point) o;
        return this.x == p.x && this.y == p.y;
    }

}
