package com.experiment;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Comparator 和Comparable
 */
public class CompareTest {
    public static void main(String[] args) {
        Comparator.comparing(Entity::getNum);
        List<Entity> entities = new ArrayList<>();
        entities.add( new Entity(3));
        entities.add( new Entity(1));
        entities.add( new Entity(2));
        entities.sort((a,b)->a.getNum()-b.getNum());
        entities.stream().map(Entity::getNum).forEach(System.out::println);
    }
    static class Entity implements Comparable  {
        private int num;

        Entity(int num){
            this.num = num;
        }

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }


        @Override
        public int compareTo(Object o) {
            return 0;
        }
    }
}
