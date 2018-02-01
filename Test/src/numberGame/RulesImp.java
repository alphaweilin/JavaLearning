package numberGame;

public class RulesImp implements Rules {
	private SpecialNum speclialNum1;
	private SpecialNum speclialNum2;
	private SpecialNum speclialNum3;
	
	public RulesImp(SpecialNum speclialNum1, SpecialNum speclialNum2, SpecialNum speclialNum3){
		this.speclialNum1 = speclialNum1;
		this.speclialNum2 = speclialNum2;
		this.speclialNum3 = speclialNum3;
	}
	
	public String getOutPut(int num, SpecialNum priorityNum){
		String result = String.valueOf(num);
		if (String.valueOf(num).contains(String.valueOf(priorityNum.getNum()))) {
			result = priorityNum.getValue();
		}else {
			StringBuffer stringBuffer = new StringBuffer();
			stringBuffer.append(multipleRule(num,speclialNum1));
			stringBuffer.append(multipleRule(num,speclialNum2));
			stringBuffer.append(multipleRule(num,speclialNum3));
			if (stringBuffer.length()>0) {
				result = stringBuffer.toString();
			}
		}

		return result;
	}
	
	private String  multipleRule(int num, SpecialNum specialNum){
		String result = "";
		if (null != specialNum && (num % specialNum.getNum() == 0)) {
			result = specialNum.getValue();
		}
		return result;
	}
	
}
