package utils;

import org.sikuli.api.DesktopScreenRegion;
import org.sikuli.api.ImageTarget;
import org.sikuli.api.ScreenRegion;
import org.sikuli.api.Target;
import org.sikuli.api.robot.Mouse;
import org.sikuli.api.robot.desktop.DesktopMouse;

import java.io.File;

/**
 * Created by 3aecb on 23.Jun.16.
 */
public class SikuliImageRecognition {
    private ScreenRegion screenRegion;

    public SikuliImageRecognition() {
        screenRegion = new DesktopScreenRegion();
    }

    public void clickOnSignInButton(String imageName) {
        File buttonPathFile = new File("src/test/resources/sikuliImages/" + imageName);
        Target imageTarget = new ImageTarget(buttonPathFile);
        ScreenRegion region = screenRegion.wait(imageTarget, 7000);
        Mouse mouse = new DesktopMouse();
        mouse.click(region.getCenter());
    }
}
