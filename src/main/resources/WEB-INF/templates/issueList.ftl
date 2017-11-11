<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<table>
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Date</th>
    </tr>
    <#list issues as issue>
    <tr>
        <td>${issue.id}</td>
        <td>${issue.title[0..*10]}+++</td>
        <td>${issue.date?date}</td>
    </tr>
    </#list>
</table>
</body>
</html>