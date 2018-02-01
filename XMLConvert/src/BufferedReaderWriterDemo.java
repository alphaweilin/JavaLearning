import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class BufferedReaderWriterDemo {
	 public static void main(String[] args)   
	    {  
	        try  
	        {  
	            //����System.in������  
	            //System.in��λ��������ͨ��InputStreamReader����ת��Ϊ�ַ���  
	            BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));  
	            //����FileWriter  
	            BufferedWriter bufWriter = new BufferedWriter(new FileWriter(args[0]));  
	  
	            String input = null;  
	  
	            //ÿ��һ�н���һ��д�붯��  
	            while(!(input = bufReader.readLine()).equals("quit"))  
	            {  
	                bufWriter.write(input);  
	                //newLine()����д�������ϵͳ�����Ļ����ַ�����ִ�л�����ʱ��OS��������������ֻ����ַ�  
	                bufWriter.newLine();  
	            }  
	            bufReader.close();  
	            bufWriter.close();  
	        }  
	        catch(ArrayIndexOutOfBoundsException e)  
	        {  
	            System.out.println("û��ָ���ļ�");  
	        }  
	        catch(IOException e)  
	        {  
	            e.printStackTrace();  
	        }  
	    }  

}
