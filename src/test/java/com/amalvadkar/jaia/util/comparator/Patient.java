package com.amalvadkar.jaia.util.comparator;

import java.time.LocalDate;
import java.util.Comparator;

record Patient(
        Long id,
        String firstname,
        String lastname,
        LocalDate dob,
        PatientStatus patientStatus) implements Comparable<Patient> {

    public static final Comparator<Patient> DEFAULT_SORTING_ID_BASED_IN_NATURAL_ORDER = Comparator.nullsFirst(Comparator.comparing(Patient::id));
    public static final Comparator<Patient> FIRSTNAME_THEN_LASTNAME_THEN_PATIENT_STATUS_ASC = Comparator.nullsLast(Comparator.comparing(Patient::firstname)
            .thenComparing(Patient::lastname)
            .thenComparing(Patient::patientStatus));
    public static final Comparator<Patient> FIRSTNAME_THEN_LASTNAME_THEN_PATIENT_STATUS_DESC = Comparator.nullsLast(Comparator.comparing(Patient::firstname)
            .thenComparing(Patient::lastname) /* can call reversed() here as well i.e in between as well */
            .thenComparing(Patient::patientStatus))
            .reversed();

    @Override
    public int compareTo(Patient o) {
        return DEFAULT_SORTING_ID_BASED_IN_NATURAL_ORDER.compare(this, o);
    }
}
