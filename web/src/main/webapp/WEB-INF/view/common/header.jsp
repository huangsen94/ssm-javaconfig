<%--
  Created by IntelliJ IDEA.
  User: xqy
  Date: 2017/3/6
  Time: 22:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
  request.setAttribute("basePath", basePath);
%>
<script type="text/javascript">
  /* 全局常量 */
  window.globalConst = {
    baseUrl: "<%= basePath %>"
  };

</script>
<html>
  <head>
    <meta charset="UTF-8">
    <link rel="stylesheet" type="text/css" href="${basePath}/static/css/modules/user/user.css">
  </head>
  <body>