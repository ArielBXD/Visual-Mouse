package main;

import org.jnativehook.mouse.*;

import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MouseInput implements NativeMouseListener {

	public void nativeMouseClicked(NativeMouseEvent arg0) {

	}

	public void nativeMousePressed(NativeMouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Main.mouseLabel.setIcon(new ImageIcon(Main.mouseLeftClicked));

		}

		if (e.getButton() == MouseEvent.BUTTON2) {
			Main.mouseLabel.setIcon(new ImageIcon(Main.mouseRightClicked));
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("wheel clicked");

		}

	}

	public void nativeMouseReleased(NativeMouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			Main.mouseLabel.setIcon(new ImageIcon(Main.mouseNotClicked));
		}

		if (e.getButton() == MouseEvent.BUTTON2) {
			Main.mouseLabel.setIcon(new ImageIcon(Main.mouseNotClicked));
		}

		if (e.getButton() == MouseEvent.BUTTON3) {
			System.out.println("wheel clicked");
		}

	}

}
