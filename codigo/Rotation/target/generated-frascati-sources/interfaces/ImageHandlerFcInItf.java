/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Sun Dec 01 21:43:27 COT 2019
 */

package interfaces;


public class ImageHandlerFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<interfaces.ImageHandler>
implements interfaces.ImageHandler {

  public ImageHandlerFcInItf()  {
  }

  public ImageHandlerFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public void setProcessedFragment(final model.CoordinatesDTO arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.setProcessedFragment(arg0);
  }

  public void ProcessImage(final byte[] arg0,final double arg1)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.ProcessImage(arg0,arg1);
  }

  public void setOutputRoute(final java.lang.String arg0)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.setOutputRoute(arg0);
  }

}