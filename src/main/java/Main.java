public class Main {

    public static void main(String[] args) {
        Matrix m = new Matrix(6,8);
        m.printMatrix();
        //long start = System.currentTimeMillis();
        System.out.println(m.findBiggestIslandBFS());
       // long end = System.currentTimeMillis();
       // System.out.println((end - start) + "ms");
    }
}
