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
    protected Product product;
    
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

class FlyweightFactory {
    public void getFlyweight (int key) {

    }
}

interface Flyweight {
    void operation (int extrinicState);
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
    }
}
