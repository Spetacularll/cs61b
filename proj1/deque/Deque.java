package deque;

public class Deque<Item> {
    private class item{
        Item data;
        item pre;
        item next;
    }
    private item sentinel;
    private int size;
    public Deque(){
    sentinel= new item();
    size=0;
    this.sentinel.next=this.sentinel;
    this.sentinel.pre=this.sentinel;
    this.sentinel.data=null;

    }

    public int size() {
        return size;
    }
    public void addFirst(Item x){
    item temp= new item() ;
    temp.data=x;
    sentinel.next.pre=temp;
    temp.next=sentinel.next;
    temp.pre=sentinel;
    sentinel.next=temp;
    size+=1;
    }
    public void addLast(Item x){
        item temp=new item();
        temp.data=x;

        temp.next=sentinel;
        temp.pre=sentinel.pre;
        sentinel.pre.next=temp;
        sentinel.pre=temp;
        size+=1;
    }
    public boolean isEmpty(){
    if(sentinel.next==sentinel.pre){
        if(sentinel.next==sentinel){
        return true;
        }

    }
    return false;
    }
    public void printDeque(){
    item p;
    p=sentinel.next;
    while (p!=sentinel){
        System.out.print(p.data+" ");
        p=p.next;
    }
    System.out.println();
    }
    public  Item removeFirst(){
    if(!this.isEmpty()){
     Item temp=sentinel.next.data;
    sentinel.next=sentinel.next.next;
    sentinel.next.next.pre=sentinel;
    size-=1;
    return temp;

    }
    return null;
   }
    public Item removeLast(){
    if(!this.isEmpty()){
    Item temp=sentinel.pre.data;
    sentinel.pre.pre.next=sentinel;
    sentinel.pre=sentinel.pre.pre;
    size-=1;
    return temp;

    }
    return null;
   }
    public Item get(int index){
    item p=sentinel.next;
    int count=0;
    while(count<index&&p!=sentinel){
        p=p.next;
        count++;
    }
    if(p==sentinel){
        return null;
    }
    return p.data;
    }

}
