package gui;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.*;
import com.Queries;

public class ViewFrame extends JFrame {
	
	JScrollPane jsc;
	JTable jt;
	
	String[] heading = {"Id","Name","Salary"};
	Object[][] data = null;
	
	public ViewFrame()
	{
		super("View All Employees");
		setSize(500,200);
		setResizable(false);
		
		
		Queries q = new Queries();
		data = q.selectasArray();
		
		jt = new JTable(data,heading);
		jsc = new JScrollPane(jt,JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		for(int i = 0;i<data.length;i++)
		{
			for(int j=0;j<data[0].length;j++)
			{
				jt.setValueAt(data[i][j], i, j);
				
			}
		}
		add(jsc);
		setLocation(290, 200);
		setVisible(true);
		
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				HomeFrame hf = new HomeFrame();
				dispose();
			}
		});
	}
}


