package Iterator;

/**
 * Created by GuiRunning on 2017/11/29.
 */
public interface Collection1 {

    public Iterator createIterator();

    /*取得集合元素*/
    public Object get(int i);

    /*取得集合大小*/
    public int size();
}
