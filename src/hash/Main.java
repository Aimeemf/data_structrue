package hash;

import java.util.HashMap;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        int a = 42;
        System.out.println(((Integer)a).hashCode());

        int b = -42;
        System.out.println(((Integer)b).hashCode());

        double c = 3.1415926;
        System.out.println(((Double)c).hashCode());

        String d = "imooc";
        System.out.println(d.hashCode());


        Student student = new Student(3, 2, "bobo", "liu");
        System.out.println(student.hashCode());

        HashSet<Student> hashSet = new HashSet<>();
        hashSet.add(student);

        HashMap<Student, Integer> hashMap = new HashMap<>();
        hashMap.put(student, 100);
    }
}
