package com.jrmcduffie.WhiteElephant;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by bobber on 12/27/2015.
 */
public class Item implements Comparable<Item> {
    String name;
    int rank;
    int numberOfTimesStolen;
    boolean wasJustStolen;

    public Item(String name, int rank) {
        this.name = name;
        this.rank = rank;
        numberOfTimesStolen = 0;
    }

    public void steal(ArrayList itemList) {
        numberOfTimesStolen++;
        wasJustStolen = true;
        if (numberOfTimesStolen >= 3) {
            itemList.remove(this);
        }
    }

    public String toString() {
        return name;
    }

    public int compareTo(Item other) {
        if (wasJustStolen) {
            return -1;
        }
        if (rank > other.rank) {
            return 1;
        } else if (rank < other.rank) {
            return -1;
        } else {
            return 0;
        }
    }
}
