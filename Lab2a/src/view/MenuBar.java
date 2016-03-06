package view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import controller.ShapeController;
import model.FileManagement;
import model.ShapeFactory;

public class MenuBar extends JMenuBar {
	private Frame frame;
	private ButtonGroup shapeGroup, colorGroup, strokeGroup, filledGroup;
	private String[] shapeNames;
	private ShapeController sc;
	private JComponent paintView;

	public MenuBar(Frame frame) {
		this.frame = frame;
		sc = ShapeController.getInstance();
		shapeGroup = new ButtonGroup();
		colorGroup = new ButtonGroup();
		strokeGroup = new ButtonGroup();
		filledGroup = new ButtonGroup();
		initializeFileMenu();
		initializeCommandMenu();
		initializeShapeMenu();
		initializeColorMenu();
		initializeThicknessMenu();
		paintView = new PaintView();
		frame.add(paintView);
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
				colorGroup.clearSelection();
				strokeGroup.clearSelection();
				filledGroup.clearSelection();
				sc.clearShape();
				paintView.setCursor(new Cursor(Cursor.HAND_CURSOR));
				sc.setSelect(true);
			}
		});
		
		JMenuItem delete = new JMenuItem("Delete");
		menu.add(delete);
		delete.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_DELETE,0));
		delete.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.removeSelected();
			}
		});
		menu.setHorizontalAlignment(SwingConstants.LEFT);
		
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
		JMenu menu = new JMenu("Stroke");
		add(menu);

		JRadioButtonMenuItem one = new JRadioButtonMenuItem("1px");
		one.setSelected(true);
		menu.add(one);
		strokeGroup.add(one);

		one.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(1);
			}
		});
		JRadioButtonMenuItem two = new JRadioButtonMenuItem("2px");
		menu.add(two);
		strokeGroup.add(two);
		two.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(2);
			}
		});

		JRadioButtonMenuItem three = new JRadioButtonMenuItem("3px");
		menu.add(three);
		strokeGroup.add(three);
		three.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setStroke(3);
			}
		});

		JRadioButtonMenuItem four = new JRadioButtonMenuItem("4px");
		menu.add(four);
		strokeGroup.add(four);
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

		JRadioButtonMenuItem fill = new JRadioButtonMenuItem("Filled");

		menu.add(fill);
		filledGroup.add(fill);
		fill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setFilled(true);
			}
		});

		JRadioButtonMenuItem unfill = new JRadioButtonMenuItem("Unfilled");
		unfill.setSelected(true);
		menu.add(unfill);
		filledGroup.add(unfill);
		unfill.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setFilled(false);
			}
		});

		menu.addSeparator();
		JRadioButtonMenuItem red = new JRadioButtonMenuItem("Red");
		menu.add(red);
		colorGroup.add(red);
		red.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.RED);
			}
		});

		JRadioButtonMenuItem blue = new JRadioButtonMenuItem("Blue");
		menu.add(blue);
		colorGroup.add(blue);
		blue.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.BLUE);
			}
		});

		JRadioButtonMenuItem green = new JRadioButtonMenuItem("Green");
		menu.add(green);
		colorGroup.add(green);
		green.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.GREEN);
			}
		});

		JRadioButtonMenuItem yellow = new JRadioButtonMenuItem("Yellow");
		menu.add(yellow);
		colorGroup.add(yellow);
		yellow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sc.setColor(Color.YELLOW);
			}
		});

		JRadioButtonMenuItem black = new JRadioButtonMenuItem("Black");
		black.setSelected(true);
		menu.add(black);
		colorGroup.add(black);
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
					sc.setSelect(false);
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

	public void loadFile() {
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("NotPaint (.ntp)", "ntp"));
		int r = fileChooser.showSaveDialog(frame);

		if (r == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				String fileName = file.getAbsolutePath();
				Object fileData = FileManagement.deSerializeFromFile(fileName);
				frame.getContentPane().removeAll();
				sc.setPainting(fileData);
				paintView = new PaintView();
				frame.add(paintView);
				sc.notifyModelObservers();
				frame.setVisible(true);
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
		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setAcceptAllFileFilterUsed(false);
		fileChooser.setMultiSelectionEnabled(false);
		fileChooser.setFileFilter(new FileNameExtensionFilter("NotPaint (.ntp)", "ntp"));
		int r = fileChooser.showSaveDialog(frame);
		if (r == JFileChooser.APPROVE_OPTION) {
			File file = fileChooser.getSelectedFile();
			try {
				String fileName = file.getAbsolutePath();
				if (fileName.contains(".ntp")) {
					fileName = file.getAbsolutePath();
				} else {
					fileName = file.getAbsolutePath() + ".ntp";
				}
				FileManagement.serializeToFile(fileName, sc.getPainting());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private static final long serialVersionUID = 1L;

}
