package test;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.border.TitledBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.border.LineBorder;
import java.awt.Color;


public class CtPanel{

	private JFrame frame;
	private JTextField cIdText;
	private JTextField cSizeText;
	private JTextField dIdText;
	private JButton dbutton;
	private JButton cbutton;
	private JTable table;

	static DocService ds;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Operate.initGraph();
					CtPanel window = new CtPanel();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CtPanel() {
		initialize();
	}	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {				//初始化界面
		frame = new JFrame();
		frame.setTitle("\u78C1\u76D8\u7A7A\u95F4\u7BA1\u7406\u7CFB\u7EDF");
		frame.setBounds(600, 200, 858, 631);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		JPanel cpanel = new JPanel();
		cpanel.setBorder(new TitledBorder(null, "\u521B\u5EFA\u9762\u677F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel dpanel = new JPanel();
		dpanel.setBorder(new TitledBorder(null, "\u5220\u9664\u9762\u677F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		JPanel dppanel = new JPanel();
		dppanel.setBorder(new TitledBorder(null, "\u5C55\u793A\u9762\u677F", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		GroupLayout groupLayout = new GroupLayout(frame.getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(dpanel, 0, 0, Short.MAX_VALUE)
						.addComponent(cpanel, GroupLayout.DEFAULT_SIZE, 295, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(dppanel, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addComponent(dppanel, GroupLayout.DEFAULT_SIZE, 570, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(cpanel, GroupLayout.PREFERRED_SIZE, 287, GroupLayout.PREFERRED_SIZE)
							.addGap(18)
							.addComponent(dpanel, GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)))
					.addContainerGap())
		);
		
		JLabel spaceLabel = new JLabel("\u78C1\u76D8\u7A7A\u95F4\u60C5\u51B5");
		
		JLabel allLeft = new JLabel("\u5269\u4F59\u603B\u7A7A\u95F4(KB)\uFF1A");
		
		JLabel lspace = new JLabel("102400");
		
		table = new JTable();
		DefaultTableModel tableModel = (DefaultTableModel)table.getModel();
		table.setBorder(new LineBorder(new Color(0, 0, 0)));
		
		table.setRowHeight(30);
		table.setEnabled(false);
		
		JScrollPane jsp = new JScrollPane(table);
		
		tableModel.addColumn("文件名");
		tableModel.addColumn("大小（KB）");
		tableModel.addColumn("起始块号");
		tableModel.addColumn("结尾块号");
		
		JLabel label = new JLabel("\u7A7A\u95F4\u5360\u7528\u793A\u610F\u56FE");
		
		
		GroupLayout gl_dppanel = new GroupLayout(dppanel);
		gl_dppanel.setHorizontalGroup(
			gl_dppanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dppanel.createSequentialGroup()
					.addGroup(gl_dppanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dppanel.createParallelGroup(Alignment.LEADING, false)
							.addGroup(gl_dppanel.createSequentialGroup()
								.addGap(31)
								.addComponent(allLeft)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(lspace))
							.addGroup(gl_dppanel.createSequentialGroup()
								.addGap(195)
								.addComponent(spaceLabel))
							.addGroup(gl_dppanel.createSequentialGroup()
								.addGap(23)
								.addComponent(jsp, GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)))
						.addGroup(gl_dppanel.createSequentialGroup()
							.addGap(179)
							.addComponent(label)))
					.addContainerGap(44, Short.MAX_VALUE))
		);
		gl_dppanel.setVerticalGroup(
			gl_dppanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dppanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(spaceLabel)
					.addPreferredGap(ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
					.addGroup(gl_dppanel.createParallelGroup(Alignment.BASELINE)
						.addComponent(allLeft)
						.addComponent(lspace))
					.addGap(18)
					.addComponent(jsp, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addGap(50)
					.addComponent(label)
					.addGap(207))
		);
		dppanel.setLayout(gl_dppanel);
		
		JLabel dIdLabel = new JLabel("\u6587\u4EF6\u540D\uFF1A");
		
		dIdText = new JTextField();
		dIdText.setColumns(10);
		
		dbutton = new JButton("\u5220\u9664\u6587\u4EF6");
		GroupLayout gl_dpanel = new GroupLayout(dpanel);
		gl_dpanel.setHorizontalGroup(
			gl_dpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dpanel.createSequentialGroup()
					.addGroup(gl_dpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_dpanel.createSequentialGroup()
							.addGap(114)
							.addComponent(dIdLabel))
						.addGroup(gl_dpanel.createSequentialGroup()
							.addGap(98)
							.addGroup(gl_dpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(dIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(dbutton))))
					.addContainerGap(114, Short.MAX_VALUE))
		);
		gl_dpanel.setVerticalGroup(
			gl_dpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_dpanel.createSequentialGroup()
					.addGap(22)
					.addComponent(dIdLabel)
					.addGap(18)
					.addComponent(dIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(41)
					.addComponent(dbutton)
					.addContainerGap(81, Short.MAX_VALUE))
		);
		dpanel.setLayout(gl_dpanel);
		
		JLabel cIdLabel = new JLabel("\u6587\u4EF6\u540D\uFF1A");
		
		cbutton = new JButton("\u521B\u5EFA\u6587\u4EF6");
		cbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JLabel csizeLabel = new JLabel("\u6587\u4EF6\u5927\u5C0F\uFF08KB\uFF09\uFF1A");
		
		cIdText = new JTextField();
		cIdText.setColumns(10);
		
		cSizeText = new JTextField();
		cSizeText.setColumns(10);
		GroupLayout gl_cpanel = new GroupLayout(cpanel);
		gl_cpanel.setHorizontalGroup(
			gl_cpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cpanel.createSequentialGroup()
					.addGroup(gl_cpanel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(110)
							.addComponent(cIdLabel))
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(93)
							.addComponent(cIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(95)
							.addGroup(gl_cpanel.createParallelGroup(Alignment.LEADING)
								.addComponent(cSizeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
								.addComponent(cbutton)))
						.addGroup(gl_cpanel.createSequentialGroup()
							.addGap(80)
							.addComponent(csizeLabel)))
					.addContainerGap(104, Short.MAX_VALUE))
		);
		gl_cpanel.setVerticalGroup(
			gl_cpanel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_cpanel.createSequentialGroup()
					.addContainerGap()
					.addComponent(cIdLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cIdText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addGap(10)
					.addComponent(csizeLabel)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(cSizeText, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
					.addPreferredGap(ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
					.addComponent(cbutton)
					.addGap(68))
		);
		cpanel.setLayout(gl_cpanel);
		frame.getContentPane().setLayout(groupLayout);	
		
		DrawPanel dm=new DrawPanel();
		dm.setSize(256,100);
		dm.setLocation(100, 400);
		dm.setBorder(new LineBorder(new Color(0, 0, 0)));
		dppanel.add(dm);
		
		ds=new DocService();
		
		cbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int begin,size;
				int flag=0;
				String name;
				
				try {
					name=cIdText.getText();
					size=Integer.valueOf(cSizeText.getText());
					if(size>0 && !name.trim().equals("")) {      //当文件大小大于0且文件名不为空时,执行操作
						for(int i=0;i<Operate.doclist.size();i++)	
							if(Operate.doclist.get(i).getName().equals(name))	 //若在文件列表中找到该文件名，则提示
								{
								JOptionPane.showMessageDialog(null, "输入的文件名已存在 ", "错误信息", JOptionPane.PLAIN_MESSAGE);
								flag=1;
								}
						if(flag==0) {				//若没找到同名文件，则开始查找合适空间
							ds.docAdd(name,size);
							begin=ds.getbegin();
							if(begin!=-1) {			//若找到合适空间，则添加进文件列表中并重画示意图
								lspace.setText(String.valueOf(Operate.lspace));
								Object[] o= {name,size,begin,begin+(int)Math.ceil((double)size/Operate.blocksize)-1};
								tableModel.addRow(o);
								dm.repaint();
							}
							else JOptionPane.showMessageDialog(null, "剩余空间不足 ", "错误信息", JOptionPane.PLAIN_MESSAGE);
						}
					}
					else if(size<1) JOptionPane.showMessageDialog(null, "输入大小不能小于1", "错误信息", JOptionPane.PLAIN_MESSAGE);
					else JOptionPane.showMessageDialog(null, "文件名不能为空", "错误信息", JOptionPane.PLAIN_MESSAGE);
				}catch(Exception e) {
					JOptionPane.showMessageDialog(null, "输入size信息有误 ", "错误信息", JOptionPane.PLAIN_MESSAGE);
				}
			}
		});
		
		dbutton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				int i;
				String dname;
				dname=dIdText.getText();
				for(i=0;i<Operate.doclist.size();i++) {		//判断文件中是否有该文件
					if(Operate.doclist.get(i).getName().equals(dname))
						break;
				}
				if(i==Operate.doclist.size()) 				//若没有则提示
					JOptionPane.showMessageDialog(null, "查不到该文件 ", "错误信息", JOptionPane.PLAIN_MESSAGE);
				else{										//若有则删除该文件并修改界面
					ds.docDelete(dname);
					lspace.setText(String.valueOf(Operate.lspace));
					tableModel.removeRow(i);
					dm.repaint();
				}
			}
		});
	}
}
