package com.rest.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Entity
@Table(name = "paymentsheet")
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class PaymentSheet {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Column(name = "order_number")
	private String orderNumber;

	@Column(name = "sale_amount")
	private BigDecimal saleAmount;

	@Column(name = "cost_price")
	private BigDecimal costPrice;

	@Column(name = "transferred_amount")
	private BigDecimal transferredAmount;

	@Column(name = "comission")
	private BigDecimal comission;

	@Column(name = "payment_gateway")
	private BigDecimal paymentGateway;

	@Column(name = "pick_pack_fee")
	private BigDecimal pickPackFee;

	@Column(name = "profit_loss")
	private BigDecimal profitLoss;

	@Column(name = "total_market_place_charges")
	private BigDecimal totalMarketPlaceCharges;

	public PaymentSheet() {
		// TODO Auto-generated constructor stub
	}

	public PaymentSheet(Long id, String orderNumber, BigDecimal saleAmount, BigDecimal costPrice,
			BigDecimal transferredAmount, BigDecimal comission, BigDecimal paymentGateway, BigDecimal pickPackFee,
			BigDecimal profitLoss, BigDecimal totalMarketPlaceCharges) {
		super();
		this.id = id;
		this.orderNumber = orderNumber;
		this.saleAmount = saleAmount;
		this.costPrice = costPrice;
		this.transferredAmount = transferredAmount;
		this.comission = comission;
		this.paymentGateway = paymentGateway;
		this.pickPackFee = pickPackFee;
		this.profitLoss = profitLoss;
		this.totalMarketPlaceCharges = totalMarketPlaceCharges;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOrderNumber() {
		return orderNumber;
	}

	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	public BigDecimal getSaleAmount() {
		return saleAmount;
	}

	public void setSaleAmount(BigDecimal saleAmount) {
		this.saleAmount = saleAmount;
	}

	public BigDecimal getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(BigDecimal costPrice) {
		this.costPrice = costPrice;
	}

	public BigDecimal getTransferredAmount() {
		return transferredAmount;
	}

	public void setTransferredAmount(BigDecimal transferredAmount) {
		this.transferredAmount = transferredAmount;
	}

	public BigDecimal getComission() {
		return comission;
	}

	public void setComission(BigDecimal comission) {
		this.comission = comission;
	}

	public BigDecimal getPaymentGateway() {
		return paymentGateway;
	}

	public void setPaymentGateway(BigDecimal paymentGateway) {
		this.paymentGateway = paymentGateway;
	}

	public BigDecimal getPickPackFee() {
		return pickPackFee;
	}

	public void setPickPackFee(BigDecimal pickPackFee) {
		this.pickPackFee = pickPackFee;
	}

	public BigDecimal getProfitLoss() {
		return profitLoss;
	}

	public void setProfitLoss(BigDecimal profitLoss) {
		this.profitLoss = profitLoss;
	}

	public BigDecimal getTotalMarketPlaceCharges() {
		return totalMarketPlaceCharges;
	}

	public void setTotalMarketPlaceCharges(BigDecimal totalMarketPlaceCharges) {
		this.totalMarketPlaceCharges = totalMarketPlaceCharges;
	}

	@Override
	public String toString() {
		return "PaymentSheet [id=" + id + ", orderNumber=" + orderNumber + ", saleAmount=" + saleAmount + ", costPrice="
				+ costPrice + ", transferredAmount=" + transferredAmount + ", comission=" + comission
				+ ", paymentGateway=" + paymentGateway + ", pickPackFee=" + pickPackFee + ", profitLoss=" + profitLoss
				+ ", totalMarketPlaceCharges=" + totalMarketPlaceCharges + "]";
	}

}
