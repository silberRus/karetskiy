package ru.job4j.fileManager;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Created by silbe on 05.06.2017.
 */
public class WindowsFileSystemTest {

    WindowsFileSystem fs = new WindowsFileSystem("E:\\java\\projects\\karetskiy\\chapter_003\\src");

    @Test
    public void scan() throws Exception {

        assertThat(this.fs.scan(), is(new String[]{"main", "test"}));
    }

    @Test
    public void enter() throws Exception {

        this.fs.enter("main");
        assertThat(fs.scan(), is(new String[]{"java"}));
    }

    @Test
    public void enterBegin() throws Exception {

        this.fs.enter("main");
        this.fs.enterBegin();
        assertThat(fs.scan(), is(new String[]{"main", "test"}));
    }

    @Test
    public void enterReturn() throws Exception {

        this.fs.enter("main");
        this.fs.enter("java");
        this.fs.enterReturn();
        assertThat(fs.scan(), is(new String[]{"java"}));

    }
}