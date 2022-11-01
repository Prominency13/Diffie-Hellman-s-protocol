package org.example;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class DiffieHellmanTest {
    DiffieHelman ann = new DiffieHelman(8,5,2);
    DiffieHelman bob = new DiffieHelman(7,5,2);

    @Test
    public void testLogic(){
        int annPK = ann.calculatePublicKey();
        int bobPK = bob.calculatePublicKey();

        int annEPK = ann.exchangePublicKey();
        int bobEPK = bob.exchangePublicKey();

        int annSPK = ann.calculateSecondaryKey();
        int bobSPK = bob.calculateSecondaryKey();

        int k = (int) (Math.pow(Math.pow(ann.getGenerateKey(),
                        ann.getPrivateKey()), bob.getPrivateKey()) % ann.getPrimeKey());

        System.out.println(k + " " + annSPK + " " + bobSPK);
        assertTrue(k == annSPK);
        assertTrue(k == bobSPK);
    }
}
