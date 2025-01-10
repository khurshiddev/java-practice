package chapter_5;

import java.util.Objects;

public class Task2 {
    public static void main(String[] args) {
        GetAge get1 = new GetAge(20);
        GetAge get2 = new GetAge(22);
        GetAge get3 = new GetAge(24);
        GetAge get4 = new GetAge(20);

        System.out.println("get1 and get2 = " + get1.equals(get2));
        System.out.println("get2 and get4 = " + get2.equals(get4));
        System.out.println("get1 and get4 = " + get1.equals(get4));
        System.out.println("get1 and get3 = " + get1.equals(get3));
    }
}
abstract class Age{


    public Age() {

    }

    abstract int getAge();

    @Override
    public boolean equals(Object obj) {
       if(obj == this) return true;
       if(obj == null || this.getClass() != obj.getClass()) return false;
       Age other = (Age) obj;
       return this.getAge() == other.getAge();

    }
}

class GetAge extends Age{
    int age;

    public GetAge(int age) {
        this.age = age;
    }

    @Override
    public int getAge() {
        return age;
    }
}