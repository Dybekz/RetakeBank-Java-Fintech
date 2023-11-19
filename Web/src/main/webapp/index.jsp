<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Sistema de Gerenciamento Financeiro</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<div class="container">
    <h1 class="text-center my-4">Bem-vindo ao Sistema de Gerenciamento Financeiro</h1>

    <!-- Dados do cartão -->
    <div class="card">
        <div class="card-header">
            <i class="bi bi-credit-card-fill"></i> Dados do Cartão
        </div>
        <div class="card-body">
            <form action="CartaoServlet" method="post">
                <div class="mb-3">
                    <label for="nm_cartao" class="form-label">Número do Cartão</label>
                    <input type="text" class="form-control" id="nm_cartao" name="nm_cartao" required>
                </div>
                <div class="mb-3">
                    <label for="nr_cartao" class="form-label">Nome do Cartão</label>
                    <input type="text" class="form-control" id="nr_cartao" name="nr_cartao" required>
                </div>
                <div class="mb-3">
                    <label for="vld_cartao" class="form-label">Validade do Cartão</label>
                    <input type="text" class="form-control" id="vld_cartao" name="vld_cartao" required>
                </div>
                <div class="mb-3">
                    <label for="cvv_cartao" class="form-label">CVV do Cartão</label>
                    <input type="text" class="form-control" id="cvv_cartao" name="cvv_cartao" required>
                </div>
                <button type="submit" class="btn btn-primary">Enviar</button>
            </form>
        </div>
    </div>

    </form>
        </div>
    </div>

    <!-- Adicione mais campos conforme necessário -->
                <button type="submit" class="btn btn-primary">Salvar</button>
            </form>
        </div>
    </div>

    <!-- Saldo atual -->
    <div class="card">
        <div class="card-header">
            <i class="bi bi-wallet-fill"></i> Saldo Atual
        </div>
        <div class="card-body">
            <!-- Aqui você pode adicionar o código para exibir o saldo atual -->
            <p>Seu saldo atual é: <%= request.getAttribute("saldo") %></p>
        </div>
    </div>

<!-- Investimentos pessoais -->
<div class="card">
    <div class="card-header">
        <i class="bi bi-bar-chart-fill"></i> Investimentos Pessoais
    </div>
    <div class="card-body">
        <form action="InvestimentoServlet" method="post">
            <div class="mb-3">
                <label for="investimentos" class="form-label">Investimentos</label>
                <input type="text" class="form-control" id="investimentos" name="investimentos">
            </div>
            <div class="mb-3">
                <label for="sld_investimento" class="form-label">Saldo do Investimento</label>
                <input type="text" class="form-control" id="sld_investimento" name="sld_investimento">
            </div>
            <button type="submit" class="btn btn-primary">Salvar</button>
        </form>
    </div>
</div>


<!-- Crédito total -->
    <div class="card">
        <div class="card-header">
            <i class="bi bi-cash-stack"></i> Crédito Total
        </div>
        <div class="card-body">
            <!-- Aqui você pode adicionar o código para exibir o crédito total -->
            <p>Seu crédito total é: <%= request.getAttribute("credito") %></p>
        </div>
    </div>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
        crossorigin="anonymous"></script>
</body>
</html>
