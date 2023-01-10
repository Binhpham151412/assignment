<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/01/2023
  Time: 10:04 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%@include file="../../../common/link.jsp" %>
</head>
<body>

<%@include file="../../../common/nav-bar.jsp" %>
<div class="container-fluid w-50 text-center">
    <h3 class="text-center text-warning fw-bold mt-5">Danh Sách Khách Hàng</h3>

    <c:if test="${not empty msg_delete}">
        <span class="text-warning text-center">${msg_delete}</span>
    </c:if>
    <c:if test="${not empty msg_update}">
        <span class="text-warning text-center">${msg_update}</span>
    </c:if>

    <%--    search--%>
    <form class="input-group" action="${pageContext.request.contextPath}/khach-hang/search" method="get">
        <input class="form-control" type="search" value="${keyword}" name="keyword" placeholder="Search"
               aria-label="Search">
        <button class="btn btn-outline-warning" type="submit">Search</button>
    </form>


    <div class="card-body">
        <table class="table table-bordered text-center">
            <thead class="table-bordered table-primary">
            <tr>
                <th>Mã Khách Hàng</th>
                <th>Tên Khách Hàng</th>
                <th>Số Điện Thoại</th>
                <th>Email</th>
                <th>Địa Chỉ</th>
                <th>Chỉnh Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSearch}" var="item">
            <tr>
                <td>${item.maKH}</td>
                <td>${item.tenKH}</td>
                <td>${item.soDT}</td>
                <td>${item.email}</td>
                <td>${item.diaChi}</td>
                <td>
                    <button class="btn btn-success">
                        <a style="text-decoration: none" class="text-white"
                           href="${pageContext.request.contextPath}/khach-hang/edit/${item.maKH}">Update
                        </a>
                    </button>
                </td>
                <td>
                    <button class="btn btn-danger">
                        <a style="text-decoration: none" class="text-white"
                           href="${pageContext.request.contextPath}/khach-hang/delete/${item.maKH}">Delete
                        </a>
                    </button>
                </td>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <a class="btn btn-warning float-start" href="${pageContext.request.contextPath}/home">Home</a>
            <a class="btn btn-warning float-end" href="${pageContext.request.contextPath}/dang-ky-su-dung-may/list">Danh
                Sách Đăng Ký Dịch Vụ</a>
        </div>
    </div>
</div>
</body>
</html>
