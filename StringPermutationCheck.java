import java.util.HashMap;

class StringPermutationCheck{
	private static final String s1 = "pool";
	private static final String s2 = "loops";
	
	public static void main(String[] args){
		System.out.println(isPermutation(s1, s2));
	}
	
	private static boolean isPermutation(String s1, String s2){
		
		if(s1.length()!= s2.length())
			return false;
		
		HashMap<Character,Integer> h1 = new HashMap<>();
		HashMap<Character,Integer> h2 = new HashMap<>();
		char ch;
		
		for(int i = 0; i < s1.length(); i++){
			ch = s1.charAt(i);
			if(!h1.containsKey(ch))
				h1.put(ch,1);
			else{
				h1.put(ch, h1.get(ch)+1);
			}
		}
		
		for(int i = 0; i < s2.length(); i++){
			ch = s2.charAt(i);
			if(!h2.containsKey(ch))
				h2.put(ch,1);
			else
				h2.put(ch, h2.get(ch)+1);
		}
		
		for(Character c: h1.keySet()){
			if(h1.get(c)!= h2.get(c))
				return false;
			else
				h2.remove(c);
		}
		if(h2.isEmpty())
			return true;
		return false;
		
	}
	
}