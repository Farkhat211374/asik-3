package com.company;
import java.util.Hashtable;

public class MyHashTable <K,V>{
    //inner class
private class HashNode<K,V>{
    private K key;
    private V value;
    private HashNode<K,V> next;

    public HashNode(K key, V value){
        this.key = key;
        this.value = value;
    }

    @Override
    public String toString(){
        return "{" + key + " " + value + "}";
    }
}

private HashNode<K,V>[] chainArray;
private int M = 18;
private int size;

public MyHashTable(){
    chainArray = new HashNode[M];
}

public MyHashTable(int userCapacity){
    this.M = userCapacity;
    chainArray = new HashNode[M];
}


}
