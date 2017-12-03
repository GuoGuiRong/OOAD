package Iterator;

/**
 * Created by GuiRunning on 2017/11/29.
 */
public class MyCollection implements Collection {

    private int[] strings={1,6,8,9,5,3,2,7};

    @Override
    public Iterator iterator() {
        return new MyInterator(this);
    }

    @Override
    public Object get(int i) {
        if(i<0){
            i=0;
        }
        return this.strings[i];
    }

    @Override
    public int size() {
        return this.strings.length;
    }
}
