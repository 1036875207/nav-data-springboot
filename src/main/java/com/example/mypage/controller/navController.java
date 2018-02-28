package com.example.mypage.controller;

import com.example.mypage.Entity.Navigation;

import com.example.mypage.Repository.navRepository;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.MediaSize;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
public class navController
{
    @Autowired
    navRepository navRepository;
    @GetMapping(value = "navlist")
    public List<Navigation> hello(HttpServletResponse response){
        List<Navigation> lists = navRepository.findAll();
        response.setHeader("Access-Control-Allow-Origin", "*");
        return lists;
    }

    @PostMapping(value = "addnav")
    public List<Navigation> addnav(HttpServletResponse response,@RequestParam("name") String name,@RequestParam("enname") String enname,@RequestParam("pid") Integer pid){
        if(pid == 0){
            //创建单节点
            Navigation navigation=new Navigation();
            navigation.setEn_name(enname);
            navigation.setName(name);
            navigation.setChildnum(0);
            navigation.setIschild(1);
            navigation=navRepository.save(navigation);
            navigation.setWight(navigation.getId());
            navRepository.save(navigation);
        }else{
            //创建节点
            Navigation navigation=new Navigation();
            navigation.setEn_name(enname);
            navigation.setName(name);
            navigation.setChildnum(0);
            navigation.setIschild(0);
            navigation=navRepository.save(navigation);
            navigation.setWight(navigation.getId());
            navRepository.save(navigation);
            //获取父节点
            Navigation parent=navRepository.findOne(pid);
            List<Navigation> list=parent.getChildlist();
            list.add(navigation);
            parent.setChildlist(list);
            parent.setChildnum(parent.getChildnum()+1);
            navRepository.save(parent);
        }
        List<Navigation> lists = navRepository.findAll();
        response.setHeader("Access-Control-Allow-Origin", "*");
        return lists;
    }
}
