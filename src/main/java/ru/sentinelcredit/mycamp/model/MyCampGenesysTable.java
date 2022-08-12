package ru.sentinelcredit.mycamp.model;

import com.cck.genesys4j.model.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MyCampGenesysTable {
    private Integer recordId;
    private String contactInfo;
/*                contact_info_type  INTEGER not null,
                record_type        INTEGER not null,
                record_status      INTEGER not null,
                call_result        INTEGER,
                attempt            INTEGER not null,
                dial_sched_time    INTEGER,
                call_time          INTEGER,
                daily_from         INTEGER not null,
                daily_till         INTEGER not null,
                tz_dbid            INTEGER not null,
                campaign_id        INTEGER,
                agent_id           VARCHAR2(32),
                chain_id           INTEGER not null,
                chain_n            INTEGER not null,
                group_id           INTEGER,
                app_id             INTEGER,
                treatments         VARCHAR2(255),
                media_ref          INTEGER,
                email_subject      VARCHAR2(255),
                email_template_id  INTEGER,
                switch_id          INTEGER,
                daily_from2        INTEGER not null,
                daily_till2        INTEGER not null,
                crm_campaign_id    VARCHAR2(20),
                crm_camp_con_id    VARCHAR2(20) not null,
                crm_contact_id     VARCHAR2(20),
                msk_music_file     INTEGER not null,
                col_lead_id        VARCHAR2(20),
                chain_sequence     INTEGER not null,
                contact_info_type2 INTEGER not null,
                portfolio_name     VARCHAR2(500),
                regestry_name      VARCHAR2(500),
                tz_dbid2           INTEGER not null,
                max_attempt        INTEGER,
                vip_status         VARCHAR2(32),
                x_cc_upd_id        DATE,
                x_batch_id         INTEGER,
                exit               VARCHAR2(20)

*/    
}
