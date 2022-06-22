package de.tum.in.ase.eist;

import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(EasyMockExtension.class)
class ABSTest {

	@TestSubject
	private ABS abs = new ABS();

	@Mock
	private Sensor sensorMock;

	@Test
	void testShouldNotOverrideBreakOnHighTraction() {
		expect(sensorMock.sense()).andReturn(0.5);
		replay(sensorMock);
		assertFalse(abs.shouldOverrideBrake());
		verify(sensorMock);
	}

	@Test
	void testShouldOverrideBreakOnLowTraction() {
		expect(sensorMock.sense()).andReturn(0.2);
		replay(sensorMock);
		assertTrue(abs.shouldOverrideBrake());
		verify(sensorMock);
	}
}
