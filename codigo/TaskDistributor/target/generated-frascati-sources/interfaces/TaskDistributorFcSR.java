/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.ServiceReferenceClassGenerator
 * on: Sun Dec 01 21:43:18 COT 2019
 */

package interfaces;


public class TaskDistributorFcSR
extends org.ow2.frascati.tinfi.oasis.ServiceReferenceImpl<interfaces.TaskDistributor>
implements interfaces.TaskDistributor {

  public TaskDistributorFcSR(Class<interfaces.TaskDistributor> businessInterface,interfaces.TaskDistributor service)  {
    super(businessInterface,service);
  }

  public interfaces.TaskDistributor getService()  {
    return this;
  }

  public int distribute(final long arg0,final int arg1,final int arg2,final double arg3)  {
    int ret = service.distribute(arg0,arg1,arg2,arg3);
    return ret;
  }

}
