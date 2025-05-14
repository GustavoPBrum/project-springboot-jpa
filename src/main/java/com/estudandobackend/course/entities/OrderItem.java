package com.estudandobackend.course.entities;

import java.io.Serializable;
import java.util.Objects;

import com.estudandobackend.course.entities.pk.OrderItemPK;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order_item")
public class OrderItem implements Serializable {
	private static final long serialVersionUID = 1L;

	// Identificador da nossa classe (PK)
	@EmbeddedId
	private OrderItemPK id = new OrderItemPK(); // Temos que instanciar toda classe auxiliar com ID composto pois se nao sera nulo
	
	private Integer quantity;
	private Double price;
	
	public OrderItem() {
	}

	public OrderItem(Order order, Product product, Integer quantity, Double price) {  // O OrderItemPK sera inserido manualmente
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.quantity = quantity;
		this.price = price;
	}

	@JsonIgnore  // Este get chamava o pedido associado a este OrderItem, que por sua vez chamava o OrderItem novamente gerando referencia ciclica
	public Order getOrder() {
		return id.getOrder();
	}
	
	public void setOrder(Order order) {
		id.setOrder(order);  // Vai pegar o pedido passado como parametro e jogar la dentro do OrderItemPK
	}
	
	public Product getProduct() {
		return id.getProduct();
	}
	
	public void setProduct(Product product) {
		id.setProduct(product);  // Vai pegar o produto passado como parametro e jogar la dentro do OrderItemPK
	}
	
	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		return Objects.equals(id, other.id);
	}		
}
