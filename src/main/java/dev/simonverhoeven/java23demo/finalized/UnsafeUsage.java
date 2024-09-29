package dev.simonverhoeven.java23demo.finalized;

import sun.misc.Unsafe;

// JEP 471: Deprecate the Memory-Access Methods in sun.misc.Unsafe

public class UnsafeUsage {
    private final int DEPRECATED_USAGE = Unsafe.INVALID_FIELD_OFFSET;
}
