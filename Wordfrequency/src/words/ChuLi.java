package words;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ChuLi extends JPanel{
	public ChuLi()
	{
		this.setLayout(new GridLayout(4,1));
		JLabel FN=new JLabel("��������ļ���Ϊ:"+MainWindows.Filename);
		this.add(FN);
		JLabel J=new JLabel("��������ļ����У�"+MainWindows.zifu+"�ַ�");
		this.add(J);
		JLabel h=new JLabel("�ļ�����Ϊ��"+MainWindows.hang+"��");
		this.add(h);
		JLabel c=new JLabel("�����ļ������ѵ�ʱ����"+MainWindows.time+"ms");
		this.add(c);
	}
	
}
