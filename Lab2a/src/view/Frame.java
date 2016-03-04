package view;


import javax.swing.*;

public class Frame extends JFrame{
	
	public Frame() {
		PaintView p = new PaintView();
		try {
			String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
			UIManager.setLookAndFeel(lookAndFeel);
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		MenuBar menuBar = new MenuBar(this);
		setJMenuBar(menuBar);
		add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("NotPaint");
		setSize(776, 590);
		setResizable(false);
		setVisible(true);
	}
	
	private static final long serialVersionUID = 1L;
}
