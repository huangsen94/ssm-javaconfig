<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8"%>
<%@include file="common/header.jsp"%>
<div class="container">
    <ul id="list"></ul>
</div>
<%@include file="common/footer.jsp"%>
<script type="text/javascript">
  $(function () {
    // 发起异步请求用户列表
    $.ajax({
      url: window.globalConst.baseUrl + "/user/getUserList?pageNum=1&pageSize=4",
      type: "post",
      dataType: "json",
      success: function (data) {
        if (data.code == 200) {
          data.data.forEach(function (user, index) {
            var $li = $("<li />").html(user.userName);
            $("#list").append($li);
          });
        }
      },
      error: function (e) {

      }
    });
  });
</script>
