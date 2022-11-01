package org.example;

public class DiffieHelman {
    private final int privateKey;
    private int primeKey;
    private int generateKey;
    private int publicKey;
    private int exchangedKey;

    public DiffieHelman(int privateKey, int primeKey, int generateKey) {
        this.privateKey = privateKey;
        this.primeKey = primeKey;
        this.generateKey = generateKey;
    }

    public int getPrivateKey() {
        return privateKey;
    }

    public int getPrimeKey() {
        return primeKey;
    }

    public void setPrimeKey(int primeKey) {
        this.primeKey = primeKey;
    }

    public int getGenerateKey() {
        return generateKey;
    }

    public void setGenerateKey(int generateKey) {
        this.generateKey = generateKey;
    }

    public int calculatePublicKey(){
        publicKey = (int) (Math.pow(primeKey, privateKey) % generateKey);
        return publicKey;
    }

    public int exchangePublicKey(){
        exchangedKey = (int) (Math.pow(publicKey, privateKey) % generateKey);
        return exchangedKey;
    }

    public int calculateSecondaryKey() {
        return (int) (Math.pow(exchangedKey, privateKey) % generateKey);
    }

}
