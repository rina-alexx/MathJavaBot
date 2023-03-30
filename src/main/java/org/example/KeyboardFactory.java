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


/**
 * Этот класс отвечает за  ReplyKeyboard и InlineKeyboard
 */
public class KeyboardFactory {


    //Главное меню
    public static class ReplyKeyboard {
        public static ReplyKeyboardMarkup getMainMenuKeyboard() {
            KeyboardRow row1 = new KeyboardRow();
            row1.add(new KeyboardButton("Решить задачу"));
            row1.add(new KeyboardButton("Помощь"));


            List<KeyboardRow> keyboard = new ArrayList<>();
            keyboard.add(row1);

            final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(keyboard);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);

            return replyKeyboardMarkup;
        }

        // /start => Помощь
        public static ReplyKeyboardMarkup getVariantHelpKeyboard() {
            KeyboardRow row1 = new KeyboardRow();
            row1.add(new KeyboardButton("Решить задачу"));


            List<KeyboardRow> keyboard = new ArrayList<>();
            keyboard.add(row1);

            final ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
            replyKeyboardMarkup.setKeyboard(keyboard);
            replyKeyboardMarkup.setSelective(true);
            replyKeyboardMarkup.setResizeKeyboard(true);
            replyKeyboardMarkup.setOneTimeKeyboard(true);

            return replyKeyboardMarkup;
        }

    }

    //Выбор варианта задачи
    public static class inlineKeyboard {
        public static InlineKeyboardMarkup sendInlineKeyBoardMessageSolve() {
            InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();
            InlineKeyboardButton task1 = new InlineKeyboardButton();
            InlineKeyboardButton task2 = new InlineKeyboardButton();
            InlineKeyboardButton task3 = new InlineKeyboardButton();
            InlineKeyboardButton task4 = new InlineKeyboardButton();
            InlineKeyboardButton task5 = new InlineKeyboardButton();
            InlineKeyboardButton task6 = new InlineKeyboardButton();
            InlineKeyboardButton task7 = new InlineKeyboardButton();

            task1.setText("№1");
            task1.setCallbackData("Task_1");

            task2.setText("№2");
            task2.setCallbackData("Task_2");

            task3.setText("№3");
            task3.setCallbackData("Task_3");

            task4.setText("№4");
            task4.setCallbackData("Task_4");

            task5.setText("№5");
            task5.setCallbackData("Task_5");

            task6.setText("№6");
            task6.setCallbackData("Task_6");

            task7.setText("№7");
            task7.setCallbackData("Task_7");

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

            return inlineKeyboardMarkup;
        }
    }
}
