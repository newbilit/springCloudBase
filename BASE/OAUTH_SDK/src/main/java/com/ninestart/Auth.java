package com.ninestart;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class Auth {
	/**
	 * 请求token
	 * @param uri
	 * @param userName
	 * @param password
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static JSONObject getToken(String uri, String userName, String password)
			throws IOException, URISyntaxException {
		// 凭据提供器
		URI Uri = new URI(uri);
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				// 认证范围
				new AuthScope(Uri.getHost(), Uri.getPort()),
				// 认证用户名和密码
				new UsernamePasswordCredentials(userName, password));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {
			
			// POST请求
			HttpPost httpPost = new HttpPost(uri);
			System.out.println("执行请求：" + httpPost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
				return jsonObject;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

	}
	/**
	 * 查询token权限
	 */
	public static JSONObject getRole(String uri, String token)
			throws IOException, URISyntaxException {
		// 凭据提供器
		URI Uri = new URI(uri);
		
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			// GET请求
			HttpGet httpGet = new HttpGet(uri+"?access_token="+token);
			System.out.println("执行请求：" + httpGet.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpGet);
			try {
				JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
				return jsonObject;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

	}
	/**
	 * 登出
	 */
	public static JSONObject logOut(String uri, String token)
			throws IOException, URISyntaxException {
		// 凭据提供器
		URI Uri = new URI(uri);
		CloseableHttpClient httpclient = HttpClients.custom().build();
		try {
			// DELETE请求
			HttpDelete httpDelete = new HttpDelete(uri+"?access_token="+token);
			System.out.println("执行请求：" + httpDelete.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpDelete);
			try {
				JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
				return jsonObject;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

	}
	
	/**
	 * 检查token是否有效
	 */
	public static JSONObject checkToken(String uri, String token,String userName, String password)
			throws IOException, URISyntaxException {
		// 凭据提供器
		URI Uri = new URI(uri);
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				// 认证范围
				new AuthScope(Uri.getHost(), Uri.getPort()),
				// 认证用户名和密码
				new UsernamePasswordCredentials(userName, password));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {
			
			// POST请求
			HttpPost httpPost = new HttpPost(uri+"token="+token);
			System.out.println("执行请求：" + httpPost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
				return jsonObject;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

	}
	/**
	 * 刷新token
	 * @param uri
	 * @param token
	 * @return
	 * @throws IOException
	 * @throws URISyntaxException
	 */
	public static JSONObject refreshToken(String uri, String token,String userName, String password)
			throws IOException, URISyntaxException {
		// 凭据提供器
		URI Uri = new URI(uri);
		CredentialsProvider credsProvider = new BasicCredentialsProvider();
		credsProvider.setCredentials(
				// 认证范围
				new AuthScope(Uri.getHost(), Uri.getPort()),
				// 认证用户名和密码
				new UsernamePasswordCredentials(userName, password));
		CloseableHttpClient httpclient = HttpClients.custom().setDefaultCredentialsProvider(credsProvider).build();
		try {
			// POST请求
			HttpPost httpPost = new HttpPost(uri+"refresh_token="+token);
			System.out.println("执行请求：" + httpPost.getRequestLine());
			CloseableHttpResponse response = httpclient.execute(httpPost);
			try {
				JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
				return jsonObject;
			} finally {
				response.close();
			}
		} finally {
			httpclient.close();
		}

	}
	
	public static void main(String[] args) throws URISyntaxException, ClientProtocolException, IOException {
		//http://localhost:8881/ribbon-consumer
		

		for (; ; ) {
			URI Uri = new URI("http://localhost:8881/ribbon-consumer");
			
			CloseableHttpClient httpclient = HttpClients.custom().build();
			try {
				// GET请求
				HttpGet httpGet = new HttpGet(Uri);
				System.out.println("执行请求：" + httpGet.getRequestLine());
				CloseableHttpResponse response = httpclient.execute(httpGet);
				try {
					//JSONObject jsonObject = JSON.parseObject(EntityUtils.toString(response.getEntity()));
					System.out.println(EntityUtils.toString(response.getEntity()));
				} finally {
					response.close();
				}
			} finally {
				httpclient.close();
			}
		}


	
	}
}
