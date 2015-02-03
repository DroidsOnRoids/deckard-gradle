package com.example.activity;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

import java.net.InetAddress;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

@RunWith(RobolectricTestRunner.class)
public class DeckardActivityTest {

    @BeforeClass
    public static void setUpClass() {

    }

    @AfterClass
    public static void tearDownClass() {

    }

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testPass() throws Exception {
        assertTrue(Robolectric.buildActivity(DeckardActivity.class).create().get() != null);
    }

    @Test
    public void testPassAsserts() throws Exception {
        final DeckardActivity deckardActivity = Robolectric.buildActivity(DeckardActivity.class).create().get();
        assertTrue(deckardActivity != null);
        assertNotNull(deckardActivity);
        int x = 2 + 2;
        int y = 3 + 1;
        assertEquals(x, y);

        assertThat(deckardActivity).isNotNull();
        assertThat(1).isIn(Arrays.asList(1, 3, 5)).isBetween(0, 2);
        Date now = new Date();
        assertThat(now).isAfterYear(2000);
        assertThat(deckardActivity.getFilesDir()).exists();
        assertThat("\uD83D\uDE39").hasSameSizeAs("\uD83D\uDE38");
    }

    @Test
    public void testFail() throws Exception {
        assertThat(new Date()).isCloseTo(new Date(0), 10);
    }

    @Test
    public void testError() throws Exception {
        int len = new int[-1].length;
    }

    @Test(timeout = 5000)
    public void testTimeout() throws Exception {
        InetAddress.getByName("google.pl");
    }

    @Test (expected = NegativeArraySizeException.class)
    public void testExpectedException() throws Exception {
        int len = new int[-1].length;
    }

    @Ignore
    @Test
    public void testIgnore() throws Exception {
        notify();
    }
}
