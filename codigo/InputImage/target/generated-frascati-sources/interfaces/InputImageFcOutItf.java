/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Mon Dec 02 11:19:07 COT 2019
 */

package interfaces;


public class InputImageFcOutItf
extends interfaces.InputImageFcInItf
implements interfaces.InputImage,org.ow2.frascati.tinfi.TinfiComponentOutInterface<interfaces.InputImage> {

  public InputImageFcOutItf()  {
  }

  public InputImageFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<interfaces.InputImage> getServiceReference()  {
    return new interfaces.InputImageFcSR(interfaces.InputImage.class,this);
  }

}