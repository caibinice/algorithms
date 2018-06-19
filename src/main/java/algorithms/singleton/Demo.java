package algorithms.singleton;


enum MySingle implements SingleTon{
    INSTANCE {
        @Override
        public void test() {
            System.out.println("my single");
        }
    };

    public static MySingle getInstance() {
        return MySingle.INSTANCE;
    }
}

public class Demo {

    public static void main(String[] args) {
        MySingle s = MySingle.INSTANCE;
        MySingle s2 = MySingle.INSTANCE;
        System.out.println(s==s2);
        MySingle.INSTANCE.test();

    }
}
