package site.codecare.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import site.codecare.global.base.RsData;
import site.codecare.global.config.AppConfig;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Component
public class Ut {
    @SneakyThrows
    public static void sleep(int millis) {
        Thread.sleep(millis);
    }

    public static class date {
        public static LocalDateTime bitsToLocalDateTime(List<Integer> bits) {
            return LocalDateTime.of(bits.get(0), bits.get(1), bits.get(2), bits.get(3), bits.get(4), bits.get(5), bits.get(6));
        }

        public static int getEndDayOf(int year, int month) {
            String yearMonth = year + "-" + "%02d".formatted(month);

            return getEndDayOf(yearMonth);
        }

        public static int getEndDayOf(String yearMonth) {
            LocalDate convertedDate = LocalDate.parse(yearMonth + "-01", DateTimeFormatter.ofPattern("yyyy-MM-dd"));
            convertedDate = convertedDate.withDayOfMonth(
                    convertedDate.getMonth().length(convertedDate.isLeapYear()));

            return convertedDate.getDayOfMonth();
        }

        public static LocalDateTime parse(String pattern, String dateText) {
            return LocalDateTime.parse(dateText, DateTimeFormatter.ofPattern(pattern));
        }

        public static LocalDateTime parse(String dateText) {
            return parse("yyyy-MM-dd HH:mm:ss.SSSSSS", dateText);
        }
    }

    private static ObjectMapper getObjectMapper() {
        return (ObjectMapper) AppConfig.getContext().getBean("objectMapper");
    }

    public static String nf(long number) {
        return String.format("%,d", (int) number);
    }

    public static String getTempPassword(int length) {
        int index = 0;
        char[] charArr = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < length; i++) {
            index = (int) (charArr.length * Math.random());
            sb.append(charArr[index]);
        }

        return sb.toString();
    }

    public static class json {

        public static String toStr(Object obj) {
            try {
                return getObjectMapper().writeValueAsString(obj);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }

        public static Map<String, Object> toMap(String jsonStr) {
            try {
                return getObjectMapper().readValue(jsonStr, LinkedHashMap.class);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public static <K, V> Map<K, V> mapOf(Object... args) {
        Map<K, V> map = new LinkedHashMap<>();

        int size = args.length / 2;

        for (int i = 0; i < size; i++) {
            int keyIndex = i * 2;
            int valueIndex = keyIndex + 1;

            K key = (K) args[keyIndex];
            V value = (V) args[valueIndex];

            map.put(key, value);
        }

        return map;
    }

    public static class url {
        public static boolean isUrl(String url) {
            if (url == null) return false;
            return url.matches("^(https?):\\/\\/([^:\\/\\s]+)(:([^\\/]*))?((\\/[^\\s/\\/]+)*)?\\/?([^#\\s\\?]*)(\\?([^#\\s]*))?(#(\\w*))?$");
        }

        public static String addQueryParam(String url, String paramName, String paramValue) {
            if (url.contains("?") == false) {
                url += "?";
            }

            if (url.endsWith("?") == false && url.endsWith("&") == false) {
                url += "&";
            }

            url += paramName + "=" + paramValue;

            return url;
        }

        public static String modifyQueryParam(String url, String paramName, String paramValue) {
            url = deleteQueryParam(url, paramName);
            url = addQueryParam(url, paramName, paramValue);

            return url;
        }

        private static String deleteQueryParam(String url, String paramName) {
            int startPoint = url.indexOf(paramName + "=");
            if (startPoint == -1) return url;

            int endPoint = url.substring(startPoint).indexOf("&");

            if (endPoint == -1) {
                return url.substring(0, startPoint - 1);
            }

            String urlAfter = url.substring(startPoint + endPoint + 1);

            return url.substring(0, startPoint) + urlAfter;
        }

        public static String encode(String str) {
            try {
                return URLEncoder.encode(str, "UTF-8");
            } catch (UnsupportedEncodingException e) {
                return str;
            }
        }

        public static String getQueryParamValue(String url, String paramName, String defaultValue) {
            String[] urlBits = url.split("\\?", 2);

            if (urlBits.length == 1) {
                return defaultValue;
            }

            urlBits = urlBits[1].split("&");

            String param = Arrays.stream(urlBits)
                    .filter(s -> s.startsWith(paramName + "="))
                    .findAny()
                    .orElse(paramName + "=" + defaultValue);

            String value = param.split("=", 2)[1].trim();

            return value.length() > 0 ? value : defaultValue;
        }
    }

    public static class sp {

        public static <T> ResponseEntity<RsData<T>> responseEntityOf(RsData<T> rsData) {
            return responseEntityOf(rsData, null);
        }

        public static <T> ResponseEntity<RsData<T>> responseEntityOf(RsData<T> rsData, HttpHeaders headers) {
            return new ResponseEntity<>(rsData, headers, rsData.isSuccess() ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
        }

        public static HttpHeaders httpHeadersOf(String... args) {
            HttpHeaders headers = new HttpHeaders();

            Map<String, String> map = Ut.mapOf(args);

            for (String key : map.keySet()) {
                String value = map.get(key);
                headers.set(key, value);
            }

            return headers;
        }
    }
}
