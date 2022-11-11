package room.model.dto;

public class RDTO {

	private int rno;  
    private String rtitle ;
    private String rcontent ;
    private int rscore; 
    private String rfile ;
    private String rcomment;
    private String rdate;
    private int rview ;
    private int mno ;
    private String mid;
    
    public RDTO() {}

	public RDTO(int rno, String rtitle, String rcontent, int rscore, String rfile, String rcomment, String rdate,
			int rview, int mno, String mid) {
		super();
		this.rno = rno;
		this.rtitle = rtitle;
		this.rcontent = rcontent;
		this.rscore = rscore;
		this.rfile = rfile;
		this.rcomment = rcomment;
		this.rdate = rdate;
		this.rview = rview;
		this.mno = mno;
		this.mid = mid;
	}

	public int getRno() {
		return rno;
	}

	public void setRno(int rno) {
		this.rno = rno;
	}

	public String getRtitle() {
		return rtitle;
	}

	public void setRtitle(String rtitle) {
		this.rtitle = rtitle;
	}

	public String getRcontent() {
		return rcontent;
	}

	public void setRcontent(String rcontent) {
		this.rcontent = rcontent;
	}

	public int getRscore() {
		return rscore;
	}

	public void setRscore(int rscore) {
		this.rscore = rscore;
	}

	public String getRfile() {
		return rfile;
	}

	public void setRfile(String rfile) {
		this.rfile = rfile;
	}

	public String getRcomment() {
		return rcomment;
	}

	public void setRcomment(String rcomment) {
		this.rcomment = rcomment;
	}

	public String getRdate() {
		return rdate;
	}

	public void setRdate(String rdate) {
		this.rdate = rdate;
	}

	public int getRview() {
		return rview;
	}

	public void setRview(int rview) {
		this.rview = rview;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMid() {
		return mid;
	}

	public void setMid(String mid) {
		this.mid = mid;
	}

	@Override
	public String toString() {
		return "RDTO [rno=" + rno + ", rtitle=" + rtitle + ", rcontent=" + rcontent + ", rscore=" + rscore + ", rfile="
				+ rfile + ", rcomment=" + rcomment + ", rdate=" + rdate + ", rview=" + rview + ", mno=" + mno + ", mid="
				+ mid + "]";
	}

	
    
    
}
