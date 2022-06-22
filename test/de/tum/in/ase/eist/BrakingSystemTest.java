package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class BrakingSystemTest {

	@TestSubject
	private BrakingSystem brakingSystem = new BrakingSystem();
	@Mock
	private ABS abs = new ABS();

	@Mock
	private Brake brake;

	@Mock(fieldName = "distanceSensor")
	private Sensor distanceSensor;

	@Mock(fieldName = "tractionSensor")
	private Sensor tractionSensor;

	@Test
	void testBrakeProcess() {
		expect(abs.shouldOverrideBrake()).andReturn(false);
		replay(abs);
		abs.shouldOverrideBrake();
		brakingSystem.calculateNextFrame();
//		expected = brake.brake(2);
//		observed = brakingSystem.calculateNextFrame();
//		assertEquals
	}

	@Test
	void testABSWarning() {
		expect(brakingSystem.isAbsWarning()).andReturn(true);
		replay(abs);
		abs.shouldOverrideBrake();
		brakingSystem.calculateNextFrame();
		assertTrue(brakingSystem.isAbsWarning());
	}

}
