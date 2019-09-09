<%--
  Created by IntelliJ IDEA.
  User: SYEDS
  Date: 06/09/2019
  Time: 10:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CALCULATOR</title>
</head>
<body>

<h1>THIS IS A CALCULATOR</h1>

<form method='POST' action = 'calculator'>
    <p>${message}</p>
    <p>Result: ${result} <br/></p>

   <input type = 'number' name ='number' />
    <input type='submit' name= 'operation' value= 'Add' />
    <input type='submit' name= 'operation' value= 'Subtract' />
    <input type='submit' name= 'operation' value= 'Multiply' />
    <input type='submit' name= 'operation' value= 'Divide' />
    <br><p> ${lstAnswers} </p>




<p>

</p>

</form></body>
</html>
