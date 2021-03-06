package interview.leetcode.dp;

public class EditDistance {

	/**
	 * Given two words word1 and word2, find the minimum number of steps
	 * required to convert word1 to word2. (each operation is counted as 1
	 * step.)
	 * 
	 * You have the following 3 operations permitted on a word:
	 * 
	 * a) Insert a character b) Delete a character c) Replace a character
	 */

	/**
	 * dynamic programming is a method for solving complex problems by breaking
	 * them down into simpler subproblems
	 * 
	 * For example, let's say that you have to get from point A to point B as
	 * fast as possible, in a given city, during rush hour. A dynamic
	 * programming algorithm will look into the entire traffic report, looking
	 * into all possible combinations of roads you might take, and will only
	 * then tell you which way is the fastest.
	 */


	public int minDistance2(String word1, String word2) {

		int m = word1.length();
		int n = word2.length();
		int[][] edit = new int[m + 1][n + 1];

		for (int i = 0; i < m + 1; i++)
			edit[i][0] = i;
		for (int i = 0; i < n + 1; i++)
			edit[0][i] = i;

		for (int i = 1; i < m + 1; i++) {
			for (int j = 1; j < n + 1; j++) {

				char c1 = word1.charAt(i - 1);
				char c2 = word2.charAt(j - 1);
				if (c1 == c2)
					edit[i][j] = edit[i - 1][j - 1];
				else
					edit[i][j] = Math.min(Math.min(edit[i - 1][j - 1], edit[i - 1][j]), edit[i][j - 1]) + 1;
			}
		}
		return edit[m][n];
	}    
    
    
	
	
	
	
	public int minDistance(String word1, String word2) {

		int len1 = word1.length();
    	int len2 = word2.length();
     
    	// len1+1, len2+1, because finally return dp[len1][len2]
    	int[][] dp = new int[len1 + 1][len2 + 1];
     
    	for (int i = 0; i <= len1; i++) {
    		dp[i][0] = i;
    	}
     
    	for (int j = 0; j <= len2; j++) {
    		dp[0][j] = j;
    	}
     
    	//iterate though, and check last char
    	for (int i = 0; i < len1; i++) {
    		char c1 = word1.charAt(i);
    		for (int j = 0; j < len2; j++) {
    			char c2 = word2.charAt(j);
     
    			//if last two chars equal
    			if (c1 == c2) {
    				//update dp value for +1 length
    				dp[i + 1][j + 1] = dp[i][j];
    			} else {
    				int replace = dp[i][j] + 1;
    				int insert = dp[i][j + 1] + 1;
    				int delete = dp[i + 1][j] + 1;
     
    				int min = replace > insert ? insert : replace;
    				min = delete > min ? min : delete;
    				dp[i + 1][j + 1] = min;
    			}
		    }
    	}
     
    	return dp[len1][len2];
	}

}
