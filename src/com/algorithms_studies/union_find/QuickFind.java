package com.algorithms_studies.union_find;

/**
 * Quick-find's downside is that the union operation is too expensive.
 * The algorithm takes N² array accesses to process an union operation.
 */
public class QuickFind {
    private int[] id;

    /**
     * Set the id of the objects
     * @param n number of objects
     */
    public QuickFind(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    /**
     * Check if two objects are connected
     * @param p first object
     * @param q second object
     * @return true if the two objects are connected
     */
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    /**
     * Unite two objects
     * @param p first object
     * @param q second object
     */
    public void union (int p, int q) {
        int pId = id[p];
        int qId = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
