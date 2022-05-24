package com.company;
import java.util.ArrayList;


public class Vertex <T> {

    int index;
    ArrayList<Vertex> adjacent;

    public Vertex(int index) {
        adjacent = new ArrayList<>();
        this.index = index;
    }
}
