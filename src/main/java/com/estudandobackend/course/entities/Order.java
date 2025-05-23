package com.estudandobackend.course.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.estudandobackend.course.entities.enums.OrderStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	// Para garantir que seja mostrado no formato de string do ISO 8601
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant moment;

	private Integer orderStatus; // Internamente sera um inteiro, mas fora sera um enum

	@ManyToOne // Muitos pedidos ou nenhum para um cliente
	@JoinColumn(name = "client_id") // Nome da chave estrangeira no BD
	private User client;
	
	@OneToMany(mappedBy = "id.order")  // No OrderItem, o id tem o order (atribudo eh o id que contem o order)
	private Set<OrderItem> items = new HashSet<>();
	
	// No caso de OneToOne, estamos mapeando as entidades para ter o mesmo Id (Id = 5 Order, Id = 5 payment)
	@OneToOne(mappedBy = "order", cascade = CascadeType.ALL)
	private Payment payment;

	public Order() {
		super();
	}

	public Order(Long id, Instant moment, OrderStatus orderStatus, User client) {
		super();
		this.id = id;
		this.moment = moment;
		setOrderStatus(orderStatus);
		this.client = client;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Instant getMoment() {
		return moment;
	}

	public void setMoment(Instant moment) {
		this.moment = moment;
	}

	public OrderStatus getOrderStatus() {
		return OrderStatus.valueOf(orderStatus);  // Transformamos o codigo inteiro em orderstatus referente ao numero do enum
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		if (orderStatus != null) {
			this.orderStatus = orderStatus.getCode();  // Fazemos o processo inverso, this.orderstatus eh inteiro, entao pegamos o codigo int
		}
	}

	public User getClient() {
		return client;
	}

	public void setClient(User client) {
		this.client = client;
	}
	
	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Set<OrderItem> getItems() {
		return items;
	}
	
	public Double getTotal() {
		double total = 0.0;
		for(OrderItem oi : items) {
			total += oi.getSubTotal();
		}
		return total;
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
		Order other = (Order) obj;
		return Objects.equals(id, other.id);
	}
}
