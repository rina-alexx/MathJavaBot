package org.example;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.send.SendPhoto;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Bot extends TelegramLongPollingBot {
   Task task=new Task();
    private static final String botUserName = "MathJavaBot";

    private static final String token = "6110261665:AAHOIFAxmVf7-LwlZzvVbGPKXUhPeuTndUU";
    @Override
    public void onUpdateReceived(Update update) {
        Message message=update.getMessage();
            if(message!=null && message.hasText()) {
                SendMessage sendMessage = new SendMessage();
                    if (message.getText().equals("/start")){
                        sendMessage.setChatId(message.getChatId());
                        sendMessage.setText("Воспользуйтесь главным меню");
                        sendMessage.setReplyMarkup(KeyboardFactory.ReplyKeyboard.getMainMenuKeyboard());
                        System.out.println(message.getText());
                    }
             else if (message.getText().equals(ButtonNameEnum.SOLVE_BUTTON)){
                        sendMessage.setChatId(message.getChatId());
                        sendMessage.setText("Выберите задачу: ");
                        sendMessage.setReplyMarkup(KeyboardFactory.inlineKeyboard.sendInlineKeyBoardMessageSolve());
                        System.out.println(message.getText());
             }
                    /*case "Команда 2":
                        sendMsg(message, "Это команда 2");
                        System.out.println(message.getText());
                        break;
                    default:
                        sendMsg(message, "Это дефолт! Брейк!");
                        System.out.println(message.getText());
                        break;

                     */
                }
            }


    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return token;
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
