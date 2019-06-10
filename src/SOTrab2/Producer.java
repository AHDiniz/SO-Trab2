/**
 * Operating Systems Assingment 2
 * 
 * Alan Herculano Diniz, Israel Santos & Rafael Belmock Pedruzzi
 * 
 * Implementing and solving the Producer/Consumer problem
*/

package SOTrab2;

import java.util.Random;

public class Producer extends Thread {
	static private Buffer b;
	private String msg;

	public Producer(String msg) {
		this.msg = msg;
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((RandomNum() + 1) * 1000);
			} catch (InterruptedException ex) {
			}

			Message m = new Message(RandomNum(), msg);

			threadId = Thread.currentThread().getId();

			System.out.println("Message created by thread #" + threadId + "; Priority = " + m.GetPriority()
					+ "; Message:\n" + msg);

			b.insert(m);
		}
	}

	private int RandomNum() {
		Random random = new Random();
		return random.nextInt(5);
	}

	public String GetMsg() {
		return msg;
	}

	public void SetMsg(String msg) {
		this.msg = msg;
	}

	public static void SetBuffer(Buffer buffer) {
		b = buffer;
	}
}
