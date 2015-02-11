package com.pimsoft.rater.ui;

import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JTabbedPane;

import com.pimsoft.rater.RaterApp;

public class RaterMainFrame extends JFrame {
	private static final long serialVersionUID = 1L;

	private final RaterApp app;

	public RaterMainFrame(RaterApp app) {
		this.app = app;
		setFrameBounds();
		JTabbedPane tpTabs = new JTabbedPane();
		tpTabs.add("Countries", new CountriesPane());
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				app.close();
			}
		});
	}

	private void setFrameBounds() {
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screenSize = toolkit.getScreenSize();
		Insets insets = toolkit.getScreenInsets(getGraphicsConfiguration());
		int visibleScreenWidth = screenSize.width - insets.left - insets.right;
		int visibleScreenHeight = screenSize.height - insets.bottom
				- insets.top;
		setSize(visibleScreenWidth * 5 / 6, visibleScreenHeight * 5 / 6);
		setLocation(insets.left + visibleScreenWidth / 12, insets.top
				+ visibleScreenHeight / 12);
	}

}
