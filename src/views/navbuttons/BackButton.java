package views.navbuttons;

import views.Window;

import java.awt.event.ActionEvent;

/**
 * Back Button allows user to go back to home page when clicked.
 *
 * @author heshamsalman
 */
public class BackButton extends NavigationButton {
    private static final long serialVersionUID = 45768139147924018L;
    Window window;

    /**
     * Constructor
     * @param window the main window
     */
    public BackButton(Window window) {
        this.window = window;
        setText("Home");
        initializeComponents();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        window.switchToHome();
    }
}
