package com.pactera.dataserver.api;

import io.hypersistence.utils.hibernate.util.StringUtils;
import org.springframework.core.io.Resource;
import org.springframework.util.Base64Utils;
import org.springframework.util.FileCopyUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UncheckedIOException;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static java.nio.charset.StandardCharsets.UTF_8;

/**
 * @author Pactera WangShuai
 * @date 2019/12/25 15:33
 */
public class Util {
    public final static String ID = "SYSTEM";
    private static final String AES_ALGORITHM = "AES";
    private static final String CIPHER_CBC_PADDING = "AES/CBC/PKCS5Padding";

    public static long getNowTime() {
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        return Long.parseLong(time);
    }

    /**
     * Convert resource to string
     *
     * @param resource Resource
     * @return string
     */
    public static String asString(Resource resource) {
        try (Reader reader = new InputStreamReader(resource.getInputStream(), UTF_8)) {
            return FileCopyUtils.copyToString(reader);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        }
    }

    /**
     * AES_CBC解密
     *
     * @param content 待解密内容
     * @param iv      偏移
     */
    public static String decryptCBC(String content, String iv) {
        if (StringUtils.isBlank(content)) {
            return null;
        }
        byte[] ivByte = createByteArray(iv);
        byte[] aesKey = createByteArray(dataDeciphering());
        try {
            // 设置解密算法，生成秘钥
            SecretKeySpec skeySpec = new SecretKeySpec(aesKey, AES_ALGORITHM);
            // 偏移
            IvParameterSpec ivSpec = new IvParameterSpec(ivByte);
            // 算法/模式/补码方式
            Cipher cipher = Cipher.getInstance(CIPHER_CBC_PADDING);
            // 选择解密
            cipher.init(Cipher.DECRYPT_MODE, skeySpec, ivSpec);

            // 先进行Base64解码
            byte[] decodeBase64 = Base64Utils.decodeFromString(content);

            // 根据待解密内容进行解密
            byte[] decrypted = cipher.doFinal(decodeBase64);
            // 将字节数组转成字符串
            return new String(decrypted, StandardCharsets.UTF_8);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String dataDeciphering() {
        String keyStr = "1bac91283be95da1d9b20e8ba3c649ea";
        int len = keyStr.length() / 2;
        StringBuilder result = new StringBuilder();
        int j = 0;
        int k = 0;
        for (int i = 0; i < keyStr.length(); i++) {
            if (i % 2 > 0) {
                result.append(keyStr.charAt(len + k++));
            } else {
                result.append(keyStr.charAt(j++));
            }
        }

        return String.valueOf(result);
    }

    public static byte[] createByteArray(String iv) {
        byte[] result = new byte[iv.length() / 2];
        for (int i = 0; i < iv.length() / 2; i++) {
            String str = iv.substring(i * 2, (i + 1) * 2);
            result[i] = (byte) Integer.parseInt(str, 16);
        }
        return result;
    }
}
