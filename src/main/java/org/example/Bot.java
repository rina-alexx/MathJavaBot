package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.ParseMode;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Bot extends TelegramLongPollingBot {

    /**
     * Обработка входяших апдейтов и отправка сообщений
     */
    boolean flag = false;
    Task task = new Task();

    @Override
    public String getBotUsername() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("C:/Users/rinaa/Downloads/email-demo/BotTelegA/src/main/resources/config.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String botUserName = properties.getProperty("telegrambot.botusername");

        return botUserName;
    }

    @Override
    public String getBotToken() {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream(new File("C:/Users/rinaa/Downloads/email-demo/BotTelegA/src/main/resources/config.properties")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String token = properties.getProperty("telegrambot.token");

        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (!message.getText().isEmpty()) {
                System.out.printf("New message '%s' from %s chatId: %d",message.getText(),message.getFrom().getUserName(),message.getChatId());
                if (message.getText().equals("/start")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setText("Воспользуйтесь главным меню");
                    sendMessage.setReplyMarkup(KeyboardFactory.ReplyKeyboard.getMainMenuKeyboard());
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (message.getText().equals("Решить задачу")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Выберите задачу");
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setReplyMarkup(KeyboardFactory.inlineKeyboard.sendInlineKeyBoardMessageSolve());
                    try {
                        sendImageFromFileId("C:/Users/rinaa/OneDrive/Изображения/Saved Pictures/formula.jpg", update.getMessage().getChatId());
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                } else if (message.getText().equals("Помощь")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Для того, чтобы решить необходимую задачу, нажмите на <b>Решить задачу</b>" +
                            "\n \nПеред вами появятся формулы и вы сможете выбрать необходимый вариант!");
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setReplyMarkup(KeyboardFactory.ReplyKeyboard.getVariantHelpKeyboard());
                    sendMessage.setParseMode(ParseMode.HTML);
                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                else if (flag) {
                    task.setArguments(message.getText());
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText(task.askAnswer());
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setReplyMarkup(KeyboardFactory.ReplyKeyboard.getMainMenuKeyboard());
                    flag = false;

                    try {
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        } else if (update.hasCallbackQuery()) {
            CallbackQuery callbackQuery = update.getCallbackQuery();
            if (callbackQuery.getData().startsWith("Task_")) {
                String mas[] = callbackQuery.getData().split("_");
                task.setNumbVariant(mas[1]);
                flag = true;
                System.out.println(flag);
                System.out.println(task.getNumbVariant());
                task.setChatId(callbackQuery.getMessage().getChatId());
                SendMessage sendMessage = new SendMessage();
                sendMessage.setChatId(callbackQuery.getMessage().getChatId());
                sendMessage.setText("<i>через пробел вводите переменные по порядку как в варианте</i>" +
                        "\n \n Введите переменные:");
                sendMessage.setParseMode(ParseMode.HTML);

                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }


    public void sendImageFromFileId(String filePath, Long chatId) {

        SendPhoto sendPhotoRequest = new SendPhoto();
        sendPhotoRequest.setChatId(chatId);
        sendPhotoRequest.setPhoto(new InputFile((new File(filePath))));
        try {
            execute(sendPhotoRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}