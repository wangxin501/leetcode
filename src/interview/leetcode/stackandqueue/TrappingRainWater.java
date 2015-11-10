package interview.leetcode.stackandqueue;

import java.util.Stack;

public class TrappingRainWater {

	
	
	/**
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
		
		For example, 
		Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
		
		The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!
	 */
	
	// solution 1
	public int trap(int[] A) {

		int n = A.length;

		if (n < 3)
			return 0;
		Stack<Integer> s = new Stack<Integer>();
		int water = 0;

		for (int i = 0; i < n; i++) {
			if (!s.isEmpty() && A[i] > A[s.peek()]) {
				while (!s.empty() && A[i] > A[s.peek()]) {
					int bottom = A[s.pop()];
					if (s.empty())
						break;
					int height = Math.min(A[s.peek()], A[i]) - bottom;
					int width = i - s.peek() - 1;
					water += height * width;
				}
			}
			s.push(i);
		}
		return water;
	}

	// solution 2
	public int trap2(int[] A) {

		int max = 0;
		for (int i = 0; i < A.length; i++) {
			if (A[i] > A[max])
				max = i;
		}

		int water = 0;
		for (int i = 0, peak = 0; i < max; i++) {
			if (A[i] > peak)
				peak = A[i];
			else
				water += peak - A[i];
		}

		for (int i = A.length - 1, peak = 0; i > max; i--) {
			if (A[i] > peak)
				peak = A[i];
			else
				water += peak - A[i];
		}

		return water;
	}
}
