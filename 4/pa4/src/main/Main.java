import java.util.Scanner;
import java.util.Arrays;

// Main.java file is not for submission.
// It is here for you to give means of testing.
// You can use any packages in "this" file but be careful on the submission files.

public class Main {
	public static void main(String[] args) {

		CuckooHash c = new CuckooHash(0.5, 4, 4);
		//Scanner scanner = new Scanner(System.in);

		HashParameter hprev, hnext;
		hprev = c.getParams();
		System.out.println("c.contains(100) : "+c.contains(100));
		c.insert(100);
		c.insert(104);
		hnext = c.getParams();
		System.out.println("c.contains(104) : "+c.contains(104));
		System.out.println("c.contains(100) : "+c.contains(100));
		System.out.println(hprev.a1==hnext.a1);
		System.out.println(hprev.a2==hnext.a2);
		System.out.println(hprev.b1==hnext.b1);
		System.out.println(hprev.b2==hnext.b2);
		System.out.println(hprev.N==hnext.N);

		System.out.println("-------------");
		System.out.println("a1 : "+c.getParams().a1);
		System.out.println("b1 : "+c.getParams().b1);

		System.out.println("a2 : "+c.getParams().a2);
		System.out.println("b2 : "+c.getParams().b2);
		for(int i = 0; i<c.N;i++){
			System.out.println(c.A1[i]);
		}
		for(int i = 0; i<c.N;i++){
			System.out.println(c.A2[i]);
		}
		System.out.println("-------------");

		c.insert(-108);
		hnext = c.getParams();
		System.out.println(hprev.a1==hnext.a1);
		System.out.println(hprev.a2==hnext.a2);
		System.out.println(hprev.b1==hnext.b1);
		System.out.println(hprev.b2==hnext.b2);
		System.out.println(hprev.N==hnext.N);


		System.out.println("-------------");
		//System.out.println("You can implement your test code here.");

		System.out.println("a1 : "+c.getParams().a1);
		System.out.println("b1 : "+c.getParams().b1);

		System.out.println("a2 : "+c.getParams().a2);
		System.out.println("b2 : "+c.getParams().b2);

		for(int i = 0; i<c.N;i++){
			System.out.println(c.A1[i]);
		}
		for(int i = 0; i<c.N;i++){
			System.out.println(c.A2[i]);
		}
		System.out.println("-------------");


		c.delete(104);
		System.out.println("-------------");

		System.out.println("a1 : "+c.getParams().a1);
		System.out.println("b1 : "+c.getParams().b1);

		System.out.println("a2 : "+c.getParams().a2);
		System.out.println("b2 : "+c.getParams().b2);
		for(int i = 0; i<c.N;i++){
			System.out.println(c.A1[i]);
		}
		for(int i = 0; i<c.N;i++){
			System.out.println(c.A2[i]);
		}
		System.out.println("-------------");

		c.delete(108);

		for (int i = 100; i<121; i++){
			c.insert(i);
		}
		System.out.println("-------------");
		System.out.println("-------------");
		System.out.println("a1 : "+c.getParams().a1);
		System.out.println("b1 : "+c.getParams().b1);

		System.out.println("a2 : "+c.getParams().a2);
		System.out.println("b2 : "+c.getParams().b2);
		System.out.println("N : "+c.getParams().N);

		for(int i = 0; i<c.N;i++){
			System.out.println(c.A1[i]);
		}
		System.out.println("-------------");
		for(int i = 0; i<c.N;i++){
			System.out.println(c.A2[i]);
		}
		System.out.println("-------------");
		System.out.println("-------------");

	}
}
