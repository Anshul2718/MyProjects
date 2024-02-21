package Generics;

import java.util.List;

public class ObjectDemo {
    public static void main(String[] args) {
//        String c = "HJKHJKHJKDH";
//        Object p = c;
//        System.out.println(p);
        ObjectPair studentIdNamePair = new ObjectPair(1,"Anshul");
        ObjectPair latLongPair = new ObjectPair(91.1,199);

        // Explicit Type Casting.
        double lat = (double)latLongPair.getFirst();


        ObjectPair latLongPair1 = new ObjectPair(91.1,"199b");
//        double lat = (double)latLongPair1.getSecond();

        System.out.println(studentIdNamePair.getFirst());
        System.out.println(latLongPair.getFirst());

        List<Integer> list;
        List<String> strings;
    }
}
