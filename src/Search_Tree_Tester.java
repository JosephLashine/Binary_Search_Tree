
public class Search_Tree_Tester {
	public static void main(String[] args)
	{
		Search_Tree test = new Search_Tree();
		test.Insert(50);
		test.Insert(40);
		test.Insert(80);
		test.Insert(20);
		test.Insert(45);
		test.Insert(60);
		test.Insert(90);
		test.Insert(55);
		test.Insert(65);
		test.inorderTransversal();
		System.out.println(test.Search(20));
		System.out.println(test.Search(30));
		test.delete(20);
		test.inorderTransversal();
		System.out.println(test.Search(80));
		test.delete(80);
		test.inorderTransversal();
}
}
