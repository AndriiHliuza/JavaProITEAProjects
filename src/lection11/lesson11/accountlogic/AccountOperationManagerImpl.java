package lection11.lesson11.accountlogic;

import lection11.lesson11.annotation.BankingAnnotation;
import lection11.lesson11.annotation.SecurityLevelEnum;

public class AccountOperationManagerImpl implements AccountOperationManager{
    @Override
    @BankingAnnotation(securityLevel = SecurityLevelEnum.HIGH)
    public double depositInCash(int accountNumber, int amount) {
        return 0;
    }

    @Override
    @BankingAnnotation(securityLevel = SecurityLevelEnum.HIGH)
    public boolean withdraw(int accountNumber, int amount) {
        return true;
    }

    @Override
    @BankingAnnotation(securityLevel = SecurityLevelEnum.LOW)
    public boolean convert(double amount) {
        return true;
    }

    @Override
    @BankingAnnotation
    public boolean transfer(int accountNumber, double amount) {
        return true;
    }
}
