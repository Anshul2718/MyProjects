package Generics;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenericPairDemo {

    public static void main(String[] args) {
        GenericsPair<Integer,String> genericsPair = new GenericsPair(1, "Rahul");
        Integer id = genericsPair.getFirst();
        System.out.println(genericsPair.getFirst());
        List list = new ArrayList();
        Map<Integer,String> mp;

    }
}
