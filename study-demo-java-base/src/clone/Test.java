package clone;

/*
浅拷贝：拷贝对象和原始对象的引用类型引用同一个对象。
浅拷贝是按位拷贝对象，它会创建一个新对象，这个对象有着原始对象属性值的一份精确拷贝。
如果属性是基本类型，拷贝的就是基本类型的值；如果属性是内存地址（引用类型），拷贝的就是内存地址 ，
因此如果其中一个对象改变了这个地址，就会影响到另一个对象。

深拷贝
拷贝对象和原始对象的引用类型引用不同对象。
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p1=new Person("小吴",12,new City("广州"));
        Person p2 = (Person) p1.clone();
        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p1.getCity().getName().toString());
        System.out.println(p2.getCity().getName().toString());
        p1.getCity().setName("深圳");//只改变p1中city名字的值，p2也随着改变
        System.out.println(p1.getCity().getName().toString());
        System.out.println(p2.getCity().getName().toString());
    }
}
