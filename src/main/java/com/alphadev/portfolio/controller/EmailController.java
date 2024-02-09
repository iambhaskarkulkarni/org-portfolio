package com.alphadev.portfolio.controller;

import com.alphadev.portfolio.dto.MessageDetailsDTO;
import com.alphadev.portfolio.dto.ResponseDTO;
import com.alphadev.portfolio.service.EmailService;
import freemarker.template.TemplateException;
import jakarta.mail.MessagingException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@CrossOrigin
@RestController
@RequestMapping("/email")
public class EmailController {

    private final Logger logger = LoggerFactory.getLogger(EmailController.class);

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<ResponseDTO> sendEmail(@RequestBody MessageDetailsDTO messageDetailsDTO) {
        String response = null;
        try {
            logger.info(messageDetailsDTO.toString());
            response = emailService.sendEmail(messageDetailsDTO);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (TemplateException e) {
            throw new RuntimeException(e);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
        return ResponseEntity.ok(new ResponseDTO(response));
    }
}
