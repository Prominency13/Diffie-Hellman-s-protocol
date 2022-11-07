package org.example;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
@RequiredArgsConstructor
public class DiffieHellman {
    private final BigInteger privateKey;
    private final BigInteger primeKey;
    private final BigInteger generateKey;
    private BigInteger publicKey = new BigInteger("0");
    private BigInteger exchangedKey = new BigInteger("0");
    private BigInteger secondaryKey = new BigInteger("0");

    public BigInteger calculatePublicKey(){
        publicKey = generateKey.pow(Integer.parseInt(String.valueOf(privateKey)));
        publicKey = publicKey.mod(primeKey);
        return publicKey;
    }

    public BigInteger exchangePublicKey(){
        exchangedKey = publicKey.pow(Integer.parseInt(String.valueOf(privateKey)));
        exchangedKey = exchangedKey.mod(primeKey);
        return exchangedKey;
    }

    public BigInteger calculateSecondaryKey(){
        secondaryKey = exchangedKey.pow(Integer.parseInt(String.valueOf(privateKey)));
        secondaryKey = secondaryKey.mod(primeKey);
        return secondaryKey;
    }

}
