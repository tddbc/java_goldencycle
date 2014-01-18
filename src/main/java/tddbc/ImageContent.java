package tddbc;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public enum ImageContent {
	RED("red.jpg"),
	GREEN("green.jpg"),
	REFACTORING("refactoring.jpg"),
	;
	
	private final String file;
	
	private ImageContent(String file) {
		this.file = file;
	}

	public Image getImage() {
		BufferedImage i;
		try {
			i = ImageIO.read(getClass().getClassLoader().getResourceAsStream(file));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
		return i;
	}

	public ImageContent next() {
		if(this == RED){
			return GREEN;
		}
		if(this == GREEN){
			return REFACTORING;
		}
		if(this == REFACTORING){
			return RED;
		}
		throw new RuntimeException();
	}
}
