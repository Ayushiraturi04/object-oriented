public class AnimalHierarchy {
    public static void main(String[] args) {
        Animal[] animals = {
                new Dog("sheru", 13),
                new Cat("many", 6),
                new Bird("chippo", 8)
        };
        for (Animal animal : animals) {
        System.out.println(animal.name + " (" + animal.getClass().getSimpleName() + ") says: " + animal.makeSound());

        }
    }

}

class Animal {
    String name;
    int age;

    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String makeSound() {
        return "Animal sound";
    }
}

class Dog extends Animal {
    public Dog(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "Woof Woof";

    }

}

class Cat extends Animal {
    public Cat(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "meow meow";
    }

}

class Bird extends Animal {
    public Bird(String name, int age) {
        super(name, age);
    }

    @Override
    public String makeSound() {
        return "chi chi";
    }

}
