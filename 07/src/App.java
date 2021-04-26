import java.util.HashMap;

//Decorator
interface Product {
    void operation();
}

class BaseProduct implements Product {
    @Override
    public void operation() {
        System.out.println("Hello from product");
    }
}

class Decorator implements Product {
    protected Product product = new BaseProduct();
    
    @Override
    public void operation() {
        product.operation();
    }
}

class DecoratedProduct1 extends Decorator{
    @Override
    public void operation() {
        
    }

    public void addedBehavior() {
        super.operation();
        System.out.println("But decorated by decorator #1");
    }
}

class DecoratedProduct2 extends Decorator{
    
    @Override
    public void operation() {
        
    }

    public void addedBehavior() {
        super.operation();
        System.out.println("But decorated by decorator #2");
    }
}
//////////

//Flyweight

abstract class Flyweight {
    public void operation(int uniqState) {}
}

class FlyweightFactory {
    private HashMap <String, Flyweight> flyweights = new HashMap<String, Flyweight>();

    public Flyweight getFlyweight (String repeatingState) {
        Flyweight flyweight = flyweights.get(repeatingState);

        if (flyweight != null) {
            return flyweight;
        }
        else {
            switch (repeatingState) {
                case ("Red"): 
                    RedFlyweight redTemp = new RedFlyweight();
                    flyweights.put(repeatingState, redTemp);
                    return redTemp;
                case ("Green"): 
                    GreenFlyweight greenTemp = new GreenFlyweight();
                    flyweights.put(repeatingState, greenTemp);
                    return greenTemp;
                default:
                    return null;
            }
        }
    }
}

class RedFlyweight extends Flyweight {
    private String repeatingState = "Red";

    public void operation(int uniqState) {
        System.out.println("Flyweight doing operation using uniqState = " + uniqState + " and repeatingState = " + this.repeatingState);
    }
}

class GreenFlyweight extends Flyweight {
    private String color = "Green";

    public void operation(int uniqState) {
        System.out.println("Flyweight doing operation using uniqState = " + uniqState + " and repeatingState = " + this.color);
    }
}

class ProgramObject {

    private int uniqState;

    private Flyweight stringFlyweight;

    public ProgramObject(FlyweightFactory factory, int uniqState, String repeatingState) {
        stringFlyweight = factory.getFlyweight(repeatingState);
    }

    public void operation() {
        stringFlyweight.operation(uniqState);
    }

    public Flyweight gFlyweight () {
        return this.stringFlyweight;
    }
}
///////////

public class App {
    public static void main(String[] args) throws Exception {
        DecoratedProduct1 dec1 = new DecoratedProduct1();
        dec1.addedBehavior();

        DecoratedProduct2 dec2 = new DecoratedProduct2();
        dec2.addedBehavior();


        FlyweightFactory factory = new FlyweightFactory();
        ProgramObject po1 = new ProgramObject(factory, 2, "Red");
        ProgramObject po2 = new ProgramObject(factory, 3, "Red");
        ProgramObject po3 = new ProgramObject(factory, 4, "Red");

        System.out.println(po1.gFlyweight().toString());
        System.out.println(po2.gFlyweight().toString());
        System.out.println(po3.gFlyweight().toString());
    }
}
