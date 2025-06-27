package com.kavex.nilu.domain.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailService {

    private final JavaMailSender mailSender;

    public void enviarEmail(String para, String assunto, String corpo) {
        try {
            if (para == null || para.isBlank()) {
                throw new IllegalArgumentException("Email de destino é obrigatório.");
            }

            var mensagem = new SimpleMailMessage();
            mensagem.setTo(para);
            mensagem.setSubject(assunto);
            mensagem.setText(corpo);
            mailSender.send(mensagem);

            log.info("Email enviado com sucesso para {}", para);
        } catch (Exception e) {
            log.error("Falha ao enviar email para {}: {}", para, e.getMessage());
            // talvez depois.. lançar exceção customizada
        }
    }
}
