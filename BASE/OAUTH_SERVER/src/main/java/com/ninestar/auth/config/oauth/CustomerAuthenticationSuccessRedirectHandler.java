package com.ninestar.auth.config.oauth;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
 
/**
 */
 
@Component("mAuthSuccessHandler")
public class CustomerAuthenticationSuccessRedirectHandler extends SimpleUrlAuthenticationSuccessHandler {
 
    private static final Logger logger = LoggerFactory.getLogger(CustomerAuthenticationSuccessRedirectHandler.class);
 
    @Autowired
    private ObjectMapper objectMapper;
 
    @Autowired
    private SecurityProperties securityProperties;
 
    private RequestCache requestCache = new HttpSessionRequestCache();
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request
            , HttpServletResponse response
            , Authentication authentication)
            throws IOException, ServletException {
 
        logger.info("登录成功");
      /*  if(securityProperties.getBrowser().getLoginType() == LoginType.JSON){
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().write(objectMapper.writeValueAsString(authentication));
        }else{*/
            SavedRequest savedRequest = requestCache.getRequest(request,response);
            String targetUrl = savedRequest.getRedirectUrl();
            getRedirectStrategy().sendRedirect(request,response,targetUrl);
            clearAuthenticationAttributes(request);
        //}
    }
}

