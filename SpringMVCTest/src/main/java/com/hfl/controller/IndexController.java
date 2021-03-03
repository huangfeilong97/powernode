package com.hfl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *  @Controller:创建处理器对象，对象放在springmvc容器中。
 *  位置：在类的上面
 *  和Spring中讲的@Service ,@Component
 *
 *  能处理请求的都是控制器（处理器）： IndexController能处理请求，
 *                         叫做后端控制器（back controller）
 *
 *  没有注解之前，需要实现各种不同的接口才能做控制器使用
 */
@RequestMapping("test")
@Controller
public class IndexController {

    /**
     * 准备使用doSome方法处理some.do请求。
     * @RequestMapping: 请求映射，作用是把一个请求地址和一个方法绑定在一起。
     *                  一个请求指定一个方法处理。
     *       属性： 1. value 是一个String，表示请求的uri地址的（some.do）。
     *                value的值必须是唯一的， 不能重复。 在使用时，推荐地址以“/”
     *       位置：1.在方法的上面，常用的。
     *            2.在类的上面
     *  说明： 使用RequestMapping修饰的方法叫做处理器方法或者控制器方法。
     *  使用@RequestMapping修饰的方法可以处理请求的，类似Servlet中的doGet, doPost
     *
     *  返回值：ModelAndView 表示本次请求的处理结果
     *   Model: 数据，请求处理完成后，要显示给用户的数据
     *   View: 视图， 比如jsp等等。
     */
    @RequestMapping(value = {"/some.do","/other.do"})
    public ModelAndView doSome(){//类似 doGet()

          ModelAndView mv=new ModelAndView();

          //添加数据， 框架在请求的最后把数据放入到request作用域。
          String info="欢迎使用springMVC做项目";
          mv.addObject("info",info);

          //指定视图, 指定视图的完整路径
          //框架对视图执行的forward操作， request.getRequestDispather("/show.jsp).forward(...)
          //mv.setViewName("/WEB-INF/view/show.jsp");

          //当配置了视图解析器后，可以使用逻辑名称（文件名），指定视图
          //框架会使用视图解析器的前缀 + 逻辑名称 + 后缀 组成完成路径， 这里就是字符连接操作
          ///WEB-INF/view/ + show + .jsp
          mv.setViewName("show");

          return mv;
    }

    /**
     * 逐个接收请求参数：
     *   要求： 处理器（控制器）方法的形参名和请求中参数名必须一致。
     *          同名的请求参数赋值给同名的形参
     * 框架接收请求参数
     *   1. 使用request对象接收请求参数
     *      String strName = request.getParameter("name");
     *      String strAge = request.getParameter("age");
     *   2. springmvc框架通过 DispatcherServlet 调用 MyController的doSome()方法
     *      调用方法时，按名称对应，把接收的参数赋值给形参
     *      doSome（strName，Integer.valueOf(strAge)）
     *      框架会提供类型转换的功能，能把String转为 int ，long ， float， double等类型。
     *
     *  400状态码是客户端错误， 表示提交请求参数过程中，发生了问题。
     */
    @RequestMapping(value = "/recive.do")
    public ModelAndView recive(String name,Integer age){
        System.out.println("doSome, name="+name+"   age="+age);
        //可以在方法中直接使用 name ， age
        //处理some.do请求了。 相当于service调用处理完成了。
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname",name);
        mv.addObject("myage",age);
        //show是视图文件的逻辑名称（文件名称）
        mv.setViewName("show2");
        return mv;

    }

}
