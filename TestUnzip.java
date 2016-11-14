public class TestUnzip{
	public static void main(String args[]){
		try{
			UnzipFile obj = new UnzipFile("E:\\Python.zip","D:\\");
			obj.extract();
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
	}
}