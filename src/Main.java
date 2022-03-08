public class Main {

    public static void main(String[] args) {

        Duck duck = new RedheadDuck();
        System.out.println(duck.display());
        System.out.println(duck.performQuack());

        Duck duck2 = new MandarinDuck();
        System.out.println(duck2.display());
        System.out.println(duck2.performQuack());

        Duck duck3 = new MallardDuck();
        System.out.println(duck3.display());
        System.out.println(duck3.performQuack());

        Duck duck4 = new RubberDuck();
        System.out.println(duck4.display());
        System.out.println(duck4.performQuack());
        System.out.println(duck4.performFly());

        Duck duck5 = new ModernDuck();
        System.out.println(duck5.display());
        System.out.println(duck5.performFly());
        duck5.setFlyBehavior(new FlyWithRocket());
        System.out.println(duck5.performFly());
    }
}

abstract class Duck {

    private final String name;
    protected QuackBehavior quackBehavior;
    protected FlyBehavior flyBehavior;

    public Duck() {
        this.name = getClass().getName();
        this.quackBehavior = new Quack();
        this.flyBehavior = new FlyWithWings();
    }

    public String swim() {
        return "I'm swimming!";
    }

    public String performQuack() {
        return quackBehavior.quack();
    }

    public String performFly() {
        return flyBehavior.fly();
    }

    public String display() {
        return "I'm a " + name + ".";
    }

    public void setFlyBehavior(FlyBehavior flyBehavior) {
        this.flyBehavior = flyBehavior;
    }
}

class RedheadDuck extends Duck {
}

class MandarinDuck extends Duck {
}

class MallardDuck extends Duck {
}

class RubberDuck extends Duck {
    public RubberDuck() {
        quackBehavior = new MuteQuack();
        flyBehavior = new NoFly();
    }
}

class ModernDuck extends Duck {
}

interface QuackBehavior {
    String quack();
}

class Quack implements QuackBehavior {

    @Override
    public String quack() {
        return "Quack!";
    }
}

class Squawk implements QuackBehavior {

    @Override
    public String quack() {
        return "Squawk!";
    }
}

class MuteQuack implements QuackBehavior {

    @Override
    public String quack() {
        return "No quack!";
    }
}

interface FlyBehavior {
    String fly();
}

class FlyWithWings implements FlyBehavior {

    @Override
    public String fly() {
        return "Fly with Wings!";
    }
}

class NoFly implements FlyBehavior {

    @Override
    public String fly() {
        return "No fly";
    }
}

class FlyWithRocket implements FlyBehavior {

    @Override
    public String fly() {
        return "Fly with rocket!";
    }
}
