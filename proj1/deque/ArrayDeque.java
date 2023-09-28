package deque;

public class ArrayDeque<T>{
    T[] core;
    int size;
    int nextfirst;
    int nextlast;

    public ArrayDeque(){
        core=(T[]) new Object[8];
        size=0;
        nextfirst=3;
        nextlast=nextfirst+1;
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        if(size==0){
            return true;
        }
        return false;
    }
    public void resize(){
        T[] temp = (T[]) new Object[size*2];
        for(int i=0;i<size;i++){
            temp[i] = core[i];
        }

    }
    public void addFirst(T x){
        if(nextlast==nextfirst){
            resize();
        }
        core[nextfirst]=x;
        size++;
        nextfirst=(nextfirst+7)%7;
    }

    public void addLast(T x){
        if(nextlast==nextfirst){
            resize();
        }
        core[nextlast]=x;
        size++;
        nextlast=(nextlast+1)%7;
    }


}
