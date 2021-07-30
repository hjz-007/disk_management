package test;

public class DocService {
	private int begin;
	public void docAdd(String name,int size) {   //增加文件
		Doc doc=new Doc();
				
		begin=Operate.searchBegin(size);  //获取起始物理块号
			if(begin!=-1) {				  //若起始块号不为-1 ，即找到合适空间，则在文件列表中插入
				doc.setName(name);
				doc.setSize(size);
				doc.setStart(begin);
				doc.setEnd(begin+(int)Math.ceil((double)size/Operate.blocksize)-1);
				Operate.doclist.add(doc);
			}
	}
	public int getbegin() {					//获得起始物理块号
		return begin;
	}
	
	public void docDelete(String name) {     //删除文件
		Operate.delete(name);
	}
}
