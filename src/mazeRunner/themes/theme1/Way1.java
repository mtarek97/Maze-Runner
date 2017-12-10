package mazeRunner.themes.theme1;


import mazeRunner.model.mapElement.Way;

public class Way1 extends Way{
	private final String standardImageLink ="";
	private  String currentImageLink = this.standardImageLink;

	/* from index 0 to 8 - Links to the images suitable for his direction*/
	private final String[] ashesImagesLink ={"","","","","","","","",""};

	

	@Override
	public void setAshes(int Direction) {
		this.currentImageLink = this.ashesImagesLink[Direction];		
	}

	

	@Override
	public String getImageLink() {
		return this.currentImageLink;
	}





}
