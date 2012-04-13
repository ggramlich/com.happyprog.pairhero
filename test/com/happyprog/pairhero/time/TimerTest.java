package com.happyprog.pairhero.time;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;

import com.happyprog.pairhero.game.Game;

public class TimerTest {

	private static final int SESSION_LENGTH = 2000;
	private StubbedTimer timer;
	private Game game;

	@Before
	public void before() {
		timer = new StubbedTimer();

		game = mock(Game.class);
	}

	@Test
	public void updatesGameWhenTimeChanges() throws Exception {
		timer.start(game);

		verify(game).onTimeChange(SESSION_LENGTH - 1);

		assertEquals(1, timer.ticks);
	}

	@Test
	public void onStopDoNotRerunInASecond() throws Exception {
		timer.start(game);

		assertEquals(1, timer.ticks);

		timer.stop();

		timer.run();

		assertEquals(1, timer.ticks);
	}

	class StubbedTimer extends Timer {

		public StubbedTimer() {
			super(new SessionLengthProvider() {
				public int getSessionLength() {
					return SESSION_LENGTH;
				}
			});
		}

		private int ticks;

		@Override
		void reRunInASecond() {
			ticks++;
		}
	}
}
