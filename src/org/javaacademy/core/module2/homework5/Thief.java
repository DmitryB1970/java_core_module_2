package org.javaacademy.core.module2.homework5;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Thief {
    private BigDecimal money;

    private Thief() {
        this.money = BigDecimal.ZERO;
    }

    private void stealMoney(Bank bank) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Field bField = bank.getClass().getDeclaredField("money");
        bField.setAccessible(true);
        this.money = (BigDecimal) bField.get(bank);
        Method mBank = bank.getClass().getDeclaredMethod("setMoney", BigDecimal.class);
        mBank.setAccessible(true);
        mBank.invoke(bank, BigDecimal.ZERO);
    }

    @Override
    public String toString() {
        return "Thief{" +
                "money=" + money +
                '}';
    }
}
