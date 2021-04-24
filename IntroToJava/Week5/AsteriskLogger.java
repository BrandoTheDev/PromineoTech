
public class AsteriskLogger implements Logger{
	
	/*
	 * 
	 * The log method on the AsteriskLogger should print out the String it receives between 3
	 *  asterisks on either side of the String (e.g. if the String passed in is “Hello”, then 
	 *  it should print ***Hello*** to the console.
	 *  
	 *	The error method on the AsteriskLogger should print the String it receives inside a 
	 *	box of asterisks, with the String preceded by the word “ERROR:”. 
	 * 
	 */

	@Override
	public void Log(String msg) {
		System.out.println("***" + msg + "***");
		
	}

	@Override
	public void Error(String msg) {
		StringBuilder dynamicAsterisk = new StringBuilder();
		for (int i = 0; i < msg.length(); i++) {
			dynamicAsterisk.append("*");
		}
		dynamicAsterisk.append("*************"); // Additional asterisks to account for "***ERROR: " & spaces
		dynamicAsterisk.toString();
		System.out.println(dynamicAsterisk);
		System.out.println("***ERROR: " + msg + "***");
		System.out.println(dynamicAsterisk);
		
	}	

}
