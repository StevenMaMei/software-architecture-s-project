/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ClientInterfaceClassGenerator
 * on: Sun Dec 01 01:53:22 COT 2019
 */

package interfaces;


public class SubjectFcOutItf
extends interfaces.SubjectFcInItf
implements interfaces.Subject,org.ow2.frascati.tinfi.TinfiComponentOutInterface<interfaces.Subject> {

  public SubjectFcOutItf()  {
  }

  public SubjectFcOutItf(org.objectweb.fractal.api.Component component,String s,org.objectweb.fractal.api.Type type,boolean flag,Object obj)  {
    super(component,s,type,flag,obj);
  }

  public org.oasisopen.sca.ServiceReference<interfaces.Subject> getServiceReference()  {
    return new interfaces.SubjectFcSR(interfaces.Subject.class,this);
  }

}