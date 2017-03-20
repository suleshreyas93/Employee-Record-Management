package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import com.Queries.*;

import javax.swing.*;

import com.Queries;

public class DeleteFrame extends JFrame {
	
	JPanel jp1,jp2;
	JTextField txt_name,txt_salary;
	JComboBox jc;
	JButton btn_delete,btn_cancel;
	JLabel nm,sal,id;
	ArrayList<Integer> list;
	
	
	public DeleteFrame()
	{
		
		setTitle("Delete Employee Record");
		setSize(500,150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp1 = new JPanel();
		jp2 = new JPanel();
		
		id =  new JLabel("Id");
		nm =  new JLabel("Name");
		sal = new JLabel("Salary");
		
		txt_name = new JTextField(10);
		txt_salary = new JTextField(10);
		
		txt_name.setEditable(false);
		txt_salary.setEditable(false);
		
		btn_delete = new JButton("Delete");
		btn_cancel = new JButton("Cancel");
		
		Queries q = new Queries();
		list = new ArrayList<Integer>(q.getId());
		jc = new JComboBox(list.toArray());
		
		jc.setSelectedIndex(-1);
		
		
		jp1.add(id);
		jp1.add(jc);
		jp1.add(nm);
		jp1.add(txt_name);
		jp1.add(sal);
		jp1.add(txt_salary);
		
		add(jp1);
		
		jp2.add(btn_delete);
		jp2.add(btn_cancel);
		
		add(jp2,BorderLayout.SOUTH);
		
		setLocation(290,200);
		setVisible(true);
		
		/* Event handing for cancel button. Navigating back to home frame*/
		btn_cancel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomeFrame hf = new HomeFrame();
				dispose();
				
			}
		});
		
		
		
		jc.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				
				String[] s = new String[2];
				Queries q = new Queries();
				int i = (int)jc.getSelectedItem();
				s = q.getData(i);
				txt_name.setText(s[0]);
				txt_salary.setText(s[1]);
				}
				
			
		});
		
		btn_delete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(jc.getSelectedIndex()==-1)
				{
					JOptionPane.showMessageDialog(rootPane, "Please Select Employee Id");
				}
				else
				{
				try
				{
					Queries qr = new Queries();
					int i = (int) jc.getSelectedItem();
					int wish = JOptionPane.showConfirmDialog(rootPane, "Do you wish to delete employee "+i);
					if(wish == 0)
					{
						qr.delete(i);
						JOptionPane.showMessageDialog(rootPane, "Employee "+i+" record deleted successfully");
						
						txt_name.setText("");
						txt_salary.setText("");
						
						list = qr.getId();
						jc.removeItemAt(jc.getSelectedIndex());
						
						
						
						
						
					}
					
				}
				catch(Exception ex)
				{
					JOptionPane.showMessageDialog(rootPane, ex.toString());
				}
				}
			}
		});
		
	}
	
	

	
	
}
