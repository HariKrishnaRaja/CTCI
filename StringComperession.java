/* 1.6 String Comperesssion
**/

public class StringComperession{
	
	public static final String in = "aabb";
	
	public static void main(String[] args){
		String comp = in;
		if(canCompress(in))
			comp = compress(in);
		System.out.println(comp);
	}
	
	public static boolean canCompress(String input){
		if(input.length() <=1)
			return false;
		int charCount = 1;
		int totCount = 1;
		for(int i = 1; i <input.length(); i++ ){
			if(input.charAt(i-1) != input.charAt(i)){
				totCount = totCount+2;
			}
		}
		if(input.charAt(input.length()-1) != input.charAt(input.length()-2))
			totCount = totCount+2;
		else
			totCount = totCount+1;
			//System.out.println(totCount);
		return totCount < input.length();
	}
	
	public static String compress(String input){
		if(input.length() < 1)
			return input;
		if(input.length() == 1){
			return input+"1";
		}
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int i = 1; i <input.length(); i++ ){
			if(input.charAt(i-1) != input.charAt(i)){
				sb.append(input.charAt(i-1));
				sb.append(count);
				count =1;
			}else{
				count++;
			}
		}
		sb.append(input.charAt(input.length()-1));
		sb.append(count);
		return sb.toString();
	}
}