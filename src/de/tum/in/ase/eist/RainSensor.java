package de.tum.in.ase.eist;

import java.util.concurrent.ThreadLocalRandom;

public class RainSensor implements Sensor {

	@Override
	public double sense() {
		return ThreadLocalRandom.current().nextDouble();
	}
}
