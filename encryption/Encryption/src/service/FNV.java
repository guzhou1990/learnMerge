package service;

public class FNV {
	public static int FNVHash1(String data)
    {
        final int p = 16777619;
        int hash = (int)2166136261L;
        for(int i=0;i<data.length();i++){
        	hash = (hash ^ data.charAt(i)) * p;
        }
        return hash;
    }
	public static void main(String[] args) {
		System.out.println(FNVHash1("4F5B1FDDD1S"));
	}
}
