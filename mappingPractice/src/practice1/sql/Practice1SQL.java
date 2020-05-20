package practice1.sql;

public class Practice1SQL {
	public final int SEL_DATA = 1001;
	
	public String getSQL(int code) {
		StringBuffer buff = new StringBuffer();
		switch(code) {
		case SEL_DATA:
			buff.append("SELECT ");
			buff.append("	* ");
			buff.append("FROM ");
			buff.append("	test01 ");
			break;
		}
		return buff.toString();
	}
}
