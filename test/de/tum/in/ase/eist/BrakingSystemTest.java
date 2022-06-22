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
	@Mock(fieldName = "abs")
	private ABS abs = new ABS();

	@Mock(fieldName = "distanceSensor")
	private Sensor distanceSensor;

	@Mock(fieldName = "tractionSensor")
	private Sensor tractionSensor;

	@Mock(fieldName = "speedSensor")
	private Sensor speedSensor;

	@Mock(fieldName = "brakingPedal")
	private Sensor brakingPedal;

	@Mock(fieldName = "brake")
	private Brake brake;

	@Test
	void testBrakeProcess() {
//		expects all the object in the calculateNextFrame and reply all the objects
		expect(abs.shouldOverrideBrake()).andReturn(false);
		replay(abs);
		expect(speedSensor.sense()).andReturn(150.0);
		replay(speedSensor);
		expect(distanceSensor.sense()).andReturn(200.0);
		replay(distanceSensor);
		expect(brakingPedal.sense()).andReturn(0.5);
		abs.shouldOverrideBrake();
		brakingSystem.calculateNextFrame();
		//		verify the brake mock
		verify(brake);
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
