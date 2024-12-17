package chapter_6;

public class task_1 {
    public static void main(String[] args) {
    Thing thing1 = new Thing("Cola",2);
    Box box = new Box(4);
    box.push();
    box.isFull();

        System.out.println(box.push());
        System.out.println(box.isFull());
    }
}
class Box{
    int size;
    int temp;
    Box(int size){
        this.size = size;
        this.temp = 0;
    }
    boolean push(){
        if(temp < size){
            temp++;
            return true;
        }
        return false;
    }

    boolean isFull(){
       if(temp >= size){
           return true;
       }
       return false;
    }
}
class Thing{

    Thing(String name, int size){

    }
}
