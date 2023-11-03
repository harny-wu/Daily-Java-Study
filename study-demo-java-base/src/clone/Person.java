package clone;

/**
 * 实现对象拷贝的类，必须实现Cloneable接口，并覆写clone()方法。
 */
public class Person implements Cloneable{
    private String name;
    private Integer age;
    private City city;

    public Person(String name, Integer age, City city) {
        this.name = name;
        this.age = age;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
