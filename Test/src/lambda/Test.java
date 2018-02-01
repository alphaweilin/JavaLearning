package lambda;

import java.util.Arrays;
import java.util.Comparator;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User[] users = {new User("张三","21",75), new User("李四","21",70),new User("王五","21",88)};
		sort1(users);
		sort2(users);
		sort3(users);
	}
	
	private static void sort1(User[] users) {
		Arrays.sort(users, new Comparator<User>() {

			@Override
			public int compare(User o1, User o2) {
				// TODO Auto-generated method stub
				return o1.getScore()-o2.getScore();
			}
		});
		System.out.println(Arrays.toString(users));
	}
	
	private static void sort2(User[] users) {
		//Lamada表达式
		Arrays.sort(users,(User o1, User o2)-> {
				// TODO Auto-generated method stub
				return o1.getScore()-o2.getScore();
			}
		);
		System.out.println(Arrays.toString(users));
	}
	
	private static void sort3(User[] users) {
		//Lamada表达式
		Arrays.sort(users,(User o1, User o2)->o1.getScore()-o2.getScore());
		System.out.println(Arrays.toString(users));
	}
	
	
}
