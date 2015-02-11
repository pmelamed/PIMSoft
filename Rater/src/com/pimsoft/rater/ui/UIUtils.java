package com.pimsoft.rater.ui;

import java.awt.Rectangle;
import java.awt.Window;

public class UIUtils {
	public static void centerInContainer(Window window) {
		Window owner = window.getOwner();
		Rectangle bounds = owner.getBounds();
		window.setLocation(bounds.x + (bounds.width - window.getWidth()) / 2,
				bounds.y + (bounds.height - window.getHeight()) / 2);
	}
}
