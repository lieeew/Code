// package com.hspedu.furns.web;
//
// /**
//  * @Author: qxy
//  * @Date: 2023/4/13
//  * @Description:
//  */
//
// import com.hspedu.furns.entity.Member;
// import com.hspedu.furns.service.MemberService;
// import com.hspedu.furns.service.impl.MemberServiceImpl;
//
// import javax.servlet.*;
// import javax.servlet.http.*;
// import javax.servlet.annotation.*;
// import java.io.IOException;
//
// @WebServlet(name = "LoginServlet", urlPatterns = "/LoginServlet")
// public class LoginServlet extends HttpServlet {
//     private MemberService memberService = new MemberServiceImpl();
//
//     @Override
//     protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         doPost(request, response);
//     }
//
//     @Override
//     protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//         String username = request.getParameter("user-name");
//         String password = request.getParameter("user-password");
//         // 如果用户没有输入内容, 就直接提交, 后台接收到的数据是""
//         Member member = new Member(null, username, null, password);
//         Member login = memberService.login(member);
//         // Gson gson = new Gson();
//         // response.setContentType("application/json;charset=utf-8");
//         if (login != null) {
//             // String s = gson.toJson(login);
//             // System.out.println("客户端 = " + s);
//             request.getRequestDispatcher("/views/member/login_ok.jsp").forward(request, response);
//         } else {
//             request.setAttribute("msg", "用户名或者密码错误");
//             request.setAttribute("username", username);
//             request.getRequestDispatcher("/views/member/login.jsp").forward(request, response);
//         }
//     }
// }
