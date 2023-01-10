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
    <h3 class="text-center text-secondary fw-bold mt-5">Đăng Ký Sử Dụng Máy</h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="SDMForm" method="post"
                action="${pageContext.request.contextPath}/dang-ky-su-dung-may/add">
            <div class="col">
                <s:label path="suDungMay_khachHang.maKH" class="form-label">Mã Khách Hàng</s:label>
                <s:select path="suDungMay_khachHang.maKH" class="form-select">
                    <c:forEach items="${khachhang}" var="item">
                        <s:option value="${item.maKH}">${item.maKH}</s:option>
                    </c:forEach>
                </s:select>
                <s:errors path="suDungMay_khachHang.maKH" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="suDungMay_may.maMay" class="form-label">Mã Máy</s:label>
                <s:select path="suDungMay_may.maMay" class="form-select">
                    <c:forEach items="${may}" var="item">
                        <s:option value="${item.maMay}">${item.maMay}</s:option>
                    </c:forEach>
                </s:select>
                <s:errors path="suDungMay_may.maMay" type="text" class="text-danger"/>
            </div>
<%--            <div class="col">--%>
<%--                <s:label path="ngayBDSD" class="form-label">Ngày BDSD</s:label>--%>
<%--                <s:input path="ngayBDSD" type="text" class="form-control"/>--%>
<%--                <s:errors path="ngayBDSD" type="text" class="text-danger"/>--%>
<%--            </div>--%>
<%--            <div class="col">--%>
<%--                <s:label path="gioBDSD" class="form-label">Giờ BDSD</s:label>--%>
<%--                <s:input path="gioBDSD" type="text" class="form-control"/>--%>
<%--                <s:errors path="gioBDSD" type="text" class="text-danger"/>--%>
<%--            </div>--%>

            <div class="col mb-3">
                <s:label path="thoiGianSD" class="form-label">Thời Gian BDSD</s:label>
                <s:input path="thoiGianSD" type="text" class="form-control"/>
                <s:errors path="thoiGianSD" type="text" class="text-danger"/>
            </div
            <div class="">
                <a class="btn btn-secondary float-start" href="${pageContext.request.contextPath}/dang-ky-su-dung-may/list">Trở
                    Lại</a>
                <s:button type="submit" class="btn btn-secondary float-end">Đăng Ký Sử Dụng Máy</s:button>
            </div>
        </s:form>
    </div>

</div>

</body>
</html>
