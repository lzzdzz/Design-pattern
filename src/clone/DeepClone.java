package clone;

/**
 * 深克隆
 *既克隆基本类型变量，也克隆引用类型变量
 */
public class DeepClone {
    public static void main(String[] args) throws CloneNotSupportedException {
        Person2 p = new Person2("李达康", 55, "汉东省京州市");
        Person2 p2 = (Person2) p.clone();
        //一级对象
        System.out.println(p == p2);//false
        //二级对象
        System.out.println(p.personInfo2 == p2.personInfo2);//true
        //三级对象
        System.out.println(p.personInfo2.name == p2.personInfo2.name);//true
    }
}

class PersonInfo2 implements Cloneable{
     String name;
     int age;
     String address;

    public PersonInfo2(String name,int age, String address){
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
        PersonInfo2 personInfo2 = (PersonInfo2) super.clone();
        personInfo2.name = new String(this.name);
        personInfo2.age = new Integer(this.age);
        personInfo2.address = new String(this.address);

        return  personInfo2;
    }
}

class Person2 implements Cloneable{
    PersonInfo2 personInfo2;
    public Person2(String name,int age, String address){
        this.personInfo2 = new PersonInfo2(name, age, address);
    }
    @Override
    public Object clone() throws CloneNotSupportedException {
        Person2 person2 = (Person2) super.clone();
        person2.personInfo2 = (PersonInfo2) this.personInfo2.clone();
        return person2;
    }
}
