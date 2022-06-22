




<section class="single-hair">
	<div class="container">
		<div class="row mb-5" >
			
			
		</div>
		<br> <br>
		<div class="row mt-20">
			<div class="col-md-5">
				<div class="single-hair">
												
					<div class="hair-img">
						<a > <!-- sản phẩm chi tiết -->
						
							<img class="default-img"  src="/images/${hair.imageUrl}" alt="#">
							<img class="hover-img"  src="/images/${hair.imageUrl}" alt="#">
						</a>
					</div>
					</div>
			</div>
			
			<div class="col-md-7">
				<div class="single-hair-details">
				<form action="/cart/${hair.id}" method="post">
					<h1>${hair.name }</h1>
					<p class="hair-price " >${hair.price } vnd</p>
					
					<p class="hair-description mt-20">
						Lorem ipsum dolor sit amet, consectetur adipisicing elit. Laborum ipsum dicta quod, quia doloremque aut deserunt commodi quis. Totam a consequatur beatae nostrum, earum consequuntur? Eveniet consequatur ipsum dicta recusandae.
					</p>
					<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nesciunt, velit, sunt temporibus, nulla accusamus similique sapiente tempora, at atque cumque assumenda minus asperiores est esse sequi dolore magnam. Debitis, explicabo.</p>
					<div class="color-swatches">
						<span>Color: ${hair.color }</span>
						
					</div>
				
					<div class="hair-quantity">
						<span>Quantity:</span>
						<div class="hair-quantity-slider">
							<input id="hair-quantity" class="input-number" type="text" value="1" data-min="0" data-max="${hair.quantity }" name="quantity">
							<span>${hair.quantity } pieces available</span>
						</div>
						
					</div>
					
					<div class="hair-type">
						<span>Type: ${hair.type }</span>
						
					</div>
					<div class="hair-length mb-3">
						<span>Length: ${hair.length }</span>
						
					</div>
					
					<button class="btn btn-main mt-5">Add To Cart</button>
					</form>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="tabCommon mt-20">
					
					<div class="tab-content patternbg">
						<div id="details" class="tab-pane fade active in">
							<h4>Product Description</h4>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum. Sed ut per spici</p>
							<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Veritatis delectus quidem repudiandae veniam distinctio repellendus magni pariatur molestiae asperiores animi, eos quod iusto hic doloremque iste a, nisi iure at unde molestias enim fugit, nulla voluptatibus. Deserunt voluptate tempora aut illum harum, deleniti laborum animi neque, praesentium explicabo, debitis ipsa?</p>
						</div>
						<div id="reviews" class="tab-pane fade">
							<div class="post-comments">
						    	<ul class="media-list comments-list m-bot-50 clearlist">
								    

	

							</ul>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</section>



