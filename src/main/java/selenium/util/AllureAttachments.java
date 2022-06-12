package selenium.util;

import DriverFactory.DriverProvider;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class AllureAttachments {
    private AllureAttachments(){
    }

    @Attachment(value = "logs", type = "text/plain", fileExtension = ".log")
    public static byte[] addFileToAllure(String path) throws IOException {
        File file = new File(path);
        return Files.readAllBytes(Paths.get(file.getPath()));
    }

    @Attachment(value = "Page screenshot", type = "image/png")
    public static byte[] addScreenToAllure() {
        return ((TakesScreenshot) DriverProvider.getDriver()).getScreenshotAs(OutputType.BYTES);
    }
}

