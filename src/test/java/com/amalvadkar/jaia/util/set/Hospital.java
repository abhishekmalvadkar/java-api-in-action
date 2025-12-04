package com.amalvadkar.jaia.util.set;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
class Hospital {
    private final Long id;
    private final String name;

    public static Hospital of(Long id, String name) {
        return new Hospital(id, name);
    }
}
