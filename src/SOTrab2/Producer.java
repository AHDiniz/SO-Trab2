package SOTrab2;

import java.util.Random;

public class Producer
{
	private String msg;
	
	int randomNum()
	{
		Random random = new Random();
		return random.nextInt(5);
	}
	
	public String getMsg()
	{
		return msg;
	}

	public void setMsg(String msg)
	{
		this.msg = msg;
	}
}
