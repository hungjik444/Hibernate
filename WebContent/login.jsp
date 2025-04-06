<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng nhập</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h2>Đăng nhập</h2>
    <div class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <div class="form-container">
        <html:form action="/doLogin">
            <p>
                <label>Tên đăng nhập:</label>
                <html:text property="username" value=""/>
            </p>
            <p>
                <label>Mật khẩu:</label>
                <html:password property="password" value=""/>
            </p>
            <p>
                <html:submit value="Đăng nhập"/>
            </p>
        </html:form>

        <a href="register.do" class="register-link">Đăng ký tài khoản mới</a>
    </div>
</body>
</html>

