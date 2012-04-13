package com.happyprog.pairhero.preferences;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;

import com.happyprog.pairhero.Activator;

/**
 * Class used to initialize default preference values.
 */
public class PreferenceInitializer extends AbstractPreferenceInitializer {

	public static final int DEFAULT_SESSION_LENGTH = 25;

	public void initializeDefaultPreferences() {
		IPreferenceStore store = Activator.getDefault().getPreferenceStore();
		store.setDefault(PreferenceConstants.P_SESSION_LENGTH,
				DEFAULT_SESSION_LENGTH);
	}

}
