package com.productApi.productApi.entities;

import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(length = 255)
    private String href;

    @Column(length = 500)
    private String description;

    @Column(name = "is_bundle")
    private Boolean isBundle;

    @Column(name = "is_customer_visible")
    private Boolean isCustomerVisible;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(name = "order_date")
    private OffsetDateTime orderDate;

    @Column(name = "product_serial_number", length = 100)
    private String productSerialNumber;

    @Column(name = "start_date")
    private OffsetDateTime startDate;

    @Column(name = "termination_date")
    private OffsetDateTime terminationDate;

}
