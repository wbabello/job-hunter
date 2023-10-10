<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        input, textarea, select {
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
            background: gray;
            color: white;
            box-sizing: border-box;
            cursor: pointer;
            width: 20%;
            float: right;
        }
        .cancel-button {
            padding: 12px 50px;
            border-radius: 4px;
            background: gray;
            color: white;
            box-sizing: border-box;
            cursor: pointer;
            margin-left: 50%;
            line-height: 40px;
            text-decoration: none;
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
    <span style="color: black; font-size: xx-large; font-weight:bold;">Post your Jobs</span>
    <span style="float: right; font-size: large;" ><a href="/advertiser">home</a></span>

    <form:form method="post" action="/advertiser/job/new" modelAttribute="job">
        <table style="width: 70%">
            <tr>
                <td>
                    <form:label path="title">Title </form:label>
                </td>
                <td>
                    <form:input path="title" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="companyName">Company </form:label>
                </td>
                <td>
                    <form:input path="companyName" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="location">Location </form:label>
                </td>
                <td>
                    <form:input path="location" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="type">Type </form:label>
                </td>
                <td>
                    <form:select path="type">
                        <form:option value="Full-Time" label="Full-Type"/>
                        <form:option value="Part-Time" label="Part-Time"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="description">Description </form:label>
                </td>
                <td>
                    <form:textarea path="description" />
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="salary">Salary </form:label>
                </td>
                <td>
                    <form:input path="salary" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <span><a href="/advertiser" class="cancel-button">Cancel</a> </span>
                    <form:button style="margin-right: 50px">Submit</form:button>
                </td>
            </tr>
        </table>
    </form:form>

</div>
</body>
