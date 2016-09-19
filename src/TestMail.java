import java.util.Scanner;


public class TestMail {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner (System.in);

		String username = "";
		System.out.print ("Input username: ");
		username = sc.nextLine();

		String psswd = "";
		System.out.print ("Input psswd: ");
		psswd = sc.nextLine();

		String to = "";
		System.out.print ("Input receiver: ");
		to = sc.nextLine();

		String header = "Test Email";

		String text = "This is a test email from " + username + "\n\nUsing the software JGMail :)";

		Mail myMail = new Mail (username, psswd);

		myMail.sendMail(to, header, text);

	}

}
