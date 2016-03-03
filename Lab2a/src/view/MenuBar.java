package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ShapeController;
import model.DataStorage;
import model.FileManagement;
import model.ShapeFactory;

public class MenuBar extends JMenuBar {
	private Frame frame;
	private ButtonGroup shapeGroup;
	private String[] shapeNames;
	private ShapeController sc;
	private JComponent paintView;

	public MenuBar(Frame frame) {
		this.frame = frame;
		shapeGroup = new ButtonGroup();
		sc = ShapeController.getInstance();
		initializeFileMenu();
		initializeCommandMenu();
		initializeShapeMenu();
		initializeColorMenu();
		initializeThicknessMenu();
		start();
	}

	private void initializeCommandMenu() {
		JMenu menu = new JMenu("Edit");
		add(menu);

		JRadioButtonMenuItem select = new JRadioButtonMenuItem("Select");
		menu.add(select);
		shapeGroup.add(select);
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				paintView.setCursor(new Cursor(Cursor.HAND_CURSOR));
			}
		});
		menu.addSeparator();
		JMenuItem undo = new JMenuItem("Undo");
		undo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z, ActionEvent.CTRL_MASK));
		menu.add(undo);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("UNDO");
			}
		});
		JMenuItem redo = new JMenuItem("Redo");
		menu.add(redo);
		redo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Y, ActionEvent.CTRL_MASK));
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("REDO");
			}
		});
		menu.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private void initializeThicknessMenu() {
		JMenu menu = new JMenu("Thickness");
		add(menu);
		ButtonGroup group = new ButtonGroup();

		JRadioButtonMenuItem one = new JRadioButtonMenuItem("1px");
		one.setSelected(true);
		menu.add(one);
		group.add(one);

		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(1);
			}
		});
		JRadioButtonMenuItem two = new JRadioButtonMenuItem("2px");
		menu.add(two);
		group.add(two);
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(2);
			}
		});

		JRadioButtonMenuItem three = new JRadioButtonMenuItem("3px");
		menu.add(three);
		group.add(three);
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(3);
			}
		});

		JRadioButtonMenuItem four = new JRadioButtonMenuItem("4px");
		menu.add(four);
		group.add(four);
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(4);
			}
		});
		menu.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private void initializeColorMenu() {
		JMenu menu = new JMenu("Color");
		add(menu);
		ButtonGroup group = new ButtonGroup();

		JRadioButtonMenuItem fill = new JRadioButtonMenuItem("Fill");
		menu.add(fill);
		fill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
			}
		});
		menu.addSeparator();
		JRadioButtonMenuItem red = new JRadioButtonMenuItem("Red");
		menu.add(red);
		group.add(red);
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.RED);
			}
		});

		JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue");
		menu.add(blue);
		group.add(blue);
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.BLUE);
			}
		});

		JRadioButtonMenuItem green = new JRadioButtonMenuItem("Green");
		menu.add(green);
		group.add(green);
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.GREEN);
			}
		});

		JRadioButtonMenuItem yellow = new JRadioButtonMenuItem("Yellow");
		menu.add(yellow);
		group.add(yellow);
		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.YELLOW);
			}
		});

		JRadioButtonMenuItem black = new JRadioButtonMenuItem("Black");
		black.setSelected(true);
		menu.add(black);
		group.add(black);
		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.BLACK);
			}
		});
		menu.setHorizontalAlignment(SwingConstants.LEFT);
	}

	private JMenu initializeShapeMenu() {
		ShapeFactory sf = new ShapeFactory();
		shapeNames = sf.getAvailableShapes();

		JMenu menu = new JMenu("Shape");
		add(menu);
		for (int i = 0; i < shapeNames.length; i++) {
			JRadioButtonMenuItem shape = new JRadioButtonMenuItem(shapeNames[i]);
			menu.add(shape);
			shapeGroup.add(shape);
			shape.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					paintView.setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
					sc.setShape(shape.getText());
				}
			});
		}
		menu.setHorizontalAlignment(SwingConstants.LEFT);
		return menu;
	}

	private JMenu initializeFileMenu() {
		JMenu menu = new JMenu("File");
		add(menu);

		JMenuItem newPic = new JMenuItem("New Painting");
		menu.add(newPic);
		newPic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		JMenuItem saveGame = new JMenuItem("Save Painting");
		menu.add(saveGame);
		saveGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();
			}
		});

		JMenuItem loadGame = new JMenuItem("Load Painting");
		menu.add(loadGame);
		loadGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadFile();

			}
		});

		JMenuItem quitItem = new JMenuItem("Exit");
		menu.add(quitItem);
		quitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				Object[] options = { "Yes", "No", "Cancel" };
				int n = JOptionPane.showOptionDialog(frame, "Do you want to quit without saving?", "Exit",
						JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
				switch (n) {
				case 0:
					saveFile();
					break;
				case 1:
					System.exit(0);
				default:
					break;
				}
			}
		});
		return menu;
	}

	public void start() {
		frame.getContentPane().removeAll();

		paintView = new PaintView();
		paintView.setPreferredSize(new Dimension(776, 550));
		paintView.setBackground(Color.WHITE);
		paintView.addMouseListener(sc);
		frame.add(paintView, BorderLayout.EAST);

		frame.setVisible(true);
	}

	public void loadFile() {
		DataStorage data;

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setFileFilter(new FileNameExtensionFilter("Othello (.oth)", "oth"));

		int r = fileChooser.showOpenDialog(frame);

		if (r == JFileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();

			System.out.println(file.getAbsolutePath());
			FileManagement fileManagement = new FileManagement();
			try {
				String fileName = file.getAbsolutePath();
				fileManagement.deSerializeFromFile(fileName);
				data = fileManagement.getData();
				// start the process
				// start(data.getMode());
				// othello.setActivePlayerIndex(data.getActivePlayerIndex());
				// othello.setBoardColors(data.getBoardColors());
				// playerGUI.updatePoints();
				// playerGUI.setPlayerTurnImage(othello.getActivePlayer().getColor());

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void saveFile() {

		DataStorage data = new DataStorage();

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("NotPaint (.ntp)", "ntp"));

		int r = fileChooser.showSaveDialog(frame);
		if (r == JFileChooser.APPROVE_OPTION) {

			File file = fileChooser.getSelectedFile();

			FileManagement fileManagement = new FileManagement();
			fileManagement.setData(data);

			try {
				String fileName = file.getAbsolutePath() + ".ntp";
				fileManagement.serializeToFile(fileName);
				System.out.println("SUCCESS!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static final long serialVersionUID = 1L;
}
