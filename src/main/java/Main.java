//Michał Zadrożny AAL Projekt 14 Archipelag

import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) {

        int n = 2, m = 2, step = 5, k = 30, r = 10;
        double p = 0.5;
        String algorithm = "bfs";
        Matrix mat = new Matrix(n,m,p);
        for(int i = 0; i < 10000; i++){
        mat = new Matrix(n,m,p);
        long star = System.nanoTime();
        mat.findBiggestIslandDFS();
        long en = System.nanoTime();}
        if(args.length == 0) {
            System.out.println("Invalid arguments. Usage: ");
            System.out.println("mode: \n\t-m1 for standard input, \n\t-m2 for randomly generated instances,\n\t-m3 for test with time measure");
            System.out.println("You can specify algorithm you want to use (BFS by default)");
            System.out.println("\t-alg bfs    or   -alg dfs");
            System.out.println("For m2 and m3 specify\n the matrix size ");
            System.out.println("\t-n numberOfRows -m numberOfCollums");
            System.out.println(" probability for 1 in matrix");
            System.out.println("\t-p probability");
            System.out.println("Example: -m2 -n 10 -m 10 -p 0.25");
            System.out.println("For m3 specify\n step (value that n and m will be increased by)");
            System.out.println("\t-step value");
            System.out.println(" number of iterations");
            System.out.println("\t-k value");
            System.out.println(" number of problem instances for each iteration");
            System.out.println("\t-r value");
            System.out.println("Example: -m3 -n 10 -m 10 -p 0.25 -k 30 -step 5 -r 10");
            System.exit(0);
        }

        for (int i = 1; i < args.length; i++) {
            if (args[i].equals("-n"))
                n = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-m"))
                m = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-p"))
                p = Double.parseDouble(args[i + 1]);
            if (args[i].equals("-step"))
                step = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-k"))
                k = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-r"))
                r = Integer.parseInt(args[i + 1]);
            if (args[i].equals("-alg"))
                algorithm = args[i + 1];
        }
        if (args[0].equals("-m1")) {
            mat = new Matrix();
            if(algorithm.equals("bfs"))
                mat.findBiggestIslandBFS();
            else
                mat.findBiggestIslandDFS();
        }

        if (args[0].equals("-m2")) {
            mat = new Matrix(n, m, p);
            if(algorithm.equals("bfs"))
                mat.findBiggestIslandBFS();
            else
                mat.findBiggestIslandDFS();
        }
        if (args[0].equals("-m3")) {
            long[] times = new long[k];
            double[] q = new double[k];

            for (int i = 0; i < k; i++) {
                long currTime = 0;
                for (int j = 0; j < r; j++) {
                    mat = new Matrix(n + step * i, m + step * i, p);
                    long start = System.nanoTime();
                    if(algorithm.equals("bfs"))
                        mat.findBiggestIslandBFS();
                    else
                        mat.findBiggestIslandDFS();
                    long end = System.nanoTime();
                    currTime += end - start;
                    mat.printMatrix();
                    System.out.println(mat.getMaxIslandSize());
                    System.out.println("time = " + /*TimeUnit.NANOSECONDS.toMillis*/(end - start));
                }
                times[i] = currTime / r;
                System.out.println("times[" + i + "] = " + times[i]);
            }

            for (int i = 0; i < k; i++) {
                q[i] = (double) (times[i] * (n + step * (k / 2)) * (n + step * (k / 2))) / ((n + step * i) * (n + step * i) * times[k / 2]);
                System.out.println("n = " + (n + step * i) + " m = " + (m + step * i) + " time = " + times[i] + " q = " + q[i]);
            }

        }


    }


        //mat.printMatrix();
        //System.out.println(mat.getMaxIslandSize());

       //
       // System.out.println((end - start) + "ms");
    }

