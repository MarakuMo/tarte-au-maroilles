import java.io.IOException;


public class Test {

	public static void main(String[] args) throws IOException {
		Text t=new Text(args[0]);
		System.out.println(t.getContenu());
	}
}
