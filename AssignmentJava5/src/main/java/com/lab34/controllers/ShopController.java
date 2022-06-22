package com.lab34.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lab34.entities.CartItem;
import com.lab34.entities.Hair;
import com.lab34.entities.OrderDetail;
import com.lab34.entities.OrderItem;
import com.lab34.entities.PaymentDetail;
import com.lab34.entities.ShoppingSession;
import com.lab34.entities.User;
import com.lab34.repository.IHairRepository;
import com.lab34.service.ICartService;
import com.lab34.service.OrderDetailService;
import com.lab34.service.OrderItemService;
import com.lab34.service.PaymentService;
import com.lab34.service.SessionService;
import com.lab34.service.ShoppingSessionService;
import com.lab34.service.UserService;
import com.lab34.service.implement.CartService;
import com.lab34.service.implement.HairService;


@Controller
public class ShopController {
	
	
	@Autowired
	SessionService session;
	@Autowired
	private HairService hairService;
	@Autowired
	private CartService cartService;
	@Autowired
	private UserService userService;
	@Autowired
	private ShoppingSessionService shoppingService;
	@Autowired
	private OrderItemService orderItemService;
	@Autowired
	private PaymentService paymentService;
	@Autowired
	private OrderDetailService orderDetailService;
	
	
	  @ModelAttribute("user") 
	  public User getUser1() {
	  int idUser = session.get("idUser");
	  return userService.findById(idUser).get();
	  
	  }
	 
	//Tăng giảm số lượng
	
	@GetMapping("quantity")
	public String changeQuantity(Model model,@RequestParam(name="action") String action,
			@RequestParam(name="id") int id
			) {

		 CartItem cart ;
		
		cart = cartService.findById(id).get();
		
		int quantity =cart.getQuantity();
		int currentlyQuantity = cart.getQuantity();
		int quantityHair =cart.getHair().getQuantity();
		if(action.equals("dec")&&quantity>=2) {
			currentlyQuantity =quantity-1;
		}
		else if(action.equals("inc")&&quantity<quantityHair) {
			currentlyQuantity =quantity+1;
		}
		cart.setQuantity(currentlyQuantity);
		cartService.save(cart);
		
		return "redirect:/cart/index";
		
	}
	@PostMapping("update-quantity")
	public String updateQuantity(@RequestParam(name="id") int id,
			@RequestParam(name="quantity") int quantity) {
		 CartItem cart ;
			cart = cartService.findById(id).get();
			
			int quantityCart =cart.getQuantity();
			
			int quantityHair =cart.getHair().getQuantity();
			
			if(quantityCart<=quantityHair) {
				quantityCart =quantity;
			}
			System.out.println(quantity);
			cart.setQuantity(quantityCart);
			cartService.save(cart);
		return "redirect:/cart/index";
		
	}
	@GetMapping("cart/index")
	public String viewCart(Model model,@ModelAttribute("user") User user) {
		ShoppingSession shoppingSession = shoppingService.findByUser(user);
		List<CartItem> listCart = cartService.findByShoppingSession(shoppingSession);
		model.addAttribute("listCart",listCart);
		
		//Tinh tong tien
		BigDecimal total = new BigDecimal(0);
		for (CartItem x : listCart) {
			total = total.add(x.getHair().getPrice().multiply(new BigDecimal(x.getQuantity())) ) ;
		}
		
		
		shoppingSession.setTotal(total);
		shoppingService.save(shoppingSession);
		model.addAttribute("total",total);
		
		model.addAttribute("view","shop/cart.jsp");
		return "layout";
			
		
	}
	
