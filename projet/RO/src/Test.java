import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// Text t=new Text(args[0]);
		// System.out.println(t.getContenu());
		Character un = 'a';
		Character deux = 'b';
		Character zzz = 'z';
		int a = un.hashCode()-97;
		int b = deux.hashCode()-97;
		int z = zzz.hashCode()-97;
		System.out.println(a);
		System.out.println(b);
		System.out.println(z);
	}
}
