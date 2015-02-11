package com.pimsoft.rater;

import java.awt.EventQueue;

import com.pimsoft.rater.ui.RaterMainFrame;

public class RaterApp {
	private static RaterApp INSTANCE = new RaterApp();
	private RaterMainFrame mainFrame;

	private void start() {
		mainFrame = new RaterMainFrame(this);
		mainFrame.setVisible(true);
	}

	public void close() {
		System.exit(0);
	}

	public static RaterApp get() {
		return INSTANCE;
	}

	public static void main(String[] args) {
		try {
			EventQueue.invokeAndWait(() -> {
				get().start();
			});
		} catch (Throwable e) {
			e.printStackTrace();
		}
	}
}
