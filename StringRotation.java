class StringRotation{
	static final String s1 = "waterbottle";
	static final String s2 = "erbottlewat";
	static final String s3 = "waters";
	
	static boolean isSubString(String s1, String s2){
		return s1.contains(s2);
	}
	
	public static void main(String[] args){
		System.out.println(isSubString(s2+s2,s1));
	}
}