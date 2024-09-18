package com.factoriaf5.telefono_micasa.implementations;

public interface IEncryptFacade {
    
    String encode(String type, String data);
    String decode(String type, String data);

}
