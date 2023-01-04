package dev.mestizos;

import dev.mestizos.signer.Main;
import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {
    @Test public void appSignXmlFile() {
        Main classUnderTest = new Main();
        assertTrue(classUnderTest.SignXmlFile().contains("Document signed"));
    }
}
