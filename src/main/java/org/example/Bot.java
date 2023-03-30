package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Bot extends TelegramLongPollingBot {

    private static final String botUserName = "MathJavaBot";
    private static final String token = "6110261665:AAHOIFAxmVf7-LwlZzvVbGPKXUhPeuTndUU";
    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();
        System.out.println(message);
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
        }
        else if(message.getText().equals("Решить задачу")){
            SendMessage sendMessage=new SendMessage();
            sendMessage.setText("Выберите задачу");
            sendMessage.setChatId(message.getChatId());
            sendMessage.setReplyMarkup(KeyboardFactory.inlineKeyboard.sendInlineKeyBoardMessageSolve());
            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                throw new RuntimeException(e);
            }
        }


    }

}