import java.util.Arrays;

class StringDuplication{
	private static final String input = "crakingthecoding";
	private static final int CHARSETCOUNT = 26;
	
	public static void main(String[] args){
		System.out.println("Output by method1: "+ method1(input));
		System.out.println("Output by method2: "+ method2(input));
		
	}
	
	public static boolean method1(String s){
		boolean[] track = new boolean[128];
		if(s.length() > 128){
			System.out.print("Exceeded Length");
			return false;
		}
		else{
			
			int charValue;
			for(int cur = 0; cur < s.length(); cur++){
				charValue = s.charAt(cur) - 'a';
				if(track[charValue]){
					Arrays.toString(track);
					return false;
				}
				track[charValue] = true;
			}
		}
		Arrays.toString(track);
		return true;
	}


	public static boolean method2(String s){
		int checker = 0;
		if(s.length() > CHARSETCOUNT)
			return false;
		else{
			
			int charValue;
			for(int cur =0; cur < s.length(); cur++){
				charValue = s.charAt(cur) - 'a';
				if(((checker >> charValue) & 1) == 1){
					System.out.println(Integer.toBinaryString(checker));
					return false;
				}
				checker = checker | (1<<charValue); 
			}
			System.out.println(Integer.toBinaryString(checker));
			return true;
		}
	}
	
}