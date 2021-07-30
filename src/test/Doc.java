package test;
public class Doc {
	private String name;		//文件名
	private int size;			//文件大小（KB）
	private int start;			//起始物理块号
	private int end;			//结尾物理块号
	
	public Doc() {
	}
	
	public void setName(String name) {	//设置文件名字
		this.name=name;
	}
	public void setSize(int size) {		//设置文件大小
		this.size=size;
	}
	public void setStart(int start) {   //设置起始块号
		this.start=start;
	}
	
	public void setEnd(int end) {		//设置结尾块号
		this.end=end;
	}
	public String getName() {			//获取文件名字
		return name;
	}
	public int getSize() {				//获取文件大小
		return size;
	}
	public int getStart() {				//获取起始块号
		return start;
	}
	public int getEnd() {				//获取结尾块号
		return end;
	}
}
