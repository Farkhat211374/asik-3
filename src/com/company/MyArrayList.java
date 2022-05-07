package com.company;

public class MyArrayList<T extends Comparable<T>> implements MyList<T> {
    private Object[] arr;
    private int length = 0;
    private int capacity = 3;

    public MyArrayList() {
        arr = new Object[capacity];
    }

    @Override
    public void add(T item) {
        if (length == capacity)
            increaseCapacity();
        arr[length++] = item;
    }

    @Override
    public void add(T item, int index) {
        if(index<0 || index>size()){
            System.out.println("throw Eception");
        }else{
            if(index>=capacity) {
                while (index > capacity) {
                    increaseCapacity();
                }
                if(arr[index]!=null){
                    for(int i=size()-1;i>index-1;i--){
                        while (i+1 >= capacity) {
                            increaseCapacity();
                        }
                        arr[i+1] = arr[i];
                    }
                    arr[index] = item;
                }else{
                    arr[index]=item;
                }
            }else{
                if(arr[index]!=null){
                    for(int i=size()-1;i>index-1;i--){
                        while (i+1 >= capacity) {
                            increaseCapacity();
                        }
                        arr[i+1] = arr[i];
                    }
                    arr[index] = item;
                }else{
                    arr[index]=item;
                }
            }
        }
    }

    @Override
    public boolean remove(T item) {
        if(contains(item)==true){
            remove(indexOf(item));
            return true;
        }else{
            return false;
        }
    }

    @Override
    public T remove(int index) {
        Object response = null;
        if(index < 0 || index >= size()){
            try {
                throw new Exception("YOUAREFOOLEXEPTION");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            response = arr[index];
            arr[index] = null;

            length = length - 1;
        }
        return (T)response;
    }

    @Override
    public void clear() {
        for(Object value : arr){
            arr = null;
        }
        capacity = 3;
        length = 0;
    }

    private void increaseCapacity() {
        capacity = 2 * capacity;
        Object[] old = arr;
        arr = new Object[capacity];

        for (int i = 0; i < old.length; i++)
            arr[i] = old[i];
    }

    public T get(int index){
        if(index<0 || index>size()){
            throw new IndexOutOfBoundsException("YOUAREFOOL");
        }else{
            return (T)arr[index];
        }
    }

    @Override
    public int indexOf(Object o){
        int index = 0;
        if(contains(o)==true){
            for(Object value : arr){
                if(value==o){
                    break;
                }
                index++;
            }
            return index;
        }else{
            return -1;
        }
    }

    @Override
    public int lastIndexOf(Object o) {
        int index = 0;
        int counter = 0;
        if(contains(o)==true) {
            for(Object value : arr){
                if(value==o){
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
    public Object sort(){
        if(length==0){
            try {
                throw new Exception("YOUFOOLEXECTION");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }else if(length>1){
            Comparable a,b;
            Object temp;
            for(int i=0;i<length-1;i++){
                for(int j=1;j<length;j++){
                    a = (T)arr[j-1];
                    b = (T)arr[j];
                    if(a.compareTo(b)>0){
                        temp = arr[j-1];
                        arr[j-1] = arr[j];
                        arr[j] = temp;
                    }
                }
            }
        }
        return arr;
    }

    public int size() {
        return length;
    }

    @Override
    public boolean contains(Object o) {
        boolean result = false;
        for(Object a : arr){
            if(a==o){
                result = true;
            }
        }
        return result;
    }
}
