package test;
import java.util.ArrayList;
import java.util.List;

public class Operate {
	public static int spaceSize=100*1024;	//磁盘全部空间
	public static int blocksize=4;			//盘块大小（KB）
	public static int rows=256;				//位示图行数
	public static int columns=100;			//位示图列数
	
	public static int[][] graph=new int[rows][columns];	//位数图表示
	public static List<Doc> doclist=new ArrayList<>();	//文件列表
	
	public static int lspace=spaceSize;		//剩余总空间
	
	public static void initGraph() {        //初始化位示图
		for(int i=0;i<rows;i++)
		{
		  for(int j=0;j<columns;j++)
		  {
			  graph[i][j]=0;   
		  }
		}
		
	}
	
	public static int searchBegin(int size) {  //查找起始位块并修改位
		int begin=-1;
		int count=0;			
		double blocknum=Math.ceil((double)size/blocksize); //将文件大小转化为块的数量
		int i,j,k;

		for(i=0;i<rows;i++){
			  for(j=0;j<columns;j++){
				  if(graph[i][j]==0) 	 //若块状态为0，则连续可用空间count加一；
					  count++;			
				  else count=0;
				  if(count==blocknum) {  //若连续块状态为0的数量等于所需块数量，则块状态改为1,
					  for(k=0;k<count;k++,j--){
						  graph[i][j]=1;
						  if(j==0 && k!=(count-1)) {	//当列数为0时且k未满足跳出循环状态时，i跳到上一行，j设为最大值
							  i--;
							  j=columns;
							  }
					  }
					  j++;
					  lspace=lspace-count*4;  //获取剩余总空间
					  return columns*i+j;     //返回文件起始块号
				  }
					  
			  }
		}
		return begin;
	}
	
	public static void delete(String name) {     //删除文件
		int i,j,k;
		for(k=0;k<doclist.size();k++) {
			if(doclist.get(k).getName().equals(name)){	//若在文件列表中找到该文件，则删除
				for(i=doclist.get(k).getStart()/columns;i<=doclist.get(k).getEnd()/columns;i++) {
					if(i==doclist.get(k).getStart()/columns) j=doclist.get(k).getStart()%columns;  //若为第一行，则j为开始列，否则为0
					else j=0;
					for(;j<columns;j++) {
						graph[i][j]=0;
						if(i==doclist.get(k).getEnd()/columns && j==doclist.get(k).getEnd()%columns) { //直到找到结束行和结束列
							break;
						}
					}
				}
				
				lspace=lspace+(doclist.get(k).getEnd()-doclist.get(k).getStart()+1)*4;  //获取剩余总空间
				doclist.remove(k);  //从文件列表中删除
				return ;
			}
		}
	}
}
