package test;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class DrawPanel extends JPanel{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void paint(Graphics g) {                             //��ʼ��ͼ
		 	super.paint(g);
	        g.setColor(Color.red);
	        
	        int i,start,end;
	        for(i=0,start=0,end=0;i<Operate.doclist.size();i++)
	        {
	        	start=Operate.doclist.get(i).getStart();             //��ȡ�ļ�����ʼ�����β��
	        	end=Operate.doclist.get(i).getEnd();
	        	g.fillRect(start/100, 0, (int)Math.ceil((double)(end-start)/100), 100); //������ʼ������β������λ����ƴ�С
	        }
	        
	 }
}
