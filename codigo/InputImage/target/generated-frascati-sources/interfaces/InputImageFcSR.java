/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Wed Dec 04 22:19:57 COT 2019
 */

package interfaces;


public class InputImageFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<interfaces.InputImage>
implements interfaces.InputImage {

  public InputImageFcSR(Class<interfaces.InputImage> businessInterface,interfaces.InputImage service)  {
    super(businessInterface,service);
  }

  public interfaces.InputImage getService()  {
    return this;
  }

  public byte[] uploadImage(final java.lang.String arg0)  {
    byte[] ret = service.uploadImage(arg0);
    return ret;
  }

}
