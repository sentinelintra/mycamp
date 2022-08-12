package ru.sentinelcredit.mycamp.service;

import com.cck.genesys4j.GenesysApi;
import com.cck.genesys4j.GenesysApiFactory;
import com.cck.genesys4j.config.ApiConfig;
import com.cck.genesys4j.model.*;
import com.genesyslab.platform.applicationblocks.com.objects.CfgAgentGroup;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.sentinelcredit.mycamp.model.MyCampPersonAgentGroupsApiResponse;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import java.sql.*;

@Slf4j
@Service
public class MyCampService {

    @Value("${genesysApi.clientName}")
    private String clientName;
    @Value("${genesysApi.userName}")
    private String userName;
    @Value("${genesysApi.password}")
    private String password;
    @Value("${genesysApi.primaryConfigHost}")
    private String primaryConfigHost;
    @Value("${genesysApi.primaryConfigPort}")
    private Integer primaryConfigPort;
    @Value("${genesysApi.bkpConfigHost}")
    private String bkpConfigHost;
    @Value("${genesysApi.bkpConfigPort}")
    private Integer bkpConfigPort;
    @Value("${genesysApi.primaryOutboundHost}")
    private String primaryOutboundHost;
    @Value("${genesysApi.primaryOutboundPort}")
    private Integer primaryOutboundPort;
    @Value("${genesysApi.bkpOutboundHost}")
    private String bkpOutboundHost;
    @Value("${genesysApi.bkpOutboundPort}")
    private Integer bkpOutboundPort;
    @Value("${genesysApi.outboundJdbcUrl}")
    private String outboundJdbcUrl;

    private GenesysApi genesysApi;
    private Connection conn;

    private BaseApiResponse genesysConnect() {
        genesysApi = GenesysApiFactory.createInstance(
                ApiConfig.load(clientName, userName, password, primaryConfigHost, primaryConfigPort, bkpConfigHost, bkpConfigPort, "", primaryOutboundHost, primaryOutboundPort, bkpOutboundHost, bkpOutboundPort, outboundJdbcUrl)
        );

        BaseApiResponse response = genesysApi.connect();
        log.trace("genesysConnect response Code => '{}' Message => '{}'", response.getErrorCode(), response.getErrorMessage());

        return response;
    }

    private void genesysDisconnect() {
        BaseApiResponse response = genesysApi.disconnect();

        try {
            if (conn != null)
                conn.close();
        } catch (SQLException e) {
            log.trace("genesysDisconnect SQL State: {} {}", e.getSQLState(), e.getMessage());
        }

        log.trace("genesysDisconnect response Code => '{}' Message => '{}'", response.getErrorCode(), response.getErrorMessage());
    }

    @PreDestroy
    private void destroy() {
        genesysDisconnect();
    }

    @PostConstruct
    private void construct() { genesysConnect(); }

    public ObjectIdApiResponse createCampaign(String name, Integer callListId, Integer path) {
        //return genesysApi.createCampaign(name, callListId, path.replace("-", "/"));
        return genesysApi.createCampaign(name, callListId, path);
    }

    public BaseApiResponse dropCampaign (Integer id) {
        return genesysApi.dropCampaign(id);
    }

    public ObjectIdApiResponse queryCampaign (String name) {
        return genesysApi.queryCampaign(name);
    }
    
    public BaseApiResponse startCampaign (Integer id, Integer groupId, String dialingMode, String optimizationMethod, Integer optimizedGoal) {
        return genesysApi.startCampaign(id, groupId, dialingMode, optimizationMethod, optimizedGoal);
    }
    
    public BaseApiResponse stopCampaign (Integer id, Integer groupId) {
        return genesysApi.stopCampaign(id, groupId);
    }
    
    public ObjectIdApiResponse createCallList (String name, Integer tableAccessId, String filterName, Integer maxAttempts, Integer timeFrom, Integer timeUntil,
                                               Collection<String> treatmentsName, Integer tenantId, Integer path) {
        /* return genesysApi.createCallList(name, tableAccessId, filterName, maxAttempts, timeFrom, timeUntil, treatmentsName, tenantId, path.replace("-", "/")); */
        return genesysApi.createCallList(name, tableAccessId, filterName, maxAttempts, timeFrom, timeUntil, treatmentsName, tenantId, path);
    }

    public BaseApiResponse dropCallList (Integer id) {
        return genesysApi.dropCallList(id);
    }

    public ObjectIdApiResponse queryCallList (String name) {
        return genesysApi.queryCallList(name);
    }

    public ObjectIdApiResponse createTableAccess (String name, String dbAccessPoint, String formatName, String tableName, Integer tenantId, Integer path) {
        //return genesysApi.createTableAccess(name, dbAccessPoint, formatName, tableName, tenantId, path.replace("-", "/"));
        return genesysApi.createTableAccess(name, dbAccessPoint, formatName, tableName, tenantId, path);
    }

    public BaseApiResponse dropTableAccess (Integer id) {
        return genesysApi.dropTableAccess(id);
    }

    public ObjectIdApiResponse queryTableAccess (String name) {
        return genesysApi.queryTableAccess(name);
    }
    
