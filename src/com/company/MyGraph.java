package com.company;
import java.util.*;

public class MyGraph<Vertex> {
    private final boolean undirected;
    private Map<Vertex, List<Vertex>> map = new HashMap<>();

    /////////////////////////
    public MyGraph() {
        this.undirected = true;
    }

    public MyGraph(boolean undirected) {
        this.undirected = undirected;
    }
    ////////////////////////

    public void addVertex(Vertex v) {
        map.put(v, new LinkedList<>());
    }
    ////////////////////

    public boolean hasVertex(Vertex v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex source, Vertex dest) {
        if (!hasVertex(source)) return false;
        return map.get(source).contains(dest);
    }
    ////////////////////////////////

    public void addEdge(Vertex source, Vertex dest, Double weight) {
        if (!hasVertex(source))
            addVertex(source);

        if (!hasVertex(dest))
            addVertex(dest);

        if (hasEdge(source, dest)
                || source.equals(dest))
            return;

        map.get(source).add(dest);

        if (undirected)
            map.get(dest).add(source);
    }
    ///////////////////////////////

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex v : map.keySet()) {
            count += map.get(v).size();
        }

        if (undirected)
            count /= 2;

        return count;
    }

    /////////////////////////////

    public Iterable<Vertex> adjacencyList(Vertex v) {
        if (!hasVertex(v)) return null;

        return map.get(v);
    }

}