package cg.demo.springcore.beans;

public class SBU {
	int sbuID;
	String sbuName;
	String sbuHead;
	
	public SBU(int sbuID, String sbuName, String sbuHead) {
		super();
		this.sbuID = sbuID;
		this.sbuName = sbuName;
		this.sbuHead = sbuHead;
	}
	public int getSbuID() {
		return sbuID;
	}
	public void setSbuID(int sbuID) {
		this.sbuID = sbuID;
	}
	public String getSbuName() {
		return sbuName;
	}
	public void setSbuName(String sbuName) {
		this.sbuName = sbuName;
	}
	public String getSbuHead() {
		return sbuHead;
	}
	public void setSbuHead(String sbuHead) {
		this.sbuHead = sbuHead;
	}
	@Override
	public String toString() {
		return "SBU [sbuID=" + sbuID + ", sbuName=" + sbuName + ", sbuHead=" + sbuHead + "]";
	}
	
}
