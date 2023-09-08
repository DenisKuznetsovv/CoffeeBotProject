package com.coffeOrderBot.CoffeBot.service;

import com.coffeOrderBot.CoffeBot.bot.Bot;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;


@Log4j2
@Service
public class SendMessageServiceImpl implements SendMessageService {


    private final Bot bot;
    @Lazy
    @Autowired
    public SendMessageServiceImpl(Bot bot) {
        this.bot = bot;
    }

    @Override
    public void sendMessage(String chatId, String messageText) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.enableHtml(true);
        message.setText(messageText);

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            log.warn("Warn from SendMessageServiceImpl:" + e.getMessage());
            log.warn(e.getStackTrace());
            e.printStackTrace();
        }

    }

    @Override
    public void sendMessageWithInlineKeyboardMarkup(String chatId, String messageText, InlineKeyboardMarkup keyboardMarkup) {
        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.enableHtml(true);
        message.setText(messageText);
        message.setReplyMarkup(keyboardMarkup);

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            log.warn("Exception: " + e.getMessage() + " || " + Arrays.toString(e.getStackTrace()));
            log.warn(e.getStackTrace());
            e.printStackTrace();
        }
    }

    public void sendMessageWithReplyKeyboardMarkup(String chatId, String messageText, ReplyKeyboardMarkup replyKeyboardMarkup){
        SendMessage message = new SendMessage();
        message.setText(messageText);
        message.setChatId(chatId);
        message.enableHtml(true);
        message.setReplyMarkup(replyKeyboardMarkup);

        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            log.warn("Exception: " + e.getMessage() + " || " + Arrays.toString(e.getStackTrace()));
            log.warn(e.getStackTrace());
            e.printStackTrace();
        }
    }
}
