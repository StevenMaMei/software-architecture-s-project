/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Tue Dec 03 14:02:26 COT 2019
 */

package interfaces;


public class OutputImageFcOutItf
extends interfaces.OutputImageFcInItf
implements interfaces.OutputImage,org.ow2.frascati.tinfi.TinfiComponentOutInterface<interfaces.OutputImage> {

  public OutputImageFcOutItf()  {
  }

  public OutputImageFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<interfaces.OutputImage> getServiceReference()  {
    return new interfaces.OutputImageFcSR(interfaces.OutputImage.class,this);
  }

}
