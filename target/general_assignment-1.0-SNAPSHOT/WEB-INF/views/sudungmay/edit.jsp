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
    <h3 class="text-center text-secondary fw-bold mt-5">Chỉnh Sửa Thông Tin Sử Dụng Máy </h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="SDMForm" method="post"
                action="${pageContext.request.contextPath}/dang-ky-su-dung-may/edit/save">
            <div class="col">
                <s:label path="suDungMay_khachHang.maKH" class="form-label">Mã Khách Hàng</s:label>
                <s:input path="suDungMay_khachHang.maKH" type="text" readonly="true"
                         value="${SDMForm.suDungMay_khachHang.maKH}"
                         class="form-select"/>
                <s:errors path="suDungMay_khachHang.maKH" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="suDungMay_may.maMay" class="form-label">Mã Máy</s:label>
                <s:input path="suDungMay_may.maMay" type="text" readonly="true" value="${SDMForm.suDungMay_may.maMay}"
                         class="form-select"/>
                <s:errors path="suDungMay_may.maMay" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="ngayBDSD" class="form-label">Ngày BDSD</s:label>
                <s:input path="ngayBDSD" readonly="true" value="${SDMForm.ngayBDSD}" type="text" class="form-control"/>
                <s:errors path="ngayBDSD" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="gioBDSD" class="form-label">Giờ BDSD</s:label>
                <s:input path="gioBDSD" readonly="true" value="${SDMForm.gioBDSD}" type="text" class="form-control"/>
                <s:errors path="gioBDSD" type="text" class="text-danger"/>
            </div>

            <div class="col mb-3">
                <s:label path="thoiGianSD" class="form-label">Thời Gian SD</s:label>
                <s:input path="thoiGianSD" type="text" value="${SDMForm.thoiGianSD}" class="form-control"/>
                <s:errors path="thoiGianSD" type="text" class="text-danger"/>
            </div
            <div class="">
                <a class="btn btn-secondary float-start"
                   href="${pageContext.request.contextPath}/dang-ky-su-dung-may/list">Trở Lại</a>
                <s:button type="submit" class="btn btn-secondary float-end">Thêm Khách Hàng</s:button>
            </div>
        </s:form>
    </div>
</div>
</body>
</html>
