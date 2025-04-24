package com.EspetinhoDoNegao.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.EspetinhoDoNegao.domain.entitys.PixPaymentRequest;

import java.util.Map;

@Service
public class MercadoPagoService {

    @Value("${mercado-pago.access-token}")
    private String accessToken;

    
    private final RestTemplate restTemplate = new RestTemplate();

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map<String, Object> createPixPayment(PixPaymentRequest request) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setBearerAuth(accessToken);

        HttpEntity<PixPaymentRequest> entity = new HttpEntity<>(request, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
            "https://api.mercadopago.com/v1/payments", entity, Map.class
        );

        return response.getBody();
    }

    @SuppressWarnings({ "rawtypes", "unchecked" })
    public Map<String, Object> consultPayment(Long id) {
        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(accessToken);

        HttpEntity<Void> entity = new HttpEntity<>(headers);

        ResponseEntity<Map> response = restTemplate.exchange(
            "https://api.mercadopago.com/v1/payments/" + id,
            HttpMethod.GET,
            entity,
            Map.class
        );

        return response.getBody();
    }
}
