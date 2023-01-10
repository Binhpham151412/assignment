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
    <h3 class="text-center text-dark fw-bold mt-5">Danh Sách Đăng Ký Sử Dụng Dịch Vụ</h3>

    <c:if test="${not empty msg_deleteSDDV}">
        <span class="text-danger text-center">${msg_deleteSDDV}</span>
    </c:if>
    <c:if test="${not empty msg_saveSDDV}">
        <span class="text-success text-center">${msg_saveSDDV}</span>
    </c:if>
    <c:if test="${not empty msg_updateSDDV}">
        <span class="text-primary text-center">${msg_updateSDDV}</span>
    </c:if>

    <%--    search--%>
    <form class="input-group" action="${pageContext.request.contextPath}/su-dung-dich-vu/search" method="get">
        <input class="form-control" type="search" name="keyword" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-dark" type="submit">Search</button>
    </form>

    <div class="card-body">
        <table class="table table-bordered text-center">
            <thead class="table-bordered table-primary">
            <tr>
                <th>Mã Khách Hàng</th>
                <th>Mã Dịch Vụ</th>
                <th>Ngày Sử Dụng</th>
                <th>Giờ Sử Dụng</th>
                <th>Số Lượng</th>
                <th>Chỉnh Sửa</th>
                <th>Xóa</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSDDV}" var="item">
                <tr>
                    <td>${item.suDungDV_maKH.maKH}</td>
                    <td>${item.suDungDV_maDV.maDV}</td>
                    <td>${item.ngaySD}</td>
                    <td>${item.gioSD}</td>
                    <td>${item.soLuong}</td>
                    <td>
                        <button class="btn btn-dark">
                            <a style="text-decoration: none" class="text-white"
                               href="${pageContext.request.contextPath}/su-dung-dich-vu/edit?idKH=${item.suDungDV_maKH.maKH}&idDV=${item.suDungDV_maDV.maDV}&ngaySD=${item.ngaySD}&gioSD=${item.gioSD}">
                                Update
                            </a>
                        </button>
                    </td>
                    <td>
                        <button class="btn btn-danger">
                            <a style="text-decoration: none" class="text-white" onclick="return ConfirmDelete()"
                               href="${pageContext.request.contextPath}/su-dung-dich-vu/delete?idKH=${item.suDungDV_maKH.maKH}&idDV=${item.suDungDV_maDV.maDV}&ngaySD=${item.ngaySD}&gioSD=${item.gioSD}">
                                Delete
                            </a>
                        </button>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <a class="btn btn-dark float-start" href="${pageContext.request.contextPath}/su-dung-dich-vu/add">Đăng
                Ký Sử Dụng Dịch Vụ</a>
            <a class="btn btn-dark float-end" href="${pageContext.request.contextPath}/su-dung-dich-vu/list">Danh
                Sách Đăng Ký Dịch Vụ áđâs</a>
        </div>

        <%--        phân trang--%>
        <nav aria-label="Page navigation example">
            <div class="pagination d-flex justify-content-center">
                <c:if test="${currentPage > 1}">
                    <a class="page-link" href="list?page=${currentPage-1}">&laquo;</a>
                </c:if>

                <c:forEach begin="1" end="${totalPages}" var="i">
                    <c:choose>
                        <c:when test="${currentPage eq i}">
                            <a class="page-link"> ${i} </a>
                        </c:when>
                        <c:otherwise>
                            <a class="page-link" href="list?page=${i}">${i}</a>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>

                <c:if test="${currentPage lt totalPages}">
                    <a class="page-link" href="list?page=${currentPage+1}">&raquo;</a>
                </c:if>
            </div>
        </nav>
    </div>
</div>
</body>
<script>
    function ConfirmDelete() {
        return confirm("Are you sure you want to delete?");
    }
</script>
</html>
