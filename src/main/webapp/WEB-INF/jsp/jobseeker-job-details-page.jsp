<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        textarea {
            width: 100%;
            padding: 10px;
            border: 1px solid black;
            border-radius: 4px;
            box-sizing: border-box;
            float: left;
            display: inline-block;
        }

        select {
            width: 48.5%;
            padding: 10px;
            border: 1px solid black;
            border-radius: 4px;
            box-sizing: border-box;
            float: right;
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
    <span style="color: black; font-size: xxx-large; font-weight:bold; text-align: center;">${job.title}</span>
    <span style="float: right; font-size: large;" ><a href="/jobSeekers">home</a></span>
    <br/><br/>
    <span style="color: black; font-size: x-large; text-align: center;">${job.companyName} - ${job.location}</span> <br/><br/>
    <span style="color: black; font-size: x-large; text-align: center;">Posted ${job.publishedDate} - ${job.type} - ${job.salary}</span> <br/><br/>
    <div style="font-size: x-large;  width:80%;" >${job.description}</div>

    <form:form method="post" action="/jobSeekers/job/${job.id}/apply" modelAttribute="appliedJob">
        <table style="width: 70%">
            <tr>
                <td style="text-align: left; font-weight:bold; font-size: x-large">
                    <form:label path="note">Note </form:label>
                </td>
                <td>
                    <form:textarea path="note" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <span><a href="/jobSeekers" class="cancel-button">Cancel</a> </span>
                    <form:button style="margin-right: 0px">Submit</form:button>
                </td>
            </tr>
        </table>
    </form:form>
</div>
</body>
