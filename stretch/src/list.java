public class list {
    public int first;
    public list rest;

    list(int x,list p){
        first=x;
        rest=p;
    }
    public int iterativesize(){
        list p=this;
        int count =1;
        if(p!=null){
            p=p.rest;
            count+=1;
        }
        return count;
    }
    public int size(){
        if(rest!=null){
           return 1+this.rest.size();
        }
        return 1;
    }

}
