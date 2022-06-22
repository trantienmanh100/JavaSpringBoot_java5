
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form:form action="/hair/update/${hair.id}" method="post" 
modelAttribute="hair" enctype="multipart/form-data">
	
	
	<div>
		<span>Name:</span> 
		<form:input class="form-control" path="name"/>
	</div>
	<div>
		<span>Create Date:</span> 
		<form:input class="form-control" path="createDate"/>
	</div>
	<div>
		<span>HairType:</span> 
		<form:select class="form-control" path="type" items="${typeHair}"></form:select>
	</div>
	<div>
		<span>Color:</span> 
		<form:input class="form-control" path="color"/>
	</div>
	<div>
		<span>Price:</span> 
		<form:input class="form-control" path="price"/>
	</div>
	<div>
		<span>Length:</span> 
		<form:input class="form-control" path="length"/>
	</div>
	<div>
		<span>Quantity:</span> 
		<form:input class="form-control" path="quantity"/>
	</div>
	
	<div>
		<input class="form-control" type="file" name="imageFile" />
	</div>
	
	
<form:button class="btn btn-primary">Update</form:button>
	
	
	</form:form>
</body>
</html>