//Fabric Method
enum Product_types {
    PRODUCT_1,
    PRODUCT_2
}

interface Product {
    void act();
}

class Product_1 implements Product{
    @Override
    public void act() {
        System.out.println("Im Product_1");
    }
}

class Product_2 implements Product{
    @Override
    public void act() {
        System.out.println("Im Product_2");
    }
}

class ProductFactory {
    public static Product createProduct (Product_types type){
        switch (type) {
            case PRODUCT_1:
                return new Product_1();
            case PRODUCT_2:
                return new Product_2();
            default:
                return null;
        }
    }
}

//Abstract Factory
interface ProductsFactory {
    Product1 createProduct1();
    Product2 createProduct2();
}

interface Product1 {
    void act();
}

interface Product2 {
    void act();
}

class Product1_Fact_1 implements Product1 {
    @Override
    public void act() {
        System.out.println("Im Product 1 from Factory 1");
    }
}

class Product1_Fact_2 implements Product1 {
    @Override
    public void act() {
        System.out.println("Im Product 1 from Factory 2");
    }
}

class Product2_Fact_1 implements Product2 {
    @Override
    public void act() {
        System.out.println("Im Product 2 from Factory 1");
    }
}

class Product2_Fact_2 implements Product2 {
    @Override
    public void act() {
        System.out.println("Im Product 2 from Factory 2");
    }
}

class ProductFactory_1 implements ProductsFactory {
    @Override
    public Product1 createProduct1() {
        return new Product1_Fact_1();
    }
    @Override
    public Product2 createProduct2() {
        return new Product2_Fact_1();
    }
}

class ProductFactory_2 implements ProductsFactory {
    @Override
    public Product1 createProduct1() {
        return new Product1_Fact_2();
    }
    @Override
    public Product2 createProduct2() {
        return new Product2_Fact_2();
    }
}

//Builder
class ComplexProduct {
    private Prod1 prod1;
    private Prod2 prod2;
    private Prod3 prod3;

    interface Builder {
        Product buildPart();
    }

    public class Prod1 implements Product {
        @Override
        public void act() {
            System.out.println("I am Prod1 of complex product");
        }
    }

    public class Prod2 implements Product {
        @Override
        public void act() {
            System.out.println("I am Prod2 of complex product");

        }
    }

    public class Prod3 implements Product {
        @Override
        public void act() {
            System.out.println("I am Prod3 of complex product");
        }
    }

    public class Prod1Builder implements Builder {
        @Override
        public Prod1 buildPart() {
            return new Prod1();
        }
    }

    public class Prod2Builder implements Builder {
        @Override
        public Prod2 buildPart() {
            return new Prod2();
        }
    }

    public class Prod3Builder implements Builder {
        @Override
        public Prod3 buildPart() {
            return new Prod3();
        }
    }

    public ComplexProduct() {
        Prod1Builder builder1 = new Prod1Builder();
        Prod2Builder builder2 = new Prod2Builder();
        Prod3Builder builder3 = new Prod3Builder();

        this.prod1 = builder1.buildPart();
        this.prod2 = builder2.buildPart();
        this.prod3 = builder3.buildPart();

    }
}

//Prototype
interface ProductPrototype {
    ProductPrototype cloneIt();
}

class FirstProduct implements ProductPrototype {
    @Override
    public ProductPrototype cloneIt() {
        return new FirstProduct();
    }
}

class SecondPrototype implements ProductPrototype {
    @Override
    public ProductPrototype cloneIt() {
        return new SecondPrototype();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("Паттерн Фабричный метод:");
        Product prod_1 = ProductFactory.createProduct(Product_types.PRODUCT_1);
        Product prod_2 = ProductFactory.createProduct(Product_types.PRODUCT_2);

        prod_1.act();
        prod_2.act();

        System.out.println("==========================");
        System.out.println("Паттерн Абстрактная фабрика:");

        ProductFactory_1 factory_1 = new ProductFactory_1();
        ProductFactory_2 factory_2 = new ProductFactory_2();

        Product1 prod11 = factory_1.createProduct1();
        Product2 prod21 = factory_1.createProduct2();

        Product1 prod12 = factory_2.createProduct1();
        Product2 prod22 = factory_2.createProduct2();

        prod11.act();
        prod21.act();

        prod12.act();
        prod22.act();

        System.out.println("==========================");
    }
}