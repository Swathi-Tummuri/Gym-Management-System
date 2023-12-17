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
</head>
<body>
<h2>Batch Details</h2>
<%
		BatchService bs = new BatchService();
		List<Batch> listOfBatches = bs.findAllBatches();
		Iterator<Batch> li = listOfBatches.iterator();
		if(li.hasNext() == false)
		{
%>
		<label>No batches available to display</label>
<%
		}
		else
		{
%>
		<table border="1">
				<tr>
					<th>BatchId</th>
					<th>Timing</th>
					<th>Instructor</th>
				</tr>
				<%
					li = listOfBatches.iterator();
					while(li.hasNext()){
						Batch bch = li.next();
						%>
						<tr>
							<td><%=bch.getBatchid() %></td>
							<td><%=bch.getTiming() %></td>
							<td><%=bch.getInstructor() %></td>
						</tr>
						<%
					}
				%>
		</table>
<%
		}
%>
<br/><br/>
<a href="batch.html">Back</a>
</body>
</html>