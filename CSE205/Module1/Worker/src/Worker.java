public class Worker {
    private String name;
    private int age;
    private double wage;

    Worker(String name, int age, double wage){
        this.name = name;
        this.age = age;

    }

    public static void main(String[] args){
        Worker mc1 = new Worker("Peter", 25, 235.0);
        Worker mc2 = new Worker("Alan", 64, 434.0);
        Worker mc3 = new Worker("Emily", 36, 320.0);
        System.out.println(mc3.age + "-" + mc2.wage + "-" + mc1.name);
    }
}