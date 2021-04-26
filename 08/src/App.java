//Template Method
class TemplateMethod {
    
    public void step1() {
        System.out.println("Doing original step1");
    }

    public void step2() {
        System.out.println("Doing original step2");
    }

    public void step3() {
        System.out.println("Doing original step3");
    }


    public void run() {
        step1();
        step2();
        step3();
    }
}

class TemplateMethodRealise1 extends TemplateMethod {
    @Override
    public void step2() {
        System.out.println("Doing realisation of original step2 method from first realisator");
    }
}

class TemplateMethodRealise2 extends TemplateMethod {
    @Override
    public void step2() {
        System.out.println("Doing realisation of original step2 method from second realisator");
    }

    @Override
    public void step3() {
        System.out.println("Doing realisation of original step3 method from second realisator");
    }
}

//Visitor
class First {
    public String acceptVisitor(Visitor visitor) {
        return visitor.visitFirst(this);
    }
}

class Second {
    public String acceptVisitor(Visitor visitor) {
        return visitor.visitSecond(this);
    }
}

class Third {
    public String acceptVisitor(Visitor visitor) {
        return visitor.visitThird(this);
    }
}

interface Visitor {
    String visitFirst(First first);
    String visitSecond(Second second);
    String visitThird(Third third);
}

class ToStringVisitor implements Visitor {
    @Override
    public String visitFirst(First first) {
        return first.toString();
    }
    public String visitSecond(Second second) {
        return second.toString();
    }
    public String visitThird(Third third) {
        return third.toString();
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        TemplateMethodRealise1 temp1 = new TemplateMethodRealise1();
        temp1.run();

        System.out.println("#####################################");
        TemplateMethodRealise2 temp2 = new TemplateMethodRealise2();
        temp2.run();


        ToStringVisitor visitor = new ToStringVisitor();
        System.out.println(new First().acceptVisitor(visitor));
        System.out.println(new Second().acceptVisitor(visitor));
        System.out.println(new Third().acceptVisitor(visitor));
    }
}
