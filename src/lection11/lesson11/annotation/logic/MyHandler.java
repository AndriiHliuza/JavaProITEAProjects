package lection11.lesson11.annotation.logic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class MyHandler implements InvocationHandler {
    private Object targetObject;

    public MyHandler(Object targetObject) {
        this.targetObject = targetObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("hello");
//            SecurityLogic logic = new SecurityLogic();
//            System.out.println(method);
//            Method realMethod = targetObject.getClass().getMethod(method.getName(), (Class[]) method.getGenericParameterTypes());
//            System.out.println(realMethod);
//            BankingAnnotation annotation = method.getAnnotation(BankingAnnotation.class);
//            BankingAnnotation annotation2 = realMethod.getAnnotation(BankingAnnotation.class);
//            System.out.println(annotation);
//            System.out.println(annotation2);
//            if (annotation != null) {
//                logic.onInvoke(annotation.securityLevel(), method, args);
//                try {
//                    return method.invoke(targetObject, args);
//                } catch (InvocationTargetException e) {
//                    System.out.println(annotation.securityLevel());
//                    throw e.getCause();
//                }
//            } else {
//                return null;
//            }
        return null;
    }
}
