package com.roma.services;

import java.util.Locale;
import java.util.ResourceBundle;

public class LocalService {
    private static LocalService localService;

    private ResourceBundle resourceBundle;
    private final String[] SUPPORTED_LOCALES = {"en", "ru"};

    private LocalService() {
        getResourceBundle();
    }

    public static LocalService getInstance() {
        if (localService == null) {
            localService = new LocalService();
        }
        return localService;
    }

    private Locale getResourceLocale() {
        for (String lang : SUPPORTED_LOCALES) {
            try {
                ResourceBundle bundle = ResourceBundle.getBundle("messages", new Locale(lang));
                if (bundle != null) {
                    System.out.println("Successfully loaded bundle for locale: " + lang);
                    return new Locale(lang);
                }
            } catch (Exception e) {
                System.err.println("Failed to load bundle for locale: " + lang + ", error: " + e.getMessage());
            }
        }
        System.out.println("---------------------- -------------------- Falling back to default locale: en");
        return new Locale("en");
    }

    private void getResourceBundle() {
        Locale locale = getResourceLocale();
        try {
            resourceBundle = ResourceBundle.getBundle("native2ascii.messages", locale);
        } catch (Exception e) {
            System.err.println("Error loading resource bundle for locale: " + locale + ", error: " + e.getMessage());
            throw new RuntimeException("Failed to load resource bundle for locale: " + locale, e);
        }
    }

    public ResourceBundle getMessage() {
        return resourceBundle;
    }
}