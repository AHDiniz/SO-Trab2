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
	static private Buffer b;
	private String msg;

	/**
	 * Producer constructor
	 * 
	 * @param msg: the message that the producer will, well, produce...
	 */
	public Producer(String msg)
	{
		this.msg = msg;
	}

	/**
	 * Thread's main execution method
	 * 
	 * This is responsible to produce a message, printing it and inserting
	 * it in the message buffer.
	 */
	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				Thread.sleep(RandomWTime() * 1000);
			}
			catch (InterruptedException e)
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
	 * Setting the proirity of the producer randomly
	 */
	private int RandomPriority()
	{
		Random random = new Random();
		return random.nextInt(4);
	}

	/**
	 * Setting a random amount of time that the producer will have to wait
	 */
	private int RandomWTime()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}

	/**
	 * Setting the buffer that will hold the produced messages
	 * 
	 * @param buffer: message buffer
	 */
	public static void SetBuffer(Buffer buffer)
	{
		b = buffer;
	}
}
