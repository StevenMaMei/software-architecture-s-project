/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Mon Dec 02 11:20:28 COT 2019
 */

package interfaces;


public class ObserverFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<interfaces.Observer>
implements interfaces.Observer {

  public ObserverFcSR(Class<interfaces.Observer> businessInterface,interfaces.Observer service)  {
    super(businessInterface,service);
  }

  public interfaces.Observer getService()  {
    return this;
  }

  public void attach() throws java.rmi.RemoteException  {
    service.attach();
  }

  public void update() throws java.rmi.RemoteException  {
    service.update();
  }

}
