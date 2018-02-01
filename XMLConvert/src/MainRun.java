import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class MainRun {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ClassB classB = new ClassB();
		classB.setClassBId(22);
		classB.setClassBName("B2");

		ClassA classA = new ClassA();
		classA.setClassAId(11);
		classA.setClassAName("A1");
		classA.setClassB(classB);
		String result = XmlUtil.toXML(classA);
		System.out.println(result);

		try {
			File file = new File("src/reuslt.xml");
			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			FileWriter fileWritter = new FileWriter(file, true);
			fileWritter.write(result);
			fileWritter.write("\r\n");
			fileWritter.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
