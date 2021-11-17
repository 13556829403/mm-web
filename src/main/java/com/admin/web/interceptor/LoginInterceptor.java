package com.admin.web.interceptor;

import com.admin.web.utils.CommonUtils.JwtUtils;
import com.admin.web.utils.result.Result;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

/**
 * 登录拦截器 判断token是否有效
 */
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 进入controller之前的方法
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        try{
            // 从请求头获取token
            String token = request.getHeader("Authorization");

            // 不为空时解密
            if(token != null){
                Claims claims = JwtUtils.checkJwt(token);
                if (claims == null){
                    // 登录失败
                    sendJsonMessage(response, Result.error("会话已过期，请重新登录！"));
                    return false;
                }

                // 从token中获取用户信息
                Integer id = (Integer) claims.get("id");
                String userName = (String) claims.get("userName");

                // 将用户信息添加到请求属性中
                request.setAttribute("userId",id);
                request.setAttribute("userName",userName);

                return true;
            }
        }catch (Exception e){
            System.out.println(e);

        }
        // 登录失败
        sendJsonMessage(response, Result.error("会话已过期，请重新登录！"));
        return false;

        // return HandlerInterceptor.super.preHandle(request, response, handler);
    }

    public static  void sendJsonMessage(HttpServletResponse response, Object data){
        try{
            // token校验失败后，通过流 写出
            ObjectMapper objectMapper = new ObjectMapper();
            response.setContentType("application/json; charset=utf-8");

            // 获取写入笔
            PrintWriter printWriter = response.getWriter();
            // 将对象序列化后写出
            printWriter.print(objectMapper.writeValueAsString(data));
            printWriter.close();
            // 刷新提交
            response.flushBuffer();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
