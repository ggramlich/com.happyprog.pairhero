package com.happyprog.pairhero.time;

import org.eclipse.ui.PlatformUI;

import com.happyprog.pairhero.game.Game;

public class Timer implements Runnable {

	private static final int ONE_SECOND = 1000;

	private Game game;
	private int countdownInSeconds;
	private boolean stopTimerSignal;

	public Timer(SessionLengthProvider sessionLengthProvider) {
		countdownInSeconds = sessionLengthProvider.getSessionLength();
	}

	public void start(Game game) {
		this.game = game;
		run();
	}

	@Override
	public void run() {
		countdownInSeconds--;

		game.onTimeChange(countdownInSeconds);

		if (!stopTimerSignal) {
			reRunInASecond();
		}
	}

	void reRunInASecond() {
		PlatformUI.getWorkbench().getDisplay().timerExec(ONE_SECOND, this);
	}

	public void stop() {
		stopTimerSignal = true;
	}

}
