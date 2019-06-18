/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

import java.util.Random;

/**
 * Implementing the class that will get messages from the buffer
 */
public class Consumer extends Thread
{
	static private Buffer b; // buffer associated with Consumer class.

	/**
	 * Sets the buffer associated to Consumer class
	 * 
	 * @param buffer: a Buffer object
	 */
	public static void SetBuffer(Buffer buffer)
	{
		b = buffer;
	}

	@Override
	public void run()
	{
		while (true)
		{
			Message m = b.remove();
			long threadId = Thread.currentThread().getId();

			System.out.println("Message consumed by thread id=" + threadId + "; Priority = " + m.GetPriority() + "; Message:\n" + m.GetMsg() + "\n");

			try
			{
				Thread.sleep(RandomWTime() * 1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return a random int between 1 and 5.
	 */
	private int RandomWTime()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}
}
