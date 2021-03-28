
public class SpacedLogger implements Logger {
	
	/*
	 *  The SpacedLogger should add spaces between each character of the String argument passed into its methods.
	 *	If the log method received “Hello” as an argument, it should print H e l l o
	 *  The error method should do the same, but with “ERROR:” preceding the spaced out input (i.e. ERROR: H e l l o)
	 *
	 */

	@Override
	public void Log(String msg) {
		StringBuilder spacedSentence = new StringBuilder();
		for (char c : msg.toCharArray()) {
			spacedSentence.append(c);
			spacedSentence.append(" ");
		}
		System.out.println(spacedSentence.toString());
	}

	@Override
	public void Error(String msg) {
		StringBuilder spacedSentence = new StringBuilder();
		for (char c : msg.toCharArray()) {
			spacedSentence.append(c);
			spacedSentence.append(" ");
		}
		System.out.println("ERROR: " + spacedSentence.toString());
	}
}
