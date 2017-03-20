package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
public class HomeFrame extends JFrame{
	
	JPanel jp;
	JButton btn_add,btn_del,btn_viewall,btn_search;
	
	public HomeFrame() //Initialization of components
	{
		
		setSize(400,100);
		setTitle("Employee Records Management");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp = new JPanel();
		jp.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		
		btn_add = new JButton("Add");
		btn_del = new JButton("Delete");
		btn_viewall = new JButton("View All");
		btn_search = new JButton("Search");
		
		jp.add(btn_add);
		jp.add(btn_del);
		jp.add(btn_viewall);
		jp.add(btn_search);
		
		add(jp);
		setLocation(290,200);
		setVisible(true);
		
		/* Event Handling. Performing action of each button click */
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddFrame af = new AddFrame();
				dispose();
				
			}
		});
		
		btn_del.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				DeleteFrame df = new DeleteFrame();
				dispose();
				
			}
		});
		
		btn_viewall.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ViewFrame vf = new ViewFrame();
				dispose();
			}
		});
		
		btn_search.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				SearchFrame sf = new SearchFrame();
				dispose();
				
			}
		});
		
	}

	
	
}
