/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Mon Dec 02 17:19:33 COT 2019
 */

package interfaces;


public class ObserverFcOutItf
extends interfaces.ObserverFcInItf
implements interfaces.Observer,org.ow2.frascati.tinfi.TinfiComponentOutInterface<interfaces.Observer> {

  public ObserverFcOutItf()  {
  }

  public ObserverFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<interfaces.Observer> getServiceReference()  {
    return new interfaces.ObserverFcSR(interfaces.Observer.class,this);
  }

}
