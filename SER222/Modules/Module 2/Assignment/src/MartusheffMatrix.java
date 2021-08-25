/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 *
 * @author Andronick Martusheff, Ruben Acuna
 * @version v8.25.2021
 */

public class MartusheffMatrix implements Matrix {

    private int[][] matrix;
    private int rows = 0;
    private int cols = 0;

    private MartusheffMatrix(int[][] data) {
        if (data.length == 0) {
            rows = 0;
            cols = 0;
        } else {
            rows = data.length;
            cols = data[0].length;
        }

        matrix = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix[i][j] = data[i][j];
            }
        }
    }


    //TODO: implement interface.

    @Override
    public int getElement(int y, int x) {
        return matrix[y][x];
    }

    @Override
    public int getRows() {
        if (matrix.length == 0)
            return 0;

        int counter = 0;
        for (int i = 0; i < matrix.length; i++)
            counter++;
        return counter;
    }


    @Override
    public int getColumns() {
        if (matrix.length == 0)
            return 0;

        int counter = 0;

        for (int i = 0; i < matrix[0].length; i++)
            counter++;

        return counter;
    }

    @Override
    public Matrix scale(int scalar) {

        int[][] data = new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = this.getElement(i, j) * scalar;
            }
        }
        return new MartusheffMatrix(data);

    }

    @Override
    public Matrix plus(Matrix other) {

        int[][] data = new int[rows][cols];

        if ((cols == other.getColumns()) && (rows == other.getRows())) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = this.getElement(j, i) + other.getElement(j, i);
                }
            }
        } else {
            return null;
        }

        return new MartusheffMatrix(data);

    }

    @Override
    public Matrix minus(Matrix other) {

        int[][] data = new int[rows][cols];

        if ((cols == other.getColumns()) && (rows == other.getRows())) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = this.getElement(i, j) - other.getElement(i, j);
                }
            }
        } else {
            return null;
        }

        return new MartusheffMatrix(data);

    }

    @Override
    public Matrix multiply(Matrix other) {

        int[][] data = new int[rows][cols];

        if ((cols == other.getColumns()) && (rows == other.getRows())) {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    data[i][j] = this.getElement(j, i) * other.getElement(j, i);
                }
            }
        } else {
            return null;
        }

        return new MartusheffMatrix(data);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;

        if ((cols == ((MartusheffMatrix) o).getColumns()) && (rows == ((MartusheffMatrix) o).getRows())) {
            for (int i = 0; i < this.getRows(); i++) {
                for (int j = 0; j < this.getColumns(); j++) {
                    if (this.getElement(i, j) != ((MartusheffMatrix) o).getElement(i, j))
                        return false;
                }
            }
        } else {
            return false;
        }

        return true;
    }

    @Override
    public String toString() {
        String matrix = "";
        int rows = this.getRows();
        int cols = this.getColumns();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                matrix += this.getElement(i, j) + " ";
            }
            matrix += "\n";
        }
        return matrix;
    }

    /**
     * Entry point for matrix testing.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[][] data1 = new int[0][0];
        int[][] data2 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] data3 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};
        int[][] data4 = {{1, 4, 7}, {2, 5, 8}, {3, 6, 9}};

        Matrix m1 = new MartusheffMatrix(data1);
        Matrix m2 = new MartusheffMatrix(data2);
        Matrix m3 = new MartusheffMatrix(data3);
        Matrix m4 = new MartusheffMatrix(data4);

        System.out.println("m1 --> Rows: " + m1.getRows() + " Columns: " + m1.getColumns());
        System.out.println("m2 --> Rows: " + m2.getRows() + " Columns: " + m2.getColumns());
        System.out.println("m3 --> Rows: " + m3.getRows() + " Columns: " + m3.getColumns());

        System.out.println();

        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 10;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true

        System.out.println();

        //test operations (valid)
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));

        //not tested... multiply(). you know what to do.
        System.out.println("m2 * m3:\n" + m2.multiply(m3));

        //test operations (invalid)
        System.out.println("m1 + m2\n" + m1.plus(m2));
        System.out.println("m1 - m2\n" + m1.minus(m2));
    }


}