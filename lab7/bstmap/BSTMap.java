package bstmap;

import edu.princeton.cs.algs4.BST;

import java.util.Iterator;
import java.util.Set;

public class BSTMap<K extends Comparable<K>,V> implements Map61B<K,V>{
    public class BSTNode{
        K key;
        V value;
        BSTNode left;
        BSTNode right;
        public BSTNode(K key,V value){
            this.key = key ;this.value = value;
            left = null;
            right = null;
        }
    }
    BSTNode bstNode;

    @Override
    public void clear() {
        bstNode = null ;
    }

    private boolean containsKey(K key,BSTNode Node){
        if(Node ==null){
            return false;
        }
        if(key.compareTo(Node.key)==0){
            return true;
        }
        if(key.compareTo(Node.key)<0){
            return containsKey(key,Node.left);
        }
        else return containsKey(key,Node.right);
    }
    @Override
    public boolean containsKey(K key) {
       return containsKey(key,bstNode);
    }

    private V get(K key , BSTNode Node){
        if(Node==null){
            return null;
        }
        if(key.compareTo(Node.key)==0){
            return Node.value;
        }
        else {
            if(key.compareTo(Node.key)<0){
                return get(key,Node.left);
            }
            return get(key,Node.right);
        }
    }
    @Override
    public V get(K key) {
        return get(key,bstNode);
    }

    private int size(BSTNode Node){
        if(Node ==null){
            return 0;
        }
        else return 1+ size(Node.left) + size(Node.right);
    }
    @Override
    public int size() {
        return size(bstNode);
    }

    private BSTNode put(K key ,V value,BSTNode x){
        if(x ==null){
            return new BSTNode(key,value);
        }
        int cmp = key.compareTo(x.key);
        if      (cmp < 0) x.left  = put(key,value,x.left);
        else if (cmp > 0) x.right = put(key,value,x.right);
        else              x.value   = value;
        return x;
    }
    @Override
    public void put(K key, V value) {
       bstNode = put(key,value,bstNode);
    }
    public void printInOrder(BSTNode Node){
        if(Node!=null){
        printInOrder(Node.left);
        System.out.println(Node.key + " maps to :" +Node.value );
        printInOrder(Node.right);
    }
    }
    @Override
    public Set<K> keySet() {
        return null;
    }

    @Override
    public V remove(K key, V value) {
        return null;
    }

    @Override
    public V remove(K key) {
        return null;
    }


    @Override
    public Iterator<K> iterator() {
        return null;
    }
}
