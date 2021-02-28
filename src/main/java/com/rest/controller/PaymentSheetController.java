package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rest.model.PaymentSheet;
import com.rest.service.PaymentSheetService;

@Controller
@RequestMapping("")
public class PaymentSheetController {

	@Autowired
	private PaymentSheetService paymentSheetService;

	// display all
	@RequestMapping("/")
	public String viewHomePage(Model model) {

		model.addAttribute("listPaymentSheets", paymentSheetService.getAllPaymentSheet());
		return "index";
	}

	@GetMapping("/newPaymentSheet")
	public String showNewPaymentSheet(Model model) {
		PaymentSheet paymentSheet = new PaymentSheet();
		model.addAttribute("paymentSheet", paymentSheet);

		return "newPaymentSheet";
	}

//create
	@PostMapping("/savePaymentSheet")
	public String savePaymentSheet(@ModelAttribute("paymentSheet") PaymentSheet paymentSheet) {
		PaymentSheet savePaymentSheet = paymentSheetService.savePaymentSheet(paymentSheet);
		System.out.println(savePaymentSheet);
		return "redirect:/";
	}

	// update
	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") Long id, Model model) {
		PaymentSheet paymentSheet = paymentSheetService.getPaymentSheetById(id);
		model.addAttribute("paymentSheet", paymentSheet);

		return "updatePaymentSheet";
	}

	// delete
	@GetMapping("/deletePaymentSheet/{id}")
	public String deletePaymentSheet(@PathVariable(value = "id") Long id, Model model) {
		this.paymentSheetService.deletePaymentSheetById(id);

		return "redirect:/";
	}
}
