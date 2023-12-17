<%@page import="java.util.Iterator"%>
<%@page import="com.gms.bean.Participant"%>
<%@page import="java.util.List"%>
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
<h4>Delete Participant Information</h4>
<%
		Object obj = session.getAttribute("obj");
		List<Participant> listOfParticipants = (List<Participant>)obj;
		Iterator<Participant> li = listOfParticipants.iterator();
		if(li.hasNext() == false)
		{
%>
		<label>No participants available to delete</label>
<%		
		}
		else
		{
%>
			<form action="ParticipantController" method="post">
				<input type="hidden" name="operation" value="delete">
				<label>Id</label>
				<input type="number" name="id"/><br/><br/>
				<input type="submit" value="delete participant"/>
				<input type="reset" value="reset"/>
			</form>
<%
		}
%>
<br/><br>
<a href="participant.html">Back</a>
</div>
</body>
</html>