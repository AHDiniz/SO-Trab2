/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

/**
 * Program's entry point class
*/
public class Main
{
	public static void main(String[] args)
	{
		String msg = "Hello! I'm the message created by producer ";
		Buffer buffer = new Buffer(); // Initializing buffer.
		
		// Giving the reference to the buffer to the Producer and Consumer classes:
		Producer.SetBuffer(buffer);
		Consumer.SetBuffer(buffer);

		// Creating 10 Producers and 10 Consumers:
		for (int i = 1; i < 11; i++)
		{
			(new Producer(msg + i)).start();
			(new Consumer()).start();
		}
	}
}