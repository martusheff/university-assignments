public abstract class RoundShape {
    private double radius;

    public RoundShape(double r) {
        radius = r;
    }

    public double GetRedius() {
        return radius;
    }

    public void SetRadius(double r) {
        radius = r;
    }

    public abstract double GetArea();
    public abstract double GetVolume();
}
