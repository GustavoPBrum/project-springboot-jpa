package com.estudandobackend.course.entities.enums;

public enum OrderStatus {
	
	WAITING_PAYMMENT(1),
	PAID(2),
	SHIPPED(3),
	DELIVERED(4),
	CANCELED(5);
	
	private int code;
	
	// Construtor especial do tipo numero eh private
	private OrderStatus(int code) {
		this.code = code;
	}
	
	public int getCode() {
		return code;
	}
	
	// Converte o valor numero em um tipo enumerado
	public static OrderStatus valueOf(int code) {
		for(OrderStatus value : OrderStatus.values()) {
			if(code == value.getCode()) {
				return value;
			}
		}
		throw new IllegalArgumentException("Invalid OrderStatus code");
	}
}
