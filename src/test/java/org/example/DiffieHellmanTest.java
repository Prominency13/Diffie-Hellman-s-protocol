package org.example;

import org.junit.Test;

import java.math.BigInteger;

public class DiffieHellmanTest {
    DiffieHellman ann = new DiffieHellman(BigInteger.valueOf(7), BigInteger.valueOf(5), BigInteger.valueOf(2));
    DiffieHellman bob = new DiffieHellman(BigInteger.valueOf(11), BigInteger.valueOf(5), BigInteger.valueOf(2));

    @Test
    public void testLogic() {
        BigInteger annPK = ann.calculatePublicKey();
        BigInteger bobPK = bob.calculatePublicKey();

        BigInteger annEPK = ann.exchangePublicKey();
        BigInteger bobEPK = bob.exchangePublicKey();

        BigInteger annSPK = ann.calculateSecondaryKey();
        BigInteger bobSPK = bob.calculateSecondaryKey();

        BigInteger k;
        BigInteger power;
        power = ann.getPrivateKey().multiply(bob.getPrivateKey());
        k = ann.getGenerateKey().pow(Integer.parseInt(String.valueOf(power)));
        k = k.mod(ann.getPrimeKey());

        System.out.println(k + " " + annSPK + " " + bobSPK);
    }

    @Test
    public void test() {
        BigInteger a = new BigInteger(String.valueOf(2));
        BigInteger b = new BigInteger(String.valueOf(a.pow(77)));
        System.out.println(b.mod(BigInteger.valueOf(5)));
        //         a = 151_115_727_451_828_646_838_272;
    }
}
