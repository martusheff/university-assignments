/**
 * An implementation of the Matrix ADT. Provides four basic operations over an
 * immutable type.
 * 
 * @author (your name), Ruben Acuna
 * @version (version)
 */
public class MartusheffMatrix implements Matrix {

    private int[][] data;

    private MartusheffMatrix(int[][] data) {
        this.data = data;
    }


    //TODO: implement interface.

    @Override
    public int getElement(int y, int x) {
        return data[y][x];
    }

    @Override
    public int getRows() {
        if (data.length == 0)
            return 0;

        int counter = 0;
        for (int i = 0; i < data.length; i++)
            counter++;
        return counter;
    }


    @Override
    public int getColumns() {
        if (data.length == 0)
            return 0;

        int counter = 0;

        for (int i = 0; i < data[0].length; i++)
            counter++;

        return counter;
    }

    @Override
    public Matrix scale(int scalar) {

        int rows = this.getRows();
        int cols = this.getColumns();
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
        int rows = this.getRows();
        int cols = this.getColumns();
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
        int rows = this.getRows();
        int cols = this.getColumns();
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

        Matrix minus = new MartusheffMatrix(data);
        return minus;
    }

    @Override
    public Matrix multiply(Matrix other) {
        int rows = this.getRows();
        int cols = this.getColumns();
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

        boolean flag;
        int rows = this.getRows();
        int cols = this.getColumns();
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
        
        //check for reference issues
        System.out.println("m2 -->\n" + m2);
        data2[1][1] = 101;
        System.out.println("m2 -->\n" + m2);

        //test equals
        System.out.println("m2==null: " + m2.equals(null));             //false
        System.out.println("m3==\"MATRIX\": " + m2.equals("MATRIX"));   //false
        System.out.println("m2==m1: " + m2.equals(m1));                 //false
        System.out.println("m2==m2: " + m2.equals(m2));                 //true
        System.out.println("m2==m3: " + m2.equals(m3));                 //false
        System.out.println("m3==m4: " + m3.equals(m4));                 //true
        
        //test operations (valid)
        System.out.println("2 * m2:\n" + m2.scale(2));
        System.out.println("m2 + m3:\n" + m2.plus(m3));
        System.out.println("m2 - m3:\n" + m2.minus(m3));
        
        //not tested... multiply(). you know what to do.
        
        //test operations (invalid)
        //System.out.println("m1 + m2" + m1.plus(m2));
        //System.out.println("m1 - m2" + m1.minus(m2));
    }




}