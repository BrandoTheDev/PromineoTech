
public class App {
	/*
	 * 	Create a class named App that has a main method.
	 *	In this class instantiate an instance of each of your logger classes that implement the Logger interface.
	 *	Test both methods on both instances, passing in Strings of your choice.
	 */

	public static void main(String[] args) {
		Logger astLogger = new AsteriskLogger();
		Logger spaLogger = new SpacedLogger();
		
		astLogger.Log("Test Log coming from Asterisk Logger!");
		astLogger.Error("This is a test error coming from Asterisk Logger!");
		
		spaLogger.Log("Test Log coming from Spaced Logger!");
		spaLogger.Error("Test Error coming from Spaced Logger!");
	}

}
