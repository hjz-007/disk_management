package test;
import java.util.ArrayList;
import java.util.List;

public class Operate {
	public static int spaceSize=100*1024;	//����ȫ���ռ�
	public static int blocksize=4;			//�̿��С��KB��
	public static int rows=256;				//λʾͼ����
	public static int columns=100;			//λʾͼ����
	
	public static int[][] graph=new int[rows][columns];	//λ��ͼ��ʾ
	public static List<Doc> doclist=new ArrayList<>();	//�ļ��б�
	
	public static int lspace=spaceSize;		//ʣ���ܿռ�
	
	public static void initGraph() {        //��ʼ��λʾͼ
		for(int i=0;i<rows;i++)
		{
		  for(int j=0;j<columns;j++)
		  {
			  graph[i][j]=0;   
		  }
		}
		
	}
	
	public static int searchBegin(int size) {  //������ʼλ�鲢�޸�λ
		int begin=-1;
		int count=0;			
		double blocknum=Math.ceil((double)size/blocksize); //���ļ���Сת��Ϊ�������
		int i,j,k;

		for(i=0;i<rows;i++){
			  for(j=0;j<columns;j++){
				  if(graph[i][j]==0) 	 //����״̬Ϊ0�����������ÿռ�count��һ��
					  count++;			
				  else count=0;
				  if(count==blocknum) {  //��������״̬Ϊ0������������������������״̬��Ϊ1,
					  for(k=0;k<count;k++,j--){
						  graph[i][j]=1;
						  if(j==0 && k!=(count-1)) {	//������Ϊ0ʱ��kδ��������ѭ��״̬ʱ��i������һ�У�j��Ϊ���ֵ
							  i--;
							  j=columns;
							  }
					  }
					  j++;
					  lspace=lspace-count*4;  //��ȡʣ���ܿռ�
					  return columns*i+j;     //�����ļ���ʼ���
				  }
					  
			  }
		}
		return begin;
	}
	
	public static void delete(String name) {     //ɾ���ļ�
		int i,j,k;
		for(k=0;k<doclist.size();k++) {
			if(doclist.get(k).getName().equals(name)){	//�����ļ��б����ҵ����ļ�����ɾ��
				for(i=doclist.get(k).getStart()/columns;i<=doclist.get(k).getEnd()/columns;i++) {
					if(i==doclist.get(k).getStart()/columns) j=doclist.get(k).getStart()%columns;  //��Ϊ��һ�У���jΪ��ʼ�У�����Ϊ0
					else j=0;
					for(;j<columns;j++) {
						graph[i][j]=0;
						if(i==doclist.get(k).getEnd()/columns && j==doclist.get(k).getEnd()%columns) { //ֱ���ҵ������кͽ�����
							break;
						}
					}
				}
				
				lspace=lspace+(doclist.get(k).getEnd()-doclist.get(k).getStart()+1)*4;  //��ȡʣ���ܿռ�
				doclist.remove(k);  //���ļ��б���ɾ��
				return ;
			}
		}
	}
}
