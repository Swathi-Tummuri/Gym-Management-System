<%@page import="java.util.Iterator"%>
<%@page import="com.gms.bean.Batch"%>
<%@page import="java.util.List"%>
<%@page import="com.gms.service.BatchService"%>
<%@page import="com.gms.bean.Participant"%>

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
<h4>Update Participant BatchId</h4>
<form action="ParticipantController" method="post">
	<%
		BatchService bs = new BatchService();
		List<Batch> listOfBatches = bs.findAllBatches();
		Iterator<Batch> li = listOfBatches.iterator();
		if(li.hasNext() == false)
		{
	%>
		<label>No batches available to update participant</label>
	<%
		}
		else 
		{
			Object obj = session.getAttribute("obj");
			List<Participant> listOfParticipants = (List<Participant>)obj;
			Iterator<Participant> lil = listOfParticipants.iterator();
			if(lil.hasNext() == false)
			{
	%>
			<label>No participants available to update</label>
	<%		
			}
			else
			{
	%>
				<input type="hidden" name="operation" value="update">
				<label>Id</label>
				<input type="number" name="id"/>
				<br/><br/>
				<label>Choose New Batch Id from below list:</label><br>
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
				<input type="submit" value="update participant batchid"/>
				<input type="reset" value="reset"/>
	<%
			}
		}
	%>
</form>
<br/><br/>
<a href="participant.html">Back</a>
</div>
</body>
</html>