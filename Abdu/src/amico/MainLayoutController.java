package amico;

import javafx.fxml.FXML;

public class MainLayoutController {

    public void setMainApp(Main mainApp) {
    }

    @FXML
    private void loadHomePage() {
        try {
			Main.showHomePage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    private void loadAboutPage() {
        try {
			Main.showAboutPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    @FXML
    private void loadContactPage() {
        try {
			Main.showContactPage();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
