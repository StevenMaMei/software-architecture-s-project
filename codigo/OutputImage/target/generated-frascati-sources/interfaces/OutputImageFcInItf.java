/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServerInterfaceClassGenerator
 * on: Wed Dec 04 22:02:58 COT 2019
 */

package interfaces;


public class OutputImageFcInItf
extends org.ow2.frascati.tinfi.TinfiComponentInterface<interfaces.OutputImage>
implements interfaces.OutputImage {

  public OutputImageFcInItf()  {
  }

  public OutputImageFcInItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public void saveImage(final byte[] arg0,final java.lang.String arg1)  {
    if ( impl == null )
    {
      throw new java.lang.NullPointerException("Trying to invoke a method on a client or server interface whose complementary interface is not bound.");
    }
    impl.saveImage(arg0,arg1);
  }

}
