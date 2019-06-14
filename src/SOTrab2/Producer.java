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

	public Producer(String msg)
	{
		this.msg = msg;
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

	private int RandomPriority()
	{
		Random random = new Random();
		return random.nextInt(4);
	}

	private int RandomWTime()
	{
		Random random = new Random();
		return random.nextInt(5) + 1;
	}

	public String GetMsg()
	{
		return msg;
	}

	public void SetMsg(String msg)
	{
		this.msg = msg;
	}

	public static void SetBuffer(Buffer buffer)
	{
		b = buffer;
	}
}
