package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class BrakingSystemTest {

	@Mock(fieldName = "distanceSensor")
	private Sensor distanceSensor;

	@Test
	void testBrakeProcess() {
		fail("Test case not implemented yet");
	}

	@Test
	void testABSWarning() {
		fail("Test case not implemented yet");
	}

}
