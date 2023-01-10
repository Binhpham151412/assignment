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
<div class="container-fluid">
    <div class="row">
        <div>
            <h3 class="text-center text-danger fw-bold mt-5">Danh Sách Thông Tin Khách Hàng Sử Dụng Dịch Vụ</h3>
        </div>
        <div>
            <a class="btn btn-primary float-end col-sm-2" href="${pageContext.request.contextPath}/khach-hang/add">Thêm Người Dùng</a>
        </div>

    </div>


    <div class="card-body">
        <table class="table table-bordered text-center">
            <thead class="table-bordered table-primary">
            <tr>
                <th>Mã Khách Hàng</th>
                <th>Tên Khách Hàng</th>
                <th>Mã Máy</th>
                <th>Vị Trí</th>
                <th>Trạng Thái</th>
                <th>Ngày Bắt Đầu Sử Dụng Máy</th>
                <th>Giờ Bắt Đầu Sử Dụng Máy</th>
                <th>Thời Gian Sử Dụng</th>
                <th>Mã Dịch Vụ</th>
                <th>Ngày Sử Dụng</th>
                <th>Giờ Sử Dụng</th>
                <th>Số Lượng</th>
                <th>Tổng Tiền</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach items="${listSDDV}" var="item">
                <tr>
                    <td>${item[0]}</td>
                    <td>${item[1]}</td>
                    <td>${item[2]}</td>
                    <td>${item[3]}</td>
                    <td>${item[4]}</td>
                    <td>${item[5]}</td>
                    <td>${item[6]}</td>
                    <td>${item[7]}</td>
                    <td>${item[8]}</td>
                    <td>${item[9]}</td>
                    <td>${item[10]}</td>
                    <td>${item[11]}</td>
                    <td>${item[12]}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <div class="mt-3">
            <a class="btn btn-primary float-start" href="${pageContext.request.contextPath}/su-dung-dich-vu/add">Đăng Ký
                Sử Dụng Dịch Vụ</a>

            <a class="btn btn-primary float-end" href="${pageContext.request.contextPath}/dang-ky-su-dung-may/add">Đăng Ký Sử
                Dụng Máy</a>
        </div>
    </div>
    <%--        phân trang--%>
    <div class="pagination">
        <c:if test="${currentPage > 1}">
            <a href="list?page=${currentPage-1}">Previous</a>
        </c:if>
        <c:forEach begin="1" end="${totalPages}" var="i">
            <c:choose>
                <c:when test="${currentPage eq i}">
                    <a class="active"> ${i} </a>
                </c:when>
                <c:otherwise>
                    <a href="list?page=${i}">${i}</a>
                </c:otherwise>
            </c:choose>
        </c:forEach>

        <c:if test="${currentPage lt totalPages}">
            <a href="list?page=${currentPage+1}">Next</a>
        </c:if>
    </div>
</div>
</body>
<script>
    function ConfirmDelete() {
        return confirm("Are you sure you want to delete?");
    }
</script>
</html>
