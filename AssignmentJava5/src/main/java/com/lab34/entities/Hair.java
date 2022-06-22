package com.lab34.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table
public class Hair {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@NotEmpty(message = "Tên sản phẩm không được để trống!")
	private String name;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date createDate;
	private HairType type;
	
	@NotEmpty(message = "Màu sản phẩm không được để trống!")
	private String color;
   
	@NotNull(message = "Không được để trống giá tiền")
	@DecimalMin(value = "1", message = "Giá phải >=1!")
	private BigDecimal price;
	@NotNull(message = "Không được để trống chiều dài")
	@DecimalMin(value = "1", message = "Chiều dài phải >=1!")
	private BigDecimal  length;
	private String imageUrl;
	@NotNull(message = "Không được để trống số lượng")
	@DecimalMin(value = "0", message = "Số lượng phải >=0!")
	private int quantity;
	
	@OneToMany(mappedBy="hair")
	private List<CartItem> cartItems;
	@OneToMany(mappedBy="hair")
	private List<OrderItem> orderItems;
//	-	Name: String
//	-	CreatedDate: Date
//	-	Type: Enum 

}
