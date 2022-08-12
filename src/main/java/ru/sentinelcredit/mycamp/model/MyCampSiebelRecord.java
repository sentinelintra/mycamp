package ru.sentinelcredit.mycamp.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyCampSiebelRecord {
    private String addr;
    private Integer contactInfoType;
    private Integer conPhoneOrdId;
    private Integer xChainSq;
    private Integer mAttempts;
}
