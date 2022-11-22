package site.codecare.global.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class JasyptConfigTest extends JasyptConfig{

    @Test
    public void jasypt_encrypt_decrypt_test() {
        String plainText = "test1234";

        StandardPBEStringEncryptor jasypt = new StandardPBEStringEncryptor();
        jasypt.setPassword("password");

        String encryptedText = jasypt.encrypt(plainText);
        String decryptedText = jasypt.decrypt(encryptedText);

        System.out.println("here" + encryptedText);

        assertThat(plainText).isEqualTo(decryptedText);
    }
}