import java.io.IOException;

public class Test {

	public static void main(String[] args) throws IOException {
		// Text t=new Text(args[0]);
		// System.out.println(t.getContenu());
		Character un = 'a';
		Character deux = 'b';
		Character zzz = 'z';
		int a = un.hashCode()-97;
		int b = deux.hashCode();
		int z = zzz.hashCode()-97;
	
		Character aa = (char) ((a+26)%26+97);
		String s = "e";
		s+=aa;
		System.out.println(aa);
		System.out.println(b);
		System.out.println(s);
	}
}
