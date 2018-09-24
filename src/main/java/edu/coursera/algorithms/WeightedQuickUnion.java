package edu.coursera.algorithms;

public class WeightedQuickUnion {
    private static final int[] id = new int[10];
    private static final int[] size = new int[10];

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            id[i] = i;
            size[i] = 1;
        }

        WeightedQuickUnion quickUnion = new WeightedQuickUnion();
        quickUnion.union(0, 5);
        quickUnion.union(5, 6);
        quickUnion.union(6, 1);
        quickUnion.union(1, 2);
        quickUnion.union(2, 7);

        quickUnion.union(3, 8);
        quickUnion.union(4, 3);
        quickUnion.union(9, 4);

        for (int i = 0; i < 10; i++) {
            System.out.print(id[i] + " ");
        }
        System.out.println();
        System.out.println(quickUnion.find(7, 1));
        System.out.println(quickUnion.find(0, 4));
        System.out.println(quickUnion.find(0, 3));


    }

    private int root(int x) {
        while (id[x] != x) {
            x = id[x];
        }
        return x;
    }

    private void union(int p, int q) {
        int i = root(p);
        int j = root(q);
        if (i == j) {
            return;
        }
        if (size[i] >= size[j]) {
            id[j] = i;
            size[i] = size[i] + size[j];
        } else if (size[j] > size[i]) {
            id[i] = j;
            size[j] = size[j] + size[i];
        }

    }


    private boolean find(int p, int q) {
        return root(p) == root(q);
    }
}
