package strategy;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/** 可配置化的XMl工具实现类
 * Created by GuiRunning on 2017/12/3.
 */
public class XMLUtil {

    public static  Object getBean(String classPath){
        //创建文档对象
        DocumentBuilderFactory dFactory = DocumentBuilderFactory.newInstance();
        Document doc;
        NodeList nl = null;
        try {
            DocumentBuilder builder = dFactory.newDocumentBuilder();
            //加载配置文件
            doc = builder.parse(XMLUtil.class.getClassLoader().getResourceAsStream(classPath));
            //获取包含类名的文本节点
            nl = doc.getElementsByTagName("className");
        }catch (Exception e){
            e.printStackTrace();
            System.out.println("配置文件加载失败");
        }

        Node classNode=nl.item(0).getFirstChild();
        String cName=classNode.getNodeValue();

        //通过类名生成实例对象并将其返回
        Class c = null;
        try {
            c = Class.forName(cName);
            Object obj = c.newInstance();
            return obj;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }

        return null;
    }
}
