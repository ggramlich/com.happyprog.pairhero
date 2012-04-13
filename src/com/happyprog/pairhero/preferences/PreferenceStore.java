package com.happyprog.pairhero.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.happyprog.pairhero.Activator;
import com.happyprog.pairhero.time.SessionLengthProvider;

public class PreferenceStore implements SessionLengthProvider {

	@Override
	public int getSessionLength() {
		IPreferenceStore store = getPreferenceStore();
		int sessionLengthInMinutes = store
				.getInt(PreferenceConstants.P_SESSION_LENGTH);
		if (sessionLengthInMinutes <= 0) {
			sessionLengthInMinutes = PreferenceInitializer.DEFAULT_SESSION_LENGTH;
		}
		return sessionLengthInMinutes * 60;
	}

	private static IPreferenceStore getPreferenceStore() {
		return Activator.getDefault().getPreferenceStore();
	}

}
