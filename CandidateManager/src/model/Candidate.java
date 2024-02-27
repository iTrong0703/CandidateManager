package model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class Candidate implements Serializable{
	private int candidateCode;
	private String candidateName;
	private Province hometown;
	private Date birthday;
	private boolean gender; // true = male, false = female
	private float score1, score2, score3;
	
	public Candidate() {
	}

	public Candidate(int candidateCode, String candidateName, Province hometown, Date birthday, boolean gender,
			float score1, float score2, float score3) {
		this.candidateCode = candidateCode;
		this.candidateName = candidateName;
		this.hometown = hometown;
		this.birthday = birthday;
		this.gender = gender;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}

	public int getCandidateCode() {
		return candidateCode;
	}

	public void setCandidateCode(int candidateCode) {
		this.candidateCode = candidateCode;
	}

	public String getCandidateName() {
		return candidateName;
	}

	public void setCandidateName(String candidateName) {
		this.candidateName = candidateName;
	}

	public Province getHometown() {
		return hometown;
	}

	public void setHometown(Province hometown) {
		this.hometown = hometown;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	public float getScore1() {
		return score1;
	}

	public void setScore1(float score1) {
		this.score1 = score1;
	}

	public float getScore2() {
		return score2;
	}

	public void setScore2(float score2) {
		this.score2 = score2;
	}

	public float getScore3() {
		return score3;
	}

	public void setScore3(float score3) {
		this.score3 = score3;
	}

	@Override
	public String toString() {
		return "Candidate [candidateCode=" + candidateCode + ", candidateName=" + candidateName + ", hometown="
				+ hometown + ", birthday=" + birthday + ", gender=" + gender + ", score1=" + score1 + ", score2="
				+ score2 + ", score3=" + score3 + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(birthday, candidateCode, candidateName, gender, hometown, score1, score2, score3);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Candidate other = (Candidate) obj;
		return Objects.equals(birthday, other.birthday) && candidateCode == other.candidateCode
				&& Objects.equals(candidateName, other.candidateName) && gender == other.gender
				&& Objects.equals(hometown, other.hometown)
				&& Float.floatToIntBits(score1) == Float.floatToIntBits(other.score1)
				&& Float.floatToIntBits(score2) == Float.floatToIntBits(other.score2)
				&& Float.floatToIntBits(score3) == Float.floatToIntBits(other.score3);
	}
	
	
	
	
}
