package com.company;
import java.util.ArrayList;

public class Vertex <T> {
    private Vertex node;
    int index;
    ArrayList<Vertex> adjacent;

    public void setNode(Vertex node){
        this.node=node;
    }

    public Vertex getNode(){
        return node;
    }

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

    public int size(){
        return adjacent.size();
    }
}
