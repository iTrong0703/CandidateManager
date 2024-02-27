package test;

import javax.swing.UIManager;

import view.CandidateManagerView;

public class Test {
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new CandidateManagerView();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
