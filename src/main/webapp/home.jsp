<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>Konnect</title>
  <link rel="stylesheet" href="home.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/background.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/accounts.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/input.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/fonts.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/spacings.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/grid.css">
  <link rel="stylesheet" href="${pageContext.request.contextPath}/styles/buttons.css">
</head>

<body>
  <div class="bg-white w-vw h-vh relative flex align-center justify-center">
    <div class="flex flex-row align-center justify-center w-900 h-650">
      <div class="relative flex align-center justify-center w-400">
        <img class="absolute top-half left-half transform-half z-2" src="${pageContext.request.contextPath}/assets/images/konnect-logo-bg.svg" alt="logo-bg" width="460">
        <img src="${pageContext.request.contextPath}/assets/images/konnect-logo.svg" alt="logo" width="300" class="z-3">
      </div>

      <div class="flex flex-column align-center justify-center w-500 gap-18">
        <div class="dark-gray title lighter m-spacing uppercase text-center">Conectando todos os grupos</div>
        <div class="flex flex-column align-center justify-center w-full gap-0">
          <div class="xxl-title heavy xxs-height text-center nunito">A rede social verdadeira</div>
          <img src="${pageContext.request.contextPath}/assets/images/konnect-home-line.svg" alt="line">
        </div>
        <a href="login" class="button">
          <div id="login-button" class="btn primary-btn">Entrar</div>
        </a>
        <div class="flex flex-row gap-12">
          <p class="dark-gray">Não tem uma conta?</p>
          <a class="text-btn primary" href="${pageContext.request.contextPath}/register">Criar conta</a>
        </div>
      </div>
    </div>

    <div class="absolute w-full bottom-0 flex flex-row align-center justify-center gap-12 pb-12">
      <a href="register" class="button">
        <div id="register-button" class="btn tertiary-btn">Sobre</div>
      </a>
      <a href="login" class="button">
        <div id="login-button" class="btn tertiary-btn">Repositório</div>
      </a>
    </div>
  </div>




  <!-- <div class="bg-white flex relative">
    <div class="w-header flex flex-row justify-between align-center absolute top-0 pt-6 pb-6 pl-144 pr-144">
      <a href="home.jsp">
        <img src="${pageContext.request.contextPath}/assets/images/Konnect-logo.svg" alt="logo">
      </a>
      <div class="flex flex-row justify-end gap-6">
        <a href="register" class="button">
          <div id="register-button" class="btn secondary-btn">Cadastrar</div>
        </a>
        <a href="login" class="button">
          <div id="login-button" class="btn primary-btn">Entrar</div>
        </a>
      </div>
    </div>

    <div class="bg-white w-full min-h-100vh flex flex-column align-center pt-92 pl-144 pr-144">
      <div class="flex flex-row justify-center w-full">
        <div class="text-ctn h-full flex flex-column justify-center align-start">
          <p class="uppercase title">Conectando você e a seus grupos</p>
          <p class="xl-title">A verdadeira rede social</p>
        </div>

        <div class="img-ctn h-full flex justify-center align-start">
          <img class="phone" src="${pageContext.request.contextPath}/assets/images/Konnect-home.svg" alt="home">
        </div>
      </div>
    </div>
  </div> -->
</body>
<script src="home.js"></script>
