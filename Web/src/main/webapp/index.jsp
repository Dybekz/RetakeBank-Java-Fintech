<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Transações e Recebimentos</title>
</head>
<body>
<h1>Transações e Recebimentos</h1>
<form action="${pageContext.request.contextPath}/SaldoServlet" method="post">
    <h2>Recebimentos</h2>
    <label for="salario">Salário:</label><br>
    <input type="number" id="salario" name="salario" step="0.01" min="0"><br>
    <label for="rcb_extra">Recebimentos Extras:</label><br>
    <input type="number" id="rcb_extra" name="rcb_extra" step="0.01" min="0"><br>
    <h2>Transação</h2>
    <label for="valor">Valor:</label><br>
    <input type="number" id="valor" name="valor" step="0.01" min="0"><br>
    <label for="tipo">Tipo:</label><br>
    <input type="text" id="tipo" name="tipo"><br>
    <label for="descricao">Descrição:</label><br>
    <input type="text" id="descricao" name="descricao"><br>
    <input type="submit" value="Enviar">
</form>
</body>
</html>
