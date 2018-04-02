package com.example.springboot.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLSocketFactory;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class HttpClient {

	private static SSLSocketFactory ssf = (SSLSocketFactory) SSLSocketFactory.getDefault();

	public String myPostTest() {
		String url = "http://api.shasenggujia.com/evaluation/create";
		// 创建默认的httpclient实例
		CloseableHttpClient httpclient = HttpClients.createDefault();
		// 创建post
		HttpPost post = new HttpPost(url);
		// 添加请求资源
		List<NameValuePair> prarm = new ArrayList<NameValuePair>();
		prarm.add(new BasicNameValuePair("app_id", "ssabcde67891111111"));
		prarm.add(new BasicNameValuePair("vin", "LFV2B28V6E5004981"));
		prarm.add(new BasicNameValuePair("spec_id", "1"));
		prarm.add(new BasicNameValuePair("register_date", "2015-05"));
		prarm.add(new BasicNameValuePair("city_id", "1000"));
		prarm.add(new BasicNameValuePair("mileage", "10000"));
		prarm.add(new BasicNameValuePair("service", "1"));
		prarm.add(new BasicNameValuePair("transfer_times", "0"));
		prarm.add(new BasicNameValuePair("color", "红⾊色"));
		prarm.add(new BasicNameValuePair("policy_company_id", "1"));
		prarm.add(new BasicNameValuePair("policy_number", "PDZA20141102T000210305"));
		prarm.add(new BasicNameValuePair("policy_identify", "23028119811216042X"));
		prarm.add(new BasicNameValuePair("plate_number", "沪A88888"));
		prarm.add(new BasicNameValuePair("engine_number", "CA4GD1"));
		prarm.add(new BasicNameValuePair("trade_no", "系统内部订单号，回调时映射订单"));
		prarm.add(new BasicNameValuePair("nonce_str", "13E2B1E673C442DB453DC0DA47"));
		prarm.add(new BasicNameValuePair("sign_type", "MD5"));
		prarm.add(new BasicNameValuePair("sign", "0543c00d30c2eac0fbf555e99ae696d1"));
		prarm.add(new BasicNameValuePair("created", "2017-08-09 12:00:00"));
		// 设置请求资源编码
		UrlEncodedFormEntity entity;
		try {
			entity = new UrlEncodedFormEntity(prarm, "UTF-8");
			// 封装post请求
			post.setEntity(entity);
			// 接收返回
			CloseableHttpResponse response = null;
			try {
				response = httpclient.execute(post);
				if (response.getEntity() != null) {
					log.info("=========response:" + response);
					log.info("=========EntityUtils.toString(xxx,utf-8):" + EntityUtils.toString(entity, "UTF-8"));
					System.out.println("#########################");
					System.out.println("=========response:" + response);
					System.out.println(
							"=========EntityUtils.toString(xxx,utf-8):" + EntityUtils.toString(entity, "UTF-8"));
					return EntityUtils.toString(entity, "UTF-8");
				}
			} finally {
				response.close();
			}
		} catch (UnsupportedEncodingException e) {
			log.error(e.getMessage());
		} catch (ClientProtocolException e) {
			log.error(e.getMessage());
		} catch (IOException e) {
			log.error(e.getMessage());
		} finally {
			try {
				httpclient.close();
			} catch (IOException e) {
				log.error(e.getMessage());
			}
		}
		return null;
	}

	public String myGetTest(Map<String, String> map) {
		String url = "http://api.shasenggujia.com/evaluation/create?";
		CloseableHttpClient client = HttpClients.createDefault();
		StringBuilder sb = new StringBuilder(url);
		for (Map.Entry<String, String> entry : map.entrySet()) {
			sb.append(entry.getKey() + "=" + entry.getValue() + "&");
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(sb.length() - 1);
		}
		HttpGet get = new HttpGet(sb.toString());
		CloseableHttpResponse response = null;
		try {
			response = client.execute(get);
			log.info("*****返回状态：" + response.getStatusLine());
			HttpEntity entity = response.getEntity();
			if (entity != null) {
				log.info("EntityUtils.toString(xxx):" + EntityUtils.toString(entity, "UTF-8"));
				return EntityUtils.toString(entity, "UTF-8");
			}
		} catch (IOException e) {
			log.info(e.getMessage());
		}
		return null;
	}

	
	/**
	 * postSSL:(https协议,post方式发送K-V参数到指定url,返回响应报文)
	 * @param submitUrl
	 * @param params
	 * @return
	 */
	public static String postSSL(String submitUrl, Map<String, Object> params) {

		HttpsURLConnection conn;

		String response = "";
		try {
			String urlString = submitUrl;

			URL url = new URL(urlString);
			// 组织请求参数
			StringBuilder postBody = new StringBuilder();
			for (Map.Entry<String, Object> entry : params.entrySet()) {
				if (entry.getValue() == null) {

					continue;
				}
				postBody.append(entry.getKey()).append("=")
						.append(URLEncoder.encode(entry.getValue().toString(), "utf-8")).append("&");
			}

			if (!params.isEmpty()) {
				postBody.deleteCharAt(postBody.length() - 1);
			}

			conn = (HttpsURLConnection) url.openConnection();

			// 设置https
			conn.setSSLSocketFactory(ssf);
			// 设置长链接
			conn.setRequestProperty("Connection", "Keep-Alive");
			// 设置连接超时
			conn.setConnectTimeout(5000);
			// 设置读取超时
			conn.setReadTimeout(5000);
			// 提交参数
			conn.setRequestMethod("POST");
			conn.setDoOutput(true);
			conn.setDoInput(true);
			/**********************************************************************************************/
			// System.out.println("请求地址:" +submitUrl+"?"+ postBody.toString());
			/**********************************************************************************************/
			OutputStream out = conn.getOutputStream();

			out.write(postBody.toString().getBytes());
			conn.getOutputStream().flush();
			int responseCode = conn.getResponseCode();
			if (responseCode == 200) {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), "utf-8"));
				StringBuilder result = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line).append("\n");
				}
				/**********************************************************************************************/
				// System.out.println("responseResult:" + result);
				/**********************************************************************************************/
				response = result.toString();
				return response;
			} else {
				BufferedReader bufferedReader = new BufferedReader(
						new InputStreamReader(conn.getInputStream(), "utf-8"));
				StringBuilder result = new StringBuilder();
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					result.append(line).append("\n");
				}
				// System.out.println("responseResult:" + result);
				response = result.toString();
				return response;
			}
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return null;
	}

}
