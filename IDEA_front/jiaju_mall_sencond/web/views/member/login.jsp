<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge"/>
    <title>韩顺平教育-家居网购</title>
    <base href="<%=request.getContextPath() + "/"%>">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no"/>
    <link rel="stylesheet" href="assets/css/vendor/vendor.min.css"/>
    <link rel="stylesheet" href="assets/css/plugins/plugins.min.css"/>
    <link rel="stylesheet" href="assets/css/style.min.css"/>
    <%-- 先搞定前端校验 --%>
    <script type="text/javascript" src="script/jquery-3.6.0.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#sub-btn").click(function () {
                // 1. 验证用户名：必须字母，数字下划线组成，并且长度为 6 到10 位=》正则表达式
                let username = $("#username").val();
                var usernamePattern = /^\w{6,10}$/;
                if (!usernamePattern.test(username)) {
                    $("span.errorMsg").text("账号名不符合规范~");
                    return false;
                }
                // 2. 验证密码：必须由字母，数字下划线组成，并且长度为 6 到10 位
                let password = $("#password").val();
                if (!usernamePattern.test(password)) {
                    $("span.errorMsg").text("密码不符合规范~");
                    return false;
                }
                let repwd = $("#repwd").val();
                if (repwd !== password) {
                    $("span.errorMsg").text("两次输入的密码不一致~");
                    return false;
                }
                // 3. 邮箱格式验证：常规验证即可
                let email = $("#email").val();
                var emailPattern = /^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,}$/;
                if (!emailPattern.test(email)) {
                    $("span.errorMsg").text("邮箱不符合规范~");
                    return false;
                }

                // 4. 验证码：后面实现
                let code = $("#code").val();
                let codeText = $.trim(code);
                if (codeText === null || codeText === "") {
                    $("span[class='errorMsg']").text("验证码不为空!")
                    return false;
                }
                // 全部ok
                return true;
            })

            $("#codeImg").click(function () {
                this.src = "<%=request.getContextPath() + "/"%>kaptchaServlet?d=" + new Date();
            })

            $("#username").mouseleave(function () {
                // alert("Please enter your username");
                $.post(
                    "MemberServlet?action=verifyName",
                    {
                        name: $(this).val()
                    },
                    function (response) {
                        // console.log("response", response);
                        if (response == null || !response.username) {
                            $("span.errorMsg").text(" ");
                        } else {
                            // 存在
                            $("span.errorMsg").text("用户名已存在");
                        }
                    },
                    "JSON"
                )
            })


        })

    </script>
</head>

<body>
<!-- Header Area start  -->
<div class="header section">
    <!-- Header Top Message Start -->
    <!-- Header Top  End -->
    <!-- Header Bottom  Start -->
    <div class="header-bottom d-none d-lg-block">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->

            </div>
        </div>
    </div>
    <!-- Header Bottom  Start 手机端的header -->
    <div class="header-bottom d-lg-none sticky-nav bg-white">
        <div class="container position-relative">
            <div class="row align-self-center">
                <!-- Header Logo Start -->
                <div class="col-auto align-self-center">
                    <div class="header-logo">
                        <a href="index.html"><img width="280px" src="assets/images/logo/logo.png" alt="Site Logo"/></a>
                    </div>
                </div>
                <!-- Header Logo End -->
            </div>
        </div>
    </div>
    <!-- Main Menu Start -->
    <div style="width: 100%;height: 50px;background-color: black"></div>
    <!-- Main Menu End -->
