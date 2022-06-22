
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${pageContext.request.contextPath }/css/bootstrap.min.css">
</head>
<body ng-app="myapp" ng-controller="myController">

	
	<div class="nav-main">
		<!-- Tab Nav -->
		<ul class="nav nav-tabs" id="myTab" role="tablist">
		<li class="nav-item"><a class="nav-link active" href="/hair/list" role="tab">All</a></li>
		
		<c:forEach items="${typeHair}" var="obj"> 
		
			<li class="nav-item"><a class="nav-link "  href="/hair/list?type=${obj}" role="tab">${obj}</a></li>
		
		</c:forEach>
		</ul>
		<!--/ End Tab Nav -->
	</div>
<form action="/hair/delete-multiple-hair" method="post">
			<button class="btn btn-danger">Delete</button>
		
	<table class="table">
  <thead>
    <tr>
      <th scope="col">
        <div>
          <input type="checkbox" ng-model="selectAll">
        </div>
      </th>
      <th scope="col">STT</th>
      <th scope="col">Image</th>
      <th scope="col">Name</th>
      <th scope="col">Quantity</th>
      <th scope="col">Create Date</th>
      <th scope="col">HairType</th>
      <th scope="col">Color</th>
      <th scope="col">Price</th>
      <th scope="col">Length</th>
      <th scope="col">Action</th>
      
     
    </tr>
  </thead>
  <tbody>
  	<c:forEach var="hair" items="${page.content}" varStatus="loop" >
    	<tr>
    	  <td><input type="checkbox" name="select" value="${hair.id}" ng-checked="selectAll" /></td>
	      <td>${loop.index+1}</td>
	      <td><img alt="" width="100px" height="100px" src="/images/${hair.imageUrl}"> </td>
	      <td>${hair.name}</td>
	      <td>${hair.quantity}</td>
	      <td><fmt:formatDate pattern="dd-MM-yyyy" value="${hair.createDate}" /></td>
	      <td>${hair.type}</td>
	      <td>${hair.color}</td>
	      <td>${hair.price}</td>
	      <td>${hair.length}</td>
		  <td><a class="btn btn-primary" href="/hair/edit-hair/${hair.id}">Edit</a></td>
		  <td><a class="btn btn-danger" href="/hair/delete-hair/${hair.id}" id="deleteButton">Delete</a></td>
    	</tr>
   </c:forEach> 
   
  </tbody>
</table>
</form>
			<nav aria-label="Page navigation example">
			  <ul class="pagination">
				 
		
			  	<li class="page-item"><a class="page-link" href="/hair/list?pageNumber=0&type=${type}">First</a></li>
			    <c:if test="${page.getNumber() >0}"> 
			  	<li class="page-item"><a class="page-link" href="/hair/list?pageNumber=${page.number-1 }&type=${type}">Previous</a></li>
			  	</c:if>
			  	<c:if test="${page.getNumber() ==0}"> 
			  	<li class="page-item disable"><a class="page-link" href="#">Previous</a></li>
			  	</c:if>
			    <li class="page-item disable"><a class="page-link" >${page.getNumber()+1 } / ${page.getTotalPages() }</a></li>
			    
			    <c:if test="${page.getNumber()<page.getTotalPages()-1}"> 
			  <li class="page-item"><a class="page-link" href="/hair/list?pageNumber=${page.getNumber()+1 }&type=${type}">Next</a></li>
			  	</c:if>
			  	<c:if test="${page.getNumber()==page.getTotalPages()-1}"> 
			  	<li class="page-item disable"><a class="page-link" href="#">Next</a></li>
			  	</c:if>
			    
			    <li class="page-item"><a class="page-link" href="/hair/list?pageNumber=${page.totalPages-1 }&type=${type}">Last</a></li>
			  
			  </ul>
			  
			</nav>
			
	<div>
   			 <a class="btn btn-primary" href="/hair/new">New</a>
   			 
		
   			<!--  <a class="btn btn-danger" href="/hair/delete-multiple-hair">Delete</a> -->
   			 
   	</div>
<!--    	<script type="text/javascript">
   		$(document).ready(function(){
   	
   	     $('#checkBoxAll').click(function(){
   	           if($(this).is(":checked"))
   	                $('.chkCheckBox Id').prop('checked',true);
   	          else
   	                $('.chkCheckBox Id').prop('checked',false);
   	                 I
   	     });
   	     </script> -->
   	<div class="modal"tabindex="-1"role="dialog"id="deleteModal">
  <div class="modal-dialog"role="document">
     <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title">Confirm delete</h5>
          <button type="button"class="close"data-dismiss="modal"aria-label="Close">
             <span aria-hidden="true">&times;</span>
          </button>
        </div>
        <div class="modal-body">
          <p>Are you sure you want to delete this hair?</p>
       </div>
        <div class="modal-footer">
          <a href="" class="btn btn-danger" id="delRef"> Yes,Delete </a>
          <button type="button"class="btn btn-secondary"data-dismiss="modal">Close</button>
       </div>
     </div>
  </div>
</div>     
   <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/popper.min.js"></script>
	<script src="/js/angular.min.js"></script>
	<script src="${pageContext.request.contextPath }/js/bootstrap.min.js"></script>	
	<script >
	var app = angular.module("myapp",[]);
	app.controller("myController", function($scope) {
		$scope.selectAll = false;
		$scope.select = function() {
			$scope.selectAll = true;
			console.log($scope.selectAll);
		}
	});	
	
	$('.table #deleteButton').on("click",function(event){
	    event.preventDefault();
	    var href=$(this).attr('href');
	    $('#deleteModal #delRef').attr('href',href);
	    $('#deleteModal').modal();
	});
	</script> 
	
</body>
</html>