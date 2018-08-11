package edu.coursera.algorithms;

public class QuickFind {

    private static final int[] id = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            id[i] = i;
        }

        QuickFind quickFind = new QuickFind();
        quickFind.union(0, 5);
        quickFind.union(5, 6);
        quickFind.union(6, 1);
        quickFind.union(1, 2);
        quickFind.union(2, 7);

        quickFind.union(3, 8);
        quickFind.union(4, 3);
        quickFind.union(9, 4);

        for (int i = 0; i < 10; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
        System.out.println(quickFind.find(7, 1));
        System.out.println(quickFind.find(0, 4));
        System.out.println(quickFind.find(0, 3));


    }

    public boolean find(int p, int q) {
        return id[p] == id[q];
    }

    public void union(int p, int q) {
        int pid = id[p];
        for (int i = 0; i < 10; i++) {
            if (id[i] == pid) {
                id[i] = id[q];
            }
        }
    }
}
