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
    <h3 class="text-center text-primary fw-bold mt-5">Danh Sách Máy</h3>

    <c:if test="${not empty msg_delete}">
        <span class="text-success text-center">${msg_delete}</span>
    </c:if>
    <c:if test="${not empty msg_update}">
        <span class="text-success text-center">${msg_update}</span>
    </c:if>

    <%--    search--%>
    <form class="input-group" action="${pageContext.request.contextPath}/may/search" method="get">
        <input class="form-control" type="search" value="${keyword}" name="keyword" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-primary" type="submit">Search</button>
    </form>


    <div class="card-body">
        <table class="table table-bordered text-center">
            <thead class="table-bordered table-primary">
            <tr>
                <th>Mã Máy</th>
                <th>Trạng Thái</th>
                <th>Vị Trí</th>
                <th>Chỉnh Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSearch}" var="item">
                <tr>
                    <td>${item.maMay}</td>

                        <%--                        dropdown--%>
                    <c:choose>
                        <c:when test="${item.trangThai==0}">
                            <td>Rảnh</td>
                        </c:when>
                        <c:when test="${item.trangThai == 1}">
                            <td>Bận</td>
                        </c:when>
                        <c:otherwise>
                            <td>Đang Sửa Chữa</td>
                        </c:otherwise>
                    </c:choose>

                    <td>${item.viTri}</td>
                    <td>
                        <button class="btn btn-primary">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/may/edit/${item.maMay}">Update
                            </a>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/may/delete/${item.maMay}">Delete
                            </a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <a class="btn btn-primary float-start" href="${pageContext.request.contextPath}/home">Home</a>
            <a class="btn btn-primary float-end" href="${pageContext.request.contextPath}/dich-vu/list">Danh Sách Dịch
                Vụ</a>
        </div>
    </div>
</div>
</body>
</html>
