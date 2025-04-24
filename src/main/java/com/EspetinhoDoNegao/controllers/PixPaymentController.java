package com.EspetinhoDoNegao.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.EspetinhoDoNegao.domain.entitys.PixPaymentRequest;
import com.EspetinhoDoNegao.services.MercadoPagoService;

import java.util.Map;

@RestController
@RequestMapping("/api/payment")
public class PixPaymentController {

    @Autowired
    private MercadoPagoService mercadoPagoService;

    @PostMapping("/pix")
    public ResponseEntity<Map<String, Object>> creatPayment(@RequestBody PixPaymentRequest request) {
        Map<String, Object> payment = mercadoPagoService.createPixPayment(request);
        return ResponseEntity.ok(payment);
    }

    @PostMapping("/webhook/pix")
    public ResponseEntity<Void> webhook(@RequestBody Map<String, Object> payload) {
        @SuppressWarnings("unchecked")
        Map<String, Object> data = (Map<String, Object>) payload.get("data");
        Long paymentId = Long.valueOf(data.get("id").toString());

        Map<String, Object> payment = mercadoPagoService.consultPayment(paymentId);
        String status = (String) payment.get("status");

        if ("approved".equalsIgnoreCase(status)) {
            
            System.out.println("Pagamento aprovado: " + paymentId);
        }

        return ResponseEntity.ok().build();
    }
}
