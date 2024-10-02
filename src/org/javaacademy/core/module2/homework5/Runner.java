package org.javaacademy.core.module2.homework5;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class Runner {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, ClassNotFoundException, NoSuchFieldException {

        Bank bank = createBank(BigDecimal.valueOf(1500));
        System.out.println(bank);

        Thief thief = createThief();
        System.out.println(thief);

        thiefStealMoneyFromBank(thief, bank);

        System.out.println(bank);
        System.out.println(thief);
    }

    private static Bank createBank(BigDecimal amount) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class<Bank> bankClass = Bank.class;
        Constructor<Bank> bankConstructor = bankClass.getDeclaredConstructor(BigDecimal.class);
        bankConstructor.setAccessible(true);
        return bankConstructor.newInstance(amount);
    }

    private static Thief createThief() throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException {

        Class<Thief> thiefClass = Thief.class;
        Constructor<Thief> thiefConstructor = thiefClass.getDeclaredConstructor();
        thiefConstructor.setAccessible(true);
        return thiefConstructor.newInstance();
    }

    private static void thiefStealMoneyFromBank(Thief thief, Bank bank) throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {

        Method thiefMethod = thief.getClass().getDeclaredMethod("stealMoney", Bank.class);
        thiefMethod.setAccessible(true);
        thiefMethod.invoke(thief, bank);
    }
}
