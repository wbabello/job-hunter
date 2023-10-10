<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>


    </style>
    <title>Job Hunter</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xxx-large; font-weight:bold; text-align: center;">Welcome, ${user.userName}</span>
    <span style="float: right; font-size: large;"> <a href="/logout"> Logout </a> </span>
    <br/><br/>
    <span style="color: black; font-size: xx-large; font-weight:bold; text-align: center;">Boost your career Find your dream job</span>
    <br/><br/>

    <form:form method="GET" action="/jobSeekers" modelAttribute="query">
        <form:input path="value"/>
        <button class = "submit">Search</button>
    </form:form>

    <br/><br/>

    <table style="border: 3px solid black; width: 80%">
        <tr>
            <th>
                Title
            </th>
            <th>
                Company
            </th>
            <th>
                Location
            </th>
            <th>
                Type
            </th>
            <th>
                Date
            </th>
            <th>
                Salary
            </th>
        </tr>
        <c:forEach var="job" items="${jobList}">
            <tr>
                <td>
                    <a href="/jobSeekers/job/${job.id}/details" style="color: mediumpurple; text-decoration: none; font-weight:bold;">
                        <c:out value="${job.title}" />
                    </a>
                </td>
                <td>
                    <c:out value="${job.companyName}" />
                </td>
                <td>
                    <c:out value="${job.location}" />
                </td>
                <td>
                    <c:out value="${job.type}" />
                </td>
                <td>
                    <c:out value="${job.publishedDate}" />
                </td>
                <td>
                    <c:out value="${job.salary}" />
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
