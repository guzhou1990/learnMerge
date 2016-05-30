package test;

import service.SimpleRC5;

public class Test {
	public static void main(String[] args) {
//		String [] a= SimpleRC5.encryptionRC5("2", "3");
//		System.out.println(a[0]+","+a[1]);
//		System.out.println(SimpleRC5.youyi("00000001"));
		System.out.println("加密开始，初始值A=R，B=H");
		System.out.println("加密前，A的二进制是："+SimpleRC5.charToBinary("R")+",B的二进制是："
		                     +SimpleRC5.charToBinary("H"));
		String [] a= SimpleRC5.encryptionRC5("R", "H");
		System.out.println("加密后，A的二进制是："+a[0]+",B的二进制是："+a[1]);
		System.out.println("解密开始：");
		a=SimpleRC5.decryptRC5(a);
		System.out.println("解密后，A的二进制是："+a[0]+",B的二进制是："+a[1]);
		System.out.println("解密后，A="+SimpleRC5.binaryToChar(a[0])+",B="+SimpleRC5.binaryToChar(a[0]));
	}

}
