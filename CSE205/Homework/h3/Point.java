// CLASS: Point (Source Code File: Point.java)
// AUTHOR: Brennon Francis, bqfranci, bqfranci@asu.edu
// AUTHOR: Andronick Martusheff, aamartus, aamartus@asu.edu


public class Point implements Comparable<Point> {
    private double x;
    private double y;

    public Point(double initX, double initY) {
        setX(initX);
        setY(initY);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x){
        this.x = x;
    }

    public void setY(double y){
        this.y = y;
    }

    @Override
    public int compareTo(Point o) {
        double d1 = Math.sqrt(x * x + y * y);
        double d2 = Math.sqrt(o.x * o.x + o.y * o.y);
        return Double.compare(d1,d2);
    }
}
