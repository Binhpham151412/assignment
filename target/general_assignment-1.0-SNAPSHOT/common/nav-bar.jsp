<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 06/01/2023
  Time: 8:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="container-fluid">
    <nav class="navbar navbar-expand-lg navbar-light bg-light">
        <div class="container-fluid">
            <a class="navbar-brand fw-bold" href="${pageContext.request.contextPath}/home">Assignment JAVA WEB</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
                    data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent"
                    aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                    <!-- Example single danger button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-primary dropdown-toggle" data-bs-toggle="dropdown">MÁY
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/may/add">Thêm Máy</a>
                            </li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/may/list">Danh Sách
                                Máy</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Example single danger button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-success dropdown-toggle" data-bs-toggle="dropdown">
                            DỊCH VỤ
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dich-vu/add">Thêm Dịch
                                Vụ</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/dich-vu/list">Danh
                                Sách Dịch Vụ</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Example single danger button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-warning dropdown-toggle" data-bs-toggle="dropdown">KHÁCH
                            HÀNG
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/khach-hang/add">Thêm
                                Khách Hàng</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/khach-hang/list">Danh
                                Sách Khách Hàng</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Example single danger button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-secondary dropdown-toggle" data-bs-toggle="dropdown">Sử
                            Dụng Máy
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/dang-ky-su-dung-may/add">Đăng Ký Sử Dụng
                                Máy</a></li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/dang-ky-su-dung-may/list">Danh Sách Sử Dụng
                                Máy</a>
                            </li>
                        </ul>
                    </div>
                    <!-- Example single danger button -->
                    <div class="btn-group">
                        <button type="button" class="btn btn-dark dropdown-toggle" data-bs-toggle="dropdown">Sử
                            Dụng Dịch Vụ
                        </button>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/su-dung-dich-vu/add">Đăng Ký Sử Dụng
                                Dịch Vụ</a></li>
                            <li><a class="dropdown-item"
                                   href="${pageContext.request.contextPath}/su-dung-dich-vu/list">Danh Sách Sử Dụng
                                Dịch Vụ</a>
                            </li>
                        </ul>
                    </div>
                    <div>
                        <a class="btn btn-primary"
                           href="${pageContext.request.contextPath}/su-dung-dich-vu/tat-ca-thong-tin" role="button">Tất
                            Cả Thông Tin</a>
                    </div>
                </ul>

                <%--                <form class="d-flex">--%>
                <%--                    <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">--%>
                <%--                    <button class="btn btn-outline-success" type="submit">Search</button>--%>
                <%--                </form>--%>
            </div>
            <h3 class="float-end text-primary">BinhPV7</h3>
        </div>
    </nav>
</div>



