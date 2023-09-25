package com.coffeOrderBot.CoffeBot.service;

import com.coffeOrderBot.CoffeBot.bot.Bot;
import jakarta.validation.constraints.NotNull;
import lombok.NonNull;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.meta.api.methods.send.SendInvoice;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.payments.LabeledPrice;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;

import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.List;


@Log4j2
@Service
@PropertySource(value = "bot.properties")
public class SendMessageService {

    private String chatIdForOrders;

    private final Bot bot;

    @Value("${bot.ukassaTestToken}")
    private String providerToken;

    @Lazy
    @Autowired
    public SendMessageService(Bot bot) {
        this.bot = bot;
    }

    public void setChatIdForOrders(String chatIdForOrders){
        this.chatIdForOrders = chatIdForOrders;
    }

    public void sendOrder(String order){
        SendMessage message = new SendMessage();
        message.setChatId(chatIdForOrders);
        message.enableHtml(true);
        message.setText(order);
    }

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

    public void sendMessageWithReplyKeyboardMarkup(String chatId, String messageText, ReplyKeyboardMarkup replyKeyboardMarkup) {
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

    @SneakyThrows
    public void sendInvoice(String chatId, String title, String description, String payload) {
        List<LabeledPrice> list = List.of(
                new LabeledPrice("Цена", 14000),
                new LabeledPrice("Работа сервиса", 500)
                );

        SendInvoice invoice = new SendInvoice(chatId, title, description, payload, this.providerToken,"start", "RUB"
                ,list);
        bot.execute(invoice);
    }
}
