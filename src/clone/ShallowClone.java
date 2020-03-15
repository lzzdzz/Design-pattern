package clone;

/**
 * 浅克隆
 * 仅仅克隆基本类型变量，而不克隆引用类型的变量
 */
public class ShallowClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person p = new Person("李达康", 55, "汉东省京州市");
        Person p2 = (Person) p.clone();
        //一级对象
        System.out.println(p == p2);//false
        //二级对象
        System.out.println(p.personInfo == p2.personInfo);//true
        //三级对象
        System.out.println(p.personInfo.name == p2.personInfo.name);//true
    }
}

class PersonInfo implements Cloneable{
     String name;
     int age;
     String address;

    public PersonInfo(String name,int age, String address){
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

class Person implements Cloneable{
    PersonInfo personInfo;
    public Person(String name,int age, String address){
        this.personInfo = new PersonInfo(name, age, address);
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
