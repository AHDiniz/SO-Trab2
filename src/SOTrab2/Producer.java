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
 * Implementing the class that will insert messages in the buffer
 */
public class Producer extends Thread
{
	static private Buffer b; // buffer associated with Producer class.
	private String msg; // message that will be genereted.

	/**
	 * Producer constructor method
	 * 
	 * @param msg: the content string for the message that will be generated
	 */
	public Producer(String msg)
	{
		this.msg = msg;
	}

	/**
	 * Sets the buffer associated to Producer class
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
			try
			{
				Thread.sleep(RandomWTime() * 1000);
			} catch (InterruptedException e)
			{
				e.printStackTrace();
			}

			Message m = new Message(RandomPriority(), msg);

			long threadId = Thread.currentThread().getId();

			System.out.println("Message created by thread id=" + threadId + "; Priority = " + m.GetPriority() + "; Message:\n" + m.GetMsg() + "\n");

			b.insert(m);
		}
	}

	/**
	 * @return a random int between 0 and 3
	 */
	private int RandomPriority()
	{
		Random random = new Random();
		return random.nextInt(4);
	}

	/**
	 * @return a random int between 1 and 5
	 */
	private int RandomWTime()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}

	/**
	 * @return the message associated to this producer
	 */
	public String GetMsg()
	{
		return msg;
	}

	/**
	 * Sets the message associated tho this producer
	 * 
	 * @param msg: the new associated message
	 */
	public void SetMsg(String msg)
	{
		this.msg = msg;
	}
}
