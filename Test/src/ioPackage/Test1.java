package ioPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Test1 {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		File file = new File("test.txt");
		InputStream inputStream = new FileInputStream(file);
		byte[] data = new byte[10];
		int len = -1;
		StringBuffer buffer = new StringBuffer();
		while (-1 != (len = inputStream.read(data))) {
			buffer.append(new String(data, 0, len));
			System.out.println(new String(data, 0, len));
		}
		inputStream.close();
//		System.out.println(buffer);
	}

}
