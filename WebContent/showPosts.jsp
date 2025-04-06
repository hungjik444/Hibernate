<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách bài viết</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
</head>
<body>
    <h2>Danh sách bài viết</h2>
    <div class="error-message">
        <%= request.getAttribute("error") != null ? request.getAttribute("error") : "" %>
    </div>

    <c:if test="${empty posts}">
        <p class="no-posts">Không có bài viết nào trong cơ sở dữ liệu.</p>
    </c:if>

    <c:if test="${not empty posts}">
        <table>
            <tr>
                <th>ID</th>
                <th>Tiêu đề</th>
                <th>Nội dung</th>
                <th>Ngày tạo</th>
                <th>Hành động</th>
            </tr>
            <c:forEach var="post" items="${posts}">
                <tr>
                 <td>${post.id}</td>
                 <td>${post.title}</td>
                 <td>${post.body}</td>
                 <td><fmt:formatDate value="${post.createdAt}" pattern="dd/MM/yyyy HH:mm:ss" /></td>
                 <td class="action-buttons">
                   <a href="editPost.do?id=${post.id}">Sửa</a>
                   <a href="deletePost.do?id=${post.id}" class="delete" onclick="return confirm('Bạn có chắc muốn xóa bài viết này?')">Xóa</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    <p>
        <a href="createPost.do" class="create-link">Tạo bài viết mới</a>
        <a href="login.do" class="login-link">Quay lại đăng nhập</a>
    </p>
</body>
</html>
