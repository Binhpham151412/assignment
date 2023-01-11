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
    <h3 class="text-center text-primary fw-bold mt-5">Thêm Dịch Vụ</h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="dichVuForm" method="post"
                action="${pageContext.request.contextPath}/dich-vu/add">
            <div class="col">
                <s:label path="maDV" class="form-label">Mã Dịch Vụ</s:label>
                <s:input path="maDV" type="text" class="form-control"/>
                <s:errors path="maDV" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="tenDV" class="form-label">Tên Dịch Vu</s:label>
                <s:input path="tenDV" type="text" class="form-control"/>
                <s:errors path="tenDV" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="donViTinh" class="form-label">Đơn Vị Tính</s:label>
                <s:select path="donViTinh" class="form-select">
                    <s:option value="0">VND</s:option>
                    <s:option value="1">$</s:option>
                    <s:option value="2">¥</s:option>
                </s:select>
                <s:errors path="donViTinh" type="text" class="text-danger"/>
            </div>
            <div class="col mb-3">
                <s:label path="donGia" class="form-label">Đơn Giá</s:label>
                <s:input path="donGia" type="number" class="form-control"/>
                <s:errors path="donGia" type="text" class="text-danger"/>
            </div
            <div class="">
                <a class="btn btn-primary float-start" href="${pageContext.request.contextPath}/dich-vu/list">Trở Lại</a>
                <s:button type="submit" class="btn btn-primary float-end">Thêm Dịch Vụ</s:button>
            </div>
        </s:form>
    </div>

</div>

</body>
</html>
