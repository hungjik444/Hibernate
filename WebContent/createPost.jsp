<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Tạo bài viết</title>
    <link rel="stylesheet" href="css/styles.css">
</head>
<body>
    <h2>Tạo bài viết mới</h2>
    <div class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <div class="form-container">
        <html:form action="/doCreatePost">
            <p>
                <label>Tiêu đề:</label>
                <html:text property="title" value=""/>
            </p>
            <p>
                <label>Nội dung:</label>
                <html:textarea property="body" value=""/>
            </p>
            <p>
                <html:submit value="Tạo bài viết"/>
            </p>
        </html:form>

        <a href="showPosts.do" class="back-link">Quay lại danh sách bài viết</a>
    </div>
</body>
</html>
