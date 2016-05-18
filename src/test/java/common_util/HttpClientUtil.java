package common_util;

import java.io.IOException;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.SystemDefaultHttpClient;

/**
* 类说明：
* @author pankx
* @date 2016年5月11日 下午2:39:16
*/
public class HttpClientUtil {

	public static String  sendGet(String url){
	try {
		
	        // 创建一个默认的HttpClient
	        HttpClient httpclient =new SystemDefaultHttpClient();
	        // 创建一个GET请求
	        HttpGet request =new HttpGet("http://localhost:59545/tfsPlatform-SpringMVC/login");
	        System.out.println(request.getURI());
	        // 发送GET请求，并将响应内容转换成字符串
	       //客户端执行get请求 返回响应实体  
            HttpResponse response = httpclient.execute(request);
	       System.out.println("response text::"+response.getEntity().getContent());
	       return response.toString();  
	    } catch (ClientProtocolException e) {
	        e.printStackTrace();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return "";
	}
	
	public static void main(String args[]){
		
		System.out.println(sendGet("www.baidu.com"));
	}
}
