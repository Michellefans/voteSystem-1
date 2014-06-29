package vote.system.message;

import java.io.UnsupportedEncodingException;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;

/**
 * ���ŷ���
 * @author ZhongJie
 *
 */
public class Message {

	public static void sendMessage(String phoneNo,String message){
		HttpClient client = new HttpClient();
		PostMethod post = new PostMethod("http://gbk.sms.webchinese.cn");
		post.addRequestHeader("Content-Type","application/x-www-form-urlencoded;charset=gbk");//����ת��
		NameValuePair[] data = {new NameValuePair("Uid","zhongjie"),//ע���û���
				new NameValuePair("Key","fa269638b37aa7a8d5c9"),//������ԿKey
				new NameValuePair("smsMob",phoneNo),//�ֻ�����
				new NameValuePair("smsText",message)//��������
		};
		post.setRequestBody(data);
		try {
			System.out.println(client.executeMethod(post));
		} catch (Exception e) {
			e.printStackTrace();
		}
		Header[] headers = post.getResponseHeaders();
		int statusCode = post.getStatusCode();
		System.out.println("statusCode:"+statusCode);
		for(Header h : headers){
			System.out.println(h.toString());
		}
		try {
			String result = new String(post.getResponseBodyAsString().getBytes("gbk"));
			System.out.println(result);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		post.releaseConnection();
	}
	
	public static void main(String[] args){
		sendMessage("13077143470", "�ɹ����ն���");
	}
}
