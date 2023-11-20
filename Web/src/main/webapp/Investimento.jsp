<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Formulário de Investimento</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/CSS/Investimento.css">
</head>
<body>
<div class="wrapper">
    <h2>Investimento</h2>
    <form action="${pageContext.request.contextPath}/InvestimentoServlet" method="post">
        <div class="input_group">
            <div class="input_box">
                <label>
                    <input type="text" name="investimentos" class="name" placeholder="Tipo de Investimento" required>
                </label>
            </div>
        </div>
        <div class="input_group">
            <div class="input_box">
                <label>
                    <input type="number" name="sld_investimento" class="name" placeholder="Saldo do Investimento" required>
                </label>
            </div>
        </div>
        <div class="input_group">
            <div class="input_box">
                <button type="submit">Registrar Investimento</button>
            </div>
        </div>
    </form>
</div>

</body>
</html>
