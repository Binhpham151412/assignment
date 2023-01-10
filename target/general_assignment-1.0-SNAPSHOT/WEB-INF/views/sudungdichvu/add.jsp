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
    <title>Đăng Ký Sử Dụng Dịch Vụ</title>
    <%@include file="../../../common/link.jsp" %>
</head>
<body>

<%@include file="../../../common/nav-bar.jsp" %>

<div class="container-md w-50">
    <h3 class="text-center text-dark fw-bold mt-5">Đăng Ký Sử Dụng Dịch Vụ</h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="SDDVForm" method="post"
                action="${pageContext.request.contextPath}/su-dung-dich-vu/add">
            <div class="col">
                <s:label path="suDungDV_maKH.maKH" class="form-label">Mã Khách Hàng</s:label>
                <s:select path="suDungDV_maKH.maKH" class="form-select">
                    <c:forEach items="${khachhang}" var="item">
                        <s:option value="${item.maKH}">${item.maKH}</s:option>
                    </c:forEach>
                </s:select>
                <s:errors path="suDungDV_maKH.maKH" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="suDungDV_maDV.maDV" class="form-label">Mã Dịch Vụ</s:label>
                <s:select path="suDungDV_maDV.maDV" class="form-select">
                    <c:forEach items="${dichvu}" var="item">
                        <s:option value="${item.maDV}">${item.maDV}</s:option>
                    </c:forEach>
                </s:select>
                <s:errors path="suDungDV_maDV.maDV" type="text" class="text-danger"/>
            </div>
            <div class="col mb-3">
                <s:label path="soLuong" class="form-label">Số Lượng</s:label>
                <s:input path="soLuong" type="number" class="form-control"/>
                <s:errors path="soLuong" type="text" class="text-danger"/>
            </div
            <div class="">
                <a class="btn btn-dark float-start" href="${pageContext.request.contextPath}/su-dung-dich-vu/list">Trở
                    Lại</a>
                <s:button type="submit" class="btn btn-dark float-end">Đăng Ký Sử Dụng Dịch Vụ</s:button>
            </div>
        </s:form>
    </div>

</div>

</body>
</html>
