package com.productApi.productApi.entities;



import java.time.OffsetDateTime;
import java.util.Objects;



public class Product {
	private Integer  id;
	private String href;
	private String description;
	private Boolean is_bundle;
	private Boolean is_customer_visible;
	private String name;
	private OffsetDateTime order_date;
	private String product_serial_number;
	private OffsetDateTime start_date;
	private OffsetDateTime termination_date;

	public Product() {
	}

	public Product(Integer id, String href, String description, Boolean is_bundle, Boolean is_customer_visible,
			String name, OffsetDateTime order_date, String product_serial_number, OffsetDateTime start_date,
			OffsetDateTime termination_date) {
		this.id = id;
		this.href = href;
		this.description = description;
		this.is_bundle = is_bundle;
		this.is_customer_visible = is_customer_visible;
		this.name = name;
		this.order_date = order_date;
		this.product_serial_number = product_serial_number;
		this.start_date = start_date;
		this.termination_date = termination_date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer  id) {
		this.id = id;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean is_bundle() {
		return is_bundle;
	}

	public void setIs_bundle(Boolean is_bundle) {
		this.is_bundle = is_bundle;
	}

	public Boolean is_customer_visible() {
		return is_customer_visible;
	}

	public void setIs_customer_visible(boolean is_customer_visible) {
		this.is_customer_visible = is_customer_visible;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public OffsetDateTime getOrder_date() {
		return order_date;
	}

	public void setOrder_date(OffsetDateTime order_date) {
		this.order_date = order_date;
	}

	public String getProduct_serial_number() {
		return product_serial_number;
	}

	public void setProduct_serial_number(String product_serial_number) {
		this.product_serial_number = product_serial_number;
	}

	public OffsetDateTime getStart_date() {
		return start_date;
	}

	public void setStart_date(OffsetDateTime start_date) {
		this.start_date = start_date;
	}

	public OffsetDateTime getTermination_date() {
		return termination_date;
	}

	public void setTermination_date(OffsetDateTime termination_date) {
		this.termination_date = termination_date;
	}

	@Override
	public int hashCode() {
		return Objects.hash(description, href, id, is_bundle, is_customer_visible, name, order_date,
				product_serial_number, start_date, termination_date);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Product other = (Product) obj;
		return Objects.equals(description, other.description) && Objects.equals(href, other.href)
				&& Objects.equals(id, other.id) && is_bundle == other.is_bundle
				&& is_customer_visible == other.is_customer_visible && Objects.equals(name, other.name)
				&& Objects.equals(order_date, other.order_date)
				&& Objects.equals(product_serial_number, other.product_serial_number)
				&& Objects.equals(start_date, other.start_date)
				&& Objects.equals(termination_date, other.termination_date);
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", href=" + href + ", description=" + description + ", is_bundle=" + is_bundle
				+ ", is_customer_visible=" + is_customer_visible + ", name=" + name + ", order_date=" + order_date
				+ ", product_serial_number=" + product_serial_number + ", start_date=" + start_date
				+ ", termination_date=" + termination_date + "]";
	}
}
