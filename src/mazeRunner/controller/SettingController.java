package mazeRunner.controller;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mazeRunner.StartGame;
import mazeRunner.model.GameSetting;
import mazeRunner.model.movingObjects.runners.Runner1;
import mazeRunner.model.movingObjects.runners.Runner2;
import mazeRunner.model.movingObjects.runners.Runner3;
import mazeRunner.model.utilities.GameContract;

public class SettingController implements Runnable{
	private final static Logger LOGGER = Logger.getLogger(SettingController.class.getName());
	GameSetting setting = new GameSetting();
	FileChooser fileChooser = new FileChooser();
	@FXML
	private TitledPane Runner;

	@FXML
	private Button runnerPictureChooser;


	@FXML
	private TextField weaponText;

	@FXML
	private TitledPane addetionalSetting;

	@FXML
	private TextField runnerTest;

	@FXML
	private Button Runner2btn;

	@FXML
	private TextField levelText;

	@FXML
	private Accordion mainSettingPane;

	@FXML
	private Button medium;

	@FXML
	private Button Runner3btn;

	@FXML
	private Button easy;
	@FXML
	private Button runner1btn;


	@FXML
	private Button weaponGiftChooser;

	@FXML
	private Button bombPictureChooser;

	@FXML
	private Button hard;


	@FXML
	private TextField bombText;

	@FXML
	private TextField giftText;

	@FXML
	private Button giftPictureChooser;

	@FXML
	private Button back1;

	@FXML
	private Button back2;

	@FXML
	void backFromAditional(ActionEvent event) {
		StartGame.root.getChildren().setAll(StartGame.startMenuePane);
	}

	@FXML
	void chooseRunner1(ActionEvent event) {
		setting.setCurrentRunner(new Runner1());
	}

	@FXML
	void chooseRunner2(ActionEvent event) {
		setting.setCurrentRunner(new Runner2());
	}

	@FXML
	void chooseRunner3(ActionEvent event) {
		setting.setCurrentRunner(new Runner3());
	}


//--------------------------
@FXML
void setEasy(ActionEvent event) {
	setting.setCustomDifficulty(GameContract.Difficulty.EASY);
	levelText.setText("Easy");

}

	@FXML
	void setMedium(ActionEvent event) {
		setting.setCustomDifficulty(GameContract.Difficulty.MEDIUM);
		levelText.setText("Medium");
	}

	@FXML
	void setHard(ActionEvent event) {
		setting.setCustomDifficulty(GameContract.Difficulty.HARD);
		levelText.setText("Hard");
	}
//---------------------------


	@FXML
	void RunnerPictureAction(ActionEvent event) {
		
		String path = FileChooser();
		setting.addCustomMapCellImageLink("CustomRunner", path);
	}

	@FXML
	void bombPictureAction(ActionEvent event) {
		
		String path = FileChooser();
		setting.addCustomMapCellImageLink("CustomBomb", path);
	}

	@FXML
	void giftPictureAction(ActionEvent event) {
		
		String path = FileChooser();
		setting.addCustomMapCellImageLink("CustomGift", path);
	}

	@FXML
	void WeaponPictureAction(ActionEvent event) {
		String path = FileChooser();
		setting.addCustomMapCellImageLink("CustomWay", path);
	}

	@FXML
	void backFromRunners(ActionEvent event) {
		StartGame.root.getChildren().setAll(StartGame.startMenuePane);
	}
	private String FileChooser(){
		Stage stage = new Stage();
		fileChooser.setTitle("Open Resource File");
		fileChooser.setTitle("View Pictures");
		fileChooser.setInitialDirectory(new File(System.getProperty("user.home"))
		);
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All Images", "*.*"),
				new FileChooser.ExtensionFilter("JPG", "*.jpg"),
				new FileChooser.ExtensionFilter("GIF", "*.gif"),
				new FileChooser.ExtensionFilter("BMP", "*.bmp"),
				new FileChooser.ExtensionFilter("PNG", "*.png")
		);
		String path = null;
		try {
			path = fileChooser.showOpenDialog(stage).getAbsolutePath();
		} catch (Exception e) {
			LOGGER.setLevel(Level.WARNING);
			LOGGER.info("Error in uploading");
		}
		return path;
	}

	@Override
	public void run() {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource("ViewController.fxml"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		StartGame.root.getChildren().setAll(root);
	}
}
