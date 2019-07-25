package com.ninestart;

import java.io.IOException;
import java.net.URISyntaxException;

import com.alibaba.fastjson.JSONObject;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) throws IOException, URISyntaxException {
		//请求token
		JSONObject jsonObject = Auth.getToken(
				"http://10.10.10.216:1202/auth/oauth/token?grant_type=password&username=哈哈&password=android", "android",
				"android");
		//检查token是否可用
		JSONObject checkObject = Auth.checkToken(
				"http://10.10.10.216:1202/auth/oauth/check_token?&username=哈哈&password=android&",
				jsonObject.get("access_token").toString(), "android", "android");
		System.out.println(checkObject.toString());
		// 查询权限
		JSONObject roleObject = Auth.getRole("http://10.10.10.216:1202/auth/api/member",
				jsonObject.get("access_token").toString());
		System.out.println(roleObject.toString());
        //刷新token
		JSONObject refreshObject = Auth.refreshToken(
				"http://10.10.10.216:1202/auth/oauth/token?grant_type=refresh_token&username=哈哈&password=android&",
				jsonObject.get("refresh_token").toString(), "android", "android");
		System.out.println(refreshObject.toString());
		// 登出
		JSONObject outObject = Auth.logOut("http://10.10.10.216:1202/auth/api/exit",
				refreshObject.get("access_token").toString());
		System.out.println(outObject.toString());

		// http://10.10.10.216:1202/auth/oauth/token?grant_type=refresh_token&username=哈哈&password=android&refresh_token=3e3aca70-cd3f-4f2f-ac92-53202ebbeaf3

	}
}
