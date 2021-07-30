package test;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {                             //开始画图
		 	super.paint(g);
	        g.setColor(Color.red);
	        
	        int i,start,end;
	        for(i=0,start=0,end=0;i<Operate.doclist.size();i++)
	        {
	        	start=Operate.doclist.get(i).getStart();             //获取文件的起始块与结尾块
	        	end=Operate.doclist.get(i).getEnd();
	        	g.fillRect(start/100, 0, (int)Math.ceil((double)(end-start)/100), 100); //根据起始块的与结尾块来定位与绘制大小
	        }
	        
	 }
}
