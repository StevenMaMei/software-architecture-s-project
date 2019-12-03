package model;

import java.util.TreeMap;

public class SaverSupervisor implements Runnable {

	private TreeMap<Long, Integer> quantOfPartsOfAnImage;
	private TreeMap<Long, Integer> quantOfPartsRecieve;
	private ImageHandlerImp handler;
	public SaverSupervisor(TreeMap<Long, Integer> imageParts, TreeMap<Long, Integer> partsReceive, ImageHandlerImp han) {
		quantOfPartsOfAnImage = imageParts;
		quantOfPartsRecieve = partsReceive;
		handler = han;
	}
	public void run() {
		while(true) {
	        for(long id : quantOfPartsOfAnImage.keySet()) {
	        	if(quantOfPartsRecieve.get(id) != null && quantOfPartsRecieve.get(id) == quantOfPartsOfAnImage.get(id)) {
	        		handler.saveImage(id, handler.route);
	        	}
	        }
	        try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        if (Thread.interrupted()) {
	            return;
	        }
	    }
	}

}
