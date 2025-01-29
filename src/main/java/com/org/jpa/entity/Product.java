package com.org.jpa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedStoredProcedureQueries;
import jakarta.persistence.NamedStoredProcedureQuery;
import jakarta.persistence.ParameterMode;
import jakarta.persistence.StoredProcedureParameter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@NamedStoredProcedureQueries({
		@NamedStoredProcedureQuery(
				name = "updateStockProcedure",
				procedureName = "update_stock",
				parameters = {
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "productId", type = Integer.class),
						@StoredProcedureParameter(mode = ParameterMode.IN, name = "quantity", type = Integer.class)
				})
})

@Entity
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
public class Product
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String name;
	double price;
	int stockQuantity;
}
