public class H1_65 {
    private int mX;
    private static int mY = 0;
    private static final int A = 100;
    public static final int B = 200;

    public int getX(){
        return mX;
    }

    public void setX(int x){
        mX = x;
    }

    public int getY(){
        return mY;
    }

    public void setY(int y){
        mY = y;
    }

    public H1_65(int pX){
        setX(pX);
    }

    public H1_65(){
        this(-1);
    }
}
