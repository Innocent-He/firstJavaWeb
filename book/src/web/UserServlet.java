package web;
import com.google.gson.Gson;
import pojo.User;
import service.UserService;
import service.impl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY;


public class UserServlet extends BaseServlet {

    private UserService userService = new UserServiceImpl();
    protected void ajaxExistsUsername(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        String username=req.getParameter("username");
        Map<String,Object> resultMap=new HashMap<>();
        boolean b = userService.existsUsername(username);
        resultMap.put("existsUsername",b);
        Gson gson=new Gson();
        String s = gson.toJson(resultMap);
        resp.getWriter().write(s);


    }

    protected void loginout(HttpServletRequest req,HttpServletResponse resp) throws IOException{
        HttpSession session = req.getSession();
        session.invalidate();
        resp.sendRedirect(req.getContextPath()+"/index.jsp");
    }
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException,IOException{
        //  1、获取请求的参数
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        // 调用 userService.login()登录处理业务
        User user = userService.login(new User(username, null, password, null));
        if (userService.login(user)==null){
            req.setAttribute("msg","用户名或密码错误");
            req.setAttribute("username",username);
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
        }else {
            HttpSession session = req.getSession();
            Cookie cookie=new Cookie("username",username);
            cookie.setMaxAge(60*60*7);
            resp.addCookie(cookie);
            session.setAttribute("user",user);
            req.getRequestDispatcher("/pages/user/login_success.jsp").forward(req,resp);
        }
    }
    protected void regist(HttpServletRequest req,HttpServletResponse resp)throws IOException,ServletException{
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String email=req.getParameter("email");
        String code=req.getParameter("code");
        String attribute =(String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

//        2、检查 验证码是否正确  === 写死,要求验证码为:abcde
        if (attribute!=null&&attribute.equals(code)) {
            if (userService.existsUsername(username)==true){
                req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
            }else{
                userService.registUser(new User(username,null,password,email));
                req.getRequestDispatcher("/pages/user/regist_success.jsp").forward(req,resp);
            }
        }else{
            req.getRequestDispatcher("/pages/user/regist.jsp").forward(req,resp);
        }
    }


}