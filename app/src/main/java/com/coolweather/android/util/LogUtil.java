package com.coolweather.android.util;

import android.util.Log;

public class LogUtil {

    private static final String TAG = "[pxyLog] ";
    public static final int VERBOSE = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
    public static final int WARN = 4;
    public static final int ERROR = 5;
    public static final int NOTHING = 6;
    public static int level = VERBOSE;

    public static void v(String msg) {
        if (level <= VERBOSE) {
            Log.v(TAG+getCallerInfo(), msg);
        }
    }

    public static void d(String msg) {
        if (level <= DEBUG) {
            Log.d(TAG+getCallerInfo(), msg);
        }
    }

    public static void i(String msg) {
        if (level >= INFO) {
            Log.i(TAG+getCallerInfo(), msg);
        }
    }

    public static void w(String msg) {
        if (level <= WARN) {
            Log.w(TAG+getCallerInfo(), msg);
        }
    }

    public static void e(String msg) {
        if (level <= ERROR) {
            Log.e(TAG+getCallerInfo(), msg);
        }
    }

    private static String getCallerInfo() {
        StackTraceElement[] stacks = Thread.currentThread().getStackTrace();
        //0 VMStack.getThreadStackTrace
        //1 Thread.getStackTrace
        //2 LogUtil.getCallerInfo
        //3 LogUtil.e
        //4 Caller
        StackTraceElement caller = stacks[4];
        return caller.getFileName() + " -> " + caller.getMethodName() + "(line:" + caller.getLineNumber() + ")";
    }

}
