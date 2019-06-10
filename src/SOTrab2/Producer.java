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
	private String msg;

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep((RandomNum() + 1) * 1000);
			} catch (Exception ex) {
			}
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
}
