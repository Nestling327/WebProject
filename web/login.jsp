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
    <title>��¼ҳ</title>
    <script language="JavaScript">
        function validate(f) {
            if(!/^\w{5,15}$/.test(f.userid.value)){
                alert("�û�idΪ��ֻ�ܽ��в鿴");
                f.userid.focus();
                return false;
            }
            if (!/^\w{5,15}$/.test(f.password.value)) {
                alert("����Ϊ��ֻ�ܽ��в鿴");
                f.password.focus();
                return false;
            }
            return true;
        }
    </script>
</head>
<body>
<h2>�û���¼����</h2>
<form action="commend" method="post" onsubmit="validate(this)">
    �û��˻�����<input type="text" name="username"><br>
    ���룺<input type="password" name="password"><br>
    <input type="submit" value="��¼">
    <input type="reset" value="����">
</form>
</body>
</html>
