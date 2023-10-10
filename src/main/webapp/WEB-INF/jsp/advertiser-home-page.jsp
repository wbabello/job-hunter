<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        input {
            width: 100%;
            padding: 10px;
            border: 1px solid black;
            border-radius: 4px;
            box-sizing: border-box;
            float: left;
            display: inline-block;
        }

        label {
            padding: 12px 12px 12px 12px;
            width: 150px;
            float: left;
            clear: left;
            text-align: left;
        }

        button {
            padding: 12px 20px;
            border-radius: 4px;
            box-sizing: border-box;
            cursor: pointer;
            width: 20%;
            float: right;
        }

        table, th, td {
            border: none;
            border-collapse: collapse;
            background-color: wheat;
            padding: 5px 5px 5px 5px;
        }
        th {
            text-align: left;
        }

    </style>
    <title>Job Hunter</title>
</head>
<body>
<div style="position: relative;">
    <span style="color: black; font-size: xxx-large; font-weight:bold; text-align: center;">Welcome, ${user.userName}</span>
    <span style="float: right; font-size: large;"> <a href="/logout"> Logout </a> </span>
    <br/><br/>
    <span style="color: black; font-size: xx-large; font-weight:bold; text-align: center;">Let's hire your next great candidate. Fast.</span>
    <span style="float: right; font-size: large;"> <a href="/advertiser/job/new">+ Post a job </a> </span>
    <br/><br/>

    <table style="border: 3px solid black; width: 70%">
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
                Status
            </th>
        </tr>
        <c:forEach var="job" items="${jobList}">
            <tr>
                <td>
                    <a href="/advertiser/job/${job.id}/edit" style="color: mediumpurple; text-decoration: none; font-weight:bold;">
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
                    <c:out value="${job.status}" />
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
