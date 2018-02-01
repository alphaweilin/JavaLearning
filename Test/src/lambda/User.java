package lambda;

public class User {
	private String name;
	private String age;
	private int score;
	
	public User(String name, String age, int score) {
		// TODO Auto-generated constructor stub
		this.name = name;
		this.age = age;
		this.score = score;
	}
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", score=" + score + "]";
	}


	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}

}
