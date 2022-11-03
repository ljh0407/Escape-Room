package room.model.dto;

public class QDTO {
	//고은시[11/01] 필드 수정
	private int bno;
	private String btitle;
	private String bcontent;
	private String bfile;
	private String bdate;
	private String reply;
	private int bview;
	private int mno;
	private String mid;
	

	public QDTO() {
		// TODO Auto-generated constructor stub
	}

	public QDTO(int bno, String btitle, String bcontent, String bfile, String bdate, String reply, int bview, int mno,
			String mid) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bfile = bfile;
		this.bdate = bdate;
		this.reply = reply;
		this.bview = bview;
		this.mno = mno;
		this.mid = mid;
	}

	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBfile() {
		return bfile;
	}

	public void setBfile(String bfile) {
		this.bfile = bfile;
	}

	public String getBdate() {
		return bdate;
	}

	public void setBdate(String bdate) {
		this.bdate = bdate;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getBview() {
		return bview;
	}

	public void setBview(int bview) {
		this.bview = bview;
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
		return "QDTO [bno=" + bno + ", btitle=" + btitle + ", bcontent=" + bcontent + ", bfile=" + bfile + ", bdate="
				+ bdate + ", reply=" + reply + ", bview=" + bview + ", mno=" + mno + ", mid=" + mid + "]";
	}

}