    public ObjectIdApiResponse createCampaignGroup (String name, Integer campaignId, Integer agentGroupId, String dialingMode, String voiceTransferDestination,
                                                    String trunkGroupDN, String operationMode, String optimizationMethod, Integer targetValue,
                                                    Integer bufferSizeMinimum, Integer bufferSizeOptimum, Integer numberCPDPorts, Collection<String> connections,
                                                    Collection<String> annexOption) {
        Collection<String> annexOptionInt = annexOption.stream().map(o -> {
            return o.replace("~", "=").replace("-", "/");
        }).collect(Collectors.toList());

        return genesysApi.createCampaignGroup(name, campaignId, agentGroupId, dialingMode, voiceTransferDestination, operationMode, optimizationMethod, targetValue,
                trunkGroupDN, bufferSizeMinimum, bufferSizeOptimum, numberCPDPorts, connections, annexOptionInt);
    }
    
    public BaseApiResponse dropCampaignGroup (Integer id) {
        return genesysApi.dropCampaignGroup(id);
    }

    public ObjectIdApiResponse queryCampaignGroup (String name) {
        return genesysApi.queryCampaignGroup(name);
    }
    
    public ObjectIdApiResponse createSkill (String name, Integer tenantId, Integer path) {
        //return genesysApi.createSkill(name, tenantId, path.replace("-", "/"));
        return genesysApi.createSkill(name, tenantId, path);
    }
    
    public BaseApiResponse dropSkill (Integer id) {
        return genesysApi.dropSkill(id);
    }

    public ObjectIdApiResponse querySkill (String name) {
        return genesysApi.querySkill(name);
    }

    public PersonApiResponse queryCfgPerson (String s) {
        return genesysApi.queryCfgPerson(s);
    }
    
    public ObjectIdApiResponse queryAgentGroup (String name) {
        return genesysApi.queryAgentGroup(name);
    }

    public MyCampPersonAgentGroupsApiResponse queryAgentGroups (Integer id) {
        return new MyCampPersonAgentGroupsApiResponse(genesysApi.queryAgentGroups(id));
    }

    public ObjectIdApiResponse createAgentGroup (String name, String script, Integer tenantId, Integer path) {
        //return genesysApi.createAgentGroup(name, script.replace("*", "="), tenantId, path.replace("-", "/"));
        return genesysApi.createAgentGroup(name, script.replace("*", "="), tenantId, path);
    }
    
    public BaseApiResponse dropAgentGroup (Integer id) {
        return genesysApi.dropAgentGroup(id);
    }
    
    public BaseApiResponse addAgentToGroup (Integer id, Integer personId) {
        return genesysApi.addAgentToGroup(id, personId);
    }
    
    public BaseApiResponse deleteAgentFromGroup (Integer id, Integer personId) {
        return genesysApi.deleteAgentFromGroup(id, personId);
    }
    
    public ObjectIdApiResponse createVirtualQueue (String name, String switchName, Integer path) {
        //return genesysApi.createVirtualQueue (name, switchName, path.replace("-", "/"));
        return genesysApi.createVirtualQueue (name, switchName, path);
    }

    public BaseApiResponse dropVirtualQueue (Integer id) {
        return genesysApi.dropVirtualQueue(id);
    }

    public ObjectIdApiResponse queryVirtualQueue (String name) {
        return genesysApi.queryVirtualQueue(name);
    }

    public BaseApiResponse updatePersonParam (Integer id, String key, String value) {
        return genesysApi.updatePersonParam(id, key.replace("-", "/"), value);
    }
    
    public BaseApiResponse dropPersonParam (Integer id, String key) {
        return genesysApi.dropPersonParam(id, key);
    }
    
    public PersonParamApiResponse queryPersonParam (Integer id, String key) {
        return genesysApi.queryPersonParam(id, key);
    }

    public BaseApiResponse dropPersonProperty (Integer id, String sectionName, String key) {
        return genesysApi.dropPersonProperty(id, sectionName, key);
    }

    public BaseApiResponse createTable (Integer id) {
        return genesysApi.createTable(id);
    }

    public BaseApiResponse addSkillToAgent (Integer id, String skillLevelName, Integer skillLevelKey) {
        return genesysApi.addSkillToAgent(id, skillLevelName, skillLevelKey);
    }

    public BaseApiResponse dropSkillFromAgent (Integer id, String skillLevelName) {
        return genesysApi.dropSkillFromAgent(id, skillLevelName);
    }

    public BaseApiResponse updatePersonProperty (Integer id, String sectionName, String key, String value) {
        return genesysApi.updatePersonProperty(id, sectionName, key, value);
    }

    public PersonParamApiResponse queryPersonProperty (Integer id, String sectionName, String key) {
        return genesysApi.queryPersonProperty(id, sectionName, key);
    }

    public CampaingStatusApiResponse getCampaignStatus (Integer id, Integer groupId) {
        return genesysApi.getCampaignStatus(id, groupId);
    }

    public BaseApiResponse loadCampaign (Integer id, Integer groupId) {
        return genesysApi.loadCampaign (id, groupId);
    }

     public BaseApiResponse unloadCampaign (Integer id, Integer groupId) {
         return genesysApi.unloadCampaign (id, groupId);
     }

    public MyCampService() {

    }
}
