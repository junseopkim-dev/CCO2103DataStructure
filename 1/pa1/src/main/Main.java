import java.util.Scanner;
import java.util.Arrays;

// Main.java file is not for submission.
// It is here for you to give means of testing.
// You can use any packages in "this" file but be careful on the submission files.

public class Main {
	public static void main(String[] args) {

		ICLL<String> l = new CircularLinkedList<String>();
		System.out.println(l.size()+"\n"); // 0
		System.out.println(l.isEmpty()+"\n"); //true
		l.insert("hi"); 
		l.insert("good luck");
		l.insert("I am your TA");
		l.insert("Hello");
		System.out.println(l.size()+"\n"); //4
		System.out.println(l.delete()+"\n"); //hi
		//System.out.println(l.isEmpty()+"\n");
		//System.out.println(l.size()+"\n");
		//System.out.println(l.getHead()+"\n");
		//System.out.println(l.find("I am your TA")+"\n");
		//System.out.println(l.getHead()+"\n");
		//System.out.println(l.find("asdf")+"\n");
		//System.out.println(l.getHead()+"\n");
		System.out.println(l.delete()+"\n"); //goodluck
		System.out.println(l.delete()+"\n"); // I am your TA
		System.out.println(l.delete()+"\n"); // Hello
		System.out.println(l.delete()+"\n"); // null
		System.out.println(l.isEmpty()+"\n"); // true
		/*

		ICLL<Point> l = new CircularLinkedList<Point>();
		l.insert(new Point(10,-10));
		l.insert(new Point(9,2));
		l.insert(new Point(9,10));
		l.insert(new Point(-4,8));
		l.insert(new Point(-5,-1));
		Polygon p = new Polygon(l);
		System.out.println(p.pointInPolygon(new Point(-10,5))+"\n");
		System.out.println(p.pointInPolygon(new Point(-2,0))+"\n");

		*/

	}
}
