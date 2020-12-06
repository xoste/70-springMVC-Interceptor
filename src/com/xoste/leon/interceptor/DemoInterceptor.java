package com.xoste.leon.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Leon
 */
public class DemoInterceptor implements HandlerInterceptor {
    /**
     * 进入控制器前执行
     * 如果返回false，阻止进入控制器
     * */

    /**
     * 控制代码
     * */
    @Override
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        System.out.println("preHandle");
        System.out.println("Object o..." + o);
        return true;
    }

    /**
     * 控制器执行完成，在jsp之前执行
     * 作用：
     * 1.日志记录
     * 2.敏感词语过滤
     * */
    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle");
        System.out.println("往" + modelAndView.getViewName() + "跳转");
//        modelAndView.getModel().put("model", "修改后的内容");
        System.out.println("model的值" + modelAndView.getModel().get("model"));
        String words = modelAndView.getModel().get("model").toString();
        String newWords = words.replace("尼玛的", "***");
        modelAndView.getModel().put("model", newWords);
    }

    /**
     * jsp执行完成后执行
     * 记录执行过程中出现的异常
     * 把异常记录到日志中
     * */
    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        System.out.println("afterCompletion");
    }
}
