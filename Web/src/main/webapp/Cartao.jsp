<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Cartao</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Investimento.css">
    <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/font-awesome/4.2.0/css/font-awesome.min.css">
</head>

<body>
<div class="wrapper">
    <h2>Payment Form</h2>
    <form action="${pageContext.request.contextPath}/CartaoServlet" method="post">
        <div class="input_group">
            <div class="input_box">
                <input type="text" name="nm_cartao" class="name" placeholder="Nome do Titular do Cartão" required>
                <i class="fa fa-user icon"></i>
            </div>
        </div>
        <div class="input_group">
            <div class="input_box">
                <input type="tel" name="nr_cartao" class="name" placeholder="Número do Cartão 1111-2222-3333-4444" required>
                <i class="fa fa-credit-card icon"></i>
            </div>
        </div>
        <div class="input_group">
            <div class="input_box">
                <input type="tel" name="cvv_cartao" class="name" placeholder="CVC do Cartão 632" required>
                <i class="fa fa-user icon"></i>
            </div>
        </div>
        <div class="input_group">
            <div class="input_box">
                <input type="text" name="vld_cartao" placeholder="Data de Validade MM/AA" required class="name">
                <i class="fa fa-calendar icon" aria-hidden="true"></i>
            </div>
        </div>

        <div class="input_group">
            <div class="input_box">
                <button type="submit">Registrar Cartão</button>
            </div>
        </div>
    </form>
</div>

</body>

</html>
