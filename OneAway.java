class OneAway{
	private static boolean isOneAway(String s1, String s2){
		// if(Math.abs(s1.length() - s2.length()) > 1)
			// return false;
		switch(s1.length() - s2.length()){
			case 0:
				return isEdit(s1, s2);
			case 1:
				return isDelete(s1, s2);
			case -1:
				return isDelete(s2, s1);
			default:
				return false;
		}
	}
	
	private static boolean isDelete(String s1, String s2){
		for(int i =0, j=0; j < s2.length(); i++, j++){
			if(s1.charAt(i)!=s2.charAt(j)){
				i++;
				if((j-i) > 1)
					return false;
			}
		}
		return true;
	}
	
	private static boolean isEdit(String s1, String s2){
	int count = 0;
		for(int i =0; i< s1.length(); i++){
			if(s1.charAt(i) != s2.charAt(i)){
				count++;
				if(count>1)
					return false;
			}
		}
		return true;
	}
	
	private static boolean isOneAway2(String s1, String s2){
		if(Math.abs(s1.length() - s2.length()) > 1)
			return false;
		
		String small = (s1.length() > s2.length())? s2: s1;
		String big = (s1.length() > s2.length())? s1: s2;
		
		//System.out.println(small+" "+big );
		
		int smallIndex = 0;
		int bigIndex = 0;
		boolean flag = false;
		
		while(smallIndex < small.length() && bigIndex < big.length()){
			if(small.charAt(smallIndex) != big.charAt(bigIndex)){
				if(flag)
					return false;
				flag = true;
				
				if(small.length() == big.length())
					smallIndex++;
					
			}else{
				smallIndex++;
			}
			bigIndex++;
		}
		
		return true;
	}
	
	
	public static void main(String[] args){
		System.out.println(isOneAway("pale","ple"));
		System.out.println(isOneAway("pale","pales"));
		System.out.println(isOneAway("pale","bale"));
		System.out.println(isOneAway("pale","bake"));
		
		
		System.out.println(isOneAway2("pale","ple"));
		System.out.println(isOneAway2("pale","pales"));
		System.out.println(isOneAway2("pale","bale"));
		System.out.println(isOneAway2("pale","bake"));
	}
	
	
}