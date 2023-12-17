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
<h4>Add Participant Details</h4>
<form action="ParticipantController" method="post">
	<%
		BatchService bs = new BatchService();
		List<Batch> listOfBatches = bs.findAllBatches();
		Iterator<Batch> li = listOfBatches.iterator();
		if(li.hasNext() == false)
		{
	%>
		<label>No batches available to add participant</label>
	<%
		}
		else
		{
	%>
			<input type="hidden" name="operation" value="store">
			<label>Id</label>
			<input type="number" name="id"/>
			<br/><br/>
			<label>Name</label>
			<input type="text" name="name"/>
			<br/><br/>
			<label>eMail</label>
			<input type="email" name="email"/>
			<br/><br/>
			<label>Mobile</label>
			<input type="number" name="mobile"/>
			<br/><br/>
			<label>Choose Batch Id from below list:</label><br> 
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
			<input type="submit" value="add participant"/>
			<input type="reset" value="reset"/>
	<%
		}
	%>
</form>
<br/><br/>
<a href="participant.html">Back</a>	
</div>
</body>
</html>