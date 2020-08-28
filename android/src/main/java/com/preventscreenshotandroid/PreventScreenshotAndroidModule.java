package com.preventscreenshotandroid;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.Callback;
import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;
import com.facebook.react.bridge.Promise;

import android.view.WindowManager;
import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

public class PreventScreenshotAndroidModule extends ReactContextBaseJavaModule {
    private static final String PREVENT_SCREENSHOT_ERROR_CODE = "PREVENT_SCREENSHOT_ERROR_CODE";
    private final ReactApplicationContext reactContext;

    public PreventScreenshotAndroidModule(ReactApplicationContext reactContext) {
        super(reactContext);
        this.reactContext = reactContext;
    }

    @Override
    public String getName() {
        return "PreventScreenshotAndroid";
    }

    @ReactMethod
    public void forbidScreenshot(final Promise promise) {
      runOnUiThread(new Runnable() {
        @Override
        public void run() {
          try {
            getCurrentActivity().getWindow().addFlags(WindowManager.LayoutParams.FLAG_SECURE);
            promise.resolve("Screenshot taking locked.");
          } catch(Exception e) {
            promise.reject(PREVENT_SCREENSHOT_ERROR_CODE, "Forbid screenshot taking failure.");
          }
        }
      });
    }

    @ReactMethod
    public void allowScreenshot(final Promise promise) {
      runOnUiThread(new Runnable() {
        @Override
        public void run() {
          try {
            getCurrentActivity().getWindow().clearFlags(WindowManager.LayoutParams.FLAG_SECURE);
            promise.resolve("Screenshot taking unlocked.");
          } catch (Exception e) {
            promise.reject(PREVENT_SCREENSHOT_ERROR_CODE, "Allow screenshot taking failure.");
          }
        }
      });
    }
}
