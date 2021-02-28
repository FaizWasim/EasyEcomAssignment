package com.rest;

import java.math.BigDecimal;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.rest.model.PaymentSheet;
import com.rest.service.PaymentSheetService;

@RunWith(SpringRunner.class)
@SpringBootTest
@ComponentScan(basePackages = { "com.rest.*" })
@EnableAutoConfiguration
class EasyEcomAssigmentApplicationTests {

	@Autowired
	PaymentSheetService paymentSheetService;

	@Test
	public void getAllPaymentSheet() {
		List<PaymentSheet> allPaymentSheet = paymentSheetService.getAllPaymentSheet();
		System.out.println(allPaymentSheet);
	}

	@Test
	public void savePaymentSheet() {
		PaymentSheet paymentSheet = new PaymentSheet();
		BigDecimal transferredAmount = new BigDecimal(100);
		BigDecimal costPrice = new BigDecimal(100);

		BigDecimal profitLoss = transferredAmount.subtract(costPrice);

		BigDecimal comission = new BigDecimal(100);
		BigDecimal paymentGateway = new BigDecimal(100);
		BigDecimal pickPackFee = new BigDecimal(100);

		BigDecimal totalMarketPlacesCharges = comission.add(paymentGateway).add(pickPackFee);

		paymentSheet.setOrderNumber("A1");
		paymentSheet.setProfitLoss(profitLoss);
		paymentSheet.setTransferredAmount(transferredAmount);
		paymentSheet.setTotalMarketPlaceCharges(totalMarketPlacesCharges);

		paymentSheet.setCostPrice(costPrice);
		paymentSheet.setPaymentGateway(paymentGateway);
		paymentSheet.setPickPackFee(pickPackFee);
		paymentSheet.setSaleAmount(new BigDecimal(100));
		paymentSheet.setComission(comission);

		PaymentSheet sheet = paymentSheetService.savePaymentSheet(paymentSheet);
		System.out.println(sheet);
	}

	@Test
	public void getPaymentSheetById() {
		Long id = 4L;
		try {
			PaymentSheet sheet = paymentSheetService.getPaymentSheetById(id);
			System.out.println(sheet);
		} catch (Exception e) {
			System.out.println("Not found");
		}
	}

	@Test
	public void deletePaymentSheetById() {
		Long id = 4L;
		try {
			paymentSheetService.deletePaymentSheetById(id);
			System.out.println("Deleted");
		} catch (Exception e) {
			System.out.println("Not found");
		}
	}

}
