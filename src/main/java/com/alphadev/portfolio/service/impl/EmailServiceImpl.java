package com.alphadev.portfolio.service.impl;

import com.alphadev.portfolio.dto.MessageDetailsDTO;
import com.alphadev.portfolio.entity.UserMessages;
import com.alphadev.portfolio.repository.UserMessagesRepository;
import com.alphadev.portfolio.service.EmailService;
import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

@Service
public class EmailServiceImpl implements EmailService {

    private final Logger logger = LoggerFactory.getLogger(EmailServiceImpl.class);

    @Value("${mail.from}")
    private String fromEmailAddress;

    @Value("${mail.subject}")
    private String emailSubject;

    @Autowired
    private final JavaMailSender emailSender;

    @Autowired
    private UserMessagesRepository userMessagesRepository;

    @Autowired
    @Qualifier("emailConfigBean")
    private Configuration emailConfig;

    public EmailServiceImpl(JavaMailSender emailSender) {
        this.emailSender = emailSender;
    }

    @Override
    public String sendEmail(MessageDetailsDTO messageDetailsDTO) throws IOException, TemplateException, MessagingException {

        Map model = new HashMap();
        model.put("name", messageDetailsDTO.getName());
        model.put("location", "Sri Lanka");
        model.put("signature", "https://techmagister.info");
        model.put("content", "Test Content");

        MimeMessage message = emailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(message, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, StandardCharsets.UTF_8.name());
        mimeMessageHelper.addInline("logo.png", new ClassPathResource("classpath:/techmagisterLogo.png"));

        Template template = emailConfig.getTemplate("email.ftl");
        String html = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);

        mimeMessageHelper.setTo(messageDetailsDTO.getEmailAddress());
        mimeMessageHelper.setText(html, true);
        mimeMessageHelper.setSubject(emailSubject);
        mimeMessageHelper.setFrom(fromEmailAddress);

        emailSender.send(message);
        logger.info("Email Sent Successfully to {}",messageDetailsDTO.getEmailAddress());

        saveUserMessages(messageDetailsDTO);
        return "Email Sent Successfully";
    }

    private void saveUserMessages(MessageDetailsDTO messageDetailsDTO) {
        UserMessages userMessages = new UserMessages();
        userMessages.setMessage(messageDetailsDTO.getMessage());
        userMessages.setEmailAddress(messageDetailsDTO.getEmailAddress());
        userMessages.setName(messageDetailsDTO.getName());
        userMessages.setPhoneNo(userMessages.getPhoneNo());
        userMessagesRepository.save(userMessages);
    }


}
