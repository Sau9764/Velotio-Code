import java.io.*;
import java.util.*;

class Customers {
	String name;
	float balance;
	int age;
	float salary;
	int dependents;

	Customers(String name, float balance, int age, float salary, int dependents){
		this.name = name;
		this.balance = balance;
		this.age = age;
		this.salary = salary;
		this.dependents = dependents;
	}

	public String toString(){
		return ("\n {" + this.name + "\t" + this.balance + "\t\t" + this.age + "\t" + this.salary + "\t\t" + this.dependents + "}");
	}
}

class BigBank {
	public static void main(String[] args) {

		PriorityQueue<Customers> pq = new PriorityQueue<Customers>(5, new Reliable_Customers());

		// Customers c1 = new Customers("A", 1000, 23, 12000, 1);
		// Customers c2 = new Customers("B", 3000, 24, 20000, 2);
		// Customers c3 = new Customers("C", 400, 26, 7000, 4);
		// Customers c4 = new Customers("D", 1500, 19, 23000, 1);
		// Customers c5 = new Customers("E", 400, 78, 67000, 2);

		Customers c1 = new Customers("p1", 1000, 23, 20000, 2);
		Customers c2 = new Customers("p2", 1000, 24, 20000, 2);

		pq.add(c1);
		pq.add(c2);
		// pq.add(c3);
		// pq.add(c4);
		// pq.add(c5);

		System.out.println(pq);
		
	}
}

class Reliable_Customers implements Comparator<Customers> {

	public int compare(Customers obj1, Customers obj2){
		// 4 criteria 
		// I assume that the priority of these attributes are balance > age > salary > dependents
		// there are multiple ways if else conditions for doing this.
		// I choose simplest approach for doing this.

		int points = 0;

		points += obj1.balance > obj2.balance ? 4 : -4;
		points += obj1.age < obj2.age ? 3 : -3;
		points += obj1.salary > obj2.salary ? 2 : -2;
		points += obj2.dependents < obj2.dependents ? 1 : -1;

		return points;
	}
}