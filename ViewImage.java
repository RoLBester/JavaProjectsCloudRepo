package lab6;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class ViewImage extends JFrame {

	private JLabel imageLabel;
	private JButton openButton;

	public ViewImage() {
		super("Image Viewer"); // Sets application title

		// Initialize components
		imageLabel = new JLabel();
		imageLabel.setHorizontalAlignment(JLabel.CENTER); // Centers image horizontally

		openButton = new JButton("Open Image");
		openButton.addActionListener(new OpenButtonListener()); // Adds listener for button click

		// Creating layout and add components
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(imageLabel, BorderLayout.CENTER);
		contentPane.add(openButton, BorderLayout.SOUTH);

		setContentPane(contentPane);
		setSize(450, 350); // Setting application window size
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private class OpenButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JFileChooser fileChooser = new JFileChooser(); // Creates file chooser
			int result = fileChooser.showOpenDialog(ViewImage.this); // Displays the file chooser dialog

			if (result == JFileChooser.APPROVE_OPTION) { // User selected a file
				File selectedFile = fileChooser.getSelectedFile();
				try {
					ImageIcon imageIcon = new ImageIcon(selectedFile.getPath()); // Loads image
					imageLabel.setIcon(imageIcon); // Sets image on label
					pack(); // Resizes window to fit image
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(ViewImage.this, "Error loading image: " + ex.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}

	// MAIN CLASS
	public static void main(String[] args) {
		new ViewImage();
	}
}