	@PostMapping("/cart/{hairId}")
	public String addToCart(Model model, 
			@PathVariable int hairId,
			@ModelAttribute("user") User user,
			@RequestParam(name="quantity",defaultValue = "0", required = false) Integer quantity) {
		
		
		ShoppingSession shoppingSession = shoppingService.findByUser(user);
		if(shoppingSession==null) {
			System.out.println("Chua ton tai");
			shoppingSession =new ShoppingSession();
			shoppingSession.setCreateDate(new Date());
			shoppingSession.setTotal(new BigDecimal(0));
			shoppingSession.setUser(user);
			shoppingService.save(shoppingSession);
		}
		
		CartItem cart ;
		Optional<Hair> hair =hairService.findById(hairId);
		cart = cartService.findByHair(hair.get());
		if(cart==null) {
			cart =new CartItem();
		}
		//nếu số lượng lớn hơn trong kho
		if(hair.get().getQuantity()<quantity+cart.getQuantity()) {
			cart.setQuantity(cart.getQuantity());
		}
		// Nếu sản phẩm đã tồn tại
		else if(cart.getQuantity()>0) {
			
			cart.setQuantity(cart.getQuantity()+quantity);
		}
		else {
			cart.setQuantity(quantity);
		}
		cart.setHair(hair.get());
		
		
		cart.setShoppingSession(shoppingSession);
		
		cartService.save(cart);
		
		

		return "redirect:/cart/index";
	}
	@GetMapping("remove")
	public String removeFromCart(@ModelAttribute("id") int id) {
		cartService.deleteById(id);
		
		
		return"redirect:/cart/index";
	}
	@PostMapping("create/bill")
	public String createBill(Model model,
			@ModelAttribute("user") User user) {
		//Tạo thanh toán
		PaymentDetail payment =new PaymentDetail();
		payment.setCreateAt(new Date());
		payment.setAmount(1);
		payment.setStatus(0);
		paymentService.save(payment);
		
		OrderDetail order =new OrderDetail();
		order.setCreatedAt(new Date());
		
		
		order.setTotal(new BigDecimal(0));
		order.setUser(user);
		order.setPaymentDetail(payment);
		
		
		orderDetailService.save(order);
		BigDecimal total = user.getShoppingSessions().get(0).getTotal();
		
		order.setTotal(total);
		orderDetailService.save(order);
		ShoppingSession shopping = user.getShoppingSessions().get(0);
		
		List<CartItem> listCart =cartService.findByShoppingSession(shopping);
		for (CartItem cartItem : listCart) {
			OrderItem orderItem =new OrderItem();
			orderItem.setOrderDetail(order);
			orderItem.setHair(cartItem.getHair());
			orderItem.setCreateAt(new Date());
			orderItem.setQuantity(cartItem.getQuantity());
			//trừ số lượng
			Hair hair= cartItem.getHair();
			int quantityCurrent =hair.getQuantity()-cartItem.getQuantity();
			hair.setQuantity(quantityCurrent);
			
			orderItemService.save(orderItem);
			cartService.deleteById(cartItem.getId());
		}
		
		return "redirect:/sale/purchase";
	}
	@GetMapping("sale/purchase")
	public String purchase(Model model) {
		List<OrderDetail> listOrderDetail=  orderDetailService.findByStatusEquals(0);
		model.addAttribute("listOrderDetail",listOrderDetail);
		
		model.addAttribute("view", "shop/purchase.jsp");
		return "layout";
	}
	@GetMapping("sale/order-details")
	public String orderDetails(Model model, @ModelAttribute("id")int id) {
		
	Optional<OrderDetail> orderDetail = orderDetailService.findById(id);
	model.addAttribute("orderDetail",orderDetail.get());
		List<OrderItem> listItem = orderItemService.findByOrderDetail(orderDetail.get());
		
		model.addAttribute("listItems",listItem);
		
		model.addAttribute("view", "shop/orderDetail.jsp");
		return "layout";
	}
	@GetMapping("hair-single/{id}")
	public String producSingle(Model model, @PathVariable int id) {
		Hair hair =	hairService.findById(id).get();
		model.addAttribute("hair",hair);
		model.addAttribute("view","shop/hair-single.jsp");
		return "layout";
	}
	@GetMapping("change-status/{id}")
	public String changeStatus(@PathVariable int id) {
		OrderDetail orderDetail = orderDetailService.findById(id).get();
		orderDetail.setStatus(4);
		orderDetailService.save(orderDetail);
		//trả lại số lượng
		List<OrderItem> listItem = orderItemService.findByOrderDetail(orderDetail);
			for (OrderItem item : listItem) {
				int idHair =item.getHair().getId();
				Hair hair= hairService.findById(idHair).get();
				int quantityCurrent = hair.getQuantity()+item.getQuantity();
				hair.setQuantity(quantityCurrent); 
				hairService.save(hair);
				
			}

		return "redirect:/sale/purchase";
	}
	
	

}
