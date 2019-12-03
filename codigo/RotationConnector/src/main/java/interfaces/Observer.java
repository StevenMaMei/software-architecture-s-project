package interfaces;

import java.io.Serializable;

import org.osoa.sca.annotations.Scope;
import org.osoa.sca.annotations.Service;


@Service
@Scope("COMPOSITE")
public interface Observer extends Serializable {

	public void update(Subject subject);
	public void attach();
	public int getId();
	public String getBinding();
}
