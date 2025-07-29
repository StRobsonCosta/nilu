package com.kavex.nilu.infra.msg;

import com.kavex.nilu.domain.service.NotificacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishRequest;

@Service
@RequiredArgsConstructor
public class SNSNotificacaoService implements NotificacaoService {

    private final SnsClient snsClient;

    private final String topicArn = "arn:aws:sns:us-east-1:123456789012:AvisosClientes"; // mock

    @Override
    public void notificarCliente(String contato, String mensagem) {
        var request = PublishRequest.builder()
                .topicArn(topicArn)
                .message(mensagem)
                .build();

        snsClient.publish(request);
    }
}
