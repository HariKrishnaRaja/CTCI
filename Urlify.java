import java.util.Arrays;

class Urlify{


	private static char[] unformattedUrl = {'t','e','s','t',' ','u','r','l','\u0000','\u0000'};
	private static char[] makeURL(char[] url){
		//check for number of spaces
		int spaceCount = 0;
		int usedSize = 0;
		for(int i =0; i < url.length; i++){
			if(url[i] == ' ')
				spaceCount++;
			else if(url[i] == '\u0000'){
				usedSize = i;
				break;
			}
		}
		
		System.out.println(usedSize+" "+spaceCount);
		
		if(url.length < usedSize + (spaceCount * 2))
			return null;
		
		int cur = usedSize -1;
		for(int i = url.length - 1; i!= cur; i--){
			if(url[cur] != ' ')
				url[i] = url[cur];
			else{
				url[i--]='0';
				url[i--]='2';
				url[i] = '%';
			}
			cur--;
		}
		return url;
	}
	
	public static void main(String[] args){
		char[] formattedUrl = makeURL(unformattedUrl);
		System.out.println(Arrays.toString(formattedUrl));
	}
	
}