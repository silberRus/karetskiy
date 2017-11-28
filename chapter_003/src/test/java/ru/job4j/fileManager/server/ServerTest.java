package ru.job4j.fileManager.server;

import org.junit.Test;
import ru.job4j.fileManager.Property;
import ru.job4j.fileManager.WindowsFileSystem;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import static org.junit.Assert.*;

/**
 * Created by silbe on 06.06.2017.
 */
public class ServerTest {

    private WindowsFileSystem fs = new WindowsFileSystem("E:\\java\\projects\\karetskiy\\chapter_003\\src");

    @Test
    public void showCurrentDirecotir() throws IOException {

        /*
        java.net.Socket socket = mock(java.net.Socket.class);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());

        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);

        Server server = new Server(new Property(), fs);
        server.loop();
        assertThat(out.toString(), is("main,test"));
        */
    }
}