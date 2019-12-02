/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Mon Dec 02 17:20:09 COT 2019
 */

package interfaces;


public class InputImageInterceptorSCAIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<interfaces.InputImage>
implements interfaces.InputImage,org.objectweb.fractal.julia.Interceptor {

  private static java.lang.reflect.Method[] METHODS;
  public InputImageInterceptorSCAIntent()  {
  }

  private InputImageInterceptorSCAIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    InputImageInterceptorSCAIntent clone = new InputImageInterceptorSCAIntent(getFcItfDelegate());
    initFcClone(clone);
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public byte[] uploadImage(final java.lang.String arg0)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[0]);
    try {
      if( handlers.size() == 0 ) {
        byte[] ret = impl.uploadImage(arg0);
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.InputImage> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[0],(Object)arg0);
    byte[] ret = (byte[]) ijp.proceed();
    return ret;
      }
    }
    catch( Throwable t ) {
      if( t instanceof RuntimeException ) {
        throw (RuntimeException) t;
      }
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(t);
    }
  }

  static  {
    try {
      METHODS = new java.lang.reflect.Method[]{
        interfaces.InputImage.class.getMethod("uploadImage",java.lang.String.class),
      };
    }
    catch( NoSuchMethodException e ) {
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(e);
    }
  }

}
