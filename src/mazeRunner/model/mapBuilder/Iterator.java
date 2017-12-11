package mazeRunner.model.mapBuilder;

/**
 * Created by Mustafa on 12/11/2017.
 */
public interface Iterator {

    public boolean hasNext();

    public Object next();

    public int rowIndex();

    public int columnIndex();

}
