package com.szq.controller;
import com.szq.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController {

    //第一个标准变量表达式
    @GetMapping("/expression1")
    public String expression1(Model model){
        //添加数据到Model
        model.addAttribute("site","www.szq.com");
        model.addAttribute("myuser",new SysUser(1001,"李四","男",20));

        //指定视图
        return "expression1";
    }

    @GetMapping("/link")
    public String link(Model model){
        model.addAttribute("userId",1002);
        return "link";
    }

    //测试链接表达式的地址
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id){
        return "queryAccount,参数id="+id;
    }

    //测试链接表达式的地址
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name,Integer age){
        return "queryUser,两个参数name="+name+"，age="+age;
    }

    //使用模板是属性
    @GetMapping("/property")
    public String userProperty(Model model){
        model.addAttribute("methodAttr","post");
        model.addAttribute("id","2342");

        model.addAttribute("paramname","name");
        model.addAttribute("uservalue","lisi");
        return "html-property";
    }

    //循环List
    @GetMapping("/eachList")
    public String eachList(Model model){
        List<SysUser> users=new ArrayList<>();
        users.add(new SysUser(1001,"张三","m",200));
        users.add(new SysUser(1002,"张三1","m",201));
        users.add(new SysUser(1003,"张三2","m",202));
        users.add(new SysUser(1004,"张三3","m",203));

        model.addAttribute("myusers",users);
        return "eachList";
    }

    //循环数组
    @GetMapping("/eachArray")
    public String eachArray(Model model){
        SysUser userarry[]=new SysUser[3];
        userarry[0]=new SysUser(1001,"马超1","m",200);
        userarry[1]=new SysUser(1002,"马超2","m",201);
        userarry[2]=new SysUser(1003,"马超3","m",202);

        model.addAttribute("userarry",userarry);

        return "eachList";
    }

    //循环Map
    @GetMapping("eachMap")
    public String eachMap(Model model){
        Map<String,SysUser> map=new HashMap<>();
        map.put("user1",new SysUser(1001,"马超1","m",200));
        map.put("user2",new SysUser(1002,"马超2","m",201));
        map.put("user3",new SysUser(1003,"马超3","m",202));
        model.addAttribute("mymap",map);


        Map<String,SysUser> map1=new HashMap<>();
        map1.put("sd1",new SysUser(1001,"马d超1","m",200));
        map1.put("sd2",new SysUser(1002,"马d超2","m",201));
        map1.put("sd3",new SysUser(1003,"马d超3","m",202));


        List<Map<String,SysUser>> listmap=new ArrayList<>();
        listmap.add(map);
        listmap.add(map1);

        model.addAttribute("listmap",listmap);
        return "eachMap";
    }

    @GetMapping("/ifunless")
    public String ifunless(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("isLogin",true);
        model.addAttribute("age",20);
        model.addAttribute("name","");
        model.addAttribute("isOld",null);

        return "ifunless";
    }

    @GetMapping("/swithch")
    public String swithch(Model model){
        model.addAttribute("sex","m");
        return "switch";
    }

    @GetMapping("/inline")
    public String inline(Model model){
        model.addAttribute("sex","m");
        model.addAttribute("age",20);
        model.addAttribute("name","张三");
        model.addAttribute("myuser",new SysUser(1003,"马超3","m",202));

        return "inline";
    }
    //模板内置对象
    @GetMapping("/baseObject")
    public String baseObject(Model model, HttpServletRequest request, HttpSession session){
        //添加数据
        model.addAttribute("myname","李四");
        request.setAttribute("requestData","request作用域中的数据");
        request.getSession().setAttribute("sessionData","session作用域中的数据");
        session.setAttribute("loginName","zhangsan");

        return "baseObject";
    }

    //内置的工具类对象
    @GetMapping("/utilobject")
    public String utilobject(Model model){
        model.addAttribute("mydate",new Date());
        model.addAttribute("mynum",280.334);
        model.addAttribute("mystr","bskdf");

        List<String> list=Arrays.asList("a","b","c");
        model.addAttribute("mylist",list);

        return "utilobject";
    }

    @GetMapping("/customtpl")
    public String customtpl(Model model){
        return "customtpl";
    }
}
