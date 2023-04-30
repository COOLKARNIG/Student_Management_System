package Student_Management_BASIC;

import java.util.ArrayList;
import java.util.Scanner;

public class MyClass
{
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> list = new ArrayList<Student>();
	static Student student = new Student();

	public static void main(String[] args)
	{
		int choice = 1;
		System.out.println("please enter entry");

		while (choice >= 1 && choice <= 3)
		{
			System.out.println("1 = show, 2= add, 3= delete, anyOther");
			choice = sc.nextInt();

			if (choice == 1)
			{
				show();

			} else if (choice == 2)
			{
				add();

			} else if (choice == 3)
			{
				delete();

			} else
			{
				System.out.println("Thank you !!");
				break;
			}
		}
		sc.close();
	}

	private static void delete()
	{
		System.out.println("inter id");
		int id = sc.nextInt();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getId() == id)
				list.remove(i);
		}
	}

	private static void add()
	{
		System.out.println("enter id, name and marks");
		int id = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
		int marks = sc.nextInt();
		Student student = new Student(id, name, marks);
		list.add(student);
	}

	private static void show()
	{
		for (Student student : list)
			System.out.println(student.getId() + " " + student.getName() + " " + student.getMarks());
	}
}
