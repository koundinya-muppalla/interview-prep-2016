package sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParititionArray {

    public static void parititionAndSort(List<Person> persons) {
        if(persons == null || persons.size() <= 1) {
            return;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(Person p : persons) {
            if(map.containsKey(p.age)) {
                map.put(p.age, map.get(p.age) + 1);
            } else {
                map.put(p.age, 1);
            }
        }

        Map<Integer, Integer> offsetMap = new HashMap<Integer, Integer>();
        int offset = 0;
        for(Integer age : map.keySet()) {
            offsetMap.put(age, offset);
            offset += map.get(age);
        }
        while(!offsetMap.isEmpty()) {
            int index = offsetMap.values().iterator().next();
            int age = persons.get(index).age;
            int toIndex = offsetMap.get(age);
            Collections.swap(persons, index, toIndex);
            map.put(age, map.get(age) - 1);

            if(map.get(age) > 0) {
                offsetMap.put(age, offsetMap.get(age) + 1);
            } else {
                offsetMap.remove(age);
            }
        }
    }

    private static class Person implements Comparable<Person>{
        int age;
        String name;

        public int compareTo(Person o) {
            return Integer.compare(age, o.age);
        }

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String toString() {
            return this.name + " " + this.age;
        }
    }

    public static void main(String[] args) {
        List<Person> list = new ArrayList<ParititionArray.Person>();
        list.add(new Person("Greg", 14));
        list.add(new Person("John", 12));
        list.add(new Person("Andy", 11));
        list.add(new Person("Jim", 13));
        list.add(new Person("Phil", 12 ));
        list.add(new Person("Bob", 13));
        list.add(new Person("Chip", 13));
        list.add(new Person("Tim", 14));
        parititionAndSort(list);
        System.out.println(Arrays.toString(list.toArray()));


    }

}
