package ir.maktabsharif.busticketreservationsystem.util;

import at.favre.lib.crypto.bcrypt.BCrypt;

public class PasswordUtil {
    public static String encode(String password) {
        return BCrypt.withDefaults().hashToString(12, password.toCharArray());
    }

    public static boolean verify(String rawPassword, String hashedPassword) {
        return BCrypt.verifyer().verify(rawPassword.toCharArray(), hashedPassword.toCharArray()).verified;
    }
}
