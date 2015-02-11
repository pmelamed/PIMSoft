package com.pimsoft.rater.ui;

import java.awt.Container;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;

import com.jgoodies.forms.factories.CC;
import com.jgoodies.forms.layout.FormLayout;
import com.pimsoft.rater.data.CountryData;

public class CountryDialog extends JDialog {
	private static final long serialVersionUID = 1L;

	private CountryData country;

	private JTextField tfFullName;

	private JTextField tfShortName;

	public CountryDialog(JFrame owner, CountryData country) {
		super(owner, "Country Properties", ModalityType.APPLICATION_MODAL,
				owner.getGraphicsConfiguration());
		this.country = country;
		createUI();
		pack();
		UIUtils.centerInContainer(this);
	}

	private void createUI() {
		Container content = getContentPane();
		content.setLayout(new FormLayout("p:n, 2:n, f:p:g",
				"p:n, 5:n, p:n, 7:n, p:n"));
		content.add(new JLabel("Country Long Name"), CC.xy(1, 1));
		tfFullName = new JTextField(country.getName(), 32);
		content.add(tfFullName, CC.xy(3, 1));
		content.add(new JLabel("Country Short Name"), CC.xy(1, 3, "l, f"));
		tfShortName = new JTextField(country.getShortName(), 3);
		content.add(tfShortName, CC.xy(3, 3));
		content.add(new JSeparator(), CC.xyw(1, 4, 3));
		FormLayout lmButtons = new FormLayout("2:g, p:n, 5:n, p:n");
		lmButtons.setColumnGroup(2, 4);
		JPanel pButtons = new JPanel(lmButtons);
		content.add(pButtons, CC.xyw(1, 5, 3));
		JButton bOk = new JButton("Ok");
		pButtons.add(bOk, CC.xy(2, 1));
		bOk.addActionListener(e -> {
			country.setName(tfFullName.getText());
			country.setShortName(tfShortName.getText());
		});
		JButton bCancel = new JButton("Cancel");
		pButtons.add(bCancel, CC.xy(4, 1));
		bCancel.addActionListener(e -> {
			setVisible(false);
		});
	}

}
