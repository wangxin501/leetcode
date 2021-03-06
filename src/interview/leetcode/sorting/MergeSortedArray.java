package interview.leetcode.sorting;

import java.util.Arrays;

public class MergeSortedArray {

	/*
	 * 
	 * Given two sorted integer arrays A and B, merge B into A as one sorted
	 * array.
	 * 
	 * Note: You may assume that A has enough space to hold additional elements
	 * from B. The number of elements initialized in A and B are m and n
	 * respectively.
	 */

	

	public void merge3(int A[], int m, int B[], int n) {
        
        
        int i=0;
        while(i!=m){
            if(B.length!=0 && A[i] > B[0]){
                int t = A[i];
                A[i] = B[0];
                B[0] = t;
                Arrays.sort(B);
            }
            i++;
        }
        
        int j=0;
        while(i!=m+n){
            A[i++]=B[j++];
        }
        
    }

public void merge4(int A[], int m, int B[], int n) {
        
        int[] C = new int[m+n];
        
        int k=0;
        int i=0;
        int j=0;
        while(i!=m && j!=n){
            if(A[i] < B[j])
                C[k++] = A[i++];
            else
                C[k++] = B[j++];
        }
        
        while(i!=m){
            C[k++] = A[i++];
        }
        while(j!=n){
            C[k++] = B[j++];
        }
        
        for (int p=0; p<m+n; p++){
            A[p] = C[p];
        }
    }

	public void merge2(int A[], int m, int B[], int n) {
        
        int i=m;
        int j=n;
        int k=A.length;
        while(i>0 || j>0){
            if(i==0){   //forget to check i==0
                A[k-1]=B[j-1];
                j--; //wrong here
            }else if(j==0){//wrong here
                A[k-1]=A[i-1];
                i--;
            }
            else if(A[i-1]>B[j-1]) {
                A[k-1]=A[i-1];
                i--;
            }else{
                A[k-1]=B[j-1];
                j--;
            }
            k--;
        }
    }
    
    
    public void merge(int A[], int m, int B[], int n) {
        
        int i=m;
        int j=n;
        int k=A.length;
        while(i>0 || j>0){
            if(i==0) A[k-1]=B[j-- - 1];
            else if(j==0) A[k-1]=A[i-- - 1];
            else if(A[i-1]>B[j-1]) A[k-1]=A[i-- - 1];
            else A[k-1]=B[j-- - 1];
            k--;
        }
    }
}
