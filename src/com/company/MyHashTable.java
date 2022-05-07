package com.company;
import java.util.Hashtable;
import java.util.Objects;
import java.util.ArrayList;

public class MyHashTable <K,V>{

private class HashNode<K,V>{
    private K key;
    private V value;
    private HashNode<K,V> next;
    private int Hash;

    public HashNode(){
        next = null;
    }

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
    private int length;

    public MyHashTable(){
        chainArray = new HashNode[M];
        for(int i=0; i<M; i++){
            chainArray[i]=null;
        }
    }

    public MyHashTable(int userCapacity){
        this.M = userCapacity;
        chainArray = new HashNode[M];
        for(int i=0; i<M; i++){
            chainArray[i]=null;
        }
    }

    private int hash(K key){
    int resultHash = Objects.hashCode(key);
    return resultHash;
    }

    private int Index(K key){
        return hash(key)/M;
    }

    public void put(K key, V value){
        int hashCode = hash(key);
        int chainIndex = Index(key);
        HashNode<K, V> listHead = chainArray[chainIndex];

        while(listHead != null){
            if (listHead.Hash==hashCode && listHead.key.equals(key)){
                listHead.value = value;
                return;
            }
            listHead = listHead.next;
        }
        length++;
        LoadFactor();

        listHead = chainArray[chainIndex];
        HashNode<K, V> node = new HashNode<>(key, value, hashCode);
        node.next = listHead;
        chainArray[chainIndex] = node;

    }

    private void LoadFactor(){
        if((1.0)*(length/M)>0.6){
            M*=2;
            HashNode<K, V>[]  List = new HashNode[M];

            for(int i=0;i<M/2;i++){
                List[i]=chainArray[i];
            }

            chainArray = new HashNode[M];

            for(int i=0;i<M;i++){
                chainArray[i]=List[i];
            }
        }
    }

    public boolean contains(V value) {
        boolean result = false;
        for (int i = 0; i < M; i++) {
            if (chainArray[i] != null) {
                HashNode<K, V> list = chainArray[i];
                while (list != null) {
                    if (list.value.equals(value)) {
                        result = true;
                    }
                    list = list.next;
                }
            }
        }
        return result;
    }

    public V get(K key){
        int index = Index(key);
        int hashCode = hash(key);
        HashNode<K, V> list = chainArray[index];
        V defaultValue = null;

        while(list != null){
            if (list.key.equals(key) && list.Hash == hashCode){
                return list.value;
            }
            list = list.next;
        }
        return defaultValue;
    }

    public int size(){
        return length;
    }

    public V remove(K key){
        int indexOf = Index(key);
        int hashCode = hash(key);
        HashNode<K, V> list = chainArray[indexOf];
        HashNode<K, V> previous = null;

        while(list != null){
            if(list.key.equals(key) && hashCode == list.Hash){
                break;
            }else{
                previous = list;
            }
            list = list.next;
        }
        if (list == null) return null;

        if(previous != null) previous.next = list.next;
        else chainArray[indexOf] = list.next;
        length-=1;
        return list.value;
    }

}
