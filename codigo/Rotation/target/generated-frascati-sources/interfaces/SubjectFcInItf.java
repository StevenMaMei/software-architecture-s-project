/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Sun Dec 01 21:43:27 COT 2019
 */

package interfaces;


public class SubjectFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<interfaces.Subject>
implements interfaces.Subject {

  public SubjectFcInItf()  {
  }

  public SubjectFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public void detach(final interfaces.Observer arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.detach(arg0);
  }

  public void noti()  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.noti();
  }

  public void attach(final interfaces.Observer arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.attach(arg0);
  }

  public model.CoordinatesDTO getState()  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    model.CoordinatesDTO ret = impl.getState();
    return ret;
  }

}
