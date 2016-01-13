package Objects;

public class Balance {

	private static double amount;
	private long lastWorked;
	
	public Balance(){
		amount = 0;
		lastWorked = 0;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public void setLastWorked(long lastWorked) {
		this.lastWorked = lastWorked;
	}

	public double getAmount() {
		return Math.round(amount * 100.0)/100;
	}

	public long getLastWorked() {
		return lastWorked;
	}
	
	public static void subtractLateFees(long timeOverdue) {
		if(timeOverdue > 1) amount = amount - timeOverdue;
	}
	
	public boolean canWork(long time){
		if((time - lastWorked)/1000 >= 10){ 
			return true;
		}
		return false;
	}
	
	public String earnMoney(long time){
		if(canWork(time)){
			amount = amount + 5;
			lastWorked=time;
			return "did some work at the library and earned $5";
		}
		else{
			return "can not do a double shift! Wait until the first job is done!";
		}
	}
	
}
