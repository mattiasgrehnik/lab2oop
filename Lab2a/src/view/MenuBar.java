package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;

import model.DataStorage;
import model.FileManagement;

public class MenuBar extends JMenuBar {
	private Frame frame;

	public MenuBar(Frame frame) {
		this.frame = frame;

		JMenu fileMenu = new JMenu("File");
		add(fileMenu);

		JMenuItem newGame = new JMenuItem("New Painting");
		fileMenu.add(newGame);
		newGame.addActionListener(new ActionListener() {
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
