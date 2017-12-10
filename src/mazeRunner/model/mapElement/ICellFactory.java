package mazeRunner.model.mapElement;

import java.util.ArrayList;
/**
 * 
 * @author ABDelRAHMAN
 */

public interface ICellFactory {
	/**
	 * takes an arrayList of Strings , each String is the name of the classes in certain theme ,
	 * the name must be something like that "mazeRunner.themes.theme1.classX"
	 * returns true if all the given classes do implements MapCell interface , false otherwise 
	 * @param classes , the names of the classes to use 
	 * @return true in case of successful setting and then you can use other methods , false otherwise
	 */
public boolean setClasses(ArrayList<String> classes);
/**
 * returns instance of the class given its name as parameter
 * @param name , the name of the class you want to get instance of 
 * @return instance of that class
 * @throws exception in case of using it without setting classes
 */
public MapCell getInstanceByClassName(String name) throws Exception;
/**
 * @return undestroyable wall 
 * @throws Exception in case of there is no undestroyable wall or  using it without setting classes
 */
public MapCell getUndestroyableWall() throws Exception;
/**
 * @return  way 
 * @throws Exception in case of there is no  way or  using it without setting classes
 */
public MapCell getWay() throws Exception;
}
