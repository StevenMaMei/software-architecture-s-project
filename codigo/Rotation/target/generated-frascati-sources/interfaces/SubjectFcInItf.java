/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Mon Dec 02 17:19:05 COT 2019
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

  public int distribute(final long arg0,final int arg1,final int arg2,final double arg3)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    int ret = impl.distribute(arg0,arg1,arg2,arg3);
    return ret;
  }

  public interfaces.ICoordinatesDTO getState()  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    interfaces.ICoordinatesDTO ret = impl.getState();
    return ret;
  }

  public void attach(final interfaces.Observer arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.attach(arg0);
  }

  public void noti()  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.noti();
  }

  public void detach(final interfaces.Observer arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.detach(arg0);
  }

}
