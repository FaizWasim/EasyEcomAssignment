package com.rest.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.PaymentSheet;
import com.rest.repo.PaymentSheetRepository;

@Service
@Transactional
public class PaymentSheetServiceImpl implements PaymentSheetService {

	@Autowired
	private PaymentSheetRepository paymentSheetRepo;

	@Override
	public List<PaymentSheet> getAllPaymentSheet() {
		return paymentSheetRepo.findAll();
	}

	@Override
	public PaymentSheet savePaymentSheet(PaymentSheet paymentSheet) {
		BigDecimal transferredAmount = paymentSheet.getTransferredAmount();
		BigDecimal costPrice = paymentSheet.getCostPrice();

		BigDecimal profitLoss = transferredAmount.subtract(costPrice);

		BigDecimal comission = paymentSheet.getComission();
		BigDecimal paymentGateway = paymentSheet.getPaymentGateway();
		BigDecimal pickPackFee = paymentSheet.getPickPackFee();

		BigDecimal totalMarketPlacesCharges = comission.add(paymentGateway).add(pickPackFee);

		paymentSheet.setOrderNumber(paymentSheet.getOrderNumber());
		paymentSheet.setProfitLoss(profitLoss);
		paymentSheet.setTransferredAmount(transferredAmount);
		paymentSheet.setTotalMarketPlaceCharges(totalMarketPlacesCharges);

		paymentSheet.setCostPrice(costPrice);
		paymentSheet.setPaymentGateway(paymentGateway);
		paymentSheet.setPickPackFee(pickPackFee);
		paymentSheet.setSaleAmount(paymentSheet.getSaleAmount());
		paymentSheet.setComission(comission);

		PaymentSheet sheet = this.paymentSheetRepo.save(paymentSheet);

		System.out.println("Saved paymentSheet : " + sheet);
		return sheet;
	}

	@Override
	public PaymentSheet getPaymentSheetById(Long id) {
		Optional<PaymentSheet> optional = paymentSheetRepo.findById(id);
		PaymentSheet paymentSheet = null;
		if (optional.isPresent()) {
			paymentSheet = optional.get();
		} else {
			throw new RuntimeException("Not found for id : " + id);
		}

		return paymentSheet;
	}

	@Override
	public void deletePaymentSheetById(Long id) {
		paymentSheetRepo.deleteById(id);

	}

}
