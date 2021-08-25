

public class Point2Dv2 {
    public static void main(String[] args) {
        Point2D point1 = new Point2D(1,1);
        Point2D point2 = new Point2D(2,2);
        Point2D point3 = new Point2D(13,2);
        Point2D point4 = new Point2D(2,34);
        Point2D point5 = new Point2D(5,323);

        Point2D[] points = {point1, point2, point3, point4, point5};

        shortDistance(points);


    }

    public static void shortDistance(Point2D[] points) {
        double distanceBound = 10.0;
        for(int i = 0; i < points.length; i++) {
            for(int j = 1 + 1; j < points.length; j++) {
                Point2D one = points[i];
                Point2D two = points[j];

                double currDistance = one.distanceTo(two);
                if(currDistance < distanceBound) {
                    double point1x = points[i].x();
                    double point1y = points[i].y();
                    double point2x = points[j].x();
                    double point2y = points[j].y();


                    System.out.println("The distance between point " +
                            "(" + point1x + ", " + point1y + ") and " +
                            "(" + point2x + ", " + point2y + ") is " + currDistance + ".");
                }


            }

        }

    }
}
