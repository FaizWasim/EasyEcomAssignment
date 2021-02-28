package com.rest.service;

import java.util.List;

import com.rest.model.PaymentSheet;

public interface PaymentSheetService {

	public List<PaymentSheet> getAllPaymentSheet();

	public PaymentSheet savePaymentSheet(PaymentSheet paymentSheet);

	public PaymentSheet getPaymentSheetById(Long id);

	public void deletePaymentSheetById(Long id);

}
