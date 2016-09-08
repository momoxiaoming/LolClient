package me.fangx.common.util.log;

import android.util.Pair;

import com.orhanobut.logger.Logger;
import com.orhanobut.logger.Printer;
import com.orhanobut.logger.Settings;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by fangxiao on 15/12/18.
 */
public class LogUtil {
    private static boolean islog = false;

    private LogUtil() {
    }


    public static Settings init(boolean log, String tag) {
        islog = log;
        return Logger.init(tag);
    }

    public static Printer t(String tag) {
        return Logger.t(tag);
    }

    public static Printer t(int methodCount) {
        return Logger.t(methodCount);
    }

    public static Printer t(String tag, int methodCount) {
        return Logger.t(tag, methodCount);
    }

    public static void d(String message) {
        if (islog)
            Logger.t(getClassName()).d(message);
    }

    public static void e(String message) {
        if (islog)
            Logger.t(getClassName()).e(message);
    }

    public static void e(Throwable throwable, String message) {
        if (islog)
            Logger.t(getClassName()).e(throwable, message);
    }

    public static void i(String message) {
        if (islog)
            Logger.t(getClassName()).i(message);
    }

    public static void v(String message) {
        if (islog)
            Logger.t(getClassName()).v(message);
    }

    public static void w(String message) {
        if (islog)
            Logger.t(getClassName()).w(message);
    }

    public static void wtf(String message) {
        if (islog)
            Logger.t(getClassName()).wtf(message);
    }

    public static void json(String json) {
        if (islog)
            Logger.t(getClassName()).json(json);
    }

    public static void xml(String xml) {
        if (islog)
            Logger.t(getClassName()).xml(xml);
    }

    /**
     * support list、map、array
     *
     * @see "https://github.com/pengwei1024/LogUtils"
     */
    public static void Object(Object object) {
        if (object != null) {
            final String simpleName = object.getClass().getSimpleName();
            if (object.getClass().isArray()) {
                String msg = "Temporarily not support more than two dimensional Array!";
                int dim = ArrayUtil.getArrayDimension(object);
                switch (dim) {
                    case 1:
                        Pair pair = ArrayUtil.arrayToString(object);
                        msg = simpleName.replace("[]", "[" + pair.first + "] {\n");
                        msg += pair.second + "\n";
                        break;
                    case 2:
                        Pair pair1 = ArrayUtil.arrayToObject(object);
                        Pair pair2 = (Pair) pair1.first;
                        msg = simpleName.replace("[][]", "[" + pair2.first + "][" + pair2.second + "] {\n");
                        msg += pair1.second + "\n";
                        break;
                    default:
                        break;
                }
                Logger.t(getClassName()).d(msg + "}");
            } else if (object instanceof Collection) {
                Collection collection = (Collection) object;
                String msg = "%s size = %d [\n";
                msg = String.format(msg, simpleName, collection.size());
                if (!collection.isEmpty()) {
                    Iterator<Object> iterator = collection.iterator();
                    int flag = 0;
                    while (iterator.hasNext()) {
                        String itemString = "[%d]:%s%s";
                        Object item = iterator.next();
                        msg += String.format(itemString, flag, SystemUtil.objectToString(item),
                                flag++ < collection.size() - 1 ? ",\n" : "\n");
                    }
                }
                Logger.t(getClassName()).d(msg + "\n]");
            } else if (object instanceof Map) {
                String msg = simpleName + " {\n";
                Map<Object, Object> map = (Map<Object, Object>) object;
                Set<Object> keys = map.keySet();
                for (Object key : keys) {
                    String itemString = "[%s -> %s]\n";
                    Object value = map.get(key);
                    msg += String.format(itemString, SystemUtil.objectToString(key),
                            SystemUtil.objectToString(value));
                }
                Logger.t(getClassName()).d(msg + "}");
            } else {
                Logger.t(getClassName()).d(SystemUtil.objectToString(object));
            }
        } else {
            Logger.t(getClassName()).d(SystemUtil.objectToString(object));
        }
    }

    /**
     * @return 当前的类名(simpleName)
     */
    private static String getClassName() {
        String result;
        StackTraceElement thisMethodStack = (new Exception()).getStackTrace()[2];
        result = thisMethodStack.getClassName();
        int lastIndex = result.lastIndexOf(".");
        result = result.substring(lastIndex + 1, result.length());
        return result;
    }


}
