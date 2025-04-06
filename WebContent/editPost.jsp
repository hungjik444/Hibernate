<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<!DOCTYPE html>
<html>
<head>
    <title>Sửa bài viết</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h2>Sửa bài viết</h2>
    <div class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <div class="form-container">
        <html:form action="/updatePost">
            <html:hidden property="id" value="${postId}"/>
            <p>
                <label>Tiêu đề:</label>
                <html:text property="title" value="${title}"/>
            </p>
            <p>
                <label>Nội dung:</label>
                <html:textarea property="body" value="${body}"/>
            </p>
            <p>
                <html:submit value="Cập nhật"/>
            </p>
        </html:form>

        <a href="showPosts.do" class="back-link">Quay lại danh sách bài viết</a>
    </div>
</body>
</html>
