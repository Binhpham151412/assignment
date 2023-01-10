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
    <h3 class="text-center text-success fw-bold mt-5">Chỉnh Sửa Dịch Vụ ${dichVuForm.maDV}</h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="dichVuForm" method="post"
                action="${pageContext.request.contextPath}/dich-vu/edit/save">
            <div class="col">
                <s:label path="maDV" class="form-label">Mã Dịch Vụ</s:label>
                <s:input path="maDV" type="text" readonly="true" value="${dichVuForm.maDV}" class="form-control"/>
                <s:errors path="maDV" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="tenDV" class="form-label">Tên Dịch Vu</s:label>
                <s:input path="tenDV" type="text" value="${dichVuForm.tenDV}" class="form-control"/>
                <s:errors path="tenDV" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="donViTinh" class="form-label">Đơn Vị Tính</s:label>
                <s:select path="donViTinh" value="${dichVuForm.donViTinh}" class="form-select">
                    <c:choose>
                        <c:when test="${dichVuForm.donViTinh == 0}">
                            VND
                        </c:when>
                        <c:when test="${dichVuForm.donViTinh == 1}">
                            $
                        </c:when>
                        <c:otherwise>
                            ¥
                        </c:otherwise>
                    </c:choose>
                    <s:option value="0">VND</s:option>
                    <s:option value="1">$</s:option>
                    <s:option value="2">¥</s:option>
                </s:select>
                <s:errors path="donViTinh" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="donGia" class="form-label">Vị Trí</s:label>
                <s:input path="donGia" type="text" value="${dichVuForm.donGia}" class="form-control"/>
                <s:errors path="donGia" type="text" class="text-danger"/>
            </div>
            <div class="col mt-3">
                <a class="btn btn-success float-start"
                   href="${pageContext.request.contextPath}/dich-vu/list">Trở Lại</a>
                <s:button type="submit" class="btn btn-success float-end">Chỉnh Sửa Dịch Vụ</s:button>
            </div>
        </s:form>
    </div>

</div>

</body>
</html>
