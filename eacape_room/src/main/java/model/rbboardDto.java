package model;

public class rbboardDto {
	
	private int rbno;  			// 리뷰 게시물 번호
	private String rbtitle;		// 리뷰 제목
    private int rbscore ; 		// 리뷰 점수
    private String rbcontent;	// 리뷰내용
    private String rbdate; 		// 리뷰 작성일
    private int rbview ;		// 리뷰 조회수
    private int mno;  			// 회원번호
    
    
	public rbboardDto(int rbno, String rbtitle, int rbscore, String rbcontent, String rbdate, int rbview, int mno) {
		super();
		this.rbno = rbno;
		this.rbtitle = rbtitle;
		this.rbscore = rbscore;
		this.rbcontent = rbcontent;
		this.rbdate = rbdate;
		this.rbview = rbview;
		this.mno = mno;
	}


	public int getRbno() {
		return rbno;
	}


	public void setRbno(int rbno) {
		this.rbno = rbno;
	}


	public String getRbtitle() {
		return rbtitle;
	}


	public void setRbtitle(String rbtitle) {
		this.rbtitle = rbtitle;
	}


	public int getRbscore() {
		return rbscore;
	}


	public void setRbscore(int rbscore) {
		this.rbscore = rbscore;
	}


	public String getRbcontent() {
		return rbcontent;
	}


	public void setRbcontent(String rbcontent) {
		this.rbcontent = rbcontent;
	}


	public String getRbdate() {
		return rbdate;
	}


	public void setRbdate(String rbdate) {
		this.rbdate = rbdate;
	}


	public int getRbview() {
		return rbview;
	}


	public void setRbview(int rbview) {
		this.rbview = rbview;
	}


	public int getMno() {
		return mno;
	}


	public void setMno(int mno) {
		this.mno = mno;
	}
    
    
	
    
    
    
}
