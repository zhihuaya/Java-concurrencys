package com.thirdstage.jcu.atomic;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceTest {

    public static void main(String[] args) {
        Simple alex = new Simple("Alex", 1);
        AtomicReference<Simple> atomicReference =
                new AtomicReference<>(alex);
        System.out.println(atomicReference.get());
        boolean result = atomicReference.compareAndSet(alex, new Simple("gg", 1));
        System.out.println(result);
    }

    static class Simple{
        private String name;
        private int age;

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

        public Simple(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }

}
