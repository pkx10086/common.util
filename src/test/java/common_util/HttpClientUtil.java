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
* ��˵����
* @author pankx
* @date 2016��5��11�� ����2:39:16
*/
public class HttpClientUtil {

	public static String  sendGet(String url){
	try {
		
	        // ����һ��Ĭ�ϵ�HttpClient
	        HttpClient httpclient =new SystemDefaultHttpClient();
	        // ����һ��GET����
	        HttpGet request =new HttpGet("http://localhost:59545/tfsPlatform-SpringMVC/login");
	        System.out.println(request.getURI());
	        // ����GET���󣬲�����Ӧ����ת�����ַ���
	       //�ͻ���ִ��get���� ������Ӧʵ��  
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
