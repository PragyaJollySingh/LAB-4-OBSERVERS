/** SYSC 2101 - Prof-Student-TA Example
 * 
 *
 */

import java.util.Date;
import java.util.Observable;
import java.util.Observer;

@SuppressWarnings("deprecation")
public class TeachingAssistant implements Observer{
	private String name;
	private Date midterm;

	public TeachingAssistant(String aName) {
		this.name = aName;
	}

	public String getName() {
		return this.name;
	}

	public void proctor(Date date){
		this.midterm = date;
		System.out.println(name + " : I have to proctor a midterm on " + this.midterm);
	}
	
	public void postpone(Date date){
		this.midterm = date;
		System.out.println(name + " : Now the midterm is on " + this.midterm);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		Date newMidterm = (Date) arg1;
		if (midterm == null)
			proctor(newMidterm);
		else if (newMidterm.before(midterm)) { //if midterm is set to an earlier date
			proctor(newMidterm);
		}
		else if (newMidterm.after(midterm))
			postpone(newMidterm);
		return; //Midterm is same date
	}
}
