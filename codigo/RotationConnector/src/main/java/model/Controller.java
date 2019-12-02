package model;

import org.osoa.sca.annotations.Reference;

import interfaces.IRotation;
import interfaces.Observer;
import interfaces.Subject;

public class Controller implements Runnable {

	@Reference(name="subject")
	private Subject subject;

	@Reference(name="iRotation")
	private IRotation rotation;

	public void run() {
		rotation.attach();
		System.out.println("attach sent");
	}
	

}
