<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ page isELIgnored="false" %>
<%@include file="../common/header.jsp"%>

<div class="main">
  <form id="loginForm" class="loginForm" action="${basePath}/user/register" method="post">
    <div>
      <label>用户名：</label>
      <input name="userName" type="text"/>
    </div>
    <div>
      <label>密码：</label>
      <input name="password" type="password"/>
    </div>
    <div>
      <label>密码：</label>
      <input name="rePassWord" type="password"/>
    </div>
    <div>
      <label>邮箱：</label>
      <input name="email" type="text"/>
    </div>
    <div>
      <button type="submit">注册</button>
    </div>
  </form>
</div>
<%@include file="../common/footer.jsp"%>
