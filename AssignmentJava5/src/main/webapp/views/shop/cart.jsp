<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<c:if test="${empty listCart}">
   	<p class="alert alert-warning">Không có bản ghi</p>
</c:if>

	
    <div class="shopping-cart section">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<!-- Shopping Summery -->
					
					<table class="table shopping-summery">
						<thead>
							<tr class="main-hading">
								<th>PRODUCT</th>
								<th>NAME</th>
								<th class="text-center">PRICE</th>
								<th class="text-center" >QUANTITY</th>
								
								<th class="text-center">TOTAL</th> 
								<th class="text-center"><i class="ti-trash remove-icon"></i></th>
							</tr>
						</thead>
						<tbody>
						<c:forEach var ="obj" items="${listCart}">
						
							<tr>
								<td class="image" data-title="No"><img src="/images/${obj.hair.imageUrl}" alt="#"></td>
								<td class="product-des" data-title="Description">
									<p class="product-name"><a href="#">${obj.hair.name}</a></p>
									<p class="product-des">Maboriosam in a tonto nesciung eget  distingy magndapibus.</p>
								</td>
								<td class="price" data-title="Price"><span>${obj.hair.price }</span></td>
							
								<td class="qty" data-title="Qty"><!-- Input Order -->
								
									<div class="input-group">
									<form action="/update-quantity?id=${obj.id }" method="post">
										<div class="button minus">
											<a class="btn btn-sm btn-decre" href="/quantity?action=dec&id=${obj.id} ">
												<i class="ti-minus"></i>
											</a>
										</div>
										<input type="text"  name="quantity" class="input-number"  data-min="1" data-max="${obj.hair.quantity }"  value="${obj.quantity }"/>
										<div class="button plus">
											<a class="btn btn-sm btn-incre"  href="/quantity?action=inc&id=${obj.id } " >
												<i class="ti-plus"></i>
											</a>
											
										</div>
										
										
									<button  class="btn btn-primary ms-4">Update</button>
									</form>
									</div>
									
									
									<!--/ End Input Order -->
								</td>
								
								
								
								<td class="total-amount" data-title="Total">
									<span>${obj.quantity*obj.hair.price }</span>
								</td>
								
								<td class="action" data-title="Remove"><a href="/remove?id=${obj.id }"><i class="ti-trash remove-icon"></i></a></td>
								<!-- <td class="action" data-title="Remove"><a data-toggle="modal" data-target="#confirmationId"><i class="ti-trash remove-icon"></i></a></td> -->
							</tr>
							
							</c:forEach>
						</tbody>
					</table>
					
					<!--/ End Shopping Summery -->
				</div>
			</div>
			<div class="row">
				<div class="col-12">
					<!-- Total Amount -->
					<div class="total-amount">
						<div class="row">
							<div class="col-lg-8 col-md-5 col-12">
								<div class="left">
									<div class="coupon">
										<form action="#" target="_blank">
											<input name="Coupon" placeholder="Enter Your Coupon">
											<button class="btn">Apply</button>
										</form>
									</div>
									<div class="checkbox">
										<label class="checkbox-inline" for="2"><input name="news" id="2" type="checkbox"> Shipping (+10$)</label>
									</div>
								</div>
							</div>
							<div class="col-lg-4 col-md-7 col-12">
								<div class="right">
									<ul>
										<li>Cart Subtotal<span>${total }</span></li>
										<li>Shipping<span>Free</span></li>
										
										<li class="last">You Pay<span>${total }</span></li>
									</ul>
									<div class="button5">
										 <form action="/create/bill" method="post">
                						<button  class="btn btn-primary mb-4 btn-lg pl-5 pr-5">Thanh toán</button>
                						</form>
          
										<a href="${pageContext.request.contextPath }/user/sell/index" class="btn">Continue shopping</a>
									</div>
								</div>
							</div>
						</div>
					</div>
					<!--/ End Total Amount -->
				</div>
			</div>
		</div>
	</div>
	
	 	<script>
 	function showConfirmModalDialog(id){
 		  
 		  $('#yesOption').attr('href','/remove?id='+id);
 		  $("#confirmationId").modal('show');
 		}
 	</script>
 	
 	<div class="modal" id="confirmationId" tabindex="-1" role="dialog">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title">Xác nhận xoá?</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <p>Bạn có chắc muốn xoá?</p> 
      </div>
      <div class="modal-footer">
        <button id="yesOption type="button" class="btn btn-danger">Yes</button>
        <button type="button" class="btn btn-secondary" data-dismiss="modal">No</button>
      </div>
    </div>
  </div>
</div>