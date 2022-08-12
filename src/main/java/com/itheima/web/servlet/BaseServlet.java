package com.itheima.web.servlet;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 替换httpServlet，根据请求的最后一段路径进行方法分发
 */
public class BaseServlet extends HttpServlet {


    //根据请求的最后一段路径来进行方法分发
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1.获取清求路径
        String uri = req.getRequestURI();   // /brand-case/brand/selectAll

        //2.获取最后一段路径（方法名）
        int index = uri.lastIndexOf('/');
        String methodName = uri.substring(index + 1); //

        //执行方法
        //获取对应的BrandServlet/UserServlet字节码对象class
        //谁调用this(this所在的方法) this代表谁

        Class<? extends BaseServlet> cls = this.getClass();

        //获取方法Method对象
        Method method = null;
        try {
            method = cls.getMethod(methodName, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }

        //执行方法

    }
}
