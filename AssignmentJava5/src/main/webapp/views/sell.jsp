<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

       <div class="product-area section">
            <div class="container">
				<div class="row">
					<div class="col-12">
						<div class="section-title">
							<h2>Trending Item</h2>
						</div>
					</div>
				</div>
				<div class="row">
					<div class="col-12">
						<div class="product-info">
							<div class="nav-main">
								<!-- Tab Nav -->
								<ul class="nav nav-tabs" id="myTab" role="tablist">
								<li class="nav-item"><a class="nav-link active" href="/hair/sale" role="tab">All</a></li>
								
								<c:forEach items="${typeHair}" var="obj"> 
								
									<li class="nav-item"><a class="nav-link "  href="/hair/sale?type=${obj}" role="tab">${obj}</a></li>
								
								</c:forEach>
								</ul>
								<!--/ End Tab Nav -->
							</div>
							<div class="tab-content" id="myTabContent">
								<!-- Start Single Tab -->
								<div class="tab-pane fade show active" id="man" role="tabpanel">
									<div class="tab-single">
										<div class="row">
										<c:forEach items="${page.content}" var="obj">
											<div class="col-xl-3 col-lg-4 col-md-4 col-12">
												
												<div class="single-product">
												
													<div class="product-img">
														<a href="/hair-single/${obj.id}"> <!-- sản phẩm chi tiết -->
														<!-- <img src="https://img2.thuthuatphanmem.vn/uploads/2019/01/02/toc-uon-xu-dai_113150407.jpg" alt="#"> -->
															<img class="default-img"  src="/images/${obj.imageUrl}" alt="#">
															<img class="hover-img"  src="/images/${obj.imageUrl}" alt="#">
														</a>
														<div class="button-head">
															<div class="product-action">
																<a data-toggle="modal" data-target="#exampleModal" title="Quick View" href="#"><i class=" ti-eye"></i><span>Quick Shop</span></a>
																<a title="Wishlist" href="#"><i class=" ti-heart "></i><span>Add to Wishlist</span></a>
																<a title="Compare" href="#"><i class="ti-bar-chart-alt"></i><span>Add to Compare</span></a>
															</div>
															<div class="product-action-2">
																<a title="Add to cart" href="/hair-single/${obj.id}">View detail</a>
															</div>
														</div>
													</div>
													
													<div class="product-content">
														<h3><a href="product-details.html">${ obj.name }</a></h3>
														<div class="product-price">
															<span>${ obj.price }</span>
														</div>
													</div>
												</div>
												
											</div>
											</c:forEach>
			<div class="row">
			<nav aria-label="Page navigation example">
			  <ul class="pagination col-1">
				 
		
			  	<li class="page-item"><a class="page-link" href="/hair/sale?pageNumber=0&type=${type}">First</a></li>
			    <c:if test="${page.getNumber() >0}"> 
			  	<li class="page-item"><a class="page-link" href="/hair/sale?pageNumber=${page.number-1 }&type=${type}">Previous</a></li>
			  	</c:if>
			  	<c:if test="${page.getNumber() ==0}"> 
			  	<li class="page-item disable"><a class="page-link" href="#">Previous</a></li>
			  	</c:if>
			    <li class="page-item disable"><a class="page-link" >${page.getNumber()+1 } / ${page.getTotalPages() }</a></li>
			    
			    <c:if test="${page.getNumber()<page.getTotalPages()-1}"> 
			  <li class="page-item"><a class="page-link" href="/hair/sale?pageNumber=${page.getNumber()+1 }&type=${type}">Next</a></li>
			  	</c:if>
			  	<c:if test="${page.getNumber()==page.getTotalPages()-1}"> 
			  	<li class="page-item disable"><a class="page-link" href="#">Next</a></li>
			  	</c:if>
			    
			    <li class="page-item"><a class="page-link" href="/hair/sale?pageNumber=${page.totalPages-1 }&type=${type}">Last</a></li>
			  
			  </ul>
			  
			</nav>
			</div>
											

										</div>
									</div>
								</div>
								<!--/ End Single Tab -->
							</div>
						</div>
					</div>
				</div>
            </div>
    </div>   
         