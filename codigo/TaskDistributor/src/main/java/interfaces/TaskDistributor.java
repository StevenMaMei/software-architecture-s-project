package interfaces;

import org.osoa.sca.annotations.Service;

@Service
public interface TaskDistributor {
	public void distribute(long idImage, int height, int width, double radians);
}
