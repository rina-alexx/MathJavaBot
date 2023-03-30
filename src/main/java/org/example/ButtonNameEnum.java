package org.example;

public enum ButtonNameEnum {
    SOLVE_BUTTON("Решить задачу"),
    HELP_BUTTON("Помощь"),
    TASK1_BUTTOM("Вариант 1"),
    TASK2_BUTTOM("Вариант 2"),
    TASK3_BUTTOM("Вариант 3"),
    TASK4_BUTTOM("Вариант 4"),
    TASK5_BUTTOM("Вариант 5"),
    TASK6_BUTTOM("Вариант 6"),
    TASK7_BUTTOM("Вариант 7");
    private final String buttonName;

    ButtonNameEnum(String buttonName) {
        this.buttonName = buttonName;
    }

    public String getButtonName() {
        return buttonName;
    }
}