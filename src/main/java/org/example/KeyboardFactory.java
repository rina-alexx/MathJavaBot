package org.example;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboard;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class KeyboardFactory {

    public static class ReplyKeyboard {
        public static ReplyKeyboardMarkup getMainMenuKeyboard() {
            KeyboardRow row1 = new KeyboardRow();
            row1.add(new KeyboardButton(ButtonNameEnum.SOLVE_BUTTON.getButtonName()));
            row1.add(new KeyboardButton(ButtonNameEnum.HELP_BUTTON.getButtonName()));


            List<KeyboardRow> keyboard = new ArrayList<>();
            keyboard.add(row1);

            final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(keyboard);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);

            return replyKeyboardMarkup;
        }

        public static ReplyKeyboardMarkup getVariantKeyboard() {
            KeyboardRow row1 = new KeyboardRow();
            row1.add(new KeyboardButton(ButtonNameEnum.TASK1_BUTTOM.getButtonName()));
            row1.add(new KeyboardButton(ButtonNameEnum.TASK2_BUTTOM.getButtonName()));
            row1.add(new KeyboardButton(ButtonNameEnum.TASK3_BUTTOM.getButtonName()));
            row1.add(new KeyboardButton(ButtonNameEnum.TASK4_BUTTOM.getButtonName()));

            KeyboardRow row2 = new KeyboardRow();
            row2.add(new KeyboardButton(ButtonNameEnum.TASK5_BUTTOM.getButtonName()));
            row2.add(new KeyboardButton(ButtonNameEnum.TASK6_BUTTOM.getButtonName()));
            row2.add(new KeyboardButton(ButtonNameEnum.TASK7_BUTTOM.getButtonName()));


            List<KeyboardRow> keyboard = new ArrayList<>();
            keyboard.add(row1);
            keyboard.add(row2);

            final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(keyboard);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(false);

            return replyKeyboardMarkup;

        }
    }

    public static class inlineKeyboard{
        public static InlineKeyboardMarkup sendInlineKeyBoardMessageSolve() {
            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            InlineKeyboardButton task1 = new InlineKeyboardButton();
            InlineKeyboardButton task2 = new InlineKeyboardButton();
            InlineKeyboardButton task3 = new InlineKeyboardButton();
            InlineKeyboardButton task4 = new InlineKeyboardButton();
            InlineKeyboardButton task5 = new InlineKeyboardButton();
            InlineKeyboardButton task6 = new InlineKeyboardButton();
            InlineKeyboardButton task7 = new InlineKeyboardButton();
            task1.setText("Задача №1");
            //   task1.setCallbackData("Введите a, x, b, n, c: ");
            task1.setCallbackData("1");
            task2.setText("Задача №2");
            // task2.setCallbackData("Введите y, x, gam, a: ");
            task2.setCallbackData("Task: 2");
            task3.setText("Задача №3");
            //task3.setCallbackData("Введите a0, a1, a2, x: ");
            task3.setCallbackData("Task: 3");
            task4.setText("Задача №4");
            //task4.setCallbackData("Введите a, x: ");
            task4.setCallbackData("Task: 4");
            task5.setText("Задача №5");
            //task5.setCallbackData("Введите y, x, gam, a: ");
            task5.setCallbackData("Task: 5");
            task6.setText("Задача №6");
            //  task6.setCallbackData("Введите a, b, c, d, x: ");
            task6.setCallbackData("Task: 6");
            task7.setText("Задача #7");
            //  task7.setCallbackData("Введите x: ");
            task7.setCallbackData("Task: 7");

            List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
            List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
            keyboardButtonsRow1.add(task1);
            keyboardButtonsRow1.add(task2);
            keyboardButtonsRow1.add(task3);
            keyboardButtonsRow1.add(task4);
            keyboardButtonsRow2.add(task5);
            keyboardButtonsRow2.add(task6);
            keyboardButtonsRow2.add(task7);
            List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
            rowList.add(keyboardButtonsRow1);
            rowList.add(keyboardButtonsRow2);
            inlineKeyboardMarkup.setKeyboard(rowList);
            return  inlineKeyboardMarkup;
        }
    }
}
