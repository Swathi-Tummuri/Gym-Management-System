<%@page import="java.util.Iterator"%>
<%@page import="com.gms.bean.Batch"%>
<%@page import="java.util.List"%>

<%@page import="com.gms.service.BatchService"%>

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
<h4>Delete Batch Information</h4>
<form action="BatchController" method="post">
	<%
		BatchService bs = new BatchService();
		List<Batch> listOfBatches = bs.findAllBatches();
		Iterator<Batch> li = listOfBatches.iterator();
		if(li.hasNext() == false)
		{
	%>
		<label>No batches available to delete</label>
	<%
		}
		else
		{
	%>
			<input type="hidden" name="operation" value="delete">
			<label>Choose Batch Id from below list to delete:</label><br> 
	<%
			li = listOfBatches.iterator();	
			while(li.hasNext()){
				Batch bch = li.next();
				%>
					<input type="radio" name="batchid" value=<%=bch.getBatchid()%>>
					<label><%=bch.getBatchid()%>(<%=bch.getTiming() %>)</label>
					<br>
				<%
			}
	%>
			<br/><br/>
			<input type="submit" value="delete batch"/>
			<input type="reset" value="reset"/>
	<%
		}
	%>
</form>
<br/><br/>
<a href="batch.html">Back</a>
</div>
</body>
</html>