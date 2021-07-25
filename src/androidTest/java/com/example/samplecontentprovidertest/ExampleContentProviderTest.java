package com.example.samplecontentprovidertest;

import android.test.ProviderTestCase2;

import androidx.test.core.app.ApplicationProvider;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Based on an incomplete official documentation https://developer.android.com/training/testing/integration-testing/content-provider-testing
 */
@RunWith(AndroidJUnit4.class)
public class ExampleContentProviderTest extends ProviderTestCase2<ExampleContentProvider> {

    public ExampleContentProviderTest() {
        super(ExampleContentProvider.class, ExampleContentProvider.AUTHORITY);
    }

    //we have to use other names instead of setUp and tearDown because those names
    //are taken already by parent class
    @Before
    public void before() {
        try {
            //we use deprecated methods because the parent class extends a deprecated class
            setContext(ApplicationProvider.getApplicationContext());
            setUp();
        } catch (Exception exception) {
            fail(exception.getMessage());
        }
    }

    @Test
    public void test_update() {
        int affectedRows = getMockContentResolver().update(ExampleContentProvider.SAMPLE_URI, null, null, null);
        assertEquals(2, affectedRows);
    }

    @Test
    public void test_delete() {
        int affectedRows = getMockContentResolver().delete(ExampleContentProvider.SAMPLE_URI, null, null);
        assertEquals(3, affectedRows);
    }

    @After
    public void after() {
        try {
            tearDown();
        } catch (Exception e) {
            fail(e.getMessage());
        }
    }

}