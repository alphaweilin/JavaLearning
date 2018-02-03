
public class Test01 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 = new String("请输入验证码");
		String str2 = new String("请输入验证码");
		if(str1 == str2){
			System.out.println("same address");
		}
		
		if(str1.equals(str2)){
			System.out.println("same value");
		}
	}

}
