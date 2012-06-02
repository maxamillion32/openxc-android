package com.openxc;

import junit.framework.TestCase;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.fail;

import com.openxc.units.Meter;
import com.openxc.measurements.Measurement;
import com.openxc.measurements.NoRangeException;

public class NoRangeMeasurementTest extends TestCase {
    Measurement<Meter> measurement;

    @Override
    public void setUp() {
        measurement = new Measurement<Meter>(new Meter(10.0));
    }

    public void testHasNoRange() {
        assertFalse(measurement.hasRange());
    }

    public void testEmptyRange() throws NoRangeException {
        try {
        measurement.getRange();
        } catch(NoRangeException e) {
            return;
        }
        fail();
    }

    public void testGet() {
        assertThat(measurement.getValue().doubleValue(), equalTo(10.0));
    }
}
