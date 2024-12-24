package chapter_11;

public class ContactTask {
    public static void main(String[] args) {
        Contact con = new Contact("Abdurohman", 01077545525, "golden.@gmail.com", "Seoul", "Android");
        con.show();
    }
}

class Contact {
    String name;
    int number;
    String email;
    String address;
    String favorite;

    Contact(
            String name,
            int number,
            String email,
            String address,
            String favorite
    ) {
        this.name = name;
        this.number = number;
        this.email = email;
        this.address = address;
        this.favorite = favorite;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", number=" + number +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", favorite='" + favorite + '\'' +
                '}';
    }

    public void show() {
        System.out.println(this);
//        System.out.println("name = " + name);
//        System.out.println("number = " + number);
//        System.out.println("email = " + email);
//        System.out.println("address = " + address);
//        System.out.println("favorite = " + favorite);
    }
}
