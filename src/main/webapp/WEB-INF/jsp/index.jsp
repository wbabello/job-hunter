<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <style>
        /* styles.css */

        form {
            background-color: #f0f0f0; /* Background color */
            border: 1px solid #ccc; /* Border */
            padding: 20px; /* Padding */
            max-width: 700px; /* Maximum width */
            margin: 0 auto; /* Center horizontally */
        }

        /* Style form elements (input, button, etc.) within the form if needed */
        form input  {
            width: 100%;
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        form select {
            width: 100%;
            padding: 10px;
            border: 1px solid black;
            border-radius: 4px;
            box-sizing: border-box;
        }

        form button {
            background-color: #3498db;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        table, th, td {
            border: none;
            border-collapse: collapse;
            padding: 5px 5px 5px 5px;
        }
        th {
            text-align: left;
        }

        .centered-span {
            font-weight: bold;
            color: #FF5733;
            font-size: 24px;
            /* Add more styles as needed */
        }

        .centered-container {
            display: flex;
            justify-content: center;
            align-items: center;
        }

        body {
            background-image: url('<%= request.getContextPath() %>/bg.jpg');
            background-size: cover;
            background-repeat: no-repeat;
            background-attachment: fixed;
        }


    </style>
    <title>Job Hunter</title>
</head>
<body>
<div class = "centered-container">
    <span class="centered-span" style="font-size: xxx-large;">Job Hunter</span>
</div>
<div class = "centered-container">
    <span class="centered-span" style="font-size: xx-large;">Find a job that works for you</span> <br/>
</div>
    <span style="color: red; font-size: large">${registerError}</span><br/><br/>
    <div class="form-style-3">
    <form:form method="post" action="/register" modelAttribute="registerUser">
        <table style="width: 40%">
            <tr>
                <th colspan="2" style="text-align: left; font-weight:bold; font-size: x-large">Register </th>
            </tr>
            <tr>
                <td>
                    <form:label path="userName">Name: </form:label>
                </td>
                <td>
                    <form:input path="userName"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email: </form:label>
                </td>
                <td>
                    <form:input path="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password">Password: </form:label>
                </td>
                <td>
                    <form:input path="password" type="password"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="confirmPassword" >Confirm PW: </form:label>
                </td>
                <td>
                    <form:input path="confirmPassword" type="password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:select path="type">
                        <form:option value="Job Seeker" label="Job Seeker"/>
                        <form:option value="Advertiser" label="Advertiser"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button class = "submit">Submit</form:button>
                </td>
            </tr>
        </table>
    </form:form>
    </div>
    <br/>

    <span style="color: red; font-size: large">${loginError}</span><br/>
    <form:form method="post" action="/login" modelAttribute="loginUser">
        <table style="width: 40%">
            <tr>
                <th colspan="2" style="text-align: left; font-weight:bold; font-size: x-large"> Log In </th>
            </tr>
            <tr>
                <td>
                    <form:label path="email">Email: </form:label>
                </td>
                <td>
                    <form:input path="email"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="password" >Password: </form:label>
                </td>
                <td>
                    <form:input path="password" type="password"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:select path="type">
                        <form:option value="Job Seeker" label="Job Seeker"/>
                        <form:option value="Advertiser" label="Advertiser"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <form:button class = "submit">Submit</form:button>
                </td>
            </tr>
        </table>
    </form:form>
</body>
