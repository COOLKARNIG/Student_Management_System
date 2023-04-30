package Student_Management_txt;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyClass
{
	static Scanner sc = new Scanner(System.in);
	static String path = "D:\\SMS\\SMS.txt";

	public static void main(String[] args) throws Exception
	{

		int choice = 1;
		while (choice >= 1 && choice <= 3)
		{
			System.out.println("Press 1 for show press 2 for add press 3 for delete press any other for exit");
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
				break;
		}
	}

	private static void show() throws Exception
	{

		List<String> list = read();
		if (list.size() == 0)
			System.out.println("no student added yet");
		else
		{
			for (String str : list)
				System.out.println(str);
		}
	}

	private static void delete() throws Exception
	{

		System.out.println("enter id to delete");
		int id = sc.nextInt();
		sc.nextLine();

		List<String> list = read();
		for (int i = 0; i < list.size(); i++)
		{
			String str = list.get(i);
			if (str.startsWith("" + id))
			{
				list.remove(i);
				break;
			}
		}
		write(list);

	}

	private static void add() throws Exception
	{
		// TODO Auto-generated method stub
		System.out.println("Enter id");
		int id = sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name");
		String name = sc.nextLine();
		System.out.println("Enter marks");
		int marks = sc.nextInt();
		sc.nextLine();

		String str = id + " " + name + " " + marks;
		List<String> list = read();
		list.add(str);
		write(list);

	}

	private static List<String> read() throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader(path));
		String line = null;
		List<String> list = new ArrayList<>();
		while (true)
		{
			line = br.readLine();
			if (line == null)
				break;
			list.add(line);
		}
		return list;

	}

	private static void write(List<String> list) throws IOException
	{
		String data = "";
		for (String str : list)
		{
			data += str + "\n";
		}

		FileWriter obj = new FileWriter(path);
		obj.write(data);
		obj.close();
	}

}
