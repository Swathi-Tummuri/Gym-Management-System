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
</head>
<body>
<h2>Participant Details</h2>
<%
		Object obj = session.getAttribute("obj");
		List<Participant> listOfParticipants = (List<Participant>)obj;
		Iterator<Participant> li = listOfParticipants.iterator();
		if(li.hasNext() == false)
		{
%>
		<label>No participants available to display</label>
<%		
		}
		else
		{
%>
			<table border="1">
					<tr>
						<th>Id</th>
						<th>Name</th>
						<th>Email</th>
						<th>Mobile</th>
						<th>BatchId</th>
					</tr>
					<%
						li = listOfParticipants.iterator();
						while(li.hasNext()){
							Participant ppt = li.next();
							%>
							<tr>
								<td><%=ppt.getId() %></td>
								<td><%=ppt.getName() %></td>
								<td><%=ppt.getEmail() %></td>
								<td><%=ppt.getMobile() %></td>
								<td><%=ppt.getBatchid() %></td>
							</tr>
							<%
						}
					%>
			</table>
<%
		}
%>
<br/><br>
<a href="participant.html">Back</a>
</body>
</html>