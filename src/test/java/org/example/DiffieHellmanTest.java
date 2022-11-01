package org.example;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DiffieHellmanTest {
    DiffieHelman ann = new DiffieHelman(38234, 5, 2);
    DiffieHelman bob = new DiffieHelman(3913123, 5, 2);

    @Test
    public void testLogic() {
        int annPK = ann.calculatePublicKey();
        int bobPK = bob.calculatePublicKey();

        int annEPK = ann.exchangePublicKey();
        int bobEPK = bob.exchangePublicKey();

        int annSPK = ann.calculateSecondaryKey();
        int bobSPK = bob.calculateSecondaryKey();

        int k = (int) (Math.pow(Math.pow(ann.getGenerateKey(),
                ann.getPrivateKey()), bob.getPrivateKey()) % ann.getPrimeKey());

        System.out.println(k + " " + annSPK + " " + bobSPK);
        assertEquals(k, annSPK);
        assertEquals(k, bobSPK);
    }
}
