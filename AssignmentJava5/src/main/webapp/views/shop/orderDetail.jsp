<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
   
   <ul class="nav">
  <li class="nav-item">
    <a class="nav-link " aria-current="page" href="${pageContext.request.contextPath }/user/bill/status?status=0">Đơn hàng chờ xác nhận</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath}/user/bill/status?status=1">Đơn hàng đang giao</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/user/bill/status?status=2">Đơn hàng đã giao</a>
  </li>
  <li class="nav-item">
    <a class="nav-link "href="${pageContext.request.contextPath }/user/bill/status?status=4">Đơn huỷ</a>
  </li>
</ul>

	<div class="card-body">
       <div class="table-responesive">
         
          <table class="table">
		  <thead>
		   <tr>
		    <th>Tên sản phẩm </th>
		    <th>Hình ảnh</th>
		    <th>Số lượng</th>
		    <th>Giá tiền</th>
		    <th>Thành tiền</th>

		   </tr>
		
		  </thead>
		  
		  <tbody>
		  <c:forEach var="obj" items="${listItems}">
		   <tr>
		    <td>${obj.hair.name }</td>
		    <td class="image" data-title="No"><img src="/images/${obj.hair.imageUrl}" alt="#" style="width: 100px"height="100px"></td>
		    <td>${obj.quantity}</td>
		    <td>${obj.hair.price }</td>
		    <td>${obj.hair.price*obj.quantity }</td>
		    
		   
	
		    
		   </tr> 
		  </c:forEach> 
 
		 
       </table>
          <h1>Tổng tiền: ${orderDetail.total }</h1>
        
       
       </div>
     </div>

   