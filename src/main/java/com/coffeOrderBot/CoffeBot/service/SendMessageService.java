package com.coffeOrderBot.CoffeBot.service;

import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;

public interface SendMessageService {
    void sendMessage(String chatId, String message);
    void sendMessageWithInlineKeyboardMarkup(String chatId, String messageText, InlineKeyboardMarkup keyboardMarkup);
    void sendMessageWithReplyKeyboardMarkup(String chatId, String messageText, ReplyKeyboardMarkup replyKeyboardMarkup);
}
