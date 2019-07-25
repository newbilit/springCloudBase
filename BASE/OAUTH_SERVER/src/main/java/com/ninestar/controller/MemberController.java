package com.ninestar.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.token.ConsumerTokenServices;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ninestar.entity.Result;
import com.ninestar.enumeration.ResultCode;
import com.ninestar.service.MyUserDetailService;

/**
 * 〈会员Controller〉
 *
 */
@RestController
@RequestMapping("/api")
public class MemberController {

    @Autowired
    
    private MyUserDetailService userDetailService;

    @Autowired
    private ConsumerTokenServices consumerTokenServices;

    @GetMapping("/member")
    public Principal user(Principal member) {
        return member;
    }

    @DeleteMapping(value = "/exit")
    public Result revokeToken(String access_token) {
        Result result = new Result();
        if (consumerTokenServices.revokeToken(access_token)) {
            result.setCode(ResultCode.SUCCESS.getCode());
            result.setMessage("注销成功");
        } else {
            result.setCode(ResultCode.FAILED.getCode());
            result.setMessage("注销失败");
        }
        return result;
    }
}
