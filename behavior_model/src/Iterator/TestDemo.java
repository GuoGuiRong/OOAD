package Iterator;

import org.junit.Test;

/**
 * Created by GuiRunning on 2017/11/29.
 */
public class TestDemo {

    @Test
    public void testdemo0() {
        Collection collection = new MyCollection();
        Iterator it = collection.iterator();

        while(it.hasNext()){
            System.out.print(it.next()+",");
        }

    }

    @Test
    public void  testdemo1(){
        MyCollection1 collection1 = new MyCollection1(new String[]{"AB","CD","EF"});
        Iterator iterator = collection1.createIterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+",");
        }
    }


}
