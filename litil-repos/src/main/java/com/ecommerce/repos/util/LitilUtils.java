package com.ecommerce.repos.util;

import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.util.UUID;

public class LitilUtils {

    public static int generateRandomId() {
        int val = -1;
        int count = 0;
        while (val < 0) {
            count++;
            final UUID uid = getUuId();
            final ByteBuffer buffer = ByteBuffer.wrap(new byte[16]);
            buffer.putLong(uid.getLeastSignificantBits());
            buffer.putLong(uid.getMostSignificantBits());
            final BigInteger bi = new BigInteger(buffer.array());
            val = bi.intValue();
        }
        return val;
    }

    public static UUID getUuId() {
        return UUID.randomUUID();
    }

}
