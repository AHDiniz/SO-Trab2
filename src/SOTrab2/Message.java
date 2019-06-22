/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

/**
 * Message class
 * 
 * It has a priority that is verified by the Buffer class and the actual message
 * string
 */
public class Message
{
	private int priority; // The message's priority
	private String msg; // The message's actual content string

	/**
	 * Message constructor method
	 * 
	 * @param priority: the priority of the message in the Buffer
	 * @param msg:      the message's content string
	 */
	public Message(int priority, String msg)
	{
		this.msg = msg;
		this.priority = priority;
	}

	/**
	 * @return the message's priority in the Buffer
	 */
	public int GetPriority()
	{
		return this.priority;
	}

	/**
	 * @return the message's content string
	 */
	public String GetMsg()
	{
		return this.msg;
	}
}
