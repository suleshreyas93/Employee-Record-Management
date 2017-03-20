package gui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

import com.Queries;

import javax.swing.*;

public class SearchFrame extends JFrame {
	
	JPanel jp1,jp2;
	JLabel id,nm,sal;
	JTextField txt_id,txt_nm,txt_sal;
	
	JButton btn_ok,btn_bck;
	
	public SearchFrame()
	{
		setTitle("Search Employee");
		setSize(500,150);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		jp1 = new JPanel();
		jp1.setLayout(new FlowLayout(FlowLayout.CENTER,10,25));
		
		id = new JLabel("Id");
		nm = new JLabel("Name");
		sal = new JLabel("Salary");
		
		
		
		txt_nm = new JTextField(10);
		txt_sal = new JTextField(10);
		txt_id = new JTextField(5);
		txt_nm.setEditable(false);
		txt_sal.setEditable(false);
		
		btn_ok = new JButton("OK");
		btn_bck = new JButton("Back");
		
		jp1.add(id);
		jp1.add(txt_id);
		jp1.add(nm);
		jp1.add(txt_nm);
		jp1.add(sal);
		jp1.add(txt_sal);
		
		add(jp1);
		
		jp2 = new JPanel();
		jp2.add(btn_ok);
		jp2.add(btn_bck);
		
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
		
		btn_ok.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Validate vd = new Validate();
				boolean b1 = vd.validateId(txt_id.getText());
				boolean flag = false;
				if(b1 == false)
				{
					JOptionPane.showMessageDialog(rootPane, "Employee Id Must Be A Number");
					txt_id.setText("");
					txt_id.requestFocus();
				}
				
				else
				{
				try
				{
					Queries q = new Queries();
					ArrayList<Integer> id = new ArrayList<Integer>(q.getId());
					for(Integer i : id)
					{
						if(i.equals(txt_id.getText()))
						{
							
							flag = true;
						}
					}
					
					if(flag == true)
					{
						String[] s = (q.getData(Integer.parseInt(txt_id.getText())));
						txt_nm.setText(s[0]);
						txt_sal.setText(s[1]);
					}
					else
					{
						JOptionPane.showMessageDialog(rootPane, "Employee "+txt_id.getText()+" Not Found");
						txt_id.setText("");
						txt_id.requestFocus();
					}
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
				}
			}
		});
	}

}
