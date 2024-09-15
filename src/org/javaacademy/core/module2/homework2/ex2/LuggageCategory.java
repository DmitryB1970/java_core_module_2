package org.javaacademy.core.module2.homework2.ex2;

public enum LuggageCategory {
    LIGHT("легкий", 5),
    MIDDLE("средний", 10),
    HEAVY("тяжелый", null);


    private final String name;
    private final Integer maxLimit;

    LuggageCategory(String name, Integer maxLimit) {
        this.name = name;
        this.maxLimit = maxLimit;
    }

    public String getName() {
        return name;
    }

    public Integer getMaxLimit() {
        return maxLimit;
    }


}
