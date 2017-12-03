package Iterator;

/**
 * Created by GuiRunning on 2017/11/29.
 */
public class MyCollection1 implements Collection1 {


    private Object[] result = null;

    public MyCollection1(Object[] objects){
        this.result = objects;
    }

    @Override
    public Iterator createIterator() {
        return new MyInterator();
    }

    @Override
    public Object get(int i) {
        return result[i];
    }

    @Override
    public int size() {
        return result.length;
    }

    private class MyInterator implements  Iterator{

        private int size;//聚集对象的大小

        private int  index;//当前游标

        public MyInterator(){
            size = result.length;
            index = -1;
        }

        @Override
        public Object previous() {

            if(index<=0){
                index = 0;
            }else{
                index--;
            }

            return result[index];
        }

        @Override
        public Object next() {

            if(index>=size-1){
                index = size-1;
            }else{
                index++;
            }
            return result[index];
        }

        @Override
        public boolean hasNext() {
            return index!=size-1;
        }

        @Override
        public Object first() {
            index = 0;
            return result[index];
        }
    }
}
