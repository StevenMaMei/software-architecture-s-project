package model;

public class AutomatedNotifier implements Runnable {
	TaskDistributorImp taskD;
	public AutomatedNotifier(TaskDistributorImp t) {
		taskD = t;
	}
	public void run() {
		while(true) {
			taskD.noti();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(Thread.interrupted()) {
				return;
			}
		}

	}

}
