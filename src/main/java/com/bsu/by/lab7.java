package com.bsu.by;

import java.util.*;

public class lab7 {
    static class Maxvalue implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o1 - o2;
        }
    }
    static class Max implements Comparator<Integer> {
        @Override
        public int compare(Integer o1, Integer o2) {
            int k=o1;
            int kk=o2;
            int sumK=0;
            int sumKK=0;
            while(k>0){
                k/=10;
                sumK++;
            }
            while(kk>0){
                kk/=10;
                sumKK++;
            }
            return sumK -sumKK ;
        }
    }

    static class Main extends Thread {

        public int size;
        public int typeOfSorting;

        public Main(int size, int typeOfSorting) {
            this.size = size;
            this.typeOfSorting = typeOfSorting;
        }


        @Override
        public void run() {
            List<Integer> ar = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                ar.add((int) (Math.random()*1000));
            }
            for (int i = 0; i < size; i++) {
                System.out.println("The number in place " + i + " is " + ar.get(i));
            }
            System.out.println("The size of array is: " + size);
            Sort sort = new Sort(size, typeOfSorting);
            sort.run(ar);
        }
    }

    static class Sort extends Thread {

        public int size;
        public int typeOfSorting;

        public Sort(int size, int typeOfSorting) {
            this.size = size;
            this.typeOfSorting = typeOfSorting;
        }

        public void run(List<Integer> ar) {
            switch (typeOfSorting) {
                case 0:
                    Comparator case0 = new Maxvalue();
                    Collections.sort(ar, case0);
                    System.out.println("By increasing:\n");
                    for (int i = 0; i < size; i++) {
                        System.out.println("The number is " + ar.get(i));
                    }
                    break;
                case 1:
                    Comparator case1 = new Maxvalue();
                    Collections.sort(ar, case1);
                    System.out.println("By decreasing:\n");
                    for (int i = size-1; i>=0; i--) {
                        System.out.println("The number is " + ar.get(i));
                    }
                    break;
                case 2:
                    Comparator case2 = new Max();
                    Collections.sort(ar, case2);
                    System.out.println("By increasing:\n");
                    for (int i = 0; i < size; i++) {
                        System.out.println("The number is " + ar.get(i));
                    }
                    break;
                case 3:
                    Comparator case3 = new Max();
                    Collections.sort(ar, case3);
                    System.out.println("By decreasing:\n");
                    for (int i = size-1; i >=0; i--) {
                        System.out.println("The number is " + ar.get(i));
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println("Write the size of array\n" +
                "Sort by:\n" +
                "ascending by value-0\n" +
                "decreasing by value-1\n" +
                " increasing by number of digits-2\n" +
                " decreasing by number of digits-3\n");
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int typeOfSorting = sc.nextInt();
        Main m = new Main(size, typeOfSorting);
        m.start();

        sc.close();
    }
}
