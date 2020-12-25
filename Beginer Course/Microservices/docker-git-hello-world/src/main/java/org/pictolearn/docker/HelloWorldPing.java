package org.pictolearn.docker;

/**
 * Hello world!
 *
 */
public class HelloWorldPing 
{
	public static void main(String[] args) {
		for (int i = 0; i < 100; i++) {
			System.out.println("Hello World Ping " + i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
