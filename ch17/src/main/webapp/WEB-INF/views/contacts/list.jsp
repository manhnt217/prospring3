<?xml version="1.0" encoding="UTF-8" standalone="no" ?>
<div xmlns:jsp="http://java.sun.com/JSP/Page"
	xmlns:c="http://java.sun.com/jsp/jstl/core"
	xmlns:joda="http://www.joda.org/joda/time/tags" version="2.0">
	<jsp:directive.page contentType="text/html; charset=UTF-8" />
	<jsp:output omit-xml-declaration="true" />
	<H1>Contact Listing</H1>
	<c:if test="${not empty contacts}">
		<table>
			<THEAD>
				<TR>
					<TH>First Name</TH>
					<TH>Last Name</TH>
					<TH>Birth Date</TH>
				</TR>
			</THEAD>
			<TBODY>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<TD>${contact.firstName}</TD>
						<TD>${contact.lastName}</TD>
						<TD><joda:format value="${contact.birthDate}"
								pattern="yyyy-MM-dd" /></TD>
					</tr>
				</c:forEach>
			</TBODY>
		</table>
	</c:if>
</div>