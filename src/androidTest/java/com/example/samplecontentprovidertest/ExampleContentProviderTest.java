package com.example.samplecontentprovidertest;

import android.test.ProviderTestCase2;

/**
 * Based on an incomplete official documentation https://developer.android.com/training/testing/integration-testing/content-provider-testing.
 *
 * It says to use some things such as @RunWith(AndroidJUnit4::class), but since this extends
 * ProviderTestCase2 that is designed to work ith Junit3 runner, then we do not need to worry
 * about it.
 */
public class ExampleContentProviderTest extends ProviderTestCase2<ExampleContentProvider> {

    public ExampleContentProviderTest() {
        super(ExampleContentProvider.class, ExampleContentProvider.AUTHORITY);
    }

    public void test_update() {
        int affectedRows = getMockContentResolver().update(ExampleContentProvider.SAMPLE_URI, null, null, null);
        assertEquals(2, affectedRows);
    }

    public void test_delete() {
        int affectedRows = getMockContentResolver().delete(ExampleContentProvider.SAMPLE_URI, null, null);
        assertEquals(3, affectedRows);
    }

}