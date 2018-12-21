<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %><%--
  Created by IntelliJ IDEA.
  User: hp
  Date: 2018/10/12
  Time: 0:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=GBK" language="java" %>
<html>
<head>
    <title>登录页</title>
    <script language="JavaScript">
        function validate(f) {
            if(!/^\w{5,15}$/.test(f.userid.value)){
                alert("用户id为空只能进行查看");
                f.userid.focus();
                return false;
            }
            if (!/^\w{5,15}$/.test(f.password.value)) {
                alert("密码为空只能进行查看");
                f.password.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<h2>用户登录程序</h2>
<form action="commend" method="post" onsubmit="validate(this)">
    用户账户名：<input type="text" name="username"><br>
    密码：<input type="password" name="password"><br>
    <input type="submit" value="登录">
    <input type="reset" value="重置">
</form>
</body>
</html>
