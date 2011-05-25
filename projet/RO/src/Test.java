import java.io.IOException;

public class Test {

	public static void main(String[] args) {
        Integer i = ('d'-'s'+26)%26;
		Character c = (char) ('o' + i);
		System.out.println(i+"###"+c);
	}
}
