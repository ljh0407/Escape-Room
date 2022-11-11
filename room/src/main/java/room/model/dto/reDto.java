package room.model.dto;

public class reDto {

private int	gno; 
private String    gname;  
private String    gdate; 	
private  int   mno; 
	

public reDto() {
	// TODO Auto-generated constructor stub
}


public reDto(int gno, String gname, String gdate, int mno) {
	super();
	this.gno = gno;
	this.gname = gname;
	this.gdate = gdate;
	this.mno = mno;
}


public int getGno() {
	return gno;
}


public void setGno(int gno) {
	this.gno = gno;
}


public String getGname() {
	return gname;
}


public void setGname(String gname) {
	this.gname = gname;
}


public String getGdate() {
	return gdate;
}


public void setGdate(String gdate) {
	this.gdate = gdate;
}


public int getMno() {
	return mno;
}


public void setMno(int mno) {
	this.mno = mno;
}


@Override
public String toString() {
	return "reDto [gno=" + gno + ", gname=" + gname + ", gdate=" + gdate + ", mno=" + mno + "]";
}



}
