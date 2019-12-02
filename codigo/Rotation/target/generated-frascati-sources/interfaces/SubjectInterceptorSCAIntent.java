/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Sun Dec 01 21:43:27 COT 2019
 */

package interfaces;


public class SubjectInterceptorSCAIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<interfaces.Subject>
implements interfaces.Subject,org.objectweb.fractal.julia.Interceptor {

  private static java.lang.reflect.Method[] METHODS;
  public SubjectInterceptorSCAIntent()  {
  }

  private SubjectInterceptorSCAIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    SubjectInterceptorSCAIntent clone = new SubjectInterceptorSCAIntent(getFcItfDelegate());
    initFcClone(clone);
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public void attach(final interfaces.Observer arg0)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[1]);
    try {
      if( handlers.size() == 0 ) {
        impl.attach(arg0);
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[1],(Object)arg0);
    ijp.proceed();
    Object ret = null;
      }
    }
    catch( Throwable t ) {
      if( t instanceof RuntimeException ) {
        throw (RuntimeException) t;
      }
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(t);
    }
  }

  public void detach(final interfaces.Observer arg0)  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[2]);
    try {
      if( handlers.size() == 0 ) {
        impl.detach(arg0);
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[2],(Object)arg0);
    ijp.proceed();
    Object ret = null;
      }
    }
    catch( Throwable t ) {
      if( t instanceof RuntimeException ) {
        throw (RuntimeException) t;
      }
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(t);
    }
  }

  public void noti()  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[3]);
    try {
      if( handlers.size() == 0 ) {
        impl.noti();
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[3]);
    ijp.proceed();
    Object ret = null;
      }
    }
    catch( Throwable t ) {
      if( t instanceof RuntimeException ) {
        throw (RuntimeException) t;
      }
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(t);
    }
  }

  public model.CoordinatesDTO getState()  {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[0]);
    try {
      if( handlers.size() == 0 ) {
        model.CoordinatesDTO ret = impl.getState();
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[0]);
    model.CoordinatesDTO ret = (model.CoordinatesDTO) ijp.proceed();
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
        interfaces.Subject.class.getMethod("getState"),
        interfaces.Subject.class.getMethod("attach",interfaces.Observer.class),
        interfaces.Subject.class.getMethod("detach",interfaces.Observer.class),
        interfaces.Subject.class.getMethod("noti"),
      };
    }
    catch( NoSuchMethodException e ) {
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(e);
    }
  }

}
