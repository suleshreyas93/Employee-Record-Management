package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.*;

import javax.swing.*;
public class AddFrame extends JFrame {
	
	JPanel jp1,jp2;
	JLabel id,nm,sal;
	JTextField txt_id,txt_nm,txt_sal;
	JButton btn_add,btn_update,btn_bck;
	int i;
	String n;
	float s;
	
	public AddFrame()
	{
		setSize(500,150);
		setTitle("Add Or Update Employee Record");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		
		id = new JLabel("Id");
		nm = new JLabel("Name");
		sal = new JLabel("Salary");
		
		txt_id = new JTextField(5);
		txt_nm = new JTextField(10);
		txt_sal = new JTextField(10);
		
		btn_add = new JButton("Add");
		btn_update = new JButton("Update");
		btn_bck = new JButton("Back");
		
		jp1.add(id);
		jp1.add(txt_id);
		jp1.add(nm);
		jp1.add(txt_nm);
		jp1.add(sal);
		jp1.add(txt_sal);
		
		jp2 = new JPanel();
		
		
		jp2.add(btn_add);
		jp2.add(btn_update);
		jp2.add(btn_bck);
		
		add(jp1);
		add(jp2,BorderLayout.SOUTH);
		
		setLocation(290,200);
		setVisible(true);
		
		/* Event Handling for back button. Navigating back to Home frame*/
		btn_bck.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				HomeFrame hf = new HomeFrame();
				dispose();
				
			}
		});
		
		/* Event handling for add button. inserting the employee record*/
		btn_add.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				 
					Validate vd = new Validate();
					boolean b1 = vd.validateId(txt_id.getText());
					boolean b2 = vd.validateSalary(txt_sal.getText());
					boolean b3 = vd.validateName(txt_nm.getText());
					if(b1 == false)
					{
						JOptionPane.showMessageDialog(rootPane, "Employee Id Must Be A Number");
						txt_id.setText("");
						txt_id.requestFocus();
					}
					
					else if(b3 == false)
					{
						JOptionPane.showMessageDialog(rootPane, "Please Enter A Proper Name");
						txt_nm.setText("");
						txt_nm.requestFocus();
					}
					else if(b2 == false)
					{
						JOptionPane.showMessageDialog(rootPane, "Salary Must Be A Number");
						txt_sal.setText("");
						txt_sal.requestFocus();
					}
					
					else
					{
					try
					{
						Queries q = new Queries();
						i = Integer.parseInt(txt_id.getText());
						n = txt_nm.getText();
						s = Float.parseFloat(txt_sal.getText());
				
						q.insert(i,n,s);
				
						JOptionPane.showMessageDialog(rootPane, "Record Inserted Successfully");
						txt_id.setText("");
						txt_nm.setText("");
						txt_sal.setText("");
						txt_id.requestFocus();
				 
					}
					catch(Exception ex)
					{
						System.out.println(ex.toString());
					}
					}
					}
				
			
		});
		
		btn_update.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Validate vd = new Validate();
				boolean b1 = vd.validateId(txt_id.getText());
				boolean b2 = vd.validateSalary(txt_sal.getText());
				boolean b3 = vd.validateName(txt_nm.getText());
				if(b1 == false)
				{
					JOptionPane.showMessageDialog(rootPane, "Employee Id Must Be A Number");
					txt_id.setText("");
					txt_id.requestFocus();
				}
				
				else if(b3 == false)
				{
					JOptionPane.showMessageDialog(rootPane, "Please Enter A Proper Name");
					txt_nm.setText("");
					txt_nm.requestFocus();
				}
				else if(b2 == false)
				{
					JOptionPane.showMessageDialog(rootPane, "Salary Must Be A Number");
					txt_sal.setText("");
					txt_sal.requestFocus();
				}
				else
				{
				try
				{
					int i = Integer.parseInt(txt_id.getText());
					String n = txt_nm.getText();
					float s = Float.parseFloat(txt_sal.getText());
					
					Queries q = new Queries();
					q.update(i,n,s);
					JOptionPane.showMessageDialog(rootPane, "Employee "+i+" updated successfully");
				}
				catch(NumberFormatException ex)
				{
					ex.printStackTrace();
				}
				}
			}
		});
		
	}
	
	

}
