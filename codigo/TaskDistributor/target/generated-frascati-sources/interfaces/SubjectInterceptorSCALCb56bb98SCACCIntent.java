/*
 * Generated by: org.ow2.frascati.tinfi.opt.oo.InterceptorClassGenerator
 * on: Mon Dec 02 17:17:25 COT 2019
 */

package interfaces;


public class SubjectInterceptorSCALCb56bb98SCACCIntent
extends org.ow2.frascati.tinfi.TinfiComponentInterceptor<interfaces.Subject>
implements interfaces.Subject,org.objectweb.fractal.julia.Interceptor {

  private juliac.generated.SCALifeCycleControllerImpl _lc;
  private static java.lang.reflect.Method[] METHODS;
  public SubjectInterceptorSCALCb56bb98SCACCIntent()  {
  }

  private SubjectInterceptorSCALCb56bb98SCACCIntent(Object obj)  {
    setFcItfDelegate(obj);
  }

  public void initFcController(org.objectweb.fractal.julia.InitializationContext ic) throws org.objectweb.fractal.api.factory.InstantiationException  {
    super.initFcController(ic);
    Object olc = ic.getInterface("lifecycle-controller");
    if ( !( olc instanceof juliac.generated.SCALifeCycleControllerImpl ) )
    {
      while ( olc instanceof org.objectweb.fractal.julia.Interceptor )
      {
        olc = ((org.objectweb.fractal.julia.Interceptor)olc).getFcItfDelegate();
      }

    }
    _lc = (juliac.generated.SCALifeCycleControllerImpl) olc;
    initIntentHandlersMap(METHODS);
  }

  public Object clone()  {
    SubjectInterceptorSCALCb56bb98SCACCIntent clone = new SubjectInterceptorSCALCb56bb98SCACCIntent(getFcItfDelegate());
    initFcClone(clone);
    clone._lc = _lc;
    clone.initIntentHandlersMap(METHODS);
    return clone;
  }

  public void attach(final interfaces.Observer arg0)  {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.incrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter++;
      }

    }

      try {
    interfaces.Subject impl = pushFcAndGet("subject",interfaces.Subject.class,this);
    try {
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
    finally {
      releaseFcAndPop(impl,false);
    }
      }
      finally {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.decrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter--;
      }

    }

      }
  }

  public void detach(final interfaces.Observer arg0)  {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.incrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter++;
      }

    }

      try {
    interfaces.Subject impl = pushFcAndGet("subject",interfaces.Subject.class,this);
    try {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[3]);
    try {
      if( handlers.size() == 0 ) {
        impl.detach(arg0);
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[3],(Object)arg0);
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
    finally {
      releaseFcAndPop(impl,false);
    }
      }
      finally {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.decrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter--;
      }

    }

      }
  }

  public interfaces.ICoordinatesDTO getState()  {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.incrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter++;
      }

    }

      try {
    interfaces.Subject impl = pushFcAndGet("subject",interfaces.Subject.class,this);
    try {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[0]);
    try {
      if( handlers.size() == 0 ) {
        interfaces.ICoordinatesDTO ret = impl.getState();
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[0]);
    interfaces.ICoordinatesDTO ret = (interfaces.ICoordinatesDTO) ijp.proceed();
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
    finally {
      releaseFcAndPop(impl,false);
    }
      }
      finally {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.decrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter--;
      }

    }

      }
  }

  public int distribute(final long arg0,final int arg1,final int arg2,final double arg3)  {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.incrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter++;
      }

    }

      try {
    interfaces.Subject impl = pushFcAndGet("subject",interfaces.Subject.class,this);
    try {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[4]);
    try {
      if( handlers.size() == 0 ) {
        int ret = impl.distribute(arg0,arg1,arg2,arg3);
        return ret;
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[4],(Object)arg0,(Object)arg1,(Object)arg2,(Object)arg3);
    Object proceed = ijp.proceed();
    int ret = (proceed==null) ? 0 : (java.lang.Integer)proceed;
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
    finally {
      releaseFcAndPop(impl,false);
    }
      }
      finally {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.decrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter--;
      }

    }

      }
  }

  public void noti()  {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.incrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter++;
      }

    }

      try {
    interfaces.Subject impl = pushFcAndGet("subject",interfaces.Subject.class,this);
    try {
    java.util.List<org.ow2.frascati.tinfi.api.IntentHandler> handlers = intentHandlersMap.get(METHODS[2]);
    try {
      if( handlers.size() == 0 ) {
        impl.noti();
      }
      else {
        org.objectweb.fractal.api.Component comp = getFcComponent();
        org.objectweb.fractal.api.Interface itf = getFcItf();
        org.ow2.frascati.tinfi.IntentJoinPointImpl<interfaces.Subject> ijp = new org.ow2.frascati.tinfi.IntentJoinPointImpl();
        ijp.init(handlers,comp,itf,impl,METHODS[2]);
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
    finally {
      releaseFcAndPop(impl,false);
    }
      }
      finally {
    synchronized(_lc)
    {
      if ( _lc.fcState != 2 )
      {
        _lc.decrementFcInvocationCounter();
      }
      else
      {
        _lc.fcInvocationCounter--;
      }

    }

      }
  }

  static  {
    try {
      METHODS = new java.lang.reflect.Method[]{
        interfaces.Subject.class.getMethod("getState"),
        interfaces.Subject.class.getMethod("attach",interfaces.Observer.class),
        interfaces.Subject.class.getMethod("noti"),
        interfaces.Subject.class.getMethod("detach",interfaces.Observer.class),
        interfaces.Subject.class.getMethod("distribute",long.class,int.class,int.class,double.class),
      };
    }
    catch( NoSuchMethodException e ) {
      throw new org.ow2.frascati.tinfi.TinfiRuntimeException(e);
    }
  }

}
