/** Functions for checking if a given string is an anagram. */
public class Anagram {
	public static void main(String args[]) {
		// Tests the isAnagram function.
		System.out.println(isAnagram("silent","listen"));  // true
		System.out.println(isAnagram("William Shakespeare","I am a weakish speller")); // true
		System.out.println(isAnagram("Madam Curie","Radium came")); // true
		System.out.println(isAnagram("Tom Marvolo Riddle","I am Lord Voldemort")); // true

		// Tests the preProcess function.
		System.out.println(preProcess("What? No way!!!"));
		
		// Tests the randomAnagram function.
		System.out.println("silent and " + randomAnagram("silent") + " are anagrams.");
		
		// Performs a stress test of randomAnagram 
		String str = "1234567";
		Boolean pass = true;
		//// 10 can be changed to much larger values, like 1000
		for (int i = 0; i < 10; i++) {
			String randomAnagram = randomAnagram(str);
			System.out.println(randomAnagram);
			pass = pass && isAnagram(str, randomAnagram);
			if (!pass) break;
		}
		System.out.println(pass ? "test passed" : "test Failed");
	}  
	// Returns true if the two given strings are anagrams, false otherwise.
	public static boolean isAnagram(String str1, String str2) {
		str1 = preProcess(str1);
		str2 = preProcess(str2);
		String mid1 = "";
		String mid2 = "";
		for(int i = 0;i < str1.length();i++){
			if (str1.charAt(i) != ' ') {
				mid1 += str1.charAt(i);
			}
		}
		for(int i = 0;i < str2.length();i++){
			if (str2.charAt(i) != ' ') {
				mid2 += str2.charAt(i);
			}
		}
		str1 = mid1;
		str2 = mid2;
		for(int i = 0;i < str1.length();i++)
		{
			int counter1 = 0;
			int counter2 = 0;
			for(int j = 0;j < str1.length();j++){
				if ((str1.charAt(i) == str1.charAt(j))) {
					counter1++;
				}
				if ((str1.charAt(i) == str2.charAt(j))) {
					counter2++;
				}
			}
			if (counter1 != counter2) {
				
				return false;
			}
		}
		return true;
	}
	   
	// Returns a preprocessed version of the given string: all the letter characters are converted
	// to lower-case, and all the other characters are deleted, except for spaces, which are left
	// as is. For example, the string "What? No way!" becomes "whatnoway"
	public static String preProcess(String str) {
		String finalstr = "";
		str = str.toLowerCase();
		for(int i = 0;i<str.length();i++){
			if (str.charAt(i) == ' ') {
				finalstr += str.charAt(i);
			}
		}

		
		return finalstr;
	} 
	   
	// Returns a random anagram of the given string. The random anagram consists of the same
	// characters as the given string, re-arranged in a random order. 
	public static String randomAnagram(String str) {
		String finalStr = "";
        String notUsed = str;
        while (notUsed.length() > 0) {
			double randIndex = (int)(notUsed.length() * Math.random());
            char c = notUsed.charAt((int)randIndex);
            finalStr += c;
            String newRemaining = "";
            for (int i = 0; i < notUsed.length(); i++) {
                if (i != randIndex) {
                    newRemaining += notUsed.charAt(i);
                }
            }
            notUsed = newRemaining;
        }
        return finalStr;
    }

}
