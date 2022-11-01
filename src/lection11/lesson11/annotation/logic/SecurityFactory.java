package lection11.lesson11.annotation.logic;

import lection11.lesson11.accountlogic.AccountOperationManager;
import lection11.lesson11.annotation.BankingAnnotation;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class SecurityFactory {
    public static AccountOperationManager createSecurityObject(AccountOperationManager targetObject) {
        return (AccountOperationManager) Proxy.newProxyInstance(targetObject.getClass().getClassLoader(),
                targetObject.getClass().getInterfaces(), new SecurityInvocationHandler(targetObject));
    }

    private static class SecurityInvocationHandler implements InvocationHandler {
        private Object targetObject;

        public SecurityInvocationHandler(Object targetObject) {
            this.targetObject = targetObject;
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            //System.out.println("hello");
            SecurityLogic logic = new SecurityLogic();
            //System.out.println(method);
            Method realMethod = targetObject.getClass().getMethod(method.getName(), (Class[]) method.getGenericParameterTypes());
            //System.out.println(realMethod);
            //Class[] cl = (Class[])method.getGenericParameterTypes();
            BankingAnnotation annotation = realMethod.getAnnotation(BankingAnnotation.class);
            //BankingAnnotation annotation2 = realMethod.getAnnotation(BankingAnnotation.class);
            //System.out.println(annotation);
            //System.out.println(annotation2);
            if (annotation != null) {
                logic.onInvoke(annotation.securityLevel(), method, args);
                try {
                    return method.invoke(targetObject, args);
                } catch (InvocationTargetException e) {
                    System.out.println(annotation.securityLevel());
                    throw e.getCause();
                }
            } else {
                return null;
            }
        }
    }
}
