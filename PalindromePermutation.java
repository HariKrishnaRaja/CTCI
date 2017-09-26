import java.util.HashMap;

class PalindromePermutation{

	private static final String s ="Tact Coa";

	private static boolean isPalindromePermutation(String s1){
		char c;
		int oddCount = 0;
		HashMap <Character, Integer> h = new HashMap<>();
		for(int i = 0; i < s1.length(); i++){
			c = Character.toLowerCase(s1.charAt(i));
			if(c != ' '){
				if(!h.containsKey(c))
					h.put(c,1);
				else
					h.put(c,h.get(c)+1);
			}
		}
		
		for(Character ch: h.keySet()){
			if(h.get(ch)%2 != 0)
				oddCount++;
		}
		
		if(oddCount > 1)
			return false;
		
		return true;
		
	}
	
	private static boolean isPalindromePermutation2(String s){
		int pos;
		int vector = 0;
		int count = 0;
		for(int i = 0; i < s.length(); i++){
			pos = Character.toLowerCase(s.charAt(i)) - 'a' ;
			//System.out.println(pos);
			if(pos >= 0 && pos < 26){
				//if(((vector>>pos) & 1) == 0)
					vector =  vector ^ (1 <<pos);
				//else
					//vector = vector ^ (1<<pos);
			}
			//System.out.println("Vector " + Integer.toBinaryString(vector));
		}
		
		// while(vector > 0){
			// if((vector & 1) == 1)
				// count++;
			// vector = vector>>1;
		// }
		
		return (vector & (vector - 1)) == 0;
		
		// if(count > 1){
			// System.out.println(Integer.toBinaryString(vector));
			// return false;
		// }
		// System.out.println(Integer.toBinaryString(vector));
		// return true;
	}
	
	
	public static void main(String[] args){
		System.out.println(isPalindromePermutation(s));
		System.out.println(isPalindromePermutation2(s));
	}
	
}