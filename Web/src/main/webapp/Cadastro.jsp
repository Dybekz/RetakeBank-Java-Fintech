<%--
  Created by IntelliJ IDEA.
  User: lucas
  Date: 17/11/2023
  Time: 23:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/CSS/Cadastro.css">
    <title>Cadastro</title>
</head>
<body>
<section class="background-radial-gradient overflow-hidden">
<div class="container px-4 py-5 px-md-5 text-center text-lg-start my-5">
    <div class="row gx-lg-5 align-items-center mb-5">
        <div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
            <h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
                The best offer <br/>
                <span style="color: hsl(218, 81%, 75%)">for your business</span>
            </h1>
            <p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
                Mussum Ipsum, cacilds vidis litro abertis. Nec orci ornare consequat. Praesent lacinia ultrices
                consectetur. Sed non ipsum felis. Si num tem leite então bota uma pinga aí cumpadi! Interessantiss
                quisso pudia ce receita de bolis, mais bolis eu num gostis. Quem num gosta di mé, boa gentis num é.
            </p>
        </div>

        <div class="col-lg-6 mb-5 mb-lg-0 position-relative">
            <div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
            <div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

            <div class="card bg-glass">
                <div class="card-body px-4 py-5 px-md-5">
                    <form action="CadastroServlet" method="post">
                        <!-- 2 column grid layout with text inputs for the first and last names -->
                        <div class="row">
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="PrimeiroNome" name="PrimeiroNome" class="form-control"/>
                                    <label class="form-label" for="PrimeiroNome">Primeiro Nome</label>
                                </div>
                            </div>
                            <div class="col-md-6 mb-4">
                                <div class="form-outline">
                                    <input type="text" id="Sobrenome" name="Sobrenome" class="form-control"/>
                                    <label class="form-label" for="Sobrenome">Sobrenome</label>
                                </div>
                            </div>
                        </div>

                        <!-- Email input -->
                        <div class="form-outline mb-4">
                            <input type="email" id="Email" name="Email" class="form-control"/>
                            <label class="form-label" for="Email">Endereço de Email</label>
                        </div>

                        <!-- Password input -->
                        <div class="form-outline mb-4">
                            <input type="password" id="Senha" name="Senha" class="form-control"/>
                            <label class="form-label" for="Senha">Senha</label>
                        </div>

                        <!-- Checkbox -->
                        <div class="form-check d-flex justify-content-center mb-4">
                            <input class="form-check-input me-2" type="checkbox" value="" id="CheckBox"
                                   checked/>
                            <label class="form-check-label" for="CheckBox">
                                Subscribe to our newsletter
                            </label>
                        </div>

                        <!-- Submit button -->
                        <button type="submit" class="btn btn-primary btn-block mb-4">
                            Sign up
                        </button>

                        <!-- Register buttons -->
                        <div class="text-center">
                            <p>or sign up with:</p>
                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-facebook-f"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-google"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-twitter"></i>
                            </button>

                            <button type="button" class="btn btn-link btn-floating mx-1">
                                <i class="fab fa-github"></i>
                            </button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
</section>
<script src="https://kit.fontawesome.com/18ddde90c6.js" crossorigin="anonymous"></script>
</body>
</html>
