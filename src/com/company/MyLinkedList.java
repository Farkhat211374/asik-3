package com.company;

import static java.lang.System.*;

public class MyLinkedList<T extends Comparable<T>> implements MyList<T>{
    private static class MyNode<T>{
        T data;
        MyNode<T> next, prev;

        MyNode(T data) {
            this.data = data;
        }
    }

    private int length = 0;
    private MyNode<T> head, tail;
    public MyLinkedList() {}

    @Override
    public void add(T item) {
        MyNode<T> newNode = new MyNode<>(item);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    @Override
    public void add(T item, int index) {
        if(index < 0 || index > size()){
            throw new IndexOutOfBoundsException("YOUAREFOOL");
        }else{
            MyNode<T> temp = new MyNode<>(item);
            if(index==0){
                head.prev = temp;
                temp.next = head;
                head =temp;
                head.prev = null;

            }else if(index==length){
                tail.next = temp;
                tail = temp;
                tail.next = null;
            }else {
                int counter = 0;
                while (head.next != null) {
                    if (counter == index - 1) {
                        temp.next = head.next;
                        head.next = temp;
                    }
                    counter++;
                    head = head.next;
                }
                while (head.prev != null) {
                    head = head.prev;
                }
            }
            length = length + 1;
        }
    }

    @Override
    public boolean remove(T item) {
        boolean result = false;
        if(contains(item)){
            int index = indexOf(item);
            remove(index);
            result = true;
        }
        return result;
    }

    @Override
    public T remove(int index) {
        MyNode result = null;
        if(index < 0 || index >= size()){
            throw new IndexOutOfBoundsException("YOUAREFOOL");
        }else{
            if(index==0){
                result=head.next;
                head=head.next;
            } else if(index==size()-1){
                tail = tail.prev;
                tail.next = null;
                result = tail;
            } else {
                int counter = index;
                MyNode unlucky= null;
                for(MyNode i =head;i!=null;i=i.next){
                    if(index==0){
                        unlucky=i;
                    }
                    index--;
                }
                while(head.next!=null){
                    if(head.next==unlucky){
                        head.next=unlucky.next;
                        unlucky.next.prev=head;
                    }
                     head=head.next;
                }
                while(head.prev!=null){
                    head=head.prev;
                }
                result=unlucky.prev;
            }
        }
        length=length-1;

        return (T)result.data;
    }

    @Override
    public void clear() {
        head=null;
        tail=null;
        length=0;
    }

    public T get(int index) {
        if (index >= length || index < 0)
            throw new IndexOutOfBoundsException("YOUAREFOOL");

        MyNode<T> temp = head;

        while (index != 0) {
            temp = temp.next;
            index--;
        }

        return temp.data;
    }

    @Override
    public int indexOf(Object o) {
        int index = 0;
        if(contains(o)){
            for(MyNode i = head;i!=null;i=i.next){
                if(i.data==o){
                    break;
                }
                index++;
            }
        }else{
            index = -1;
        }
        return index;
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int counter = 0;
        if(contains(o)){
            for(MyNode i = head;i!=null;i=i.next){
                if(i.data==o){
                    index = counter;
                }
                counter++;
            }
        }else{
            index = -1;
        }
        return index;
    }

    @Override
    public Object sort() {
        if(length==0){
            try {
                throw new Exception("YOUFOOLEXECTION");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(length>1){
            MyNode temp = head;
            Comparable a,b;
          for (MyNode i = head;i!=null;i=i.next){
             for(MyNode j=i.next;j!=null;j=j.next){
                 a=(T)i.data;
                 b=(T)j.data;
                 if(a.compareTo(b)>0){
                     out.println(head.data);
                     temp.data = i.data;
                     i.data=j.data;
                     j.data=temp.data;
                 }
             }
          }
        }
        return (T)head;
    }
    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for(MyNode i = head; i != null; i=i.next){
            if(i.data==o){
                result = true;
                break;
            }
        }
        return result;
    }
    public void see(){
        for (MyNode i=head;i!=null;i=i.next){
            out.print(i.data + " ");
        }
    }
}
