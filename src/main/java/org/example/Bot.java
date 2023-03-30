package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendChatAction;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;

public class Bot extends TelegramLongPollingBot {

    boolean flag=false;
    private static final String botUserName = "MathJavaBot";
    private static final String token = "6110261665:AAHOIFAxmVf7-LwlZzvVbGPKXUhPeuTndUU";
    Task task = new Task();
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

        if (update.hasMessage()) {
            Message message = update.getMessage();
            if (!message.getText().isEmpty()) {
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
                } else if (message.getText().equals("Решить задачу")) {
                    SendMessage sendMessage = new SendMessage();
                    sendMessage.setText("Выберите задачу");
                    sendMessage.setChatId(message.getChatId());
                    sendMessage.setReplyMarkup(KeyboardFactory.inlineKeyboard.sendInlineKeyBoardMessageSolve());
                    try {
                        sendImageFromFileId("C:/Users/rinaa/OneDrive/Изображения/Saved Pictures/formula.jpg",update.getMessage().getChatId());
                        execute(sendMessage);
                    } catch (TelegramApiException e) {
                        throw new RuntimeException(e);
                    }
                }
                    if (flag){
                        System.out.println("<KKKKKKKKKKKKKKKKKKK");
                        task.setArguments(message.getText());
                        System.out.println(task.getArguments());
                        System.out.println(task.numbVariant);
                        SendMessage sendMessage=new SendMessage();
                        sendMessage.setText(task.askAnswer());
                        sendMessage.setChatId(message.getChatId());
                        flag=false;

                        try {
                            execute(sendMessage);
                        } catch (TelegramApiException e) {
                            throw new RuntimeException(e);
                        }
                    }
                }
            }
        else if (update.hasCallbackQuery()) {
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
                sendMessage.setText("Введите переменные для этого варианта: ");
                try {
                    execute(sendMessage);
                } catch (TelegramApiException e) {
                    e.printStackTrace();
                }
            }

        }
    }
    public void sendImageFromFileId(String filePath, Long chatId) {
        // Create send method
        SendPhoto sendPhotoRequest = new SendPhoto();
        // Set destination chat id
        sendPhotoRequest.setChatId(chatId);
        // Set the photo file as a new photo (You can also use InputStream with a constructor overload)
        sendPhotoRequest.setPhoto(new InputFile((new File(filePath))));
        try {
            // Execute the method
            execute(sendPhotoRequest);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

}