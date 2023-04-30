package Student_Management_SQL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class MyClass
{
	static Scanner sc = new Scanner(System.in);
	static String url = "jdbc:mysql://localhost:3306/test1";
	static String username = "root";
	static String password = "Gk@14496";
	// static ArrayList<Student> list = new ArrayList<Student>();
	// static Student student = new Student();

	public static void main(String[] args) throws Exception
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

	private static void delete() throws Exception
	{
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement Statement = connection.createStatement();
		System.out.println("inter id");
		int id = sc.nextInt();
		String query = "delete from student where id=" + id + "";
		Statement.execute(query);
	}

	private static void add() throws Exception
	{
		System.out.println("enter id, name and marks");
		int id = sc.nextInt();
		sc.nextLine();
		String name = sc.nextLine();
		int marks = sc.nextInt();
		sc.nextLine();
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement Statement = connection.createStatement();
		String query = "INSERT INTO student VALUES(" + id + ",'" + name + "'," + marks + ")";
		int executeUpdate = Statement.executeUpdate(query);

	}

	private static void show() throws Exception
	{
		Connection connection = DriverManager.getConnection(url, username, password);
		Statement Statement = connection.createStatement();
		String query = "SELECT * FROM student";
		ResultSet rs = Statement.executeQuery(query);
		while (rs.next())
		{
			int id = rs.getInt(1);
			String name = rs.getString(2);
			int marks = rs.getInt(3);
			System.out.println(id + " " + name + " " + marks);
		}
	}
}
