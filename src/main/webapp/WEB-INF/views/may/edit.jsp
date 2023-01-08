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
    <h3 class="text-center text-primary fw-bold mt-5">Chỉnh Sửa Máy ${mayForm.maMay}</h3>
    <div class="card-body">
        <s:form class="container-fluid" modelAttribute="mayForm" method="post"
                action="${pageContext.request.contextPath}/may/edit/save">
            <div class="col">
                <s:label path="maMay" class="form-label">Mã Máy</s:label>
                <s:input path="maMay" type="text" value="${mayForm.maMay}" class="form-control" readonly="true"/>
                <s:errors path="maMay" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="trangThai" class="form-label">Trạng Thái</s:label>
                <s:select path="trangThai" value="${mayForm.trangThai}" class="form-select">
                    <c:choose>
                        <c:when test="${mayForm.trangThai == 0}">
                            Rảnh
                        </c:when>
                        <c:when test="${mayForm.trangThai == 1}">
                            Bận
                        </c:when>
                        <c:otherwise>
                            Đang Sửa Chữa
                        </c:otherwise>
                    </c:choose>
                    <s:option value="0">Rảnh</s:option>
                    <s:option value="1">Bận</s:option>
                    <s:option value="2">Đang Sửa</s:option>
                </s:select>
                <s:errors path="trangThai" type="text" class="text-danger"/>
            </div>
            <div class="col">
                <s:label path="viTri" class="form-label">Vị Trí</s:label>
                <s:input path="viTri" type="text" value="${mayForm.viTri}" class="form-control"/>
                <s:errors path="viTri" type="text" class="text-danger"/>
            </div>
            <div class="col mt-3">
                <a class="btn btn-primary float-start"
                   href="${pageContext.request.contextPath}/may/list">Trở Lại</a>
                <s:button type="submit" class="btn btn-primary float-end">Chỉnh Sửa Máy</s:button>
            </div>
        </s:form>
    </div>

</div>

</body>
</html>
