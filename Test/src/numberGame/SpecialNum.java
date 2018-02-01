package numberGame;

public class SpecialNum{
	//the num's value between 1-9
	private int num;
	//the num's describe
	private String describe;
	
	public SpecialNum(int num, String describe) {
		// TODO Auto-generated constructor stub
		this.num = num;
		this.describe = describe;
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getValue() {
		return describe;
	}
	public void setValue(String describe) {
		this.describe = describe;
	}
}
