package com.article;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

import com.article.math.Vec2;

public final class Mouse implements MouseListener, MouseMotionListener, MouseWheelListener {
	private static final Vec2 mousePosition = new Vec2(0);
	
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		mousePosition.setX( e.getX() );
		mousePosition.setY( e.getY() );
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}
	
	/**
	 * @return
	 * {@code X} coordinate of the Mouse
	 */
	public static int getX() {
		return mousePosition.getX();
	}

	/**
	 * @return
	 * {@code Y} coordinate of the Mouse
	 */
	public static int getY() {
		return mousePosition.getX();
	}
}