package deque;


import deque.LinkedListDeque;

public class VengefulSLList <Item> extends LinkedListDeque<Item> {
    LinkedListDeque<Item> deletedItems;

    public void printLostItems(){
        deletedItems.printDeque();
    }

    @Override
    public Item removeLast() {
        Item last;
        last= super.removeLast();
        deletedItems.addLast(last);
        return last;
    }
}
