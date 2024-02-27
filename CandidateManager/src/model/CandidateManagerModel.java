package model;

import java.util.ArrayList;

public class CandidateManagerModel {
	public ArrayList<Candidate> candidateList;
	private String choose;
	private String fileName;

	public CandidateManagerModel() {
		// khởi tạo
		this.candidateList = new ArrayList<Candidate>();
		this.choose = "";
		this.fileName = "";
	}

	public CandidateManagerModel(ArrayList<Candidate> candidateList) {
		this.candidateList = candidateList;
	}

	public ArrayList<Candidate> getCandidateList() {
		return candidateList;
	}

	public void setCandidateList(ArrayList<Candidate> candidateList) {
		this.candidateList = candidateList;
	}
	
	public String getChoose() {
		return choose;
	}

	public void setChoose(String choose) {
		this.choose = choose;
	}
	
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public void insert(Candidate candidate) {
		this.candidateList.add(candidate);
	}
	
	public void delete(Candidate candidate) {
		this.candidateList.remove(candidate);
	}
	


	public boolean checkExist(Candidate candidateCheck) {
		for (Candidate c : candidateList) {
			if(c.getCandidateCode() == candidateCheck.getCandidateCode()) {
				return true;
			}
		}
		return false;
	}
}
