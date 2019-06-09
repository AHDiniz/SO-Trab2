/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

import java.util.Random;

public class Producer
{
	private String msg;
	
	int RandomNum()
	{
		Random random = new Random();
		return random.nextInt(5);
	}
	
	public String GetMsg()
	{
		return msg;
	}

	public void SetMsg(String msg)
	{
		this.msg = msg;
	}
}
