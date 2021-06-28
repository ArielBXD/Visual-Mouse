package main;

import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.jnativehook.GlobalScreen;
import org.jnativehook.NativeHookException;
import org.jnativehook.mouse.NativeMouseMotionListener;

public class Main {

	public static BufferedImage mouseBothClick, mouseNotClicked, mouseLeftClicked, mouseRightClicked;

	public static JFrame mainFrame;
	public static JLabel mouseLabel;

	public static void display() {

		mainFrame = new JFrame("Visual Mouse");
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setResizable(false);
		mainFrame.setSize(500, 602);
		mainFrame.setLocationRelativeTo(null);

		mouseBothClick = Images.loadImage("res/mouseBothClick.png");
		mouseNotClicked = Images.loadImage("res/mouseNotClicked.png");
		mouseLeftClicked = Images.loadImage("res/mouseLeftClick.png");
		mouseRightClicked = Images.loadImage("res/mouseRightCLick.png");

		mouseLabel = new JLabel();
		mouseLabel.setIcon(new ImageIcon(mouseNotClicked));

		mainFrame.setVisible(true);
		mainFrame.add(mouseLabel);
	}

	public static void main(String[] args) {
		display();
		try {
			GlobalScreen.registerNativeHook();
		} catch (NativeHookException e) {
			System.exit(1);
		}

		MouseInput m = new MouseInput();
		GlobalScreen.addNativeMouseListener(m);
		GlobalScreen.addNativeMouseMotionListener((NativeMouseMotionListener) m);

	}

}
