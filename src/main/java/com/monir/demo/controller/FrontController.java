package com.monir.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monir.demo.model.User;
import com.sun.deploy.net.HttpResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

@Controller
public class FrontController {


    RestTemplate restTemplate=new RestTemplate();

    String BASE_URL="http://localhost:8083/back";
    ObjectMapper mapper=new ObjectMapper();
    HttpHeaders header=new HttpHeaders();

    @RequestMapping(value = "/")
    public String index(Model m)
    {
        m.addAttribute("reply","Controller msg...");
        System.out.println("Front controller...");
        return "index";
    }

    @RequestMapping(value = "/addUser")
    public String addUser(@ModelAttribute(value = "user") User user)
    {
        System.err.println("Name : "+user.getName());
        header.setContentType(MediaType.APPLICATION_JSON);
        try {
            String userJSON=mapper.writeValueAsString(user);
            BASE_URL=BASE_URL+"/addUser";
            System.err.println(userJSON);

            HttpEntity<String> entity=new HttpEntity<>(userJSON,header);
            String res=restTemplate.exchange(BASE_URL, HttpMethod.POST, entity, String.class).getBody();

            System.out.println("Data sent...");
            System.out.println("Respnse :"+res);


        } catch (Exception e) {
            e.printStackTrace();
        }


        return "index";
    }
}
