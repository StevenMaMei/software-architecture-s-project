package model;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ImageWrapper implements Serializable {

	private static final long serialVersionUID = 1L;

	private transient BufferedImage image;
	
	public ImageWrapper(BufferedImage im) {
		image = im;
	}
	public BufferedImage getImage() {
		return image;
	}

	public void setImage(BufferedImage image) {
		this.image = image;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        
    }
	
	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
    }
}
