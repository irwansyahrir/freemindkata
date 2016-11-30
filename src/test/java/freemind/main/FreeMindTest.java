package freemind.main;

import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.io.File;
import java.util.Properties;

import static org.junit.Assert.assertEquals;



/**
 * Created by irwansyahrir on 29/11/16.
 */
public class FreeMindTest {
    private FrameFixture window;

    Properties defaultProp;
    Properties userProp;
    File autoPropFile;


    @Before
    public void setUp() {
        defaultProp = new Properties();
        defaultProp.setProperty("patternsfile", "");

        userProp = new Properties();
        userProp.setProperty("properties_folder", ".");

        autoPropFile = new File("");
        FreeMind frame = GuiActionRunner.execute(() -> new FreeMind(defaultProp, userProp, autoPropFile));
        window = new FrameFixture(frame);
        window.show(); // shows the frame to test
    }

    @Test
    public void testInitial() throws Exception {
        Frame freeMind = window.target();
        assertEquals("FreeMind Kata", freeMind.getTitle());

        FreeMind.main(null, defaultProp, userProp, autoPropFile);
    }
}
