package javaJobScheduler;
import java.time.LocalDateTime;


/* Initially I thought that Job class will be an interface but as it need
 * to have a instant variable of Schedule it is not possible so Job is an abstract class 
 * and whichever specific Job want to specify it's functionality will extend it and 
 * override the doSomeThing Method
 */
public class JobType1 extends Job {

	public JobType1(Schedule s, int x) {
		super(s, x);
		// TODO Auto-generated constructor stub
	}


	@Override
	void doSomeThing(int x) {
		
		System.out.println("This is a JobType1 and it will say hi "+ x + " at " + LocalDateTime.now() );
		// TODO Auto-generated method stub

	}

}
