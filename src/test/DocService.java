package test;

public class DocService {
	private int begin;
	public void docAdd(String name,int size) {   //�����ļ�
		Doc doc=new Doc();
				
		begin=Operate.searchBegin(size);  //��ȡ��ʼ������
			if(begin!=-1) {				  //����ʼ��Ų�Ϊ-1 �����ҵ����ʿռ䣬�����ļ��б��в���
				doc.setName(name);
				doc.setSize(size);
				doc.setStart(begin);
				doc.setEnd(begin+(int)Math.ceil((double)size/Operate.blocksize)-1);
				Operate.doclist.add(doc);
			}
	}
	public int getbegin() {					//�����ʼ������
		return begin;
	}
	
	public void docDelete(String name) {     //ɾ���ļ�
		Operate.delete(name);
	}
}
