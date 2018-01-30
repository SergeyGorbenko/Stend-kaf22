package com.kaf22;

import java.util.ArrayList;

public class BD {
    private static ArrayList<Table> table=new ArrayList<>(50);

    public static ArrayList<Table> getTable() {
        return table;
    }

    public static void setTable(ArrayList<Table> table) {
        BD.table = table;
    }
}
