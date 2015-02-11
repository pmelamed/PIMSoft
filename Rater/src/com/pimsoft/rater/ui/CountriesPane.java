package com.pimsoft.rater.ui;

import javax.swing.JPanel;
import javax.swing.JTable;

import com.jgoodies.forms.layout.FormLayout;

public class CountriesPane extends JPanel {
	private JTable tbCountries;

	public CountriesPane() {
		super(new FormLayout("f:10:g", "f:10:g, 7:n, p:n"));
		tbCountries = new JTable();
	}

}
