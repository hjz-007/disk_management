package test;
public class Doc {
	private String name;		//�ļ���
	private int size;			//�ļ���С��KB��
	private int start;			//��ʼ������
	private int end;			//��β������
	
	public Doc() {
	}
	
	public void setName(String name) {	//�����ļ�����
		this.name=name;
	}
	public void setSize(int size) {		//�����ļ���С
		this.size=size;
	}
	public void setStart(int start) {   //������ʼ���
		this.start=start;
	}
	
	public void setEnd(int end) {		//���ý�β���
		this.end=end;
	}
	public String getName() {			//��ȡ�ļ�����
		return name;
	}
	public int getSize() {				//��ȡ�ļ���С
		return size;
	}
	public int getStart() {				//��ȡ��ʼ���
		return start;
	}
	public int getEnd() {				//��ȡ��β���
		return end;
	}
}
