
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
		.error{
		color:red;
			}
</style>
</head>

<body>
<form:form action="/hair/save" method="post" modelAttribute="hair"
enctype="multipart/form-data">
	
	
	<div>
		<span>Name:</span> 
		<form:input class="form-control" path="name"/>
		<form:errors path="name" cssClass="error"></form:errors>
	</div>
	<%-- <div>
		<span>Create Date:</span> 
		<form:input class="form-control" path="createDate"/>
	</div> --%>
	<div>
		<span>HairType:</span> 
		<form:select class="form-control" path="type" items="${typeHair}"></form:select>
		
	</div>
	<div>
		<span>Color:</span> 
		<form:input class="form-control" path="color"/>
		<form:errors path="color" cssClass="error"></form:errors>
	</div>
	<div>
		<span>Price:</span> 
		<form:input class="form-control" path="price"/>
		<form:errors path="price" cssClass="error"></form:errors>
	</div>
	<div>
		<span>Length:</span> 
		<form:input class="form-control" path="length"/>
		<form:errors path="length" cssClass="error"></form:errors>
	</div>
	<div>
		<span>Quantity:</span> 
		<form:input class="form-control" path="quantity"/>
		<form:errors path="quantity" cssClass="error"></form:errors>
	</div>
	<div>
	<span>Image:</span>
		<input type="file" name="imageFile"  class="form-control"/>
		<p class="error">${error_photo }</p>
	</div>
	
	
	
<form:button class="btn btn-primary">Save</form:button>
	
	
	</form:form>
</body>
</html>