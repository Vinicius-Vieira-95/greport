package org.greport;

import java.awt.Desktop;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Calendar;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Set;
import org.greport.pdf.ReportExporterPDF;

/**
 *
 * @author Marcius
 * @Version 1.1
 * @since 26/08/2008
 */
public final class Util {

    private Util() {
    }

    /**
     * Conviniente mÃ©todo para retornar o typo de um objeto. OBS: Filtra
     * classes proxy do CGLIB. Ex: getClass("br.locais.Pais") ou
     * getClass(Pais.class) ou getClass(new Pais())
     *
     * @param object (Class), instacia(Object) da classe ou nome (String) da
     * classe
     * @return uma classe do tipo informado
     */
    public static Class getClass(final Object object) {
        if (object == null) {
            throw new IllegalArgumentException("N�o se pode converter o tipo null");
        }

        Class clazz;

        if (object instanceof Class) {
            clazz = (Class) object;
        } else {
            clazz = object.getClass();
        }

        return checkForCGLIB(clazz);
    }

    /**
     * @param type the (usable) super type if passed a CGLIB enhanced class
     * @return
     */
    private static Class checkForCGLIB(Class type) {
        if (type.getName().contains("CGLIB")) {
            return type.getSuperclass();
        } else {
            return type;
        }
    }

    /**
     * Indica se a classe Ã© do tipo primitivo ou do tipo mais baixo que uma
     * propriedade pode assumir que represente uma informaÃ§Ã£o.
     *
     * @param type (.class) da propriedade
     * @return true se for uma tipo primitivo ou afim. @todo Verificar todos os
     * tipos possÃ­veis.
     */
    public static boolean isBasicProperty(final Class type) {
        String typeName = type.getSimpleName().toLowerCase(Locale.getDefault());

        return typeName.startsWith("string")
                || typeName.startsWith("byte")
                || typeName.startsWith("short")
                || typeName.startsWith("int")
                || typeName.startsWith("long")
                || typeName.startsWith("double")
                || typeName.startsWith("float")
                || typeName.startsWith("date")
                || typeName.startsWith("calendar")
                || typeName.startsWith("bool")
                || typeName.startsWith("char")
                || typeName.equals("biginteger")
                || typeName.equals("enum")
                || typeName.equals("array");
    }

    /**
     * Indica se a classe Ã© do tipo numerico (com ou sem casas decimais).
     *
     * @param type
     * @return true se for um tipo numerico (primitivo ou wrapper).
     */
    public static boolean isNumber(final Class<?> type) {
        return isInteger(type) || isDecimal(type);
    }

    /**
     * Indica se a classe Ã© do tipo Collection
     *
     * @param type
     * @return true se type for uma Collection, List ou Set
     */
    public static boolean isCollection(final Class<?> type) {
        return type.equals(Collection.class)
                || type.equals(List.class)
                || type.equals(Set.class);
    }

    /**
     * Indica se a classe Ã© do tipo boolean
     *
     * @param type
     * @return true se type for Booleano
     */
    public static boolean isBoolean(final Class<?> type) {
        return type.equals(Boolean.class)
                || type.equals(boolean.class);
    }

    /**
     * Indica se a classe Ã© do tipo data
     *
     * @param type
     * @return true se date ou Calendar
     */
    public static boolean isDate(final Class<?> type) {
        return type.equals(java.util.Date.class)
                || type.equals(java.sql.Date.class)
                || type.equals(java.util.Calendar.class);
    }

    /**
     * Indica se a classe Ã© do tipo Stream
     *
     * @param type
     * @return true se byte[], File ou InputStream
     */
    public static boolean isStream(final Class<?> type) {
        return type.equals(byte[].class)
                || type.equals(Byte[].class)
                || type.equals(File.class)
                || type.equals(InputStream.class);
    }

    /**
     * Indica se a classe Ã© do tipo inteiro (sem casas decimais).
     *
     * @param type
     * @return true se byte, short, int,long e BigInteger (e seus wrapperÂ´s).
     */
    public static boolean isInteger(final Class<?> type) {
        return type.equals(Short.class)
                || type.equals(short.class)
                || type.equals(int.class)
                || type.equals(Integer.class)
                || type.equals(Long.class)
                || type.equals(long.class)
                || type.equals(BigInteger.class)
                || type.equals(Byte.class)
                || type.equals(byte.class);
    }

