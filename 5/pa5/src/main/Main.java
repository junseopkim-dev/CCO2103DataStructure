//import java.util.Scanner;
//import java.util.Arrays;

// Main.java file is not for submission.
// It is here for you to give means of testing.
// You can use any packages in "this" file but be careful on the submission files.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
//	static int[] table;
	public static void main(String[] args) throws IOException
	{
		PrefixMin prefixMin = new PrefixMin();
		YonseiString s1 = new YonseiString(new int[] {'a', 'b', 'c', 'd', 'e', 'f'});
		YonseiString s2 = new YonseiString(new int[] {'a', 'b', 'c', 'c', 'c', 'c'});
		YonseiString s3 = new YonseiString(new int[] {'c', 'c', 'c', 'c', 'c', 'c'});
		YonseiString s4 = new YonseiString(new int[] {'a', 'b', 'c'});


		prefixMin.insert(s1, 5);
		prefixMin.insert(s2, 10);
		prefixMin.insert(s1, 4);
		prefixMin.insert(s3, 1);
		System.out.println(prefixMin.getMin(s4));
		// 출력: 5


		prefixMin.insert(new YonseiString(new int[] {1, 2, 3}), 10);
		prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 5}), 1);
		prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 4}), 2);
		prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 6}), 3);
		prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 7}), 4);
		prefixMin.insert(new YonseiString(new int[] {1, 2, 3, 7, 8}), 3);

		System.out.println(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 5})));
		System.out.println(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 4})));
		System.out.println(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 6})));
		System.out.println(prefixMin.getValue(new YonseiString(new int[] {1, 2, 3, 7})));
		System.out.println();
	}

//	public static void makeTable(String p)
//	{
//		int pSize = p.length();
//		table = new int[pSize];
//		int j = 0;
//		for(int i = 1; i < pSize; i++)
//		{
//			while(j > 0 && p.charAt(i) != p.charAt(j))
//			{
//				j = table[j-1];
//			}
//			if(p.charAt(i) == p.charAt(j))
//			{
//				table[i] = ++j;
//			}
//		}
//	}
//
//	public static int search(String s, String p)
//	{
//		int sSize = s.length();
//		int pSize = p.length();
//		int j = 0;
//		for(int i = 0; i < sSize; i++)
//		{
//			while(j > 0 && s.charAt(i) != p.charAt(j))
//			{
//				j = table[j-1];
//			}
//			if(s.charAt(i) == p.charAt(j))
//			{
//				if(j == pSize-1)
//				{
//					j = table[j];
//					return 1;
//				}
//				else
//				{
//					j++;
//				}
//			}
//		}
//		return 0;
//	}
}
