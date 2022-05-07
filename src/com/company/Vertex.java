package com.company;
import java.util.ArrayList;

public class Vertex <T> {

    int index;
    ArrayList<Vertex> adjacent;

    public Vertex(int index) {
        adjacent = new ArrayList<>();
        this.index = index;
    }

    public boolean hasAdjacrent(){
        if(adjacent.size()==0)return false;
        return true;
    }

    public void put(Vertex vertex){
        adjacent.add(vertex);
    }
}
