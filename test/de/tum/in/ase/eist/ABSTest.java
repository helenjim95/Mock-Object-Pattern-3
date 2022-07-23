package de.tum.in.ase.eist;

//TODO: import EasyMock
import org.easymock.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

//TODO: import EasyMock
import static org.easymock.EasyMock.*;
import static org.junit.jupiter.api.Assertions.*;

//TODO: Easymock annotation
@ExtendWith(EasyMockExtension.class)
class ABSTest {

	//TODO: Easymock annotation - TestSubject
	@TestSubject
	private ABS abs = new ABS();

	//TODO: Easymock annotation - Mock
	@Mock
	private Sensor sensorMock;

	//TODO: Easymock annotation - Test
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
