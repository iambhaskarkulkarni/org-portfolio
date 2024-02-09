package com.alphadev.portfolio.service;

import com.alphadev.portfolio.dto.MessageDetailsDTO;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;

import java.io.IOException;

public interface EmailService {

    public String sendEmail(MessageDetailsDTO messageDetailsDTO) throws IOException, TemplateException, MessagingException;
}
