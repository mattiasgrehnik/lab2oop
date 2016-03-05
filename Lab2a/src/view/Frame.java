package view;


import javax.swing.*;

public class Frame extends JFrame{
	
	public Frame() {
		try {
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		MenuBar menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NotPaint");
		setSize(1024, 768);
		setResizable(false);
		setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}
