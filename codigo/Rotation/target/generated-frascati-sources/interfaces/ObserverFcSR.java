/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Sun Dec 01 01:53:22 COT 2019
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

  public void update()  {
    service.update();
  }

}