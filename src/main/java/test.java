import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

/**
 * https://codetop.cc/home 企业高频题目
 * */
public class test{
    private int price;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static void main(String[] args) throws Exception {
        // 正常的调用
        test test = new test() ;
        test.setPrice(5);
        System.out.println("Apple Price:" + test.getPrice());

        // 使用反射调用
        // 获取对象的实例
        Class clazz = Class.forName("test") ;
        // 根据Class实例获取Constructor对象
        Constructor appleConstructor = clazz.getConstructor() ;
        // 使用appleConstructor对象的newInstance方法获取反射类对象
        Object appleObj = appleConstructor.newInstance() ;

        // 如果要使用类对象的方法
        // 1. 首先需要获取方法的Method对象
        Method setPriceMethod = clazz.getMethod("setPrice", int.class) ;
        // 2. 利用invoke方法调用对象
        setPriceMethod.invoke(appleObj , 14) ;
        Method getPriceMethod = clazz.getMethod("getPrice") ;
        System.out.println("Apple Price:" + getPriceMethod.invoke(appleObj));
    }
}
