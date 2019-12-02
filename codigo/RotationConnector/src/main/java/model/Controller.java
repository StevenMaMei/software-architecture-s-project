package model;

import org.osoa.sca.annotations.Reference;
import org.osoa.sca.annotations.Scope;

import interfaces.Observer;
import interfaces.Subject;
@Scope("COMPOSITE")
public class Controller implements Runnable {

	@Reference(name="subject")
	private Subject subject;

	@Reference(name="observer")
	private Observer rotation;

	public void run() {

			rotation.attach();

		System.out.println("attach sent");
	}
	

}
