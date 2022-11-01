package lection11.lesson11.run;

import lection11.lesson11.accountlogic.AccountOperationManager;
import lection11.lesson11.accountlogic.AccountOperationManagerImpl;
import lection11.lesson11.annotation.logic.SecurityFactory;

public class AnnoRunner {
    public static void main(String[] args) {
        AccountOperationManager account = new AccountOperationManagerImpl();
//        AccountOperationManager account2 = new AccountOperationManagerImpl();
        AccountOperationManager securityAccount = SecurityFactory.createSecurityObject(account);
        System.out.println("Class: " + securityAccount.getClass());
//        AccountOperationManager securityAccount1 = SecurityFactory.createSecurityObject(account);
//        System.out.println("Class: " + securityAccount1.getClass());
//        AccountOperationManager securityAccount2 = SecurityFactory.createSecurityObject(account2);
//        System.out.println("Class: " + securityAccount2.getClass());

        System.out.println("depositInCash ---->" + securityAccount.depositInCash(10128336, 6));
        System.out.println("withdraw ---->" + securityAccount.withdraw(64092376, 2));
        System.out.println("convert ---->" + securityAccount.convert(200));
        System.out.println("transfer ---->" + securityAccount.transfer(64092376, 300));

    }
}
