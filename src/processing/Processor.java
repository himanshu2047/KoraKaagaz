package processing;

import java.util.*;

import infrastructure.validation.logger.LogLevel;
import infrastructure.validation.logger.ModuleID;
import processing.boardobject.*;
import processing.utility.*;
import processing.threading.*;

/**
 * This file implements all the function and uses the static functions defined by some other classes.
 * UI will get an object of this class after they call the getProcessor function of ProcessingFactory class.
 *
 * @author Himanshu Jain
 * @reviewer Ahmed Zaheer Dadarkar
 */

public class Processor implements IDrawErase, IDrawShapes, IOperation, IUndoRedo, IUser {
	
	protected Processor() {};
	
	@Override
	public void drawCurve (ArrayList <Pixel> pixels) {
		
		if(pixels == null) {
			
			ClientBoardState.logger.log(
					ModuleID.PROCESSING, 
					LogLevel.ERROR, 
					"Null object given as argument for drawCurve from UI"
			);
			return;
		}
		
		IBoardObjectOperation boardOp = new CreateOperation();
		Timestamp time = Timestamp.getCurrentTime();
		ObjectId objectId = new ObjectId(ClientBoardState.userId, time);
		
		DrawCurve runnable = new DrawCurve(
				pixels, boardOp, objectId, time, 
				ClientBoardState.userId, 
				new ArrayList<Pixel>(), false
		);
		
		Thread drawCurveThread = new Thread(runnable);
		drawCurveThread.start();
	}
	
	@Override
	public void erase (ArrayList <Position> position) {
		
		if(position == null) {
			
			ClientBoardState.logger.log(
					ModuleID.PROCESSING, 
					LogLevel.ERROR, 
					"Null object given as argument for erase from UI"
			);
			return;
		}
		
		IBoardObjectOperation boardOp = new CreateOperation();
		Timestamp time = Timestamp.getCurrentTime();
		ObjectId objectId = new ObjectId(ClientBoardState.userId, time);
		
		Erase runnable = new Erase(position, boardOp, objectId, time, 
				ClientBoardState.userId, true
		);
		
		Thread eraseThread = new Thread(runnable);
		eraseThread.start();
	}
	
	@Override
	public void drawCircle(Pixel center, float radius) {
		
		if(center == null) {
			
			ClientBoardState.logger.log(
					ModuleID.PROCESSING, 
					LogLevel.ERROR, 
					"center object given as argument is null for drawCircle from UI"
			);
			return;
		}	
		
		DrawCircle runnable = new DrawCircle(center.position, 
				new Radius(radius), center.intensity
		);
		
		Thread drawCircleThread = new Thread(runnable);
		drawCircleThread.start();
	}
	
	@Override
	public void drawSquare(Pixel start, float length) {
		return;
	}
	
	@Override
	public void drawRectangle(Pixel start, Pixel end) {
		return;
	}
	
	@Override
	public void drawLine(Pixel start, Pixel end) {
		return;
	}
	
	@Override
	public void drawTriangle(Pixel vertA, Pixel vertB, Pixel vertC) {
		return;
	}
	
	@Override
	public ArrayList<Position> select (ArrayList <Position> positions) {
		ArrayList<Position> selectedPixels = new ArrayList<Position>();
		return selectedPixels;
	}
	
	@Override
	public void delete() {
		return;
	}
	
	@Override
	public void colorChange (Intensity intensity) {
		return;
	}
	
	@Override
	public void rotate (Angle angleCCW) {
		return;
	}
	
	@Override
	public void reset () {
		return;
	}
	
	@Override
	public void undo() {
		return;
	}
	
	@Override
	public void redo() {
		return;
	}
	
	@Override
	public String giveUserDetails(String userName, String ipAddress, String boardId) {
		String userId = new String();
		return userId;
	}
	
	@Override
	public String getUser(ArrayList<Position> positions) {
		String userId = new String();
		return userId;
	}
	
	@Override
	public void stopBoardSession() {
		return;
	}
	
	@Override
	public void subscribeForChanges(String identifier, IChanges handler) {
		return;
	}
}
