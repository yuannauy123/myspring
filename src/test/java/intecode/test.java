package intecode;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String n="3.72";
		int len=n.length();
		String str=n.substring(n.indexOf("."),len);
        double right= Double.parseDouble(("0"+str).toString());
		System.out.println(""+right);
	}

}
