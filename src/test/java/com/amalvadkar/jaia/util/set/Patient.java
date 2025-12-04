package com.amalvadkar.jaia.util.set;

record Patient(Long id, String name) {
    public static Patient of(Long id, String name) {
        return new Patient(id, name);
    }
}
