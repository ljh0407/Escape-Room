package model;

public class misrNoticeDto {

	private int nno; 
    private String ntitle;		
	private String ncontent;			
    private String ndate; 		
	private int bview;	
	
	public misrNoticeDto() {}

	public misrNoticeDto(int nno, String ntitle, String ncontent, String ndate, int bview) {
		super();
		this.nno = nno;
		this.ntitle = ntitle;
		this.ncontent = ncontent;
		this.ndate = ndate;
		this.bview = bview;
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

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
	}

	@Override
	public String toString() {
		return "misrNoticeDto [nno=" + nno + ", ntitle=" + ntitle + ", ncontent=" + ncontent + ", ndate=" + ndate
				+ ", bview=" + bview + "]";
	}
	
	
	
	
}
