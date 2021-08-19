public class Cone extends RoundShape {

    private double height;

    public Cone(double r, double h) {
        super(r);
        height = h;
    }

    public double GetHeight() {
        return height;
    }

    public void SetHeight(double h) {
        height = h;
    }

    public double GetArea() {
        return Math.PI * GetRedius() * GetRedius();
    }

    public double GetVolume() {
        return Math.PI * Math.pow(GetRedius(), 2);
    }

    String ToString() {
        return "A cone of radius " + GetRedius();
    }
}
