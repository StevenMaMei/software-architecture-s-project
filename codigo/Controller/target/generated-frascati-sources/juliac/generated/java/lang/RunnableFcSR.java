/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Wed Dec 04 07:01:09 COT 2019
 */

package juliac.generated.java.lang;


public class RunnableFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<java.lang.Runnable>
implements java.lang.Runnable {

  public RunnableFcSR(Class<java.lang.Runnable> businessInterface,java.lang.Runnable service)  {
    super(businessInterface,service);
  }

  public java.lang.Runnable getService()  {
    return this;
  }

  public void run()  {
    service.run();
  }

}
