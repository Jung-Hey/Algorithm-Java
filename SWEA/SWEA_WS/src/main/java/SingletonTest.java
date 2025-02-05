
class SingletonClass {
    private static SingletonClass instamce = new SingletonClass();

    private SingletonClass() {
    }

    public static SingletonClass getInstance(){
        return instamce;
    }



}

public class SingletonTest {

    public static void main(String[] args) {
        SingletonClass s1 = SingletonClass.getInstance();
        SingletonClass s2 = SingletonClass.getInstance();
        System.out.println(s1.hashCode() == s2.hashCode());
    }
}