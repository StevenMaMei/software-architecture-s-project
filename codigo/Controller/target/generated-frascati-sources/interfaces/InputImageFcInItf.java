/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Wed Dec 04 07:01:09 COT 2019
 */

package interfaces;


public class InputImageFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<interfaces.InputImage>
implements interfaces.InputImage {

  public InputImageFcInItf()  {
  }

  public InputImageFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public byte[] uploadImage(final java.lang.String arg0,final java.lang.String arg1)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    byte[] ret = impl.uploadImage(arg0,arg1);
    return ret;
  }

}
