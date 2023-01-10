<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 07/01/2023
  Time: 2:51 PM
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
    <h3 class="text-center text-dark fw-bold mt-5">Chỉnh Sửa Thông Tin Sử Dụng Dịch Vụ </h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="SDDVForm" method="post"
                action="${pageContext.request.contextPath}/su-dung-dich-vu/edit/save">
            <div class="col">
                <s:label path="suDungDV_maKH.maKH" class="form-label">Mã Khách Hàng</s:label>
                <s:input path="suDungDV_maKH.maKH" type="text" readonly="true"
                         value="${SDDVForm.suDungDV_maKH.maKH}"
                         class="form-select"/>
                <s:errors path="suDungDV_maKH.maKH" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="suDungDV_maDV.maDV" class="form-label">Mã Dịch Vụ</s:label>
                <s:input path="suDungDV_maDV.maDV" type="text" readonly="true"
                         value="${SDDVForm.suDungDV_maDV.maDV}"
                         class="form-select"/>
                <s:errors path="suDungDV_maDV.maDV" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="ngaySD" class="form-label">Ngày Sử Dụng</s:label>
                <s:input path="ngaySD" readonly="true" value="${SDDVForm.ngaySD}" type="text" class="form-control"/>
                <s:errors path="ngaySD" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="gioSD" class="form-label">Giờ Sử Dụng</s:label>
                <s:input path="gioSD" readonly="true" value="${SDDVForm.gioSD}" type="text" class="form-control"/>
                <s:errors path="gioSD" type="text" class="text-danger"/>
            </div>

            <div class="col mb-3">
                <s:label path="soLuong" class="form-label">Số Lượng</s:label>
                <s:input path="soLuong" type="number" value="${SDDVForm.soLuong}" class="form-control"/>
                <s:errors path="soLuong" type="number" class="text-danger"/>
            </div
            <div class="">
                <a class="btn btn-dark float-start"
                   href="${pageContext.request.contextPath}/su-dung-dich-vu/list">Trở Lại</a>
                <s:button type="submit" class="btn btn-dark float-end">Chỉnh Sửa Thông Tin Sử Dụng Dịch Vụ</s:button>
            </div>
        </s:form>
    </div>
</div>
</body>
</html>
