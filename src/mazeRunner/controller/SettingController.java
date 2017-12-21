package mazeRunner.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import mazeRunner.StartGame;
import mazeRunner.model.GameSetting;
import mazeRunner.model.movingObjects.runners.IRunner;
import mazeRunner.model.movingObjects.runners.Runner1;
import mazeRunner.model.movingObjects.runners.Runner2;
import mazeRunner.model.movingObjects.runners.Runner3;
import mazeRunner.model.utilities.GameContract;

import java.io.File;
import java.io.IOException;

public class SettingController implements Runnable{
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
		setting.setCurrentRunner((IRunner) new Runner1());
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

}

	@FXML
	void setMedium(ActionEvent event) {
		setting.setCustomDifficulty(GameContract.Difficulty.MEDIUM);

	}

	@FXML
	void setHard(ActionEvent event) {
		setting.setCustomDifficulty(GameContract.Difficulty.HARD);
	}
//---------------------------


	@FXML
	void RunnerPictureAction(ActionEvent event) {
		//TODO
		String path = FileChooser();
		setting.getCurrentRunner().setImageLinks(path);
	}

	@FXML
	void bombPictureAction(ActionEvent event) {
		//TODO
	}

	@FXML
	void giftPictureAction(ActionEvent event) {
		//TODO
	}

	@FXML
	void weaponPictureAction(ActionEvent event) {

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
		String path = fileChooser.showOpenDialog(stage).getAbsolutePath();
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
