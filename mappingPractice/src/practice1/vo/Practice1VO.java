package practice1.vo;

import java.sql.*;
public class Practice1VO {
	private int tno;
	private String ttitle;
	private long ttext;
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public String getTtitle() {
		return ttitle;
	}
	public void setTtitle(String ttitle) {
		this.ttitle = ttitle;
	}
	public long getTtext() {
		return ttext;
	}
	public void setTtext(long ttext) {
		this.ttext = ttext;
	}
	
}
