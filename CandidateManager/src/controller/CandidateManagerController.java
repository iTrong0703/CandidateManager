package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JOptionPane;

import model.Candidate;
import model.Province;
import view.CandidateManagerView;

public class CandidateManagerController implements ActionListener{
	public CandidateManagerView view;
	
	public CandidateManagerController(CandidateManagerView view) {
		this.view = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String src = e.getActionCommand();
//		JOptionPane.showMessageDialog(view, src);
		if(src.equals("Insert")) {
			this.view.emptyForm();
			this.view.model.setChoose("Insert");
			this.view.enableInforBox();
		} else if(src.equals("Delete")) {
			this.view.emptyForm();
			this.view.model.setChoose("Delete");
			this.view.deleteChoose();
		} else if(src.equals("Edit")) {
			this.view.emptyForm();
			this.view.model.setChoose("Edit");
			this.view.displayedOnInforForm();
			this.view.enableInforBox();
		} else if(src.equals("Confirm")) {
			try {
				this.view.addOrEditCandidate();
				this.view.emptyForm();
				this.view.disableInforBox();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		} else if(src.equals("Cancel")) {
			this.view.emptyForm();
			this.view.disableInforBox();
		} else if(src.equals("Filter")) {
			this.view.filter();
		} else if(src.equals("Cancel Filter")) {
			this.view.refreshTable();
		} else if(src.equals("Open")) {
			this.view.openFile();
		} else if(src.equals("Save")) {
			this.view.saveFile();
		} else if(src.equals("Exit")) {
			this.view.exitApp();
		} else if(src.equals("About Me")) {
		
			String lineSep = System.lineSeparator();
			StringBuilder result = new StringBuilder();
			result.append("My information: ").append(lineSep).append(lineSep);
			result.append("Name: Nguyen Thanh Trong").append(lineSep);
			result.append("Age: 21").append(lineSep);
			result.append("Address: Vung Tau City").append(lineSep);
			result.append("Contact Number: 0354281759");

			JOptionPane.showMessageDialog(null, result.toString());
		}
	}

}
