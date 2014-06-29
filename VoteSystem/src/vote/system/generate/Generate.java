package vote.system.generate;

import java.util.Random;

/**
 * ������֤ID����ͶƱ�û�ƥ��
 * @author ZhongJie
 *
 */
public class Generate {
	
	/*��֤ID���ɣ�������10-15λ֮��*/
	public static String getRandomString(){
		String base = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";//�����ַ����Ӵ�������ȡ
	    Random random = new Random();   
	    StringBuffer sb = new StringBuffer();
	    int length = getLength(10, 15);
	    System.out.println(length);
	    for (int i = 0; i < length; i++) {   
	        int number = random.nextInt(base.length());   
	        sb.append(base.charAt(number));   
	    }   
	    return sb.toString();
	}
	
	/*[min,max]��������*/
	public static int getLength(int min,int max){
		Random random = new Random();
        int length = random.nextInt(max)%(max-min+1) + min;
        return length;
	}
	
	public static void main(String[] args){
		System.out.println(getRandomString());
	}
}
