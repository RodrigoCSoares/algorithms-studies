package com.algorithms_studies.union_find;

/**
 * The  downside of Quick Union is that trees can get too tall
 * and the find method is too expensive (could be N array accesses)
 */
public class QuickUnion {
    private int[] id;

    /**
     * Set the id of each object
     * @param N number of objects at the list
     */
    public QuickUnion (int N) {
        id = new int[N];
        for (int i = 0; i < N; i++) {
            id[i] = i;
        }
    }

    /**
     * Get the root of an object
     * @param i id of the object
     * @return root
     */
    private int getRoot (int i) {
        while (i != id[i]) {
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
    public boolean isConnected (int p, int q) {
        return getRoot(p) == getRoot(q);
    }

    /**
     * Unite two objects
     * @param p first object
     * @param q second object
     */
    public void union (int p, int q) {
        int i = getRoot(p);
        int j = getRoot(q);
        id[i] = j;
    }
}
