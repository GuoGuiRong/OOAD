package Iterator;

/**
 * Created by GuiRunning on 2017/11/29.
 */
public class MyInterator implements Iterator {

    private Collection collection;
    private int pos=-1;

    public MyInterator(Collection collection){
        this.collection = collection;
    }

    @Override
    public Object previous() {
        if(this.pos<0){
            pos = 0;
        }else{
            pos--;
        }
        return this.collection.get(pos);
    }

    @Override
    public Object next() {
        if(this.pos>this.collection.size()-1){
            pos = this.collection.size()-1;
            return this.collection.get(pos);
        }else{
            pos++;
        }
        return this.collection.get(pos);
    }

    @Override
    public boolean hasNext() {
        if(this.pos>=this.collection.size()-1){
            return false;
        }
        return true;
    }

    @Override
    public Object first() {
        this.pos=0;
        return this.collection.get(pos);
    }
}
