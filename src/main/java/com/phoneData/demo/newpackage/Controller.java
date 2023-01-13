/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.phoneData.demo.newpackage;

import java.util.Map;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.phoneData.demo.Dao.User;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author USER
 */
@RestController
@RequestMapping(path="/api/phone")
public class Controller {
    @GetMapping("/getIphone")
    public String getIPhone() {
        return "Iphone 14 proMax";
    }
    @GetMapping("/getAndroid")
    public String getAndroidPhone() {
        return "Google Pixel6, Pixel 6 pro, Pix7 Pro";
    }
    @GetMapping("/getAll")
    public String getAllPhone() {
        return "所有手機的資料";
    }
    @GetMapping("/search")
    public String getSearchPhone(@RequestParam("q") String searchKey){
        return"查詢:"+searchKey+"回傳結果......";
    }
    
     @PostMapping("/reg")
    public String userRegistration( @RequestParam Map<String,String> user  ) {
      
        return "使用者：" + user.get("name") + " 電子郵件： " + user.get("mail") + " 註冊結果： 成功";
    }
    
    @PostMapping(value="/reg2")
    public String userRegistration2(@RequestBody User user  ) {        
        System.out.print("接收使用者" +user.getName() + " 電子郵件: " + user.getEmail() +" mobile:" + user.getMobile() + "資料");
        
        return "使用者" + user.getName() + " 電子郵件: " + user.getEmail() + "註冊結果: 成功";
    }
    
    
    
    @GetMapping("/queryByCapacity/{capacity}")
    public String queryCapacity(@PathVariable String capacity){
        return "依容量查詢："+capacity+"的手機有：......";
    }
    @GetMapping("/queryByCapacity/{capacity}/queryByColor/{Colour}")
    public String queryCapacity(@PathVariable("capacity") String capacity,@PathVariable("Colour") String color){
        return "複合查詢,容量為："+capacity+",顏色為："+color+"的手機有：......";
    }
}

