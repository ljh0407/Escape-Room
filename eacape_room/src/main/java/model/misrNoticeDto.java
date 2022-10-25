package model;

public class misrNoticeDto {

	private int nno; 
    private String ntitle;		
	private String ncontent;			
    private String ndate; 		
	private int nview;	
	private int mno;
	private String mid;

	public misrNoticeDto() {}

	public misrNoticeDto(int nno, String ntitle, String ncontent, String ndate, int nview, int mno, String mid) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.nview = nview;
		this.mno = mno;
		this.mid = mid;
	}

	public int getNno() {
		return nno;
	}

	public void setNno(int nno) {
		this.nno = nno;
	}

	public String getNtitle() {
		return ntitle;
	}

	public void setNtitle(String ntitle) {
		this.ntitle = ntitle;
	}

	public String getNcontent() {
		return ncontent;
	}

	public void setNcontent(String ncontent) {
		this.ncontent = ncontent;
	}

	public String getNdate() {
		return ndate;
	}

	public void setNdate(String ndate) {
		this.ndate = ndate;
	}

	public int getNview() {
		return nview;
	}

	public void setNview(int nview) {
		this.nview = nview;
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
		return "misrNoticeDto [nno=" + nno + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ndate=" + ndate
				+ ", nview=" + nview + ", mno=" + mno + ", mid=" + mid + "]";
	}
	
	
	
	
	
	
}