    /**
     * Indica se a classe Ã© do tipo decimal (com casas decimais).
     *
     * @param type
     * @return true se double,float,Double,Float e BigDecimal.
     */
    public static boolean isDecimal(final Class<?> type) {
        return type.equals(double.class)
                || type.equals(Double.class)
                || type.equals(float.class)
                || type.equals(Float.class)
                || type.equals(BigDecimal.class);
    }

    static private final DecimalFormat decimalFormat = new DecimalFormat("#,###,###.00", new DecimalFormatSymbols(new Locale("pt", "BR")));

    public static String formatDecimal(Object value) {
        return decimalFormat.format(value);
    }

    public static BigDecimal toBigDecimal(Object value) {
        BigDecimal ret = new BigDecimal(0);
        if (value != null) {
            if (value instanceof BigDecimal) {
                ret = (BigDecimal) value;
            } else if (value instanceof String) {
                ret = new BigDecimal((String) value);
            } else if (value instanceof BigInteger) {
                ret = new BigDecimal((BigInteger) value);
            } else if (value instanceof Number) {
                ret = new BigDecimal(((Number) value).doubleValue());
            } else {
                throw new ClassCastException("Not possible to coerce [" + value + "] from class " + value.getClass() + " into a BigDecimal.");
            }
        }
        return ret;
    }

    public static boolean isNullOrEmpty(Object object) {
        if (object == null) {
            return true;
        } else if (object instanceof String) {
            return object.toString().isEmpty();
        } else if (object instanceof Collection) {
            return ((Collection) object).isEmpty();
        } else if (object instanceof BigDecimal) {
            return BigDecimal.ZERO.compareTo((BigDecimal) object) == 0;
        } else {
            return false;
        }
    }

    public static boolean isPresent(Object object) {
        return !isNullOrEmpty(object);
    }

    public static Object ifPresent(Object object, Object ok, Object nok) {
        if (isPresent(object)) {
            return ok;
        } else {
            return nok;
        }
    }

    /**
     * Use:<br>
     * String s = StreamsFacade.getResourceAbsolutePath("resource.ext");<br>
     * String s = StreamsFacade.getResourceAbsolutePath("package/resource.ext");
     *
     * @param resourceName
     * @return resource in bytes[]
     */
    public static String getAbsolutePath(String resourceName) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL resource = classLoader.getResource(resourceName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return new File(resource.getFile()).getAbsolutePath();
        }
    }

    /**
     * Use:<br>
     * byte[] b = StreamsFacade.getResourceAsBytes("resourcename.ext");<br>
     * byte[] b = StreamsFacade.getResourceAsBytes("package/resourcename.ext");
     *
     * @param resourceName
     * @return resource in bytes[]
     */
    public static byte[] getResourceAsBytes(String resourceName) throws IOException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

        URL resource = classLoader.getResource(resourceName);
        if (resource == null) {
            throw new IllegalArgumentException("file is not found!");
        } else {
            return getFileAsBytes(new File(resource.getFile()));
        }
    }

    /**
     * Read byte array from file. Take care with big files, this would be memory
     * hogging, rather use readStream() instead.
     *
     * @param file The file to read the byte array from.
     * @return The byte array with the file contents.
     * @throws IOException If reading file fails.
     */
    public static byte[] getFileAsBytes(File file) throws IOException {
        BufferedInputStream stream = (BufferedInputStream) new BufferedInputStream(new FileInputStream(file));
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        return bytes;
    }

    public static String makeFileNameTemp() {
        Integer i = (Calendar.getInstance().get(Calendar.HOUR) * 100000000);
        i += (Calendar.getInstance().get(Calendar.MINUTE) * 1000000);
        i += (Calendar.getInstance().get(Calendar.SECOND) * 10000);
        i += (Calendar.getInstance().get(Calendar.MILLISECOND) * 100);

        return System.getProperty("java.io.tmpdir") + i + ".pdf";
    }

    public static void showReport(Report report) throws IOException {
        String dest = makeFileNameTemp();
        ReportExporterPDF.exportToPdf(report, dest);
        Desktop.getDesktop().open(new File(dest));
    }

}
