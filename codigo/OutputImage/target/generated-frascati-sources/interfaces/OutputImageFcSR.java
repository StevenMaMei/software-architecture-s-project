/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Tue Dec 03 11:31:10 COT 2019
 */

package interfaces;


public class OutputImageFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<interfaces.OutputImage>
implements interfaces.OutputImage {

  public OutputImageFcSR(Class<interfaces.OutputImage> businessInterface,interfaces.OutputImage service)  {
    super(businessInterface,service);
  }

  public interfaces.OutputImage getService()  {
    return this;
  }

  public void saveImage(final byte[] arg0,final java.lang.String arg1)  {
    service.saveImage(arg0,arg1);
  }

}
