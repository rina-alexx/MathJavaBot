package org.example;

public class Task {
    public String numbVariant;
    public String arguments[];

    public long chatId;

    public Task() {
    }

    public String getNumbVariant() {
        return numbVariant;
    }

    public void setNumbVariant(String numbVariant) {
        this.numbVariant = numbVariant;
    }

    public String[] getArguments() {
        return arguments;
    }

    public void setArguments(String[] arguments) {
        this.arguments = arguments;
    }

    public long getChatId() {
        return chatId;
    }

    public void setChatId(long chatId) {
        this.chatId = chatId;
    }
}
