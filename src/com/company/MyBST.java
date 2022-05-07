package com.company;

import javax.swing.plaf.IconUIResource;

public class MyBST<K extends Comparable<K>,V> {
    private Node root;

    private class Node {
    private K key;
    private V value;
    private Node left, right;

    public Node(K key,V value){
    this.key = key;
    this.value = value;
    left = null;
    right = null;
        }
    }

    public MyBST(){
        root = null;
    }

    public MyBST(K key,V value){
        root = new Node(key,value);
    }

    //inserting
    public void put(K key, V value){
        Node currentNode = root;
        root = put(currentNode, key, value);
    }

    private Node put(Node currentNode, K key, V value){
        if(currentNode == null){
            currentNode = new Node(key, value);
            return currentNode;
        }
        if(key.compareTo(currentNode.key)>0){
            currentNode.right = put(currentNode.right, key, value);
        }else{
            currentNode.left = put(currentNode.left, key, value);
        }
        return currentNode;
    }

    //reading
    public V get (K key){
        Node currentNode = root;
        return get(currentNode, key);
    }

    private V get (Node currentNode, K key){
        if(currentNode == null){
            return null;
        }
        if(currentNode.key.compareTo(key)==0){
            return currentNode.value;
        }
        else{
            if(currentNode.key.compareTo(key)<0){
                return get(currentNode.right, key);
            }else{
                return get(currentNode.left, key);
            }
        }
    }

    //removing

    public void delete(K key){
        Node currentNode = root;
        root = delete(currentNode, key);
    }

    private Node delete(Node currentNode, K key){
        if(currentNode == null){
            return null;
        }
        if(currentNode.key.compareTo(key)>0){
            root.left = delete(root.left, key);
        }else if(currentNode.key.compareTo(key)<0){
            root.right = delete(root.right, key);
        }else{
            if (currentNode.left == null){
                return currentNode.right;
            }
            else if (currentNode.right == null){
                return currentNode.left;
            }
            currentNode.key = minElemRight(currentNode.right, currentNode.right.key);
            currentNode.right = delete(currentNode.right, root.key);
        }
        return currentNode;
    }

    private K minElemRight (Node currentNode, K min){
        while(currentNode.left != null){
            min = currentNode.left.key;
            currentNode = currentNode.left;
        }
        return min;
    }

    //checking for contains

    public boolean contains(K key){
        Node currentNode = root;
        return contains(currentNode, key);
    }

    private boolean contains(Node currentNode, K key){
        if(currentNode == null){
            return false;
        }if (currentNode.key.compareTo(key)==0){
            return true;
        }else{
            if(currentNode.key.compareTo(key)<0){
                return contains(currentNode.right, key);
            }else{
                return contains(currentNode.left, key);
            }
        }
    }
}
