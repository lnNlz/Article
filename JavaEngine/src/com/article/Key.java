package com.article;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;

/**
 * {@code Key} class handles key input made the user,
 * this has several methods that will be helpful for some cases
 * 
 * @version 1.0
 * @since 1.0
 */
public final class Key implements KeyListener {
	// Stack of key pressed
	private static final LinkedList<Integer> keyPressed = new LinkedList<Integer> ();
	
	// Key pressed
	private static final LinkedList<Integer> keyPressedOnce = new LinkedList<Integer> ();
	
	protected Key() {}
	
	@Override
	public void keyPressed(KeyEvent e) {
		final Integer keyCode = Integer.valueOf(e.getKeyCode());
		
		// Registers key code to the stack
		keyPressed.add(keyCode);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Removes key code to the stack
		keyPressed.clear();
		
		// Removes key code pressed to the stack
		keyPressedOnce.clear();
	}

	@Override
	public void keyTyped(KeyEvent e) {}
	
	// ***********************************************************
	// Static methods
	// ***********************************************************
	
	/**
	 * @param keyCode
	 * - {@code Key code} to check
	 * 
	 * @return
	 * {@code true} if the key code specified is {@code being pressed}; {@code false} otherwise
	 * 
	 * <p><b> KNOWN ISSUE: {@code LinkedList.contains()} is O(n) so you'll notice a delay on input </b>
	 */
	public static boolean keyPressed(final int keyCode) {
		return keyPressed.contains(Integer.valueOf(keyCode));
	}
	
	/**
	 * @param keyChar
	 * - {@code Key char} to check
	 * 
	 * @return
	 * {@code true} if the key code specified is {@code being pressed}; {@code false} otherwise
	 * 
	 * @see #keyPressed(int)
	 */
	public static boolean keyPressed(final char keyChar) {
		return keyPressed((int)keyChar);
	}
	
	/**
	 * @param keyCode
	 * - {@code Key code} to check
	 * 
	 * @return
	 * {@code true} if the key code specified has {@code been pressed}; {@code false} otherwise
	 * 
	 *  <p><b> KNOWN ISSUE: {@code LinkedList.contains()} is O(n) so you'll notice a delay on input </b>
	 */
	public static boolean keyPressedUp(final int keyCode) {
		final Integer keycode = Integer.valueOf(keyCode);
		
		// Check whether the key code specified has already been pressed
		if(keyPressed.contains(keycode) && !keyPressedOnce.contains(keycode)) {
			keyPressedOnce.add(keycode);
			
			return true;
		}
		
		// The key is on the list or not being pressed
		return false;
	}
	
	/**
	 * @param keyChar
	 * - {@code Key char} to check
	 * 
	 * @return
	 * {@code true} if the key code specified has {@code been pressed}; {@code false} otherwise
	 * 
	 * @see #keyPressedUp(int)
	 */
	public static boolean keyPressedUp(final char keyChar) {
		return keyPressedUp((int)keyChar);
	}
	
	/**
	 * Clears all the {@code key code} from two lists
	 */
	public static void clear() {
		keyPressed.clear();
		keyPressedOnce.clear();
	}
}