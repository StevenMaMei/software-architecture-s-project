/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Tue Dec 03 14:24:54 COT 2019
 */

package interfaces;


public class SubjectFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<interfaces.Subject>
implements interfaces.Subject {

  public SubjectFcSR(Class<interfaces.Subject> businessInterface,interfaces.Subject service)  {
    super(businessInterface,service);
  }

  public interfaces.Subject getService()  {
    return this;
  }

  public int distribute(final long arg0,final int arg1,final int arg2,final double arg3)  {
    int ret = service.distribute(arg0,arg1,arg2,arg3);
    return ret;
  }

  public void detach(final interfaces.Observer arg0)  {
    service.detach(arg0);
  }

  public void attach(final interfaces.Observer arg0)  {
    service.attach(arg0);
  }

  public java.lang.String getBinding()  {
    java.lang.String ret = service.getBinding();
    return ret;
  }

  public void noti()  {
    service.noti();
  }

  public interfaces.ICoordinatesDTO getState()  {
    interfaces.ICoordinatesDTO ret = service.getState();
    return ret;
  }

}
