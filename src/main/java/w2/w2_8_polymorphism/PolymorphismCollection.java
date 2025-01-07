package w2.w2_8_polymorphism;

import java.util.ArrayList;
import java.util.List;

class Animal {
    public void sound() {
        System.out.println("Some sound");
    }
}

class Dog extends Animal {
    @Override
    public void sound() {
        System.out.println("Bark");
    }
}

class Cat extends Animal {
    @Override
    public void sound() {
        System.out.println("Meow");
    }
}

public class PolymorphismCollection {
    public static void main(String[] args) {
        List<Animal> animals = new ArrayList<>(); // 단일 타입만을 핸들링할 수 있는 Collection
        animals.add(new Dog());
        animals.add(new Cat());

        for (Animal animal : animals) {
            animal.sound();
        }
    }
}
