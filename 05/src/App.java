enum EnumSingleton {
    INSTANCE;
    public static EnumSingleton getInstance() {
        return INSTANCE;
    }
}

class LazySingleton {
    public static class SingletonHolder {
        public static final LazySingleton HOLDER = new LazySingleton();
    }

    public static LazySingleton getInstance() {
        return SingletonHolder.HOLDER;
    }
}

class Singleton_object_as_field {
    private static final Singleton_object_as_field INSTANCE = new Singleton_object_as_field();

    public static Singleton_object_as_field getInstance() {
        return INSTANCE;
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        EnumSingleton.getInstance();
        LazySingleton lazySingleton = LazySingleton.getInstance();
        Singleton_object_as_field singleton_object_as_field = Singleton_object_as_field.getInstance();

    }
}
