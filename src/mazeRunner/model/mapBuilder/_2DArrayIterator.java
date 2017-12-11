package mazeRunner.model.mapBuilder;

/**
 * Created by Mustafa on 12/11/2017.
 */
public class _2DArrayIterator implements Iterator{
    private Object[][] array;
    public  _2DArrayIterator(Object[][] array){
        this.array = array;
    }
    private int rowIndex = -1;
    private int columnIndex = -1;
    private int numberOfRows = array.length;
    private int numberOfColumns = array[0].length;
    @Override
    public boolean hasNext() {
        if(rowIndex >= numberOfRows && columnIndex >= numberOfColumns){
            return  false;
        }
        return  true;
    }

    @Override
    public Object next() {
        columnIndex ++;
        if(columnIndex >= numberOfColumns){
            columnIndex = 0;
            rowIndex ++;
        }
        Object arrayObject = array[rowIndex][columnIndex];
        return arrayObject;
    }

    @Override
    public int rowIndex() {
        return rowIndex;
    }

    @Override
    public int columnIndex() {
        return columnIndex;
    }
}
