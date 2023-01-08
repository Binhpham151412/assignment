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
    <h3 class="text-center text-success fw-bold mt-5">Danh Sách Dịch Vụ</h3>

    <c:if test="${not empty msg_delete}">
        <span class="text-success text-center">${msg_delete}</span>
    </c:if>
    <c:if test="${not empty msg_update}">
        <span class="text-success text-center">${msg_update}</span>
    </c:if>

    <%--    search--%>
    <form class="input-group" action="${pageContext.request.contextPath}/dich-vu/search" method="get">
        <input class="form-control" type="search" name="keyword" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success" type="submit">Search</button>
    </form>

    <div class="card-body">
        <table class="table table-bordered text-center">
            <thead class="table-bordered table-primary">
            <tr>
                <th>Mã Dịch Vụ</th>
                <th>Tên Dịch Vụ</th>
                <th>Đơn Vị Tính</th>
                <th>Đơn Giá</th>
                <th>Chỉnh Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listDV}" var="item">
                <tr>
                    <td>${item.maDV}</td>
                    <td>${item.tenDV}</td>

                    <c:choose>
                        <c:when test="${item.donViTinh==0}">
                            <td>VND</td>
                        </c:when>
                        <c:when test="${item.donViTinh == 1}">
                            <td>$</td>
                        </c:when>
                        <c:otherwise>
                            <td>¥</td>
                        </c:otherwise>
                    </c:choose>

                    <td>${item.donGia}</td>
                    <td>
                        <button class="btn btn-success">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/dich-vu/edit/${item.maDV}">Update
                            </a>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/dich-vu/delete/${item.maDV}">Delete
                            </a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <a class="btn btn-success float-start" href="${pageContext.request.contextPath}/dich-vu/add">Thêm Dịch
                Vụ</a>
            <a class="btn btn-success float-end" href="${pageContext.request.contextPath}/khach-hang/list">Danh Sách Khách
                Hàng</a>
        </div>
    </div>

</div>
</body>
</html>
