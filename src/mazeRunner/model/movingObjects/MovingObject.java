package mazeRunner.model.movingObjects;

import java.awt.Point;

public interface MovingObject {
	
	public void setDirection(int direction);
	
	public int getDirection();
	
	public void setPosition(Point position);
	
	public Point getPosition();
	
	public void setImageLinks(String imageLinks);
	
	public String getImageLinks();
	
	public void setMappedPosition(Point mappedPosition);
	
	public Point getMappedPosition();

	public String getLayer();
}
