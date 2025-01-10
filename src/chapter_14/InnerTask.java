package chapter_14;

public class InnerTask {
    public static void main(String[] args) {
        City city1 = new City("London");
        City city2 = new City("South Korea");

        City.Person person1 = city1.new Person("Jon");
        City.Person person2 = city2.new Person("Abdurohman");

        person1.info();
        person2.info();

    }
}
class City{
    private String name;

    public City(String name) {
        this.name = name;
    }
    class Person {
        private String name;

        public Person(String name) {
            this.name = name;
        }
        public void info() {
            System.out.println();
            System.out.println("Person");
            System.out.println("Name: " + this.name);
            System.out.println("Name: " + City.this.name);
        }
    }


}