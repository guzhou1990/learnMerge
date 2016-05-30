package service;

public class SimpleRC5 {
	public static String charToBinary(String str) {
		String binaryWatermark = "";
		for(int i=0;i<str.length();i++){
			int binary = str.charAt(i);
			String temp = Integer.toBinaryString(binary);
			if(temp.length()<8){
				for(int j=temp.length();j<8;j++){
					temp='0'+temp;
				}
				binaryWatermark=binaryWatermark+temp;
			}
		}
		return binaryWatermark;
	}
	
	public static String binaryToChar(String binary) {
		String watermark = "";
		for(int i=0;i<(binary.length()/8);i++){
			String temp = binary.substring(i*8, (i+1)*8);
//			System.out.println(temp+"�����ֽ���"+temp.length());
			try {
				int a= Integer.valueOf(temp,2);
				char c =(char) a;
				watermark=watermark+c;
			} catch (Exception e) {
//				System.out.println(e);
			}
		}
		return watermark;
	}
	
	public static String zuoyi(String str){
		String temp ="";
		for(int i=0;i<str.length();i++){
			temp = temp+str.charAt(i+3>=str.length()?i+3-str.length():i+3);
		}
		return temp;
	}
	
	public static String youyi(String str){
		String temp ="";
		for(int i=0;i<str.length();i++){
			temp = temp+str.charAt(i-3<0?i-3+str.length():i-3);
		}
		return temp;
	}
	
	public static String yihuo(String a,String b){
		String temp="";
		for(int i=0;i<a.length();i++){
			int tempA=Integer.valueOf(a.charAt(i));
			int tempB=Integer.valueOf(b.charAt(i));
			int c=tempA^tempB;
			temp=temp+c;
		}
		return temp;
	}
	
	public static String[] encryptionRC5(String a,String b){
		String resultA = charToBinary(a);
		String resultB = charToBinary(b);
		resultA = yihuo(resultA, resultB);
		resultA = zuoyi(resultA);
		resultB = yihuo(resultB, resultA);
		resultB = zuoyi(resultB);
		String[] result = new String[2];
		result[0] = resultA;
		result[1] = resultB;
		return result;
//		for(int i=0;i<a.length();i++){
//			int binary1 = a.charAt(i);
//			int binary2 = b.charAt(i);
//			int binary = binary1^binary2;
//			String temp = Integer.toBinaryString(binary);
//			if(temp.length()<8){
//				for(int j=temp.length();j<8;j++){
//					temp='0'+temp;
//				}
//			}
//			resultA = resultA +temp;
//			resultA = zuoyi(resultA);
//		}
		
	}
	
	public static String[] decryptRC5(String[] str){
		String A = str[0];
		String B = str[1];
		B = youyi(B);
		B = yihuo(B, A);
		A = youyi(A);
		A = yihuo(A, B);
		String[] result = new String[2];
		result[0]=A;
		result[1]=B;
		return result;
	}
	
}
