package com.algorithms_studies.union_find;

/**
 * This is the improvement of the Quick-Union algorithm. Now the algorithm try to avoid tall trees
 * connecting the smaller tree to the tallest tree when performing union operation. This approach
 * improve the array access of union-find to lg* N and the connection-find to 1.
 */
public class QuickUnionWeightedWithPathCompression {
    private int[] id;
    private int[] iz;

    /**
     * Set the id of the objects
     * @param n number of objects
     */
    public QuickUnionWeightedWithPathCompression(int n) {
        id = new int[n];
        iz = new int[n];
        for(int i = 0; i < id.length; i++) {
            iz[i] = i;
            id[i] = i;
        }
    }

    /**
     * Get the getRoot of an object
     * @param i id of the object
     * @return getRoot
     */
    private int getRoot(int i) {
        while(i != id[i]) {
            id[i] = id[id[i]];
            i = id[i];
        }
        return i;
    }

    /**
     * Checks if two objects are connected
     * @param p first object
     * @param q second object
     * @return true if is connected and false if it is not
     */
    public boolean isConnected(int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /**
     * Unite two objects
     * @param p first object
     * @param q second object
     */
    public void union(int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);

        if(iz[i] < iz[j]) {
            id[i] = j;
            iz[j] += iz[i];
        } else {
            id[j] = i;
            iz[i] += iz[j];
        }
    }
}