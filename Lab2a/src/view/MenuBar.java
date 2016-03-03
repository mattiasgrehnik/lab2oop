package view;

import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DataStorage;
import model.FileManagement;
import model.Shape;
import model.ShapeFactory;

public class MenuBar extends JMenuBar {
	private Frame frame;
	private String[] shapeNames;
	private JMenuItem select;
	public MenuBar(Frame frame) {
		this.frame = frame;
		initializeFileMenu();
		initializeCommandMenu();
		initializeSelectButton();
		initializeShapeMenu();
		initializeColorMenu();
		initializeFillButton();
		initializeThicknessMenu();
	}



	private void initializeCommandMenu() {
		JMenu fileMenu = new JMenu("Edit");
		add(fileMenu);

		JMenuItem undo = new JMenuItem("Undo");
		fileMenu.add(undo);
		undo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		JMenuItem redo = new JMenuItem("Redo");
		fileMenu.add(redo);
		redo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
	}

	private void initializeThicknessMenu() {
		JMenu fileMenu = new JMenu("Thickness");
		add(fileMenu);

		JMenuItem one = new JMenuItem("1px");
		fileMenu.add(one);
		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		JMenuItem two = new JMenuItem("2px");
		fileMenu.add(two);
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		JMenuItem three = new JMenuItem("3px");
		fileMenu.add(three);
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		JMenuItem four = new JMenuItem("4px");
		fileMenu.add(four);
		four.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		
	}



	private void initializeFillButton() {
		JMenuItem fill = new JMenuItem("Fill");
		this.add(fill);
		fill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				fill.setEnabled(false);
			}
		});
		

		
	}



	private void initializeColorMenu() {
		JMenu fileMenu = new JMenu("Color");
		add(fileMenu);
	
		JMenuItem red = new JMenuItem("Red");
		fileMenu.add(red);
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		JMenuItem blue = new JMenuItem("Blue");
		fileMenu.add(blue);
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		JMenuItem green = new JMenuItem("Green");
		fileMenu.add(green);
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		JMenuItem yellow = new JMenuItem("Yellow");
		fileMenu.add(yellow);
		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
		JMenuItem black = new JMenuItem("Black");
		fileMenu.add(black);
		black.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO Draw shape
			}
		});
		
	}

	private void initializeSelectButton() {
		select = new JMenuItem("Select");
		this.add(select);
		select.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO SELECT
			}
		});
	}

	private void initializeShapeMenu() {
		ShapeFactory sf = new ShapeFactory();
		shapeNames = sf.getAvailableShapes();
		
		JMenu fileMenu = new JMenu("Shape");
		add(fileMenu);
		for (int i = 0; i < shapeNames.length; i++) {
			JMenuItem shape = new JMenuItem(shapeNames[i]);
			fileMenu.add(shape);
			shape.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					//TODO: DRAW
				}
			});
		}
	}
	
	private void initializeFileMenu() {
		JMenu fileMenu = new JMenu("File");
		add(fileMenu);

		JMenuItem newPic = new JMenuItem("New Painting");
		fileMenu.add(newPic);
		newPic.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				start();
			}
		});

		JMenuItem saveGame = new JMenuItem("Save Painting");
		fileMenu.add(saveGame);
		saveGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveFile();

			}
		});

		JMenuItem loadGame = new JMenuItem("Load Painting");
		fileMenu.add(loadGame);
		loadGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loadFile();

			}
		});

		JMenuItem quitItem = new JMenuItem("Exit");
		fileMenu.add(quitItem);
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
		
	}

	public void start() {

//		frame.getContentPane().removeAll();
//		model = new PaintModel();
//
//		boardView = new BoardView(model);
//		boardView.setPreferredSize(new Dimension(520, 540));
//		frame.add(boardView, BorderLayout.EAST);
//
//		playerGUI = new PlayerGUI(othello);
//		playerGUI.setPreferredSize(new Dimension(250, 540));
//		frame.add(playerGUI, BorderLayout.WEST);
//
//		frame.setVisible(true);
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
//				start the process
//				start(data.getMode());
//				othello.setActivePlayerIndex(data.getActivePlayerIndex());
//				othello.setBoardColors(data.getBoardColors());
//				playerGUI.updatePoints();
//				playerGUI.setPlayerTurnImage(othello.getActivePlayer().getColor());

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
