package org.cjh.websocket.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/hello")
public class HelloController {
    
    @GetMapping("/greeting.do")
    public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
        model.addAttribute("name", name);
        return "greeting";
    }
    
    @GetMapping("/json.do")
    @ResponseBody
    public Map<String, Object> json(@RequestParam Map<String, Object> requestParam) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("response", new Date().toString());
        return resp;
    }
    
    @RequestMapping("/postFormUtf8.do")
    @ResponseBody
    public Map<String, Object> postFormUtf8(@RequestParam Map<String, Object> requestParam) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("sourceData", requestParam);
        resp.put("responseTime", new Date().toString());
        return resp;
    }
    
    @RequestMapping("/postFormGbk.do")
    @ResponseBody
    public Map<String, Object> postFormGbk(@RequestParam("CustomerName") String customerName) {
        Map<String, Object> resp = new HashMap<String, Object>();
        
        resp.put("customerName", customerName);
        resp.put("responseTime", new Date().toString());
        return resp;
    }
    
    @GetMapping("/getFormUtf8.do")
    @ResponseBody
    public Map<String, Object> getFormUtf8(@RequestParam Map<String, Object> requestParam) {
        Map<String, Object> resp = new HashMap<String, Object>();
        resp.put("sourceData", requestParam);
        resp.put("responseTime", new Date().toString());
        return resp;
    }
    
    @GetMapping("/getFormGbk.do")
    @ResponseBody
    public Map<String, Object> getFormGbk(@RequestParam("CustomerName") String customerName) {
        Map<String, Object> resp = new HashMap<String, Object>();
        
        resp.put("customerName", customerName);
        resp.put("responseTime", new Date().toString());
        return resp;
    }
}
