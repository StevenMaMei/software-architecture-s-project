/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Mon Dec 02 17:20:09 COT 2019
 */

package interfaces;


public class ImageHandlerFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<interfaces.ImageHandler>
implements interfaces.ImageHandler {

  public ImageHandlerFcSR(Class<interfaces.ImageHandler> businessInterface,interfaces.ImageHandler service)  {
    super(businessInterface,service);
  }

  public interfaces.ImageHandler getService()  {
    return this;
  }

  public void setOutputRoute(final java.lang.String arg0)  {
    service.setOutputRoute(arg0);
  }

  public void ProcessImage(final byte[] arg0,final double arg1)  {
    service.ProcessImage(arg0,arg1);
  }

  public void setProcessedFragment(final interfaces.ICoordinatesDTO arg0)  {
    service.setProcessedFragment(arg0);
  }

}
