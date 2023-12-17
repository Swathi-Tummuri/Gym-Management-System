<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gym Management Solution</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
<div class="container">
<h4>Add Batch Details</h4>
<form action="BatchController" method="post">
	<input type="hidden" name="operation" value="store">
	<label>BatchId</label>
	<input type="number" name="batchid"/>
	<br/><br/>
	<label>Timing</label>
	<input type="text" name="timing"/>
	<br/><br/>
	<label>Instructor</label>
	<input type="text" name="instructor"/>
	<br/><br/>
	<input type="submit" value="add batch"/>
	<input type="reset" value="reset"/>
</form>
<br/><br/>
<a href="batch.html">Back</a>	
</div>
</body>
</html>