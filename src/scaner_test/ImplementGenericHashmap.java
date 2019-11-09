package scaner_test;
import java.util.*;
public class ImplementGenericHashmap {

}

class MyMap<K, V> {
    class Node {
        K key;
        V val;
        Node next = null;
        private Node (K key, V val) {
            this.key = key;
            this.val = val;
        }
    }

    int size;
    int curSize;
    List<Node> [] arr;
    // Default loadFactor
    final double DEFAULT_LOAD_FACTOR = 0.75;

    public MyMap(int size) throws IllegalArgumentException {
        if (size == 0)
            throw new IllegalArgumentException();
        this.size = size;
        // creating an array of list
        this.arr = new List[this.size];
        for (int i = 0; i < size; i++) {
            arr[i] = new ArrayList<Node>();
        }
    }

    public MyMap() {
        this.size = 4;
        // creating an array of list
        this.arr = new List[this.size];
//        for (int i = 0; i < size; i++) {
//            arr[i] = new ArrayList<Node>();
//        }
    }

    // put (key, val)
    public void put(K key, V val) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int index = Math.abs(key.hashCode()) % this.size;
        List<Node> list = arr[index];
        if (list == null) {
            arr[index] = new ArrayList<>();
            arr[index].add(new Node(key, val));
            curSize++;
            double loadFactor = (1.0 * curSize) / size;

            if (loadFactor > DEFAULT_LOAD_FACTOR) {
                rehash();
            }
        } else {
            if (list.size() > 0) {
                for (Node n : list) {
                    if (n.key.equals(key)) {
                        n.val = val;
                        return;
                    }
                }
            }
            list.add(new Node(key, val));
            curSize++;
            double loadFactor = (1.0 * curSize) / size;

            if (loadFactor > DEFAULT_LOAD_FACTOR) {
                rehash();
            }
        }
    }
    private void rehash() {
        // the present array
        List<Node> [] temp = arr;
        // new array
        arr = new List[2 * size];

//        for (int i = 0; i < size; i++) {
//            arr[i] = temp[i];
//        }

        curSize = 0;
        size *= 2;

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == null) {
                continue;
            }
            for (int j = 0; j < temp[i].size(); j++) {
                Node head = temp[i].get(j);
                if (head != null) {
                    K key = head.key;
                    V val = head.val;
                    put(key, val);
                }
            }
        }
        System.out.println(size);
    }

    // get (key)
    public synchronized V get(K key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }
        int index = Math.abs(key.hashCode())%this.size;
        List<Node> list = arr[index];
        if (list == null) {
            return null;
        }
        for (Node n : list) {
            if (n.key.equals(key)) {
                return n.val;
            }
        }
        return null;
    }

    //delete method to delete a (key,value) pair from the map
    public synchronized void delete(K key) throws IllegalArgumentException{
        if (key == null)
            throw new IllegalArgumentException();
        int index = Math.abs(key.hashCode())%this.size;
        List<Node> list = arr[index];

        for(Node n : list){
            if(n.key.equals(key)){
                list.remove(n);
                return;
            }
        }
        System.out.println("Key not found");
    }
    // exist method to check if a key exists in the map or not
    public synchronized boolean exist(K key) throws IllegalArgumentException{
        if (key == null)
            throw new IllegalArgumentException();
        int index = Math.abs(key.hashCode())%this.size;
        List<Node> list = arr[index];
        if (list == null) {
            return false;
        }
        for(Node n : list){
            if(n.key.equals(key)){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) throws IllegalArgumentException {
        //check the exception thrown
        //MyMap<String,String> map = new MyMap<String,String>(0);
        MyMap<String,String> map = new MyMap<String,String>();
        map.put("dummy key","dummy value");
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> put");
////        //Test get
        System.out.println(map.get("dummy key"));
        System.out.println(map.get("non existent key"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> get");
////        //Test exist
        System.out.println(map.exist("dummy key"));
        System.out.println(map.exist("does not exist"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> exist");
////        //Test delete
        map.delete("dummy key");
        System.out.println(map.get("dummy key"));
        System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>> delete");
//
        map.put("123","dummy value 1");
        map.put("345","dummy value 2");
        map.put("456","dummy value 3");
        map.put("789", "dummy value 4");
        map.put("101112", "dummy value 1");
        map.put("101112", "dummy value 11");

        System.out.println(map.get("123"));
        System.out.println(map.get("345"));
        System.out.println(map.get("456"));
        System.out.println(map.get("789"));
        System.out.println(map.get("101112"));
    }
}
