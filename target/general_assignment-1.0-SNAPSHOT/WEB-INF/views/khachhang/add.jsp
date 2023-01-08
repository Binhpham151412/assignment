<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/01/2023
  Time: 12:20 PM
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

<div class="container-md w-50">
    <h3 class="text-center text-warning fw-bold mt-5">Thêm Khách Hàng</h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="khachHangForm" method="post"
                action="${pageContext.request.contextPath}/khach-hang/add">
            <div class="col">
                <s:label path="maKH" class="form-label">Mã Khách Hàng</s:label>
                <s:input path="maKH" type="text" class="form-control"/>
                <s:errors path="maKH" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="tenKH" class="form-label">Tên Khách Hàng</s:label>
                <s:input path="tenKH" type="text" class="form-control"/>
                <s:errors path="tenKH" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="soDT" class="form-label">Số Điện Thoại</s:label>
                <s:input path="soDT" type="text" class="form-control"/>
                <s:errors path="soDT" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="email" class="form-label">Email</s:label>
                <s:input path="email" type="text" class="form-control"/>
                <s:errors path="email" type="text" class="text-danger"/>
            </div>
            <div class="col mb-3">
                <s:label path="diaChi" class="form-label">Địa Chỉ</s:label>
                <s:input path="diaChi" type="text" class="form-control"/>
                <s:errors path="diaChi" type="text" class="text-danger"/>
            </div
            <div class="">
                <a class="btn btn-warning float-start" href="${pageContext.request.contextPath}/khach-hang/list">Trở
                    Lại</a>
                <s:button type="submit" class="btn btn-warning float-end">Thêm Khách Hàng</s:button>
            </div>
        </s:form>
    </div>

</div>

</body>
</html>
