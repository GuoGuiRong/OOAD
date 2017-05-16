package prototype;

import java.io.*;

/**
 * 所谓的原型模式，实际就是通过原有对象复制生成另一个对象
 */
public class Prototype implements Cloneable,Serializable {

    private int age;//年龄

    private String name;//名字

    private Address address;//地址

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    /**
     * 浅复制
     */
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 深复制
     */
    private Object clonedeep() throws IOException, ClassNotFoundException {
         /* 写入当前对象的二进制流 */
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(bos);
            oos.writeObject(this);
        } catch (IOException e) {
            e.printStackTrace();
        }


        /* 读出二进制流产生的新对象 */
        ByteArrayInputStream bis = new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = null;
        ois = new ObjectInputStream(bis);
        return ois.readObject();

        /*//另一种实现方式
        Prototype o = new Prototype();
        o.age=this.age;
        o.name=this.name;
        Address address = new Address(this.address);
        o.setAddress(address);
        return o;*/

    }

    public static void main(String[] args){
        Prototype prototype = new Prototype();

        Address address = new Address();
        address.setCity(11);
        address.setCode("001");
        address.setCountry("china");

        prototype.setAddress(address);

        Prototype prototype1 = prototype.clone();

        Prototype prototype2 = null;
        try {
            prototype2 = (Prototype) prototype.clonedeep();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        /**
         * 浅复制,引用对象不会复制出来,而是让新对象的引用指向源对象里同一个对象地址
         * 所以，复制出来的对象改变了引用对象后，源对象的引用数据也会发生改变
         */
        System.out.println("引用类型浅复制:"+(prototype.getAddress()==prototype1.getAddress()));
        prototype1.getAddress().setCountry("中国");

        System.out.println(prototype.getAddress());

        /**
         * 这里发现深复制的话是真的连引用类型的成员变量都会一起复制出来一份
         * 引用对象不共享
         *
         */
        System.out.println("引用类型深复制:"+(prototype.getAddress()==prototype2.getAddress()));
        prototype2.getAddress().setCountry("美国");
        System.out.println(prototype.getAddress());
    }

}