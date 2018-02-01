package abstractTest;

import java.io.IOException;
import java.io.InputStream;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Human() {
			
			@Override
			public void say() {
				// TODO Auto-generated method stub
				
			}
		};
		
		new InputStream() {
			
			@Override
			public int read() throws IOException {
				// TODO Auto-generated method stub
				return 0;
			}
		};
	}

}