</div>
<!-- Header Area End  -->
<!-- login area start -->
<div class="login-register-area pt-70px pb-100px">
    <div class="container">
        <div class="row">
            <div class="col-lg-7 col-md-12 ml-auto mr-auto">
                <div class="login-register-wrapper">
                    <div class="login-register-tab-list nav">
                        <a class="active" data-bs-toggle="tab" href="#lg1">
                            <h4>会员登录</h4>
                        </a>
                        <a id="register_tab" data-bs-toggle="tab" href="#lg2">
                            <h4>会员注册</h4>
                        </a>
                    </div>
                    <div class="tab-content">
                        <div id="lg1" class="tab-pane active">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span class="errorMsg"
                                          style="float: right; font-weight: bold; font-size: 20pt; margin-left: 10px;">
                                        ${requestScope.errMessage}
                                    </span>
                                    <form action="MemberServlet?action=login" method="post">
                                        <input type="text" name="user-name" placeholder="Username"
                                               value="${requestScope.username}"/>
                                        <input type="password" name="user-password" placeholder="Password"/>
                                        <div class="button-box">
                                            <div class="login-toggle-btn">
                                                <input type="checkbox"/>
                                                <a class="flote-none" href="javascript:void(0)">Remember me</a>
                                                <a href="#">Forgot Password?</a>
                                            </div>
                                            <button type="submit"><span>Login</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        <div id="lg2" class="tab-pane">
                            <div class="login-form-container">
                                <div class="login-register-form">
                                    <span class="errorMsg"
                                          style="float: right; font-weight: bold; font-size: 20pt; margin-left: 10px;">
                                    </span>
                                    <form action="MemberServlet?action=register" method="post">
                                        <input type="text" id="username" name="user-name" placeholder="Username"/>
                                        <input type="password" id="password" name="user-password"
                                               placeholder="输入密码"/>
                                        <input type="password" id="repwd" name="user-password" placeholder="确认密码"/>
                                        <input name="user-email" id="email" placeholder="电子邮件" type="email"/>
                                        <input type="text" id="code" name="code" style="width: 50%"
                                               placeholder="验证码"/>　　<img id="codeImg" alt="" src="kaptchaServlet"
                                                                            style="width: 120px;height: 50px">
                                        <div class="button-box">
                                            <button type="submit" id="sub-btn"><span>会员注册</span></button>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- login area end -->

<!-- Footer Area Start -->
<div class="footer-area">
    <div class="footer-container">
        <div class="footer-top">
            <div class="container">
                <div class="row">
                    <!-- Start single blog -->
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-sm-6 col-lg-3 mb-md-30px mb-lm-30px" data-aos="fade-up"
                         data-aos-delay="400">
                        <div class="single-wedge">
                            <h4 class="footer-herading">信息</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="about.html">关于我们</a></li>
                                        <li class="li"><a class="single-link" href="#">交货信息</a></li>
                                        <li class="li"><a class="single-link" href="privacy-policy.html">隐私与政策</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="#">条款和条件</a></li>
                                        <li class="li"><a class="single-link" href="#">制造</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-2 col-sm-6 mb-lm-30px" data-aos="fade-up" data-aos-delay="600">
                        <div class="single-wedge">
                            <h4 class="footer-herading">我的账号</h4>
                            <div class="footer-links">
                                <div class="footer-row">
                                    <ul class="align-items-center">
                                        <li class="li"><a class="single-link" href="my-account.html">我的账号</a>
                                        </li>
                                        <li class="li"><a class="single-link" href="cart.html">我的购物车</a></li>
                                        <li class="li"><a class="single-link" href="login.jsp">登录</a></li>
                                        <li class="li"><a class="single-link" href="wishlist.html">感兴趣的</a></li>
                                        <li class="li"><a class="single-link" href="checkout.html">结账</a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                    <!-- End single blog -->
                    <!-- Start single blog -->
                    <div class="col-md-6 col-lg-3" data-aos="fade-up" data-aos-delay="800">

                    </div>
                    <!-- End single blog -->
                </div>
            </div>
        </div>
        <div class="footer-bottom">
            <div class="container">
                <div class="row flex-sm-row-reverse">
                    <div class="col-md-6 text-right">
                        <div class="payment-link">
                            <img src="#" alt="">
                        </div>
                    </div>
                    <div class="col-md-6 text-left">
                        <p class="copy-text">Copyright &copy; 2021 韩顺平教育~</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Footer Area End -->
<script src="assets/js/vendor/vendor.min.js"></script>
<script src="assets/js/plugins/plugins.min.js"></script>
<!-- Main Js -->
<script src="assets/js/main.js"></script>
</body>
</html>