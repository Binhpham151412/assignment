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
    <h3 class="text-center text-warning fw-bold mt-5">Danh Sách Đăng Ký Sử Dụng Máy</h3>

    <c:if test="${not empty msg_delete}">
        <span class="text-warning text-center">${msg_delete}</span>
    </c:if>
    <c:if test="${not empty msg_update}">
        <span class="text-warning text-center">${msg_update}</span>
    </c:if>

    <%--    search--%>
    <form class="input-group" action="${pageContext.request.contextPath}/dang-ky-su-dung-may/search" method="get">
        <input class="form-control" type="search" name="keyword" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-secondary" type="submit">Search</button>
    </form>

    <div class="card-body">
        <table class="table table-bordered text-center">
            <thead class="table-bordered table-primary">
            <tr>
                <th>Mã Khách Hàng</th>
                <th>Mã Máy</th>
                <th>Thời Gian SD</th>
                <th>Ngày Sử Dụng</th>
                <th>Giờ Bắt Đầu SD</th>
                <th>Chỉnh Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSDM}" var="item">
                    <td>${item.suDungMay_khachHang.tenKH}</td>
                    <td>${item.suDungMay_may.maMay}</td>
                    <td>${item.thoiGianSD}</td>
                    <td>${item.ngayBDSD}</td>
                    <td>${item.gioBDSD}</td>
                    <td>
                        <button class="btn btn-warning">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/dang-ky-su-dung-may/edit/sd">Update
                            </a>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/dang-ky-su-dung-may/delete/sdf">Delete
                            </a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <a class="btn btn-warning float-start" href="${pageContext.request.contextPath}/dang-ky-su-dung-may/add">Đăng Ký Thuê Máy</a>
            <a class="btn btn-warning float-end" href="${pageContext.request.contextPath}/dang-ky-su-dung-may/list">Danh Sách
                Đăng Ký Dịch Vụ</a>
        </div>
    </div>

</div>
</body>
</html>
