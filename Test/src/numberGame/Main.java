package numberGame;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpecialNum speclialNum1 = new SpecialNum(3, "Fizz");
		SpecialNum speclialNum2 = new SpecialNum(5, "Buzz");
		SpecialNum speclialNum3 = new SpecialNum(7, "Whizz");
		Rules rules = new RulesImp(speclialNum1, speclialNum2, speclialNum3);
		for(int i = 1 ; i < 100; i++) {
			System.out.println(rules.getOutPut(i, speclialNum1));
		}

	}

}
