/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Sun Dec 01 21:43:27 COT 2019
 */

package interfaces;


public class ObserverFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<interfaces.Observer>
implements interfaces.Observer {

  public ObserverFcInItf()  {
  }

  public ObserverFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public void update() throws java.rmi.RemoteException  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.update();
  }

}