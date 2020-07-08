package javaJobScheduler;

/* Initially I thought that Job class will be an interface but as it need
 * to have a instant variable of Schedule it is not possible so Job is an abstract class 
 * and whichever specific Job want to specify it's functionality will extend it and 
 * override the doSomeThing Method
 */

public abstract class Job implements Runnable {
	Schedule s;
	private int x;
	/**
	 * @return the s
	 */
	public Schedule getS() {
		return s;
	}
	public Job(Schedule s, int x) {
		super();
		this.s = s;
		this.x = x;
	}
	/**
	 * @param s the s to set
	 */
	public void setS(Schedule s) {
		this.s = s;
	}
public void run() {
	
	doSomeThing(this.x);
		
		
	}
	abstract void doSomeThing(int x);
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
}
