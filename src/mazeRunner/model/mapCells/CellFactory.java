package mazeRunner.model.mapCells;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Random;

import mazeRunner.model.mapCells.MapCell;

/**
 * 
 * @author ABDelRAHMAN
 */
public class CellFactory implements ICellFactory{
private boolean readyClasses=false;
	private HashMap<String,Class<? extends MapCell>> classes = new HashMap<String,Class<?extends MapCell>>();
	private LinkedList<Class<? extends Wall>> Walls = new LinkedList<Class<?extends Wall>>();
	private LinkedList<Class<? extends Way>> Ways = new LinkedList<Class<?extends Way>>();
	private LinkedList<Class<? extends Way>> GiftDestroysObstacles = new LinkedList<Class<?extends Way>>();

	@Override

	public boolean setClasses(ArrayList< String>ClassesList) {
		 Iterator<String> classesNames = ClassesList.iterator();
			while (classesNames.hasNext()) {
				String className=classesNames.next();
			try {
				Class<? extends MapCell> mapCellSubClass = Class.forName(className).asSubclass(MapCell.class);
				if(isUndestroyableWall(mapCellSubClass)){
				this.Walls.add((Class<? extends Wall>) mapCellSubClass);
				}else if(isWay(mapCellSubClass)){
					this.Ways.add((Class<? extends Way>) mapCellSubClass);
				}else if(isDestroyingObstacles(mapCellSubClass)){
					this.GiftDestroysObstacles.add((Class<? extends Way>) mapCellSubClass);
				}
				classes.put(className,mapCellSubClass);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
				return false;
			}catch(ClassCastException e){
				e.printStackTrace();
				return false;
			}catch(Exception e){
				e.printStackTrace();
				return false;
			}
			}
		this.readyClasses = true;
		return true;
	}

	private boolean isDestroyingObstacles(Class<? extends MapCell> mapCellSubClass) throws Exception {
		MapCell tempMapCell = mapCellSubClass.newInstance();
		if(tempMapCell.isNonObstacle()&&tempMapCell.isCauseDamage()){
			return true;
		}
		return false;
	}

	private boolean isUndestroyableWall(Class<? extends MapCell> mapCellSubClass) {
		try {
			MapCell mc = mapCellSubClass.newInstance();
			return (mc.isWall()&&!mc.isDestroyable());
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}

	}

	private boolean isWay(Class<? extends MapCell> mapCellSubClass) {
		try {
			return mapCellSubClass.newInstance().isWay();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
			return false;
		}
	}


	@Override
	public MapCell getInstanceByClassName(String name) throws Exception {
		if(!this.readyClasses){
			throw new Exception("used cell factory without settign the classes' list");
		}
		return this.classes.get(name).newInstance();
	}

	@Override
	public MapCell getUndestroyableWall() throws Exception {
		if(!this.readyClasses){
			throw new Exception("used cell factory without settign the classes' list");
		}
		if(this.Walls.size()!=0){
		return this.Walls.get(0).newInstance();
		}else{
			throw new Exception("there is no walls in this theme");
		}
	}

	@Override
	public MapCell getWay() throws Exception{
		if(!this.readyClasses){
			throw new Exception("used cell factory without settign the classes' list");
		}
		if(this.Ways.size()!=0){
			return this.Ways.get(0).newInstance();
			}else{
				throw new Exception("there is no walls in this theme");
			}
	}

	@Override
	public MapCell getGiftDestroysObstacles() throws Exception {
		if(!this.readyClasses){
			throw new Exception("used cell factory without settign the classes' list");
		}
		if(this.GiftDestroysObstacles.size()!=0){
		Random rnd = new Random();
		int index=rnd.nextInt(this.GiftDestroysObstacles.size());
		return this.GiftDestroysObstacles.get(index).newInstance();
		}else{
			throw new Exception("there is no gifts in this theme");

		}
	}
	


}
