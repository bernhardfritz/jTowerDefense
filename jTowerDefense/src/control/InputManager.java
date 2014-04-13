package control;

import model.Mouse;
import model.Toolbox;

import org.newdawn.slick.Input;
import org.newdawn.slick.InputListener;

public class InputManager implements InputListener{
	
	@Override
	public void mouseClicked(int button, int x, int y, int clickCount) {
		//System.out.printf("Mousebutton %d clicked %d time(s) at (%d,%d)\n",button,clickCount,x,y);
	}
	@Override
	public void mouseDragged(int oldx, int oldy, int newx, int newy) {
		//System.out.printf("Mouse dragged from (%d,%d) to (%d,%d)\n",oldx,oldy,newx,newy);
		Mouse.move(newx, newy);
		Toolbox.update();
		Toolbox.performAction();
	}
	@Override
	public void mouseMoved(int oldx, int oldy, int newx, int newy) {
		Mouse.move(newx, newy);
		Toolbox.update();
	}
	@Override
	public void mousePressed(int button, int x, int y) {
		//System.out.printf("Mousebutton %d pressed at (%d,%d)\n",button,x,y);
		if(Mouse.press(button)) Toolbox.performAction();
	}
	@Override
	public void mouseReleased(int button, int x, int y) {
		//System.out.printf("Mousebutton %d released at (%d,%d)\n",button,x,y);
		Mouse.release();
	}
	@Override
	public void mouseWheelMoved(int change) {
		Mouse.moveMouseWheel(change/Math.abs(change));
		Toolbox.performAction();
	}
	@Override
	public void inputEnded() {
		
	}
	@Override
	public void inputStarted() {
		
	}
	@Override
	public boolean isAcceptingInput() {
		return true;
	}
	@Override
	public void setInput(Input input) {
		
	}
	@Override
	public void keyPressed(int key, char c) {
		model.Keyboard.press(key);
		Toolbox.performAction();
		//System.out.printf("Key %s pressed\n",c);
	}
	@Override
	public void keyReleased(int key, char c) {
		model.Keyboard.release(key);
		//System.out.printf("qKey %s released\n",c);
	}
	@Override
	public void controllerButtonPressed(int controller, int button) {
		
	}
	@Override
	public void controllerButtonReleased(int controller, int button) {
		
	}
	@Override
	public void controllerDownPressed(int controller) {
		
	}
	@Override
	public void controllerDownReleased(int controller) {
		
	}
	@Override
	public void controllerLeftPressed(int controller) {
		
	}
	@Override
	public void controllerLeftReleased(int controller) {
		
	}
	@Override
	public void controllerRightPressed(int controller) {
		
	}
	@Override
	public void controllerRightReleased(int controller) {
		
	}
	@Override
	public void controllerUpPressed(int controller) {
		
	}
	@Override
	public void controllerUpReleased(int controller) {
		
	}
}
