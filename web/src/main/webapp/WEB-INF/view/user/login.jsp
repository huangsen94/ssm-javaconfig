<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="../common/header.jsp"%>
<div class="main">
  <form id="loginForm" class="loginForm" action="${basePath}/user/login" method="post">
    <div>
      <label>用户名：</label>
      <input name="userName" type="text"/>
    </div>
    <div>
      <label>密码：</label>
      <input name="passWord" type="password"/>
    </div>
    <div>
      <button type="submit">登录</button>
      <a href="${basePath}/user/registerPage" target="_blank">注册</a>
    </div>
  </form>
</div>
<%@include file="../common/footer.jsp"%>
