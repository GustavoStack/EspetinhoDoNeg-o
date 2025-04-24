package com.EspetinhoDoNegao.domain.entitys;

public class PixPaymentRequest {
    public double transaction_amount;
    public String description;
    public String payment_method_id = "pix";
    public Payer payer;

    public static class Payer {
        public String email;
        public String first_name;
        public String last_name;
    }
}
