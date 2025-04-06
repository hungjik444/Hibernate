<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Đăng ký</title>
    <link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h2>Đăng ký</h2>
    <div class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <div class="form-container">
        <html:form action="/doRegister">
            <p>
                <label>Tên đăng nhập:</label>
                <html:text property="username" value=""/>
            </p>
            <p>
                <label>Mật khẩu:</label>
                <html:password property="password" value=""/>
            </p>
            <p>
                <html:submit value="Đăng ký"/>
            </p>
        </html:form>

        <a href="login.do" class="login-link">Quay lại đăng nhập</a>
    </div>
</body>
</html>