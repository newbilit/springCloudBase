package com.ninestar.service;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

/**
 * 〈〉
 *@author Administrator
 */
@RestController
@RequestMapping("/api")
public class MemberController {

    @GetMapping("hello")
    @PreAuthorize("hasAnyAuthority('ROLE_ADMIN')")  //这个是role表中的角色
    public String hello(){
        return "来自PRODUCT2--hello";
    }

    @GetMapping("current")
    public Principal user(Principal principal) {
        return principal;
    }

    @GetMapping("query")
    @PreAuthorize("hasAnyAuthority('query')")  //这个是es_permission表中的uri
    public String query() {
        return "来自PRODUCT2--具有query权限";
    }
    
    @PostMapping("queryPost")
    @PreAuthorize("hasAnyAuthority('query')")
    public String query1() {
        return "具有queryPost权限";
    }
}
